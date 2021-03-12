package com.ajay.demoapplication;

import com.ajay.demoapplication.model.unsplash.Photo;
import com.ajay.demoapplication.network.UnSplashRetrofitInstance;
import com.ajay.demoapplication.network.UnsplashServices;
import org.junit.Test;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertTrue;

public class GetPhotosTest {

    @Test
    public void getPhotos(){

        UnsplashServices service = UnSplashRetrofitInstance.getRetrofitInstance().create(UnsplashServices.class);
        Call<List<Photo>> call = service.getPhotos();

        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.body() != null) {
                    assertTrue(true);
                }else{
                    assertTrue(false);
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }
}
