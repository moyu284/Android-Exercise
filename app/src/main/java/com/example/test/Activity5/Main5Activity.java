package com.example.test.Activity5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.test.R;

public class Main5Activity extends AppCompatActivity {
//    private FrameLayout mFl;
    private PrimaryFragment primaryFragment;
    private MiddleFragment middleFragment;
    private CollegeFragment collegeFragment;
    private Button primaryBtn,middleBtn,collegeBtn;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initView();
    }
    protected void initView(){
//        mFl = findViewById(R.id.fl);
        primaryFragment = new PrimaryFragment();
        middleFragment = new MiddleFragment();
        collegeFragment = new CollegeFragment();
        primaryBtn = findViewById(R.id.primaryBtn);
        middleBtn = findViewById(R.id.middleBtn);
        collegeBtn = findViewById(R.id.collegeBtn);
        primaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(primaryFragment);
            }
        });
        middleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(middleFragment);
            }
        });
        collegeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(collegeFragment);
            }
        });
        intent = new Intent(this,MusicService.class);
        startService(intent);
    }
    /**
     * 切换Fragment
     * */
    protected void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl,fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(intent);
    }
}
