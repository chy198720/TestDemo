package com.lanou3g.testdemo.me.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.base.BaseActivity;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

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
    private ImageView login_img_fork, img_wei_bo, img_wei_xi, img_q_q;

    private LinearLayout login_linear_The_login, login_linear_Verification_code;

    private boolean isVisible = true;


    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        img_wei_bo = bindView(R.id.img_wei_bo);
        img_wei_xi = bindView(R.id.img_wei_xi);
        img_q_q = bindView(R.id.img_q_q);
        login_img_fork = bindView(R.id.login_img_fork);
        login_text_The_area_code = bindView(R.id.login_text_The_area_code);
        login_btn_The_login = bindView(R.id.login_btn_The_login);
        login_text_Verification_code = bindView(R.id.login_text_Verification_code);

        login_linear_The_login = bindView(R.id.login_linear_The_login);
        login_linear_Verification_code = bindView(R.id.login_linear_Verification_code);

        login_text_The_area_code.setOnClickListener(this);
        login_btn_The_login.setOnClickListener(this);
        login_text_Verification_code.setOnClickListener(this);
        login_img_fork.setOnClickListener(this);
        img_wei_bo.setOnClickListener(this);
        img_wei_xi.setOnClickListener(this);
        img_q_q.setOnClickListener(this);

        login_linear_Verification_code.setVisibility(View.GONE);


    }

    @Override
    protected void initView() {
        ShareSDK.initSDK(this);

    }

    @Override
    public void onClick(View view) {
        PlatformActionListener paListener = null;

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
            case R.id.login_img_fork:
                finish();
                break;

            case R.id.img_wei_bo:
                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                weibo.setPlatformActionListener(paListener);
                //authorize与showUser单独调用一个即可
                weibo.authorize();//单独授权,OnComplete返回的hashmap是空的
                weibo.showUser(null);//授权并获取用户信息
                break;

            case R.id.img_wei_xi:
                break;


            case R.id.img_q_q:

                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.setPlatformActionListener(paListener);
                //authorize与showUser单独调用一个即可
                qq.authorize();//单独授权,OnComplete返回的hashmap是空的
                qq.showUser(null);//授权并获取用户信息
                break;

        }
    }
}
