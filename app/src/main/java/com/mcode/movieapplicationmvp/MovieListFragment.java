package com.mcode.movieapplicationmvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mcode.movieapplicationmvp.models.Movie;

public class MovieListFragment extends Fragment implements MovieListMVP.View{

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
    public void toDetailsFragment(View v, int idMovie){
        Bundle bundle = new Bundle();
        bundle.putInt("idMovie", idMovie);
        Navigation.findNavController(v).navigate(R.id.toDetailsFragment, bundle);
    }

    @Override
    public int getIdMovie(Movie movie) {
        return movie.getId();
    }
}