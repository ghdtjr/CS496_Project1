package com.example.tab_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp = findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        // sync between tab and viewpager
        TabLayout tab = findViewById(R.id.tabs);
        tab.setupWithViewPager(vp);
//        // add images on the tab
//        ArrayList<Integer> images = new ArrayList<>();
//        images.add(R.drawable.cal);
//        images.add(R.drawable.sea);
//        images.add(R.drawable.set);
//        for(int i=0; i<3; i++) tab.getTabAt(i).setIcon
    }
}