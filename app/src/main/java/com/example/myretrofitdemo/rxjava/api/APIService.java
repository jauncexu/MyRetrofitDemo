package com.example.myretrofitdemo.rxjava.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface APIService {
    @GET("/user/lg/userinfo/json")
    Observable<ResponseBody> getUerInfo();
}