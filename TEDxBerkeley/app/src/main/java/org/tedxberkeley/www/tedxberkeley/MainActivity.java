package org.tedxberkeley.www.tedxberkeley;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v4.app.FragmentActivity;
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

import org.tedxberkeley.www.tedxberkeley.Speakers.SpeakerListFragment;
import org.tedxberkeley.www.tedxberkeley.Views.SlidingTabLayout;
import org.tedxberkeley.www.tedxberkeley.Views.TabsPagerAdapter;


public class MainActivity extends ActionBarActivity implements SpeakerListFragment.OnFragmentInteractionListener {

    // Fragments
    private FragmentManager fragmentManager;
    private SpeakerListFragment mSpeakerListFragment;

    // Navigation
    private ActionBar actionBar;
    private ViewPager mViewPager;
    private TabsPagerAdapter mAdapter;
    private View mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_launcher);
        toolbar.setNavigationContentDescription(R.string.navigation_icon_description);

        initializeFragments();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    public void onFragmentInteraction(Uri uri){}

    private void initializeFragments(){
        mSpeakerListFragment = SpeakerListFragment.newInstance();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.container, mSpeakerListFragment);
        ft.commit();
    }
}
