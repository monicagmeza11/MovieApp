package com.mcode.movieapplicationmvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mcode.movieapplicationmvp.MovieListPresenter;
import com.mcode.movieapplicationmvp.R;
import com.mcode.movieapplicationmvp.models.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder>  {
    LayoutInflater inflater;
    ArrayList<Movie> movies;

    Context context;
    public MovieAdapter(ArrayList<Movie> movies, Context context){
        inflater = LayoutInflater.from(context);
        this.movies = movies;

        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_movie_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        holder.nameMovie.setText(movies.get(position).getTitle());
        holder.nameMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MovieListPresenter().toDetailsFragment(v, movies.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }



    @Override
    public long getItemId(int position) {
        return position;
    }



}

