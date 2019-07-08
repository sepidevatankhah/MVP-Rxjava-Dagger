package com.nwise.javamvptemplate.domain.executer;

import io.reactivex.Scheduler;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public interface PostExecutionThread {

     Scheduler getScheduler();


}
