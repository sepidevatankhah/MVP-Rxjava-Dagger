package com.nwise.javamvptemplate.ui.main;
import com.nwise.javamvptemplate.domain.models.Answer;
import com.nwise.javamvptemplate.domain.models.ListWrapper;
import com.nwise.javamvptemplate.domain.models.Question;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public interface MainViewInterface {

    void onQuestionSucceed(ListWrapper<Question> questions);
    void onAnswerSucceed(ListWrapper<Answer> questions);
    void onFailed();
}
