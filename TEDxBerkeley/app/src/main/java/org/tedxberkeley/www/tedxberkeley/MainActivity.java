package org.tedxberkeley.www.tedxberkeley;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private ActionBar mActionBar;
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
                mActionBar.setTitle("Schedule");
                break;
            case R.id.speakers:
                replaceFragment(mSpeakerListFragment);
                mActionBar.setTitle("Speakers");
                break;
            case R.id.about:
                replaceFragment(mAboutFragment);
                mActionBar.setTitle("About");
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
        mActionBar = getSupportActionBar();
        toolbar.setNavigationContentDescription(R.string.navigation_icon_description);
        mActionBar.setTitle("Speakers");
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

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }


    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
