package com.lanou3g.testdemo.main;

import android.content.Intent;
import android.os.Handler;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.BaseActivity;


public class WelcomeActivity extends BaseActivity {
    private int time = 3;

    @Override
    protected int setLayout() {
        return R.layout.activity_welcom;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                time--;
                if (0 == time){
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        handler.postDelayed(runnable,1000);
    }
}
