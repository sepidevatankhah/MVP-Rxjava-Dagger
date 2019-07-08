package com.nwise.javamvptemplate.domain.interactors;

import com.nwise.javamvptemplate.domain.executer.PostExecutionThread;
import com.nwise.javamvptemplate.domain.executer.UseCaseExecutor;
import com.nwise.javamvptemplate.domain.interactors.base.FlowableUseCase;
import com.nwise.javamvptemplate.domain.models.ListWrapper;
import com.nwise.javamvptemplate.domain.models.Question;
import com.nwise.javamvptemplate.network.Repository;
import javax.inject.Inject;
import io.reactivex.Flowable;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public class QuestionUseCase extends FlowableUseCase<ListWrapper<Question>, Question> {

    private UseCaseExecutor useCaseExecutor;
    private PostExecutionThread postExecutionThread;
    private Repository apiRepository;

    @Inject
    public QuestionUseCase(UseCaseExecutor useCaseExecutor, PostExecutionThread postExecutionThread, Repository apiRepository) {
        super(useCaseExecutor, postExecutionThread, apiRepository);
        this.apiRepository = apiRepository;
    }

    @Override
    protected Flowable<ListWrapper<Question>> interact(Question param) {
        return apiRepository.getQuestions();
    }


}
