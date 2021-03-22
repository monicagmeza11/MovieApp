package com.mcode.movieapplicationmvp.models;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {
    @SerializedName("english_name")
    private String englishName;
    @SerializedName("iso_639_1")
    private String iso6391;
    @SerializedName("name")
    private String name;

    public SpokenLanguage(){}
}
