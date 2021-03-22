package com.mcode.movieapplicationmvp.io;

import com.google.gson.annotations.SerializedName;
import com.mcode.movieapplicationmvp.models.Movie;


import java.util.ArrayList;

public class HttpMovieResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private ArrayList<Movie> results;

    public HttpMovieResponse(){}

    public ArrayList<Movie> getResults() {
        return results;
    }
}
