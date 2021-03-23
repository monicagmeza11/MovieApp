package com.mcode.movieapplicationmvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mcode.movieapplicationmvp.adapters.MovieAdapter;
import com.mcode.movieapplicationmvp.adapters.MovieViewHolder;
import com.mcode.movieapplicationmvp.io.HttpMovieResponse;
import com.mcode.movieapplicationmvp.models.Movie;
import com.mcode.movieapplicationmvp.ui.MasterFragment;
import com.mcode.movieapplicationmvp.utils.Utils;

import java.util.ArrayList;

public class MovieListFragment extends MasterFragment implements MovieListMVP.View {
    MovieListPresenter presenter;
    ArrayList<Movie> movies = new ArrayList<>();
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    RelativeLayout noItemsMessage;
    Button retryDownload;
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
        getActivity().setTitle(R.string.app_name);
        presenter = new MovieListPresenter(this);
        showDialog("Cargando...");
        recyclerView = view.findViewById(R.id.grid_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));

        noItemsMessage = (RelativeLayout) view.findViewById(R.id.action_no_items);
        retryDownload = (Button) view.findViewById(R.id.retry);
        retryDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
            }
        });

        refresh();
    }

    @Override
    public void toDetailsFragment(View v, int idMovie){
        Bundle bundle = new Bundle();
        bundle.putInt(Utils.KEY_ID_MOVIE, idMovie);
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
                dismissDialog();
                if(movieResponse!=null){
                    movies = movieResponse.getResults();
                    movieAdapter = new MovieAdapter(movies, getActivity());
                    recyclerView.setAdapter(movieAdapter);
                    noItemsMessage.setVisibility(View.GONE);
                }else{
                    noItemsMessage.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailed(String message) {
                dismissDialog();
                noItemsMessage.setVisibility(View.VISIBLE);
            }
        });
    }


}