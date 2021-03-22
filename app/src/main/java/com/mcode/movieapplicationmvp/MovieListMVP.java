package com.mcode.movieapplicationmvp;

import android.view.View;

public class MovieListMVP {

    public interface View {
        void toDetailsFragment(android.view.View v, int idMovie);
    }

}
