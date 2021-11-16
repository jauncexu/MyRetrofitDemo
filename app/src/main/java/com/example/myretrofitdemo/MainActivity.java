package com.example.myretrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myretrofitdemo.bean.UserInfo;
import com.example.myretrofitdemo.rxjava.HttpRequest;
import com.example.myretrofitdemo.rxjava.interfaces.RealCallBack;
import com.example.myretrofitdemo.rxjava.interfaces.ResultCallBack;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpRequest.getInstance().getUserInfo(new RealCallBack<UserInfo>() {
                    @Override
                    public void onSuccess(UserInfo data) {
                        Log.w(TAG, "onSuccess:" + data.toString());
                    }

                    @Override
                    public void onFailed(String errMsg) {
                        Log.w(TAG, "onFailed:" + errMsg);
                    }
                });
            }
        }).start();
    }
}