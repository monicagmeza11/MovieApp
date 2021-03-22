package com.mcode.movieapplicationmvp;

import com.mcode.movieapplicationmvp.io.HttpMovieResponse;

public class MovieListModel implements MovieListMVP.Model{

    public MovieListMVP.Presenter presenter;

    public MovieListModel(MovieListMVP.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void refresh(MovieListMVP.CallBackResult callBackResult) {

    }
}
