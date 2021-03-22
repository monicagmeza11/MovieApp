package com.mcode.movieapplicationmvp.models;

import com.google.gson.annotations.SerializedName;

public class ProductionCountry {
    @SerializedName("iso_3166_1")
    public String iso31661;
    @SerializedName("name")
    public String name;

    public ProductionCountry(){}
}
