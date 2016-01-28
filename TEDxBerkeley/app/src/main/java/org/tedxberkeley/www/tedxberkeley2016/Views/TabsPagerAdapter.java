package org.tedxberkeley.www.tedxberkeley2016.Views;

/**
 * Created by maxwolffe on 1/13/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import org.tedxberkeley.www.tedxberkeley2016.About.AboutFragment;
import org.tedxberkeley.www.tedxberkeley2016.MainActivity;
import org.tedxberkeley.www.tedxberkeley2016.Schedule.ScheduleFragment;
import org.tedxberkeley.www.tedxberkeley2016.Speakers.SpeakerListFragment;


public class TabsPagerAdapter extends FragmentPagerAdapter {

    private MainActivity mMainActivity;

    public TabsPagerAdapter(FragmentManager fm, MainActivity mainActivity ) {
        super(fm);
        mMainActivity = mainActivity;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return ScheduleFragment.newInstance("Test", "1");
            case 1:
                return SpeakerListFragment.newInstance();
            case 2:
                return AboutFragment.newInstance("Test", "2");
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position) {
            case 0:
                return "Schedule";
            case 1:
                return "Speakers";
            case 2:
                return "About";
            default:
                return "None";
        }
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        int layout = 0;
//        switch(position){
//            case 0:
//                layout = R.layout.fragment_schedule;
//            case 1:
//                layout = R.layout.fragment_speaker_list;
//            case 2:
//                layout = R.layout.fragment_about;
//        }
//        View view = mMainActivity.getLayoutInflater().inflate(layout,
//                container, false);
//
//        container.addView(view);
//        return view;
//    }

}
