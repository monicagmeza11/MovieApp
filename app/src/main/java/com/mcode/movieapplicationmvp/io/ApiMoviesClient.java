package com.mcode.movieapplicationmvp.io;

import android.app.Application;

import com.mcode.movieapplicationmvp.utils.Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMoviesClient {
    private static Retrofit retrofit = null;

    public void buildInstance(){
        TokenInterceptor interceptor = new TokenInterceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Utils.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public Retrofit getInstance(){
        if(retrofit==null){
            buildInstance();
        }
        return retrofit;
    }

    public ApiMoviesClient(){}
}
