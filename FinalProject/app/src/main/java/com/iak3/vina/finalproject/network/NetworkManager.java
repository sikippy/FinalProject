package com.iak3.vina.finalproject.network;

/**
 * Created by vwinata on 28/08/2017.
 */


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.iak3.vina.finalproject.model.MovieResponse;
import com.iak3.vina.finalproject.utils.ServiceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
    set Gson naming policy. It will be used in GsonConverterFactory
 */

public class NetworkManager {

    /**
     * Set Gson naming policy. It will be used in GsonConverterFactory
     */
    public static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public static Retrofit INSTANCE;

    public static Retrofit getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(ServiceUtils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GSON))
                    .build();
        }
        return INSTANCE;
    }

    public static void getPopularMovie(int page, final NetworkCallback callback) {
        MovieService movieService = getInstance().create(MovieService.class);

        Call<MovieResponse> call = movieService.getPopularMovie(ServiceUtils.API_KEY, page);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable throwable) {
                callback.onFailure(throwable);
            }
        });
    }

    // TODO 1) added method to get top rated movie!
    public static void getTopRatedMovie(int page, final NetworkCallback callback) {
        MovieService movieService = getInstance().create(MovieService.class);

        Call<MovieResponse> call = movieService.getTopRatedMovie(ServiceUtils.API_KEY, page);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable throwable) {
                callback.onFailure(throwable);
            }
        });
    }

    public interface NetworkCallback {
        void onFailure(Throwable throwable);
        void onSuccess(MovieResponse movieResponse);
    }
}
