package com.nwise.javamvptemplate.domain.models;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sepideh Vatankhah on 01.08.2019.
 * sun.vatankhah@gmail.com
 * https://github.com/sepidevatankhah
 */
public class Answer {
    @SerializedName("answer_id")
    public int answerId;

    @SerializedName("is_accepted")
    public boolean accepted;

    public int score;

    @SerializedName("owner")
    public Owner owner;

    @Override
    public String toString() {
        return answerId + " - Score: " + score + " - Accepted: " + (accepted ? "Yes" : "No");
    }
}
