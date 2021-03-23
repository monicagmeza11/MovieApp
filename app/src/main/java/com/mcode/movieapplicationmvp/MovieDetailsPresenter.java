package com.mcode.movieapplicationmvp;

public class MovieDetailsPresenter implements MovieDetailsMVP.Presenter{
    private MovieDetailsMVP.View view;
    private MovieDetailsModel model;

    public MovieDetailsPresenter(MovieDetailsMVP.View view){
        this.view = view;
        model = new MovieDetailsModel(this);
    }


    @Override
    public void refresh(int idMovie, MovieDetailsMVP.CallBackResult callBackResult) {
        model.refresh(idMovie,callBackResult);
    }
}
