package com.example.bunktracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class CreateScheduleFragment extends Fragment {
    TabLayout createScheduleTabLayout;
    ViewPager createScheduleViewPager;
    CreateScheduleViewPagerAdapter createScheduleViewPagerAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.create_schedule_fragment, null);

        createScheduleTabLayout = v.findViewById(R.id.create_schedule_tab_layout);
        createScheduleViewPager = v.findViewById(R.id.create_schedule_view_pager);

        createScheduleTabLayout.addTab(createScheduleTabLayout.newTab().setText("Mon"));
        createScheduleTabLayout.addTab(createScheduleTabLayout.newTab().setText("Tue"));
        createScheduleTabLayout.addTab(createScheduleTabLayout.newTab().setText("Wed"));
        createScheduleTabLayout.addTab(createScheduleTabLayout.newTab().setText("Thu"));
        createScheduleTabLayout.addTab(createScheduleTabLayout.newTab().setText("Fri"));
        createScheduleTabLayout.addTab(createScheduleTabLayout.newTab().setText("Sat"));
        createScheduleTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        createScheduleViewPagerAdapter = new CreateScheduleViewPagerAdapter(getChildFragmentManager(), createScheduleTabLayout.getTabCount());
        createScheduleViewPager.setAdapter(createScheduleViewPagerAdapter);

        createScheduleTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                createScheduleViewPager.setCurrentItem(tab.getPosition());
                createScheduleViewPagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        createScheduleViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(createScheduleTabLayout));
        createScheduleTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(createScheduleViewPager));

        return v;
    }
}
