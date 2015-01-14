package org.tedxberkeley.www.tedxberkeley;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.view.View;

import org.tedxberkeley.www.tedxberkeley.About.AboutFragment;
import org.tedxberkeley.www.tedxberkeley.Schedule.ScheduleFragment;
import org.tedxberkeley.www.tedxberkeley.Speakers.SpeakerListFragment;
import org.tedxberkeley.www.tedxberkeley.Views.TabsPagerAdapter;


public class MainActivity extends ActionBarActivity implements SpeakerListFragment.OnFragmentInteractionListener,
                                                               AboutFragment.OnFragmentInteractionListener,
                                                               ScheduleFragment.OnFragmentInteractionListener{

    // Fragments
    private FragmentManager fragmentManager;
    private SpeakerListFragment mSpeakerListFragment;
    private AboutFragment mAboutFragment;
    private ScheduleFragment mScheduleFragment;

    // Navigation
    private ActionBar actionBar;
    private ViewPager mViewPager;
    private TabsPagerAdapter mAdapter;
    private View mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFragments();
        setUpToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.schedule:
                replaceFragment(mScheduleFragment);
                break;
            case R.id.speakers:
                replaceFragment(mSpeakerListFragment);
                break;
            case R.id.about:
                replaceFragment(mAboutFragment);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void replaceFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void setUpToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        toolbar.setNavigationContentDescription(R.string.navigation_icon_description);
        actionBar.setTitle("Speakers");
    }

    public void onFragmentInteraction(Uri uri){}

    private void initializeFragments(){
        mSpeakerListFragment = SpeakerListFragment.newInstance();
        mAboutFragment = AboutFragment.newInstance("Fight", "me");
        mScheduleFragment = ScheduleFragment.newInstance("Schedule", "me");
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.container, mSpeakerListFragment);
        ft.commit();
    }
}
