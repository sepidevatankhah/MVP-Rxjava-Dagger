package com.nwise.javamvptemplate.di.components;


import com.nwise.javamvptemplate.di.modules.ActivityModule;
import com.nwise.javamvptemplate.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
@Singleton
@Component(modules = {AppModule.class })
public interface AppComponent {

    ActivityComponent plus(ActivityModule module);


}