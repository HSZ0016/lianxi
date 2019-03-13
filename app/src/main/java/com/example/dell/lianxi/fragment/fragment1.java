package com.example.dell.lianxi.fragment;

import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.lianxi.HTTPtitle;
import com.example.dell.lianxi.R;
import com.example.dell.lianxi.adapter.PAdapter;
import com.example.dell.lianxi.base.BaseFragment;
import com.example.dell.lianxi.bean.One;
import com.example.dell.lianxi.bean.Two;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.net.URL;
import java.util.List;

public class fragment1 extends BaseFragment {

    private PullToRefreshListView listView;
    private String url="https://api.apiopen.top/getJoke?page=1&count=2&type=video";
    private PAdapter pAdapter;
    private List<One> result;

    @Override
    public int bindlayout() {
        return R.layout.frag01;
    }
    @Override
    protected void initView() {
        listView = getView().findViewById(R.id.pull11);


        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setPullToRefreshOverScrollEnabled(true);


    }
    @Override
    protected void intData() {
        HTTPtitle.getAsynaTask(url, new HTTPtitle.CallBackA() {
            @Override
            public void getData(String s) {
                Gson gson=new Gson();
                Two two = gson.fromJson(s, Two.class);
                result = two.getResult();
                pAdapter = new PAdapter(getActivity(), result);
                listView.setAdapter(pAdapter);
            }
        });
    }

    @Override
    protected void Event() {
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                HTTPtitle.getAsynaTask(url, new HTTPtitle.CallBackA() {
                    @Override
                    public void getData(String s) {
                        Gson gson=new Gson();
                        Two two = gson.fromJson(s, Two.class);
                        List<One> result1 = two.getResult();
                        result.addAll(result1);
                        listView.onRefreshComplete();
                    }
                });
                listView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                HTTPtitle.getAsynaTask(url, new HTTPtitle.CallBackA() {
                    @Override
                    public void getData(String s) {
                        Gson gson=new Gson();
                        Two two = gson.fromJson(s, Two.class);
                        List<One> result2 = two.getResult();
                        result.addAll(result2);
                        listView.onRefreshComplete();
                    }
                });
                listView.onRefreshComplete();
            }
        });
    }


}
