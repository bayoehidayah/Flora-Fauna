package uas.febri.faunaflora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnBelajar;
    private Button mBtnBermain;
    private Button mBtnTentang;
    private Button mBtnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnBelajar = (Button) findViewById(R.id.btnBelajar);
        mBtnBermain = (Button) findViewById(R.id.btnBermain);
        mBtnTentang = (Button) findViewById(R.id.btnTentang);
        mBtnKeluar = (Button) findViewById(R.id.btnKeluar);

        mBtnBelajar.setOnClickListener(this);
        mBtnBermain.setOnClickListener(this);
        mBtnTentang.setOnClickListener(this);
        mBtnKeluar.setOnClickListener(this);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.btnBelajar:
                i = new Intent(this, MenuActivity.class);
                startActivity(i);
                break;
            case R.id.btnBermain:
                i = new Intent(this, BermainActivity.class);
                startActivity(i);
                break;
            case R.id.btnTentang:
                i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
            case R.id.btnKeluar:
                finish();
                System.exit(0);
                break;
        }
    }
}