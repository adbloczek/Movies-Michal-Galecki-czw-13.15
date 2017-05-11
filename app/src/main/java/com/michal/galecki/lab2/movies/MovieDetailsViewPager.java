package com.michal.galecki.lab2.movies;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.Vector;

public class MovieDetailsViewPager extends FragmentActivity {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private MovieDescriptionFragment movieDescriptionFragment;
    private MovieSecondDetailsFragment movieSecondDetailsFragment;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        bundle = getIntent().getExtras();
        List<Fragment> fragments = new Vector<Fragment>();
        movieDescriptionFragment = (MovieDescriptionFragment) Fragment.instantiate(this, MovieDescriptionFragment.class.getName());
        movieSecondDetailsFragment = (MovieSecondDetailsFragment) Fragment.instantiate(this, MovieSecondDetailsFragment.class.getName());
        fragments.add(movieDescriptionFragment);
        fragments.add(movieSecondDetailsFragment);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments, bundle);
        mPager.setAdapter(mPagerAdapter);
    }

    public void onSaveInstanceState(Bundle outState) {
        System.out.println("Zapisuję dwa");
        outState.putInt("currentItem", mPager.getCurrentItem());
    }

    public void onRestoreInstanceState(Bundle inState) {
        System.out.println("Odczytuję dwa");
        mPager.setCurrentItem(inState.getInt("currentItem", 0));
    }

    public void onBackPressed() {
        super.onBackPressed();

    }
}
