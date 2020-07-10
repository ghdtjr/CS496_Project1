package com.example.tab_application;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<String>();

    public VPAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(new frag_contacts());
        items.add(new frag_imgs());
        items.add(new Fragment3());

        itext.add("Contacts");
        itext.add("Gallery");
        itext.add("Unknown");
    }
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

