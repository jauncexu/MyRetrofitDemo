package com.example.myretrofitdemo.rxjava;

import retrofit2.Retrofit;

public class RetrofitUtils {
    private Retrofit mRetrofit;

    private RetrofitUtils() {
    }

    public void initClient(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    private static final class RetrofitHolder {
        private static final RetrofitUtils INSTANCE = new RetrofitUtils();
    }

    public static RetrofitUtils getInstance() {
        return RetrofitHolder.INSTANCE;
    }

    public <T> T createReq(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }
}
