package com.cyl.drawapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cyl.drawapp.hencoderpracticedraw1.TestActivity1;
import com.cyl.drawapp.hencoderpracticedraw2.TestActivity2;
import com.cyl.drawapp.hencoderpracticedraw3.TestActivity3;
import com.cyl.drawapp.hencoderpracticedraw4.TestActivity4;

/**
 * Created by D22434 on 2017/10/18.
 */

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {

    int[] viewIds = new int[]{R.id.btn_draw1, R.id.btn_draw2,
            R.id.btn_draw3,R.id.btn_draw4
    };
    Class[] TargetClasses = new Class[]{
            TestActivity1.class,
            TestActivity2.class,
            TestActivity3.class,
            TestActivity4.class,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        for (int i = 0; i < viewIds.length; i++) {
            findViewById(viewIds[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < viewIds.length; i++) {
            if (v.getId() == viewIds[i]) {
                startActivity(new Intent(DrawActivity.this,
                        TargetClasses[i]));
            }
        }
    }
}
