package com.iak3.vina.finalproject.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vwinata on 9/2/2017.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "http://api.themoviedb.org/3/";

    private static OkHttpClient.Builder sHttpClient =
            new OkHttpClient.Builder()
                    .addInterceptor(new ApiKeyAdderInterceptor());

    private static Retrofit.Builder sBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(sHttpClient.build());

    public static <T> T createService(Class<T> serviceClass) {
        return sBuilder.build().create(serviceClass);
    }
}
