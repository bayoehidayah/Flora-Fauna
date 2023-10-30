package uas.febri.faunaflora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uas.febri.faunaflora.utils.QuestionDatas;

public class BermainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mSoalNumber;
    private TextView mSoalKet;
    private ImageView mQuestionImage;
    private Button mBtnA;
    private Button mBtnB;
    private Button mBtnC;
    private Button mBtnD;
    private Button mBtnMenu;

    private int currentQuestionIndex = 0, totalCorrectQuestions = 0;
    private List<String> questions;
    private Map<String, Integer> imageList;
    private Map<String, Map<String, Boolean>> questionAnswer;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bermain);
        initView();
        initData();
        displayData();
    }

    private void initData() {
        questionAnswer = QuestionDatas.getQuestionsList();
        questions = new ArrayList<>(questionAnswer.keySet());
        imageList = QuestionDatas.getImageList();
    }

    private void setAnswersToList() {
        ArrayList<String> questionKey = new ArrayList(questionAnswer.get(questions.get(currentQuestionIndex)).keySet());
        mBtnA.setText(questionKey.get(0));
        mBtnB.setText(questionKey.get(1));
        mBtnC.setText(questionKey.get(2));
        mBtnD.setText(questionKey.get(3));
    }

    private void initView() {
        mSoalNumber = (TextView) findViewById(R.id.soalNumber);
        mSoalKet = (TextView) findViewById(R.id.soalKet);
        mQuestionImage = (ImageView) findViewById(R.id.questionImage);
        mBtnA = (Button) findViewById(R.id.btnA);
        mBtnB = (Button) findViewById(R.id.btnB);
        mBtnC = (Button) findViewById(R.id.btnC);
        mBtnD = (Button) findViewById(R.id.btnD);
        mBtnMenu = (Button) findViewById(R.id.btnMenu);

        mBtnA.setOnClickListener(this);
        mBtnB.setOnClickListener(this);
        mBtnC.setOnClickListener(this);
        mBtnD.setOnClickListener(this);
        mBtnMenu.setOnClickListener(this);
    }

    private void displayData() {
        mQuestionImage.setImageResource(imageList.get(questions.get(currentQuestionIndex)));
        mSoalKet.setText(questions.get(currentQuestionIndex));
        mSoalNumber.setText("Soal " + (currentQuestionIndex + 1) + "/" + questions.size());
        setAnswersToList();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        boolean answer = false;

        if (id == R.id.btnBack) {
            onBackPressed();
            finish();
        } else {
            if (currentQuestionIndex == (questions.size() - 1)) {
                bundle = new Bundle();
                bundle.putInt("correctAnswer", totalCorrectQuestions);
                bundle.putInt("totalQuestion", questions.size());

                Intent i = new Intent(this, BermainResultActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            } else {
                if (id == R.id.btnA) {
                    answer = questionAnswer.get(questions.get(currentQuestionIndex)).get(mBtnA.getText());
                } else if (id == R.id.btnB) {
                    answer = questionAnswer.get(questions.get(currentQuestionIndex)).get(mBtnB.getText());
                } else if (id == R.id.btnC) {
                    answer = questionAnswer.get(questions.get(currentQuestionIndex)).get(mBtnC.getText());
                } else if (id == R.id.btnD) {
                    answer = questionAnswer.get(questions.get(currentQuestionIndex)).get(mBtnD.getText());
                }

                if (answer) {
                    Toast.makeText(this, "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
                    totalCorrectQuestions++;
                }
                else{
                    Toast.makeText(this, "Jawaban Anda Salah", Toast.LENGTH_SHORT).show();
                }

                currentQuestionIndex++;
                displayData();
            }
        }
    }
}