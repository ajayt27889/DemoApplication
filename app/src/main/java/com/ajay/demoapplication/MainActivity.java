package com.ajay.demoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.ajay.demoapplication.DI.component.DaggerDummyComponent;
import com.ajay.demoapplication.DI.component.DummyComponent;
import com.ajay.demoapplication.DI.component.modules.ApplicationModule;
import com.ajay.demoapplication.adapter.PhotoAdapter;
import com.ajay.demoapplication.model.unsplash.Photo;
import com.ajay.demoapplication.viewmodel.MainActivityViewModel;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    RecyclerView rv_photos;

    @Inject
    MainActivityViewModel viewModel;
    @Inject
    PhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DummyComponent component = DaggerDummyComponent.builder().applicationModule(new ApplicationModule(getApplication())).build();
        component.inject(this);
        rv_photos = findViewById(R.id.rv_photos);

        viewModel.PhotosLiveDate.observe(this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> data) {
                if(data!=null){
                    rv_photos.setAdapter(adapter);
                    adapter.submitNewList(data);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        viewModel.getPhotos(this);
    }
}