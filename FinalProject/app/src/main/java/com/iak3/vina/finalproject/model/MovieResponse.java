package com.iak3.vina.finalproject.model;

/**
 * Created by vwinata on 28/08/2017.
 */


import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MovieResponse {

    public int page;
    //if name from api and name from variable is not the same
    @SerializedName("total_results")
    public int totalResults;

    @SerializedName("total_pages")
    public int totalPages;

    public List<MovieEntity> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<MovieEntity> getResults() {
        return results;
    }

    public void setResults(List<MovieEntity> results) {
        this.results = results;
    }
}
