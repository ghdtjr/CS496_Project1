package com.example.tab_application;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    String[] permission_list = {Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* basic operations for initializing activity itself */
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        checkPermissions();
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
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1)
        {
            for(int i=0; i<grantResults.length; i++)
            {
                //허용됬다면
                if(grantResults[i]==PackageManager.PERMISSION_GRANTED){
                }
                else {
                    Toast.makeText(getApplicationContext(),"앱권한설정하세요",Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }
    }
    public void checkPermissions(){
        for(String permission : permission_list){
            //권한 허용 여부를 확인한다.
            int check = checkCallingOrSelfPermission(permission);

            if(check == PackageManager.PERMISSION_DENIED){
                //권한 허용을여부를 확인하는 창을 띄운다
                ActivityCompat.requestPermissions(this, permission_list,1);
            }
        }
    }
}