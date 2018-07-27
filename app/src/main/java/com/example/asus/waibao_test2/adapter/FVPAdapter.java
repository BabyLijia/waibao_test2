package com.example.asus.waibao_test2.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FVPAdapter extends FragmentPagerAdapter {
    private ArrayList<String> mchuyiTitle;
    private List<Fragment> mFragmentList;

    public FVPAdapter(FragmentManager fm, ArrayList<String> mchuyiTitle, List<Fragment> mFragmentList) {
        super(fm);
        this.mchuyiTitle = mchuyiTitle;
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mchuyiTitle.get(position);
    }
}
