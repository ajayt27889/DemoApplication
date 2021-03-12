package com.ajay.demoapplication.network;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnSplashRetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.unsplash.com";

    public static Retrofit getRetrofitInstance() {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Client-ID " + "21eb92414653b822289d8e63bead7cc1847c8973e474140bd188b3cd25d0fa81")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
