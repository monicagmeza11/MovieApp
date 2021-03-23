package com.mcode.movieapplicationmvp;


import com.mcode.movieapplicationmvp.io.ApiMoviesClient;
import com.mcode.movieapplicationmvp.io.ApiMoviesInterface;
import com.mcode.movieapplicationmvp.models.MovieDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsModel implements MovieDetailsMVP.Model{
    public MovieDetailsMVP.Presenter presenter;
    ApiMoviesInterface apiMoviesInterface;

    public MovieDetailsModel(MovieDetailsMVP.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void refresh(int idMovie, MovieDetailsMVP.CallBackResult callBackResult) {
        apiMoviesInterface = new ApiMoviesClient().getInstance().create(ApiMoviesInterface.class);
        Call<MovieDetails> call = apiMoviesInterface.getMovieDetail(Integer.toString(idMovie));
        call.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {
                if(response.isSuccessful() && response.body()!=null){
                    callBackResult.onSucess(response.body());
                }else{
                    callBackResult.onFailed("Ha ocurrido un error");
                }
            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable throwable) {
                callBackResult.onFailed("Ha ocurrido un error");
            }
        });
    }
}
