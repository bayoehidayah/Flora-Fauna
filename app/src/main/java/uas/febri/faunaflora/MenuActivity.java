package uas.febri.faunaflora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnFauna;
    private Button mBtnFlora;
    private Button mBtnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
    }

    private void initView() {
        mBtnFauna = (Button) findViewById(R.id.btnFauna);
        mBtnFlora = (Button) findViewById(R.id.btnFlora);
        mBtnKembali = (Button) findViewById(R.id.btnKembali);

        mBtnFauna.setOnClickListener(this);
        mBtnFlora.setOnClickListener(this);
        mBtnKembali.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        Bundle bundle = new Bundle();
        switch(view.getId()){
            case R.id.btnFauna:
                i = new Intent(this, BelajarActivity.class);
                bundle.putString("learn", "fauna");
                i.putExtras(bundle);
                startActivity(i);
                break;
            case R.id.btnFlora:
                i = new Intent(this, BelajarActivity.class);
                bundle.putString("learn", "flora");
                i.putExtras(bundle);
                startActivity(i);
                break;
            case R.id.btnKembali:
                onBackPressed();
                finish();
                break;
        }
    }
}