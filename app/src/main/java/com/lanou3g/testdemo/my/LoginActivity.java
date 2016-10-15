package com.lanou3g.testdemo.my;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
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
 * <p/>
 * Created by 程洪运 on 16/10/11.
 */
public class LoginActivity extends BaseActivity implements OnClickListener {

    private TextView login_text_The_area_code, login_text_Verification_code;
    private Button login_btn_The_login;

    private LinearLayout login_linear_The_login, login_linear_Verification_code;

    private boolean isVisible = true;


    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        login_text_The_area_code = bindView(R.id.login_text_The_area_code);
        login_btn_The_login = bindView(R.id.login_btn_The_login);
        login_text_Verification_code = bindView(R.id.login_text_Verification_code);

        login_linear_The_login = bindView(R.id.login_linear_The_login);
        login_linear_Verification_code = bindView(R.id.login_linear_Verification_code);

        login_text_The_area_code.setOnClickListener(this);
        login_btn_The_login.setOnClickListener(this);
        login_text_Verification_code.setOnClickListener(this);

        login_linear_Verification_code.setVisibility(View.GONE);


    }

    @Override
    protected void initView() {


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_text_The_area_code:

                Toast.makeText(this, "选择区号", Toast.LENGTH_SHORT).show();

                break;

            case R.id.login_btn_The_login:
                Toast.makeText(this, "点击登录", Toast.LENGTH_SHORT).show();
                break;

            case R.id.login_text_Verification_code:
                Toast.makeText(this, "点击了使用验证码登录", Toast.LENGTH_SHORT).show();
                if (isVisible) {
                    isVisible = false;
                    login_linear_Verification_code.setVisibility(View.VISIBLE);
                    login_linear_The_login.setVisibility(View.GONE);
                    login_text_Verification_code.setText("使用密码登录");
                } else {
                    login_linear_The_login.setVisibility(View.VISIBLE);
                    login_linear_Verification_code.setVisibility(View.GONE);
                    login_text_Verification_code.setText("使用验证码登录");
                    isVisible = true;
                }
                break;

        }
    }
}
