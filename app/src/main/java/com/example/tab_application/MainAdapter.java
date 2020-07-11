package com.example.tab_application;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentPagerAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class MainAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext= new ArrayList<String>();

    public MainAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(new Fragment_Contact());
        items.add(new Fragment_Gallery());
        items.add(new Fragment_Other());

        itext.add("PhoneBook");
        itext.add("Gallery");
        itext.add("Others");
    }
    @Override
    @Nullable
    public CharSequence getPageTitle(int position){
        return itext.get(position);
    }
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }
    @Override
    public int getCount() {
        return items.size();
    }
}
