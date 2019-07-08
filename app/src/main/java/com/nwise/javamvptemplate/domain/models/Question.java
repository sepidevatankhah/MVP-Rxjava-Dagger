package com.nwise.javamvptemplate.domain.models;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public class Question {


    public String title;
    public String body;


    @SerializedName("question_id")
    public String questionId;

    @Override
    public String toString() {
        return(title);
    }
}
