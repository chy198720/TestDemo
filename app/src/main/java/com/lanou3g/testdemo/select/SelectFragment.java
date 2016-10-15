package com.lanou3g.testdemo.select;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.select.day.DayFragment;
import com.lanou3g.testdemo.task.BaseFragment;

import java.util.ArrayList;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

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
public class SelectFragment extends BaseFragment implements OnClickListener {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView select_img;
    ArrayList<Fragment> mFragments = new ArrayList<>();
    ArrayList<String> mArrayList = new ArrayList<>();

    @Override
    protected int setLayout() {
        return R.layout.fragment_select;
    }

    @Override
    protected void initView() {
        mTabLayout = bindView(R.id.select_Tab);
        mViewPager = bindView(R.id.select_pager);
        select_img = bindView(R.id.select_img);
        select_img.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        mArrayList.add("每日推荐");
        mArrayList.add("TOP100");
        mArrayList.add("独立原创榜");
        mArrayList.add("新星榜");


        mFragments.add(new DayFragment());
        mFragments.add(new TOPFragment());
        mFragments.add(new OriginalFragment());
        mFragments.add(new NewStarFragment());

        SelectAdapter adapter = new SelectAdapter(getChildFragmentManager(), mArrayList, mFragments);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(adapter);

    }

    private void showShare() {
        ShareSDK.initSDK(getContext());
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(getContext());
    }

    @Override
    public void onClick(View view) {
        showShare();
    }
}
