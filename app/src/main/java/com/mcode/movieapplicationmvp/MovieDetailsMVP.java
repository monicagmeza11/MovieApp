package com.mcode.movieapplicationmvp;

import com.mcode.movieapplicationmvp.io.HttpMovieResponse;
import com.mcode.movieapplicationmvp.models.Movie;
import com.mcode.movieapplicationmvp.models.MovieDetails;

public class MovieDetailsMVP {

    public interface CallBackResult{
        void onSucess(MovieDetails movieResponse);
        void onFailed(String message);
    }

    public interface View {
        void showData(MovieDetails movieDetails);
        void refresh();
    }

    public interface Model {
        void refresh(int idMovie, MovieDetailsMVP.CallBackResult callBackResult);

    }

    public interface Presenter{
        void refresh(int idMovie, MovieDetailsMVP.CallBackResult callBackResult);

    }
}
