package com.lanou3g.testdemo.home.homepager;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.home.BoxBean;
import com.lanou3g.testdemo.home.EtActivity;
import com.lanou3g.testdemo.home.send.SendFragment;
import com.lanou3g.testdemo.home.tab.TabFragment;
import com.lanou3g.testdemo.my.LoginActivity;
import com.lanou3g.testdemo.task.BaseFragment;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;
import com.lanou3g.testdemo.task.URLValues;

import java.util.ArrayList;

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
 * Created by 程洪运 on 16/9/19.
 */
public class HomeFragment extends BaseFragment implements OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    ArrayList<String> mStrings = new ArrayList<>();
    ArrayList<Fragment> mFragments = new ArrayList<>();
    private EditText mEditText;
    private HomeAdapter mAdapter;
    private ImageView home_img;
    private ImageView radio_btn;

    private ListView popupWindow_Left;
    private PopAdapter mPopAdapter;

    private HomeBean mBean;
    private HomeBean mHomeBean;

    NetTool mTool = new NetTool();

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        radio_btn = bindView(R.id.radio_btn);
        home_img = bindView(R.id.home_img);
        mEditText = bindView(R.id.et_name);
        mTabLayout = bindView(R.id.home_Tab, getView());
        mViewPager = bindView(R.id.home_Pager);
        mEditText.setOnClickListener(this);
        home_img.setOnClickListener(this);
        radio_btn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        mTool.getData(URLValues.ROLL_CHANNEL, HomeBean.class, new NetInterface<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                for (int i = 0; i < homeBean.getData().getChannels().size(); i++) {
                    mStrings.add(homeBean.getData().getChannels().get(i).getName());
                }
                for (int i = 0; i < mStrings.size(); i++) {
                    if (i == 0) {
                        mFragments.add(new TabFragment());
                    } else {
                        SendFragment sendFragment = new SendFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("url", String.valueOf(homeBean.getData().getChannels().get(i).getId()));
                        sendFragment.setArguments(bundle);
                        mFragments.add(sendFragment);
                    }
                }


                mAdapter = new HomeAdapter(getChildFragmentManager(), mFragments, mStrings);
                mTabLayout.setupWithViewPager(mViewPager);
                mViewPager.setAdapter(mAdapter);
                mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


            }

            @Override
            public void onError(String errorMsg) {

            }
        });

        mTool.getData(URLValues.EDITTEXT, BoxBean.class, new NetInterface<BoxBean>() {
            @Override
            public void onSuccess(BoxBean boxBean) {
                mEditText.setHint(boxBean.getData().getPlaceholder());
                mEditText.setTextSize(10);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_name:
                startActivity(new Intent(getContext(), EtActivity.class));
                break;

            case R.id.home_img:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;

            case R.id.radio_btn:

                showPopupWindow();

                break;

        }
    }

    private void showPopupWindow() {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_popupwindow_left, null);
        popupWindow_Left = (ListView) view.findViewById(R.id.popupWindow_Left);

        mTool.getData(URLValues.ROLL_CHANNEL, HomeBean.class, new NetInterface<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                mPopAdapter = new PopAdapter();
                mPopAdapter.setHomeBean(homeBean);
                mPopAdapter.setFragments(mFragments);
                popupWindow_Left.setAdapter(mPopAdapter);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });


        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT, 800);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);


        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);


        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        window.showAtLocation(getActivity().findViewById(R.id.radio_btn),
                Gravity.BOTTOM, 0, 0);

        // 这里检验popWindow里的button是否可以点击
        popupWindow_Left.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mViewPager.setCurrentItem(i);
                if (window.isShowing()) {
                    window.dismiss();

                }


                Log.d("HomeFragment", "点击了" + i);
            }
        });

        //popWindow消失监听方法
        window.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                System.out.println("popWindow消失");
            }
        });

    }
}