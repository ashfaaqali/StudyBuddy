package com.example.bunktracker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int tabCount = 0;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ShareNotesFragment();
            case 2:
                return new CreateScheduleFragment();
            case 3:
                return new MyNotesFragment();
            case 4:
                return new MoreTabFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
