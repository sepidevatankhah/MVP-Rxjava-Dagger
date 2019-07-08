package com.nwise.javamvptemplate.domain.executer;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public class NetworkJobExecutor implements UseCaseExecutor {

    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
