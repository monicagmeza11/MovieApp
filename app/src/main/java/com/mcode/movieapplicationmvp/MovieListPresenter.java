package com.mcode.movieapplicationmvp;

import android.content.Context;

public class MovieListPresenter implements MovieListMVP.Presenter{

    private MovieListMVP.View view;
    private MovieListModel model;

    public MovieListPresenter(MovieListMVP.View view){
        this.view = view;
        model = new MovieListModel(this);
    }

    @Override
    public void refresh(MovieListMVP.CallBackResult callBackResult) {
        model.refresh(callBackResult);
    }
}
