package com.lanou3g.testdemo.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.classification.ClassificationFragment;
import com.lanou3g.testdemo.home.homepager.HomeFragment;
import com.lanou3g.testdemo.my.MyFragment;
import com.lanou3g.testdemo.select.SelectFragment;
import com.lanou3g.testdemo.task.BaseActivity;

public class MainActivity extends BaseActivity implements OnClickListener {


    private RadioButton home, list, classification, my;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        home = bindView(R.id.home_btn);
        list = bindView(R.id.select_btn);
        classification = bindView(R.id.classification_btn);
        my = bindView(R.id.my_btn);


        home.setOnClickListener(this);
        list.setOnClickListener(this);
        classification.setOnClickListener(this);
        my.setOnClickListener(this);
        home.setChecked(true);
    }

    @Override
    protected void initView() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_Frame, new HomeFragment());
        ft.commit();


    }

    @Override
    public void onClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.home_btn:
                ft.replace(R.id.main_Frame, new HomeFragment());
                break;
            case R.id.select_btn:
                ft.replace(R.id.main_Frame, new SelectFragment());
                break;
            case R.id.classification_btn:
                ft.replace(R.id.main_Frame, new ClassificationFragment());
                break;
            case R.id.my_btn:
                ft.replace(R.id.main_Frame, new MyFragment());
                break;
        }
        ft.commit();
    }
}
