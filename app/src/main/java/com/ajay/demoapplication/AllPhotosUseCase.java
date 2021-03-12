package com.ajay.demoapplication;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import com.ajay.demoapplication.model.unsplash.Photo;
import com.ajay.demoapplication.network.UnSplashRetrofitInstance;
import com.ajay.demoapplication.network.UnsplashServices;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllPhotosUseCase {
    private static final String TAG = "AllPhotosUseCase";
    public MutableLiveData<List<Photo>> photoResponseLiveData = new MutableLiveData<>();

    public void execute(){
        UnsplashServices service = UnSplashRetrofitInstance.getRetrofitInstance().create(UnsplashServices.class);
        Call<List<Photo>> call = service.getPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if(response.body()!=null){
                    photoResponseLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.d(TAG, "onResponse: failed");
            }
        });
    }
}
