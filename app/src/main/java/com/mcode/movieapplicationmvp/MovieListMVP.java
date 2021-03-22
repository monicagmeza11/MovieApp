package com.mcode.movieapplicationmvp;

import android.view.View;

import com.mcode.movieapplicationmvp.io.HttpMovieResponse;
import com.mcode.movieapplicationmvp.models.Movie;

public class MovieListMVP {

    public interface View {
        void toDetailsFragment(android.view.View v, int idMovie);
        int getIdMovie(Movie movie);
        void refresh();
    }

    public interface Model {
        void refresh(MovieListMVP.CallBackResult callBackResult);

    }

    public interface Presenter{
        void refresh(MovieListMVP.CallBackResult callBackResult);
    }

    public interface CallBackResult{
        void onSucess(HttpMovieResponse movieResponse);
        void onFailed(String message);
    }

}
