package com.ajay.demoapplication.DI.component;

import com.ajay.demoapplication.DI.component.modules.AdapterModule;
import com.ajay.demoapplication.DI.component.modules.ApplicationModule;
import com.ajay.demoapplication.DI.component.modules.ViewModelModule;
import com.ajay.demoapplication.MainActivity;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AdapterModule.class, ViewModelModule.class, ApplicationModule.class})

public interface DummyComponent {
    void inject(MainActivity activity);
}
