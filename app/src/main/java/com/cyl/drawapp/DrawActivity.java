package com.cyl.drawapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cyl.drawapp.hencoderpracticedraw1.TestActivity1;
import com.cyl.drawapp.hencoderpracticedraw3.TestActivity3;
import com.cyl.drawapp.hencoderpracticedraw4.TestActivity4;
import com.cyl.drawapp.hencoderpracticedraw5.TestActivity5;
import com.cyl.drawapp.hencoderpracticedraw6.TestActivity6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D22434 on 2017/10/18.
 */

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {

    List<TestModel> testModels = new ArrayList<>();

    {
        testModels.add(new TestModel(R.id.btn_draw1, TestActivity1.class));
        testModels.add(new TestModel(R.id.btn_draw2, TestActivity3.class));
        testModels.add(new TestModel(R.id.btn_draw3, TestActivity3.class));
        testModels.add(new TestModel(R.id.btn_draw4, TestActivity4.class));
        testModels.add(new TestModel(R.id.btn_draw5, TestActivity5.class));
        testModels.add(new TestModel(R.id.btn_draw6, TestActivity6.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        for (int i = 0; i < testModels.size(); i++) {
            findViewById(testModels.get(i).viewId).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < testModels.size(); i++) {
            if (v.getId() == testModels.get(i).viewId) {
                startActivity(new Intent(DrawActivity.this,
                        testModels.get(i).targetClass));
            }
        }
    }

    public class TestModel {
        int viewId;
        Class targetClass;

        public TestModel(int viewId, Class targetClass) {
            this.viewId = viewId;
            this.targetClass = targetClass;
        }
    }
}
