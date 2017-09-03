package com.iak3.vina.finalproject.db;

import com.iak3.vina.finalproject.model.MovieEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vwinata on 9/2/2017.
 */

public class FavoriteMovie extends MovieEntity {


    public static FavoriteMovie fromMovie(MovieEntity movie) {
        FavoriteMovie favoriteMovie = new FavoriteMovie();
        favoriteMovie.voteCount = movie.getVoteCount();
        favoriteMovie.id = movie.getId();
        favoriteMovie.video = movie.isVideo();
        favoriteMovie.voteAverage = movie.getVoteAverage();
        favoriteMovie.title = movie.getTitle();
        favoriteMovie.popularity = movie.getPopularity();
        favoriteMovie.posterPath = movie.getPosterPath();
        favoriteMovie.originalLanguage = movie.getOriginalLanguage();
        favoriteMovie.originalTitle = movie.getOriginalTitle();
        favoriteMovie.backdropPath = movie.getBackdropPath();
        favoriteMovie.adult = movie.isAdult();
        favoriteMovie.overview = movie.getOverview();
        favoriteMovie.releaseDate = movie.getReleaseDate();

        favoriteMovie.genreIds = new ArrayList<>();
        List<Integer> genreIds = movie.getGenreIds();
        for (Integer genreId : genreIds) {
            IntegerObject integerObject = new IntegerObject();
            integerObject.getInteger = genreId;
            favoriteMovie.genreIds.add(genreId);
        }
        return favoriteMovie;
    }

    public static MovieEntity toMovie(FavoriteMovie favoriteMovie) {
        MovieEntity movie = new MovieEntity();
        movie.setVoteCount(favoriteMovie.voteCount);
        movie.setId(favoriteMovie.id);
        movie.setVideo(favoriteMovie.video);
        movie.setVoteAverage(favoriteMovie.voteAverage);
        movie.setTitle(favoriteMovie.title);
        movie.setPopularity(favoriteMovie.popularity);
        movie.setPosterPath(favoriteMovie.posterPath);
        movie.setOriginalLanguage(favoriteMovie.originalLanguage);
        movie.setOriginalTitle(favoriteMovie.originalTitle);
        movie.setBackdropPath(favoriteMovie.backdropPath);
        movie.setAdult(favoriteMovie.adult);
        movie.setOverview(favoriteMovie.overview);
        movie.setReleaseDate(favoriteMovie.releaseDate);
        List<Integer> genreList = new ArrayList<>();
       /* List<IntegerObject> integerObjectRealmList = favoriteMovie.genreIds;
        for (IntegerObject integerObject : integerObjectRealmList) {
            genreList.add(integerObject.integer);
        }*/
        movie.setGenreIds(genreList);
        return movie;
    }

}
