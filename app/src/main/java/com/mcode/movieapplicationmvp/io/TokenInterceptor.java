package com.mcode.movieapplicationmvp.io;



import com.mcode.movieapplicationmvp.utils.Utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request headerRequest=chain.request().newBuilder()
                .header("Authorization","Bearer "+ Utils.BEARER_TOKEN)
                .build();

        return chain.proceed(headerRequest);
    }
}
