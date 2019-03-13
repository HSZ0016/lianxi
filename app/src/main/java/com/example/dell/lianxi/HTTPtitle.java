package com.example.dell.lianxi;

import android.os.AsyncTask;

public class HTTPtitle {
    public static void getAsynaTask(String url,final CallBackA backA){
        new AsyncTask<String,Void,String>(){
            //请求数据方法
            @Override
            protected String doInBackground(String... strings) {
                return HTTPUtil.request(strings[0]);
            }
            //回调的方法


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backA.getData(s);
            }
        }.execute(url);

    }
    //重写个接口
    public interface CallBackA{
        //回调这个方法
        void getData(String s);
    }
}
