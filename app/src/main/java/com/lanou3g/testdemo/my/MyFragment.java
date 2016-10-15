package com.lanou3g.testdemo.my;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.BaseFragment;

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
 * Created by 程洪运 on 16/9/19.
 */
public class MyFragment extends BaseFragment implements OnClickListener {

    private ImageView mImg;

    private LinearLayout linear_my_shopping, linear_my_The_order, linear_my_Gift_certificates,
            linear_my_Focus_on, linear_my_Customer_service, linear_My_Please_log_in;


    @Override
    protected int setLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {

        mImg = bindView(R.id.iv_me_setting);
        linear_my_shopping = bindView(R.id.linear_my_shopping);
        linear_my_The_order = bindView(R.id.linear_my_The_order);
        linear_my_Gift_certificates = bindView(R.id.linear_my_Gift_certificates);
        linear_my_Focus_on = bindView(R.id.linear_my_Focus_on);
        linear_my_Customer_service = bindView(R.id.linear_my_Customer_service);
        linear_My_Please_log_in = bindView(R.id.linear_My_Please_log_in);

        mImg.setOnClickListener(this);

        linear_My_Please_log_in.setOnClickListener(this);

        linear_my_shopping.setOnClickListener(this);
        linear_my_The_order.setOnClickListener(this);
        linear_my_Gift_certificates.setOnClickListener(this);
        linear_my_Focus_on.setOnClickListener(this);
        linear_my_Customer_service.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_me_setting:
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                break;
            case R.id.linear_my_shopping:
                Toast.makeText(context, "购物车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_my_The_order:
                Toast.makeText(context, "订单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_my_Gift_certificates:
                Toast.makeText(context, "礼券", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_my_Focus_on:
                Toast.makeText(context, "关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_my_Customer_service:
                Toast.makeText(context, "客服", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linear_My_Please_log_in:
                Toast.makeText(context, "登录", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),LoginActivity.class));
                break;
        }

    }
}
