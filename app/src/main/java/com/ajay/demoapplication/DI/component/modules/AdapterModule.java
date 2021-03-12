package com.ajay.demoapplication.DI.component.modules;

import com.ajay.demoapplication.adapter.PhotoAdapter;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {
    @Singleton
    @Provides
    PhotoAdapter getPhotoAdapter(){
        return new PhotoAdapter();
    }
}
