package com.example.acer.hpquiz;

/**
 * Created by Acer on 04/12/2017.
 */

public class Hints {

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    private int mTextResId;

    public Hints(int textResId){
        mTextResId = textResId;
    }
}
