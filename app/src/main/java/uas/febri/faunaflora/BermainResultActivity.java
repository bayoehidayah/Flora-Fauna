package uas.febri.faunaflora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BermainResultActivity extends AppCompatActivity implements View.OnClickListener {

    private int scorePerCorrectAnswer = 10;
    private int correctQuestion = 0;
    private int totalScore = 0;
    private Bundle bundle;
    private TextView mTextCorrect;
    private TextView mTextWrong;
    private TextView mTextScore;
    private Button mBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bermain_result);
        initView();

        bundle = getIntent().getExtras();
        correctQuestion = bundle.getInt("correctAnswer");
        totalScore = correctQuestion * scorePerCorrectAnswer;

        mTextCorrect.setText("Jawaban Benar : " + Integer.toString(correctQuestion));
        mTextScore.setText("Score Anda : " + Integer.toString(totalScore));
        mTextWrong.setText("Jawaban Salah : " + Integer.toString((10 - correctQuestion)));
    }

    private void initView() {
        mTextCorrect = (TextView) findViewById(R.id.textCorrect);
        mTextWrong = (TextView) findViewById(R.id.textWrong);
        mTextScore = (TextView) findViewById(R.id.textScore);
        mBtnBack = (Button) findViewById(R.id.btnBack);

        mBtnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBack:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}