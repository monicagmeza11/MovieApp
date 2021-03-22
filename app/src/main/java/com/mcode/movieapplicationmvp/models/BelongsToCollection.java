package com.mcode.movieapplicationmvp.models;

import com.google.gson.annotations.SerializedName;

public class BelongsToCollection {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("poster_path")
    public String posterPath;
    @SerializedName("backdrop_path")
    public String backdropPath;

    public BelongsToCollection(){}
}
