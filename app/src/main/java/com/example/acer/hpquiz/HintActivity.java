package com.example.acer.hpquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {

    private static final String KEY_INDEX = "index";

    private TextView mHintsTextView;

    private Hints[] mHintsBank = new Hints[] {
            new Hints(R.string.hint_one),
            new Hints(R.string.hint_two),
            new Hints(R.string.hint_three),
            new Hints(R.string.hint_four),
            new Hints(R.string.hint_five),
            new Hints(R.string.hint_six),
            new Hints(R.string.hint_seven),
            new Hints(R.string.hint_eight),
            new Hints(R.string.hint_nine),
            new Hints(R.string.hint_ten),
    };

    private int mCurrentIndex = 0;

    private void updateHints(){
        int hints = mHintsBank[mCurrentIndex].getTextResId();
        mHintsTextView.setText(hints);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        mHintsTextView = (TextView) findViewById(R.id.hints_text_view);

        mCurrentIndex = (mCurrentIndex + 1) % mHintsBank.length;
        updateHints();


        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateHints();

    }




}
