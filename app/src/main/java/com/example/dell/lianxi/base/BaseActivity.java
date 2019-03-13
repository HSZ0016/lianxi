package com.example.dell.lianxi.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        //查找控件
        //请求数据
        //事件
        setContentView(bindlayout());;
        initView();
        intData();
        Event();

    }

    protected abstract void intData();
    protected abstract void Event();
    protected abstract void initView();
    public abstract int bindlayout();

}
