package com.mcode.movieapplicationmvp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.navigation.Navigation;

public class MovieListPresenter implements MovieListMVP.Presenter{

    private MovieListMVP.View view;
    private MovieListModel model;

    public MovieListPresenter(MovieListMVP.View view){
        this.view = view;
        model = new MovieListModel(this);
    }

    public MovieListPresenter(){}

    @Override
    public void refresh(MovieListMVP.CallBackResult callBackResult) {
        model.refresh(callBackResult);
    }

    @Override
    public void toDetailsFragment(View v, int idMovie) {
        Bundle bundle = new Bundle();
        bundle.putInt("idMovie", idMovie);
        Navigation.findNavController(v).navigate(R.id.toDetailsFragment, bundle);
    }


    public MovieListMVP.View getView() {
        return view;
    }
}
