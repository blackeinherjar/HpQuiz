package com.example.acer.hpquiz;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mHintButton;
    private TextView mQuestionsTextView;

    private Questions[] mQuestionsBank = new Questions[] {
            new Questions(R.string.question_one, true),
            new Questions(R.string.question_two,false),
            new Questions(R.string.question_three, true),
            new Questions(R.string.question_four, false),
            new Questions(R.string.question_five, false),
            new Questions(R.string.question_six, false),
            new Questions(R.string.question_seven, true),
            new Questions(R.string.question_eight, true),
            new Questions(R.string.question_nine, false),
            new Questions(R.string.question_ten, false),
    };

    private int mCurrentIndex = 0;

    private void updateQuestions(){
        int questions = mQuestionsBank[mCurrentIndex].getTextResId();
        mQuestionsTextView.setText(questions);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionsBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionsTextView = (TextView) findViewById(R.id.questions_text_view);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               checkAnswer(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionsBank.length;
                updateQuestions();
            }
        });

        mHintButton = (Button)findViewById(R.id.hint_button);
        mHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // Start HintActivity
                Intent i = new Intent(QuizActivity.this, HintActivity.class);
                startActivity(i);
            }
        });

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestions();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
}
