package uas.febri.faunaflora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uas.febri.faunaflora.utils.LearnDatas;

public class BelajarActivity extends AppCompatActivity implements View.OnClickListener {

    private String getLessonType;

    private TextView mTitle;
    private ImageView mImg;
    private TextView mKet;
    private Button mBtnPrevious;
    private Button mBtnNext;
    private Button mBtnBack;

    private int curentLessonData = 0;
    private List<String> datas;
    private Map<String, String> lessonDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar);
        initView();

        Bundle bundle = getIntent().getExtras();
        getLessonType = bundle.getString("learn");

        initData();
        displayData();
    }

    private void displayData() {
        mKet.setText(lessonDatas.get(datas.get(curentLessonData)));
        mImg.setImageResource(Integer.valueOf(datas.get(curentLessonData)));
        checkNomor();
    }

    private void initData() {
        if (getLessonType.equals("fauna")) {
            mTitle.setText("Fauna Terlangka");
            lessonDatas = LearnDatas.getFaunaLangka();
        } else {
            mTitle.setText("Flora Terlangka");
            lessonDatas = LearnDatas.getFloraLangka();
        }

        datas = new ArrayList<>(lessonDatas.keySet());
    }

    private void checkNomor() {
        if (curentLessonData == 0) {
            mBtnNext.setEnabled(true);
            mBtnPrevious.setEnabled(false);
        } else if (curentLessonData == (lessonDatas.size() - 1)) {
            mBtnNext.setEnabled(false);
            mBtnPrevious.setEnabled(true);
        } else {
            mBtnNext.setEnabled(true);
            mBtnPrevious.setEnabled(true);
        }
    }

    private void initView() {
        mTitle = (TextView) findViewById(R.id.title);
        mImg = (ImageView) findViewById(R.id.img);
        mKet = (TextView) findViewById(R.id.ket);
        mBtnPrevious = (Button) findViewById(R.id.btnPrevious);
        mBtnNext = (Button) findViewById(R.id.btnNext);
        mBtnBack = (Button) findViewById(R.id.btnBack);

        mBtnPrevious.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
        mBtnBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnBack) {
            onBackPressed();
            finish();
        } else {
            if (id == R.id.btnNext) {
                curentLessonData++;
            } else if (id == R.id.btnPrevious) {
                curentLessonData--;
            }

            displayData();
        }
    }
}