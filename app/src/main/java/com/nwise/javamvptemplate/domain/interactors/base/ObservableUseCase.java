package com.nwise.javamvptemplate.domain.interactors.base;
import android.util.Log;
import com.nwise.javamvptemplate.domain.executer.PostExecutionThread;
import com.nwise.javamvptemplate.domain.executer.UseCaseExecutor;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public abstract class ObservableUseCase<R, Q> extends UseCase<Observable, Q> {
    public ObservableUseCase(UseCaseExecutor useCaseExecutor,
                             PostExecutionThread postExecutionThread) {
        super(useCaseExecutor, postExecutionThread);

        schedulersTransformer = rObservable -> rObservable.subscribeOn(useCaseExecutor.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }

    private final ObservableTransformer<? super R, ? extends R> schedulersTransformer;

    @Override
    public Observable<R> execute(Q param) {
        return Observable.create(subscriber -> {
            interact(param).compose(getSchedulersTransformer()).subscribe(o -> {
                subscriber.onNext(o);
                subscriber.onComplete();
            }, error -> {
                Log.e("ObservableUseCase" , "error message : " +error.getMessage() +
                        "error StackTrace : " +  error.getStackTrace());
                //changing error message
//                if (error.getMessage().toLowerCase().contains("timeout")||error.getMessage()
//                        .toLowerCase().contains("unable to resolve")
//                        || error.getMessage()
//                        .toLowerCase().contains("failed to connect to"))
//                    subscriber.onError(new Throwable("خطا:اشکال ارتباط با سرور"));
//                else
//                    subscriber.onError(error);
            });
        }).compose((ObservableTransformer<? super Object, ? extends R>) getSchedulersTransformer());
    }

    @Override
    protected abstract Observable<R> interact(Q param);

    private ObservableTransformer<? super R, ? extends R> getSchedulersTransformer() {
        return schedulersTransformer;
    }
}
