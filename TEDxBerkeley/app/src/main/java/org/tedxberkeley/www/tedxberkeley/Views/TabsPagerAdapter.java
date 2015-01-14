package org.tedxberkeley.www.tedxberkeley.Views;

/**
 * Created by maxwolffe on 1/13/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.tedxberkeley.www.tedxberkeley.About.AboutFragment;
import org.tedxberkeley.www.tedxberkeley.MainActivity;
import org.tedxberkeley.www.tedxberkeley.Schedule.ScheduleFragment;
import org.tedxberkeley.www.tedxberkeley.Speakers.SpeakerListFragment;


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
                return SpeakerListFragment.newInstance();
            case 1:
                return ScheduleFragment.newInstance("Test", "1");
            case 2:
                return AboutFragment.newInstance("Test", "2");
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
