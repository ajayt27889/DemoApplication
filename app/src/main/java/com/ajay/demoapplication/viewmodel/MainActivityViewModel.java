package com.ajay.demoapplication.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ajay.demoapplication.AllPhotosUseCase;
import com.ajay.demoapplication.model.unsplash.Photo;
import java.util.List;

public  class MainActivityViewModel extends AndroidViewModel {
    private static final String TAG = "MainActivityViewModel";
    public MutableLiveData<List<Photo>> PhotosLiveDate  = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void getPhotos(LifecycleOwner owner){
        AllPhotosUseCase obj = new AllPhotosUseCase();
        obj.execute();
        obj.photoResponseLiveData.observe(owner, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {
                PhotosLiveDate.setValue(photos);
            }
        });
    }
}
