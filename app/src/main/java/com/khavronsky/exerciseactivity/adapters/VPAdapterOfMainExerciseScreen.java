package com.khavronsky.exerciseactivity.adapters;


import com.khavronsky.exerciseactivity.fragments.CustomExercisesFragment;
import com.khavronsky.exerciseactivity.fragments.ExerciseCatalogFragment;
import com.khavronsky.exerciseactivity.fragments.RecentExercisesFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class VPAdapterOfMainExerciseScreen extends FragmentPagerAdapter {

    private Fragment mFragment1;

    private Fragment mFragment2;

    private Fragment mFragment3;

    private String[] tabsTitle = {"НЕДАВНИЕ", "МОИ УПРАЖНЕНИЯ", "КАТАЛОГ"};

    public VPAdapterOfMainExerciseScreen(final FragmentManager fm) {
        super(fm);
        Log.d("KhS", "VPAdapterOfMainExerciseScreen: ");
        mFragment1 = new ExerciseCatalogFragment();
        mFragment2 = new CustomExercisesFragment();
        mFragment3 = new RecentExercisesFragment();
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case 0:
                return mFragment3;
            case 1:
                return mFragment1;
            case 2:
                return mFragment2;
        }
        return mFragment2;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return tabsTitle[position];
    }
}
