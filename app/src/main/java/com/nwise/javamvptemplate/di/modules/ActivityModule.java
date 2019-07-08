package com.nwise.javamvptemplate.di.modules;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
@Module
public class ActivityModule {
    final Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    public Context context() {
        return activity();
    }

    @Provides
    public Activity activity() {
        return mActivity;
    }

    @Provides
    LayoutInflater layoutInflater() {
        return mActivity.getLayoutInflater();
    }
}
