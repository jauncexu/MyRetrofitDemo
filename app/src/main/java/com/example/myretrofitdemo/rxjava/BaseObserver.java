package com.example.myretrofitdemo.rxjava;


import com.example.myretrofitdemo.rxjava.interfaces.ResultCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<String> {
    private ResultCallBack mCallBack;

    public BaseObserver(ResultCallBack callBack) {
        mCallBack = callBack;
    }

    public ResultCallBack getCallBack() {
        return mCallBack;
    }

    public void setCallBack(ResultCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    public void onSubscribe(Disposable d) {
        mCallBack.onBefore();
    }

    @Override
    public void onNext(String value) {
        // errorCode,errorMsg,data
        try {
            JSONObject object = new JSONObject(value);
            int errorCode = object.getInt("errorCode");
            String errorMsg = object.getString("errorMsg");
            String data = object.optString("data");
            if (errorCode == 0) {
                handleSuccess(data);
            } else {
                handleFailed(errorMsg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected abstract void handleFailed(String errorMsg);

    protected abstract void handleSuccess(String data);

    @Override
    public void onError(Throwable e) {
        mCallBack.onFailed(e.getMessage());
    }

    @Override
    public void onComplete() {
        mCallBack.onAfter();
    }
}