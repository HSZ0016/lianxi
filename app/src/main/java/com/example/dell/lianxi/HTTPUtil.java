package com.example.dell.lianxi;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPUtil {
    public static Boolean iswork(MainActivity mainActivity) {
        //判断是否有网
        //获取网络管理器
        ConnectivityManager manager= (ConnectivityManager) mainActivity.getSystemService(mainActivity.CONNECTIVITY_SERVICE);
        //获取网络状态
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        //判断是否成功
        if (activeNetworkInfo!=null){
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }
    public static String request(String str){
        try {
            URL url = new URL(str);
            //打开连接 HTTPURl
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
             //设置超时连接
            urlConnection.setConnectTimeout(5000);
            //设置读取连接
            urlConnection.setReadTimeout(5000);
            //请求方式
            urlConnection.setRequestMethod("GET");
            if (urlConnection.getResponseCode()==200) {
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer buffer=new StringBuffer();
                String strs="";
                while ((strs=bufferedReader.readLine())!=null){
                    buffer.append(strs);
                }
                return buffer.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return "";
    }

}
