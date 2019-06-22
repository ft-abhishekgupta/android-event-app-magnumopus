package com.ietkriti.abhishek.magnumopus;

/**
 * Created by abhishek on 13-08-2016.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class schedulepageradapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Day 1 - 1st Sept", "Day 2 - 2nd Sept", "Day 3 - 3rd Sept",
            "Day 4 - 4th Sept" };
    private Context context;

    public schedulepageradapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new day1();
        } else if (position == 1) {
            return new day2();
        } else if (position == 2) {
            return new day3();
        } else if (position == 3) {
            return new day4();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}