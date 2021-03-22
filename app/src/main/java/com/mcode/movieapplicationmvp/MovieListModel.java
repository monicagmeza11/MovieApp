package com.mcode.movieapplicationmvp;

import com.mcode.movieapplicationmvp.io.ApiMoviesClient;
import com.mcode.movieapplicationmvp.io.ApiMoviesInterface;
import com.mcode.movieapplicationmvp.io.HttpMovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListModel implements MovieListMVP.Model{

    public MovieListMVP.Presenter presenter;
    ApiMoviesInterface apiMoviesInterface;

    public MovieListModel(MovieListMVP.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void refresh(MovieListMVP.CallBackResult callBackResult) {
        apiMoviesInterface = new ApiMoviesClient().getInstance().create(ApiMoviesInterface.class);
        Call<HttpMovieResponse> call = apiMoviesInterface.getMovieList();
        call.enqueue(new Callback<HttpMovieResponse>() {
            @Override
            public void onResponse(Call<HttpMovieResponse> call, Response<HttpMovieResponse> response) {
                if(response.isSuccessful() && response.body()!=null){
                    callBackResult.onSucess(response.body());
                }else{
                    callBackResult.onFailed("Ha ocurrido un error");
                }

            }

            @Override
            public void onFailure(Call<HttpMovieResponse> call, Throwable throwable) {
                callBackResult.onFailed("Ha ocurrido un error");
            }
        });
    }
}
