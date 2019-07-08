package com.nwise.javamvptemplate.domain.interactors.base;

import com.nwise.javamvptemplate.domain.executer.PostExecutionThread;
import com.nwise.javamvptemplate.domain.executer.UseCaseExecutor;
import com.nwise.javamvptemplate.network.Repository;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public abstract class FlowableUseCase<R, Q> extends UseCase<Flowable, Q> {

    public FlowableUseCase(UseCaseExecutor useCaseExecutor,
                           PostExecutionThread postExecutionThread,
                           Repository apiRepository) {
        super(useCaseExecutor, postExecutionThread);

        schedulersTransformer = rObservable -> rObservable.subscribeOn(useCaseExecutor.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }

    private final FlowableTransformer<? super R, ? extends R> schedulersTransformer;

    @Override
    public Flowable<R> execute(Q param) {
        return interact(param).compose(getSchedulersTransformer());
    }

    @Override
    protected abstract Flowable<R> interact(Q param);

    private FlowableTransformer<? super R, ? extends R> getSchedulersTransformer() {
        return schedulersTransformer;
    }
}
