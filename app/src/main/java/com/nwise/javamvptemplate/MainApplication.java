package com.nwise.javamvptemplate;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.nwise.javamvptemplate.di.components.ActivityComponent;
import com.nwise.javamvptemplate.di.components.AppComponent;
import com.nwise.javamvptemplate.di.components.DaggerAppComponent;
import com.nwise.javamvptemplate.di.modules.ActivityModule;
import com.nwise.javamvptemplate.di.modules.AppModule;

public class MainApplication extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static ActivityComponent getComponent(AppCompatActivity activity) {
        return component.plus(new ActivityModule(activity));
    }

}
