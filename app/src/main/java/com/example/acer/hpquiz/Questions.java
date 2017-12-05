package com.example.acer.hpquiz;

/**
 * Created by Acer on 02/12/2017.
 */

public class Questions {

    private int mTextResId;
    private boolean mAnswerTrue;

    public int getTextResId() {

        return mTextResId;
    }

    public void setTextResId(int textResId) {

        mTextResId = textResId;
    }


    public boolean isAnswerTrue() {

        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {

        mAnswerTrue = answerTrue;
    }

    public Questions(int textResId, boolean answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }
}