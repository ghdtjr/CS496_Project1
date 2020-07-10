package com.example.tab_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;


import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        check_stor_permission();
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
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //권한을 허용 했을 경우
        if (requestCode == 1) {
            int length = permissions.length;
            for (int i = 0; i < length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("MainActivity", "권한 허용 : " + permissions[i]);
                }
            }
        }
    }
    public void check_stor_permission(){
        String temp = "";
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            temp +=Manifest.permission.READ_EXTERNAL_STORAGE + " ";
        }

        if (TextUtils.isEmpty(temp) == false){
            ActivityCompat.requestPermissions(this, temp.trim().split(" "),1);
        }
    }
}