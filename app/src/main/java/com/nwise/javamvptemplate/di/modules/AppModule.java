package com.nwise.javamvptemplate.di.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nwise.javamvptemplate.MainApplication;
import com.nwise.javamvptemplate.domain.executer.NetworkJobExecutor;
import com.nwise.javamvptemplate.domain.executer.PostExecutionThread;
import com.nwise.javamvptemplate.domain.executer.UseCaseExecutor;
import com.nwise.javamvptemplate.network.AppApi;
import com.nwise.javamvptemplate.network.Repository;
import com.nwise.javamvptemplate.network.RestDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */

@Module
public class AppModule {

    private final MainApplication application;

    public AppModule(@NonNull MainApplication context) {
        this.application = context;
    }

    @NonNull
    @Provides
    Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    MainApplication provideApplication() {
        return this.application;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @NonNull
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(AppApi.BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    Repository provideDataRepository(RestDataSource restDataSource) {
        return restDataSource;
    }

    @NonNull
    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }


    @NonNull
    @Provides
    @Singleton
    public UseCaseExecutor provideUseCaseExecutor() {
        return new NetworkJobExecutor();
    }

    @NonNull
    @Provides
    @Singleton
    public PostExecutionThread postExecutionThread() {
        return AndroidSchedulers::mainThread;
    }
}
