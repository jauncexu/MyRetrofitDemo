package com.example.myretrofitdemo.rxjava;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;


public class RetryWithDelay implements Function<Observable<Throwable>, ObservableSource<?>> {
    private final int maxRetries;   // 最大重试次数
    private final int retryDelayMillis;  // 重试延迟时间
    private int retryCount;

    public RetryWithDelay(int maxRetries, int retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
    }

    @Override
    public ObservableSource<?> apply(@NonNull Observable<Throwable> throwableObservable) throws Exception {
        return throwableObservable
                .flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(@NonNull Throwable throwable) throws Exception {

                        if (++retryCount <= maxRetries) {
                            // 重新请求
                            return Observable.timer(retryDelayMillis, TimeUnit.MILLISECONDS);
                        }
                        // 超过最大重试次数
                        return Observable.error(throwable);
                    }
                });
    }
}
