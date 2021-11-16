package com.example.myretrofitdemo.rxjava;

import com.example.myretrofitdemo.rxjava.interfaces.ResultCallBack;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ResultObserver<T> extends BaseObserver<T> {
    public ResultObserver(ResultCallBack callBack) {
        super(callBack);
        setCallBack(callBack);
    }

    // 获取类型  默认为string
    private Type getType() {
        Type genericSuperclass = getCallBack().getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        }
        return String.class;
    }

    @Override
    protected void handleFailed(String errorMsg) {
        getCallBack().onFailed(errorMsg);
    }

    @Override
    protected void handleSuccess(String data) {
        T t = new Gson().fromJson(data, getType());
        getCallBack().onSuccess(t);
    }
}
