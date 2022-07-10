package com.zc;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Executors;

/**
 * guava异步回调测试
 *
 * @author 周超
 * @since 2022/7/9 9:20
 */
public class GuavaFutureCallbackDemo {
    public static void main(String[] args) {
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));
        ListenableFuture<?> hello = listeningExecutorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello");
        });
        Futures.addCallback(hello, new FutureCallback<Object>() {
            @Override
            public void onSuccess(Object result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        }, listeningExecutorService);
    }
}
