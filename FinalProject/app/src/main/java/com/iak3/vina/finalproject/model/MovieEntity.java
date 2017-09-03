package com.iak3.vina.finalproject.model;

/**
 * Created by vwinata on 28/08/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MovieEntity implements Parcelable{;

    public int voteCount;
    public int id;
    public boolean video;
    public float voteAverage;
    public String title;
    public float popularity;
    public String posterPath;
    public String originalLanguage;
    public String originalTitle;
    public List<Integer> genreIds;
    public String backdropPath;
    public boolean adult;
    public String overview;
    public String releaseDate;

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }


    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }


    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.voteCount);
        dest.writeValue(this.id);
        dest.writeValue(this.video);
        dest.writeValue(this.voteAverage);
        dest.writeString(this.title);
        dest.writeValue(this.popularity);
        dest.writeString(this.posterPath);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.originalTitle);
        dest.writeList(this.genreIds);
        dest.writeString(this.backdropPath);
        dest.writeValue(this.adult);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
    }

    public MovieEntity() {
    }

    protected MovieEntity(Parcel in) {
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.video = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.voteAverage = (Float) in.readValue(Double.class.getClassLoader());
        this.title = in.readString();
        this.popularity = (Float) in.readValue(Double.class.getClassLoader());
        this.posterPath = in.readString();
        this.originalLanguage = in.readString();
        this.originalTitle = in.readString();
        this.genreIds = new ArrayList<Integer>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.backdropPath = in.readString();
        this.adult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.overview = in.readString();
        this.releaseDate = in.readString();
    }

    public static final Parcelable.Creator<MovieEntity> CREATOR = new Parcelable.Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel source) {
            return new MovieEntity(source);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };
}
