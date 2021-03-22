package com.mcode.movieapplicationmvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mcode.movieapplicationmvp.io.HttpMovieResponse;
import com.mcode.movieapplicationmvp.models.Movie;

import java.util.ArrayList;

public class MovieListFragment extends Fragment implements MovieListMVP.View{
    MovieListPresenter presenter;
    ArrayList<Movie> movies;
    RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_movie_list, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        presenter = new MovieListPresenter(this);
        refresh();
    }

    @Override
    public void toDetailsFragment(View v, int idMovie){
        Bundle bundle = new Bundle();
        bundle.putInt("idMovie", idMovie);
        Navigation.findNavController(v).navigate(R.id.toDetailsFragment, bundle);
    }

    @Override
    public int getIdMovie(Movie movie) {
        return movie.getId();
    }

    @Override
    public void refresh() {
        presenter.refresh(new MovieListMVP.CallBackResult() {
            @Override
            public void onSucess(HttpMovieResponse movieResponse) {
                if(movieResponse!=null){
                    movies = movieResponse.getResults();
                }
            }

            @Override
            public void onFailed(String message) {
                Log.e("status", message);
            }
        });
    }
}