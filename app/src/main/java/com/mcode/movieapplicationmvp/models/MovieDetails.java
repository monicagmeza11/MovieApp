package com.mcode.movieapplicationmvp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieDetails {
    @SerializedName("id")
    private int id;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    private BelongsToCollection belongsToCollection;
    @SerializedName("budget")
    private int budget;
    @SerializedName("genres")
    private ArrayList<Genre> genres;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("imdb_id")
    private String imdbId;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("production_companies")
    private ArrayList<ProductionCompany> productionCompanies;
    @SerializedName("production_countries")
    private ArrayList<ProductionCountry> productionCountries;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("revenue")
    private int revenue;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("spoken_languages")
    private ArrayList<SpokenLanguage> spokenLanguages;
    @SerializedName("status")
    private String status;
    @SerializedName("tagline")
    private String tagLine;
    @SerializedName("title")
    private String title;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("vote_count")
    private int voteCount;

}
