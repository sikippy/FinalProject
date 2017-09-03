package com.iak3.vina.finalproject.network;

/**
 * Created by vwinata on 28/08/2017.
 */


import com.iak3.vina.finalproject.model.MovieResponse;
import com.iak3.vina.finalproject.model.ReviewResponse;
import com.iak3.vina.finalproject.model.VideoResponse;
import com.iak3.vina.finalproject.utils.ServiceUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
    @GET(ServiceUtils.POP_MOVIE_URL)
    Call<MovieResponse> getPopularMovie(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    /**
     * It will be generate URI:
     * http://api.themoviedb.org/3/movie/top_rated?api_key=<key>&page=<page>
     * @param apiKey
     * @param page
     * @return
     */
    @GET(ServiceUtils.TOP_MOVIE_URL)
    Call<MovieResponse> getTopRatedMovie(
            @Query("api_key") String apiKey,
            @Query("page") int page);

    @GET("movie/{category}")
    Call<MovieResponse> getMovies(@Path("category") String category);

    @GET("movie/{movie_id}/reviews?language=en-US&page=1")
    Call<ReviewResponse> getReviews(@Path("movie_id") Integer movieId);

    @GET("movie/{movie_id}/videos")
    Call<VideoResponse> getVideos(@Path("movie_id") Integer movieId);
}
