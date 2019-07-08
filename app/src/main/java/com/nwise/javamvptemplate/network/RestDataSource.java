package com.nwise.javamvptemplate.network;


import com.nwise.javamvptemplate.domain.models.Answer;
import com.nwise.javamvptemplate.domain.models.ListWrapper;
import com.nwise.javamvptemplate.domain.models.Question;
import javax.inject.Inject;
import io.reactivex.Flowable;
import retrofit2.Retrofit;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public class RestDataSource implements Repository {

    @Inject
    public RestDataSource(Retrofit retrofit) {
        restApi = retrofit.create(AppApi.class);
    }

    public AppApi restApi;

    @Override
    public Flowable<ListWrapper<Question>> getQuestions() {
        return restApi.getQuestions();
    }

    @Override
    public Flowable<ListWrapper<Answer>> getAnswersForQuestion(String questionId) {
        return restApi.getAnswersForQuestion(questionId);
    }

}
