package com.mcode.movieapplicationmvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.mcode.movieapplicationmvp.models.Genre;
import com.mcode.movieapplicationmvp.models.MovieDetails;
import com.mcode.movieapplicationmvp.ui.MasterFragment;
import com.mcode.movieapplicationmvp.utils.Utils;

import java.util.ArrayList;


public class DetailsFragment extends MasterFragment implements MovieDetailsMVP.View {
    private int idMovie;
    MovieDetailsPresenter presenter;
    TextView information, popularity, voteCount;
    ImageView backdropImage;
    RatingBar rating;
    ChipGroup genreGroup;
    View contentInformation, noDataMessage;
    Button retryDownload;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            idMovie = bundle.getInt(Utils.KEY_ID_MOVIE, 0);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new MovieDetailsPresenter(this);
        information = (TextView) view.findViewById(R.id.information);
        backdropImage = (ImageView) view.findViewById(R.id.image);
        rating = (RatingBar) view.findViewById(R.id.ratingStar);
        genreGroup = (ChipGroup) view.findViewById(R.id.content_genres);
        popularity = (TextView) view.findViewById(R.id.popularity);
        voteCount = (TextView) view.findViewById(R.id.vote_count);
        noDataMessage = view.findViewById(R.id.action_no_data);
        contentInformation = view.findViewById(R.id.content_information);
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
    public void showData(MovieDetails movieDetails) {
        getActivity().setTitle(movieDetails.getTitle());
        information.setText(movieDetails.getOverview());
        rating.setRating((float)movieDetails.getVoteAverage());
        voteCount.setText(Integer.toString(movieDetails.getVoteCount()));
        popularity.setText(Double.toString(movieDetails.getPopularity()));
        processGenres(movieDetails.getGenres());
        Glide.with(getActivity()).load(movieDetails.getUrlBackdopPath()).placeholder(R.drawable.ic__local_movies).into(backdropImage);
    }

    @Override
    public void refresh() {
        showDialog("Obteniendo información de la película");
        presenter.refresh(idMovie, new MovieDetailsMVP.CallBackResult() {
            @Override
            public void onSucess(MovieDetails movieResponse) {
                dismissDialog();
                showData(movieResponse);
                contentInformation.setVisibility(View.VISIBLE);
                noDataMessage.setVisibility(View.GONE);

            }

            @Override
            public void onFailed(String message) {
                dismissDialog();
                contentInformation.setVisibility(View.GONE);
                noDataMessage.setVisibility(View.VISIBLE);
            }
        });
    }

    public void processGenres(ArrayList<Genre> genres){
        if(!genres.isEmpty()){
            for(Genre genre: genres){
                Chip chipGenre = new Chip(genreGroup.getContext());
                chipGenre.setText(genre.name);
                genreGroup.addView(chipGenre);
            }
        }
    }
}