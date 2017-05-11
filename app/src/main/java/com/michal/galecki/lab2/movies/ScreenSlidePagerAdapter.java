package com.michal.galecki.lab2.movies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private final Bundle fragmentBundle;

    public ScreenSlidePagerAdapter(FragmentManager fm, List<Fragment> fragments, Bundle data) {
        super(fm);
        mFragments = fragments;
        fragmentBundle = data;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment f = mFragments.get(position);
        f.setArguments(this.fragmentBundle);
        return f;
    }

}
