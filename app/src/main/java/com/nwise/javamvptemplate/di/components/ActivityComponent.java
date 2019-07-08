package com.nwise.javamvptemplate.di.components;


import com.nwise.javamvptemplate.di.modules.ActivityModule;
import com.nwise.javamvptemplate.di.scopes.ActivityScope;
import com.nwise.javamvptemplate.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
