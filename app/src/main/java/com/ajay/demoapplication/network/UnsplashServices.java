package com.ajay.demoapplication.network;

import com.ajay.demoapplication.model.unsplash.Photo;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UnsplashServices {
    @GET("/photos")
    Call<List<Photo>> getPhotos();
}
