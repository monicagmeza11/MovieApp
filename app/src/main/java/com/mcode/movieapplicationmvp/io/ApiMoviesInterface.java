package com.mcode.movieapplicationmvp.io;


import com.mcode.movieapplicationmvp.models.MovieDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiMoviesInterface {

    @GET("movie/popular")
    Call<HttpMovieResponse> getMovieList();

    @GET("movie/{id}")
    Call<MovieDetails> getMovieDetail(@Path("id") String id);
}
