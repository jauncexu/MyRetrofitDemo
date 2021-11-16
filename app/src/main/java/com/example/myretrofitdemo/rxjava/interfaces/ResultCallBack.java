package com.example.myretrofitdemo.rxjava.interfaces;

public interface ResultCallBack<T> {
    void onBefore();

    void onAfter();

    void onSuccess(T data);

    void onFailed(String errMsg);
}
