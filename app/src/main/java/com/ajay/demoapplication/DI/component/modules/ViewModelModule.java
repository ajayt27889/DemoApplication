package com.ajay.demoapplication.DI.component.modules;

import android.app.Application;
import com.ajay.demoapplication.viewmodel.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {
    @Singleton
    @Provides
    MainActivityViewModel getMainActivityViewModel(Application application){
        return new MainActivityViewModel(application);
    }
}
