package com.nwise.javamvptemplate.network;
import com.nwise.javamvptemplate.domain.models.Answer;
import com.nwise.javamvptemplate.domain.models.ListWrapper;
import com.nwise.javamvptemplate.domain.models.Question;

import io.reactivex.Flowable;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public interface Repository {
    Flowable<ListWrapper<Question>> getQuestions();
    Flowable<ListWrapper<Answer>> getAnswersForQuestion(String questionId);
}
