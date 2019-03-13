package com.example.dell.lianxi;

import android.os.Trace;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.dell.lianxi.base.BaseActivity;
import com.example.dell.lianxi.fragment.fragment1;
import com.example.dell.lianxi.fragment.fragment2;
import com.example.dell.lianxi.fragment.fragment3;

public class MainActivity extends BaseActivity {

    private RadioGroup group;
    private FragmentManager supportFragmentManager;
    private com.example.dell.lianxi.fragment.fragment1 fragment1;
    private com.example.dell.lianxi.fragment.fragment2 fragment2;
    private com.example.dell.lianxi.fragment.fragment3 fragment3;


    @Override
    protected void initView() {
        group = findViewById(R.id.radio_group);
    }
    @Override
    protected void intData() {
        fragment1 = new fragment1();
        fragment2 = new fragment2();
        fragment3 = new fragment3();
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.frame_layout,fragment1)
                .add(R.id.frame_layout,fragment2)
                .add(R.id.frame_layout,fragment3)
                .show(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .commit();
    }

    @Override
    protected void Event() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                switch (checkedId){
                    case R.id.rb1:
                        transaction .show(fragment1)
                                .hide(fragment2)
                                .hide(fragment3).commit();
                        break;
                    case R.id.rb2:
                        transaction .show(fragment2)
                                .hide(fragment1)
                                .hide(fragment3).commit();
                        break;
                    case R.id.rb3:
                        transaction .show(fragment3)
                                .hide(fragment2)
                                .hide(fragment1).commit();
                        break;

                }
            }
        });
    }



    @Override
    public int bindlayout() {
        return R.layout.activity_main;
    }
}
