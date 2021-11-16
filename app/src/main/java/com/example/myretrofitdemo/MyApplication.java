package com.example.myretrofitdemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.myretrofitdemo.constanst.Urls;
import com.example.myretrofitdemo.rxjava.RetrofitUtils;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    private Context mContext;

    public void setContext(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化retrofit
        initRetrofit();
    }

    private void initRetrofit() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("MyApplication", "" + message);
            }
        });
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logInterceptor) // 添加日志打印
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        RetrofitUtils.getInstance().initClient(retrofit);
    }
}
