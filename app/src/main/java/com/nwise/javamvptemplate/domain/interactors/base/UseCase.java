package com.nwise.javamvptemplate.domain.interactors.base;
import com.nwise.javamvptemplate.domain.executer.PostExecutionThread;
import com.nwise.javamvptemplate.domain.executer.UseCaseExecutor;
import io.reactivex.Scheduler;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */

public abstract class UseCase<P, Q> {

    private final UseCaseExecutor useCaseExecutor;
    private final PostExecutionThread postExecutionThread;

    public UseCase(UseCaseExecutor useCaseExecutor,
                   PostExecutionThread postExecutionThread) {
        this.useCaseExecutor = useCaseExecutor;
        this.postExecutionThread = postExecutionThread;
    }


    public abstract P execute(Q param);


    protected abstract P interact(Q param);

    public Scheduler getUseCaseExecutor() {
        return useCaseExecutor.getScheduler();
    }

    public Scheduler getPostExecutionThread() {
        return postExecutionThread.getScheduler();
    }
}
