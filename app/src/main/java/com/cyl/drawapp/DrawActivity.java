package com.cyl.drawapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cyl.drawapp.hencoderpracticedraw1.TestActivity1;
import com.cyl.drawapp.hencoderpracticedraw2.TestActivity2;

/**
 * Created by D22434 on 2017/10/18.
 */

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtnDraw1, mBtnDraw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        mBtnDraw1 = findViewById(R.id.btn_draw1);
        mBtnDraw2 = findViewById(R.id.btn_draw2);
        mBtnDraw1.setOnClickListener(this);
        mBtnDraw2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_draw1:
                intent = new Intent(DrawActivity.this, TestActivity1.class);
                startActivity(intent);
                break;
            case R.id.btn_draw2:
                intent = new Intent(DrawActivity.this, TestActivity2.class);
                startActivity(intent);
                break;
        }
    }
}
