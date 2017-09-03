package com.iak3.vina.finalproject.network;

import android.support.annotation.NonNull;

import com.iak3.vina.finalproject.utils.ServiceUtils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by vwinata on 9/2/2017.
 */


public class ApiKeyAdderInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final HttpUrl url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", ServiceUtils.API_KEY)
                .build();
        final Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
