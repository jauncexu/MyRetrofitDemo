package com.example.myretrofitdemo.rxjava;

import com.example.myretrofitdemo.bean.UserInfo;
import com.example.myretrofitdemo.rxjava.api.APIService;
import com.example.myretrofitdemo.rxjava.interfaces.RealCallBack;
import com.example.myretrofitdemo.rxjava.interfaces.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class HttpRequest {
    private final APIService mAPIService;

    private HttpRequest() {
        mAPIService = RetrofitUtils.getInstance().createReq(APIService.class);
    }

    private static class HttpHold {
        private static final HttpRequest INSTANCE = new HttpRequest();
    }

    public static HttpRequest getInstance() {
        return HttpHold.INSTANCE;
    }

    private void request(Observable<ResponseBody> observable, ResultCallBack callBack) {
        observable.map(new Function<ResponseBody, String>() {
            @Override
            public String apply(ResponseBody responseBody) throws Exception {
                return responseBody.string();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen(new RetryWithDelay(3, 5000))
                .subscribe(new ResultObserver<>(callBack));
    }

    /**
     * 获取用户信息接口
     */
    public void getUserInfo(RealCallBack<UserInfo> callBack) {
        request(mAPIService.getUerInfo(), callBack);
    }
}
