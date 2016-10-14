package com.lanou3g.testdemo.my;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.BaseActivity;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * Created by 程洪运 on 16/10/9.
 */
public class SettingsActivity extends BaseActivity implements OnClickListener {
    private LinearLayout linear_My_identity, linear_Invitation, linear_score,
            linear_opinion, linear_Customer_service, linear_like, linear_push,
            linear_update, linear_cache, linear_network, linear_about;
    @Override
    protected int setLayout() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initData() {
        linear_My_identity = bindView(R.id.linear_My_identity);
        linear_Invitation = bindView(R.id.linear_Invitation);
        linear_score = bindView(R.id.linear_score);
        linear_opinion = bindView(R.id.linear_opinion);
        linear_Customer_service = bindView(R.id.linear_Customer_service);
        linear_like = bindView(R.id.linear_like);
        linear_push = bindView(R.id.linear_push);
        linear_update = bindView(R.id.linear_update);
        linear_cache = bindView(R.id.linear_cache);
        linear_network = bindView(R.id.linear_network);
        linear_about = bindView(R.id.linear_about);

        linear_My_identity.setOnClickListener(this);
        linear_Invitation.setOnClickListener(this);
        linear_score.setOnClickListener(this);
        linear_opinion.setOnClickListener(this);
        linear_Customer_service.setOnClickListener(this);
        linear_like.setOnClickListener(this);
        linear_push.setOnClickListener(this);
        linear_update.setOnClickListener(this);
        linear_cache.setOnClickListener(this);
        linear_network.setOnClickListener(this);
        linear_about.setOnClickListener(this);

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linear_My_identity:
                break;
            case R.id.linear_Invitation:
                break;
            case R.id.linear_score:
                break;
            case R.id.linear_opinion:
                break;
            case R.id.linear_Customer_service:
                break;
            case R.id.linear_like:
                break;
            case R.id.linear_push:
                break;
            case R.id.linear_update:
                Toast.makeText(this, "当前以是最新版本~不需要再更新啦...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_cache:
                break;
            case R.id.linear_network:
                break;
            case R.id.linear_about:
                break;

        }

    }
}
