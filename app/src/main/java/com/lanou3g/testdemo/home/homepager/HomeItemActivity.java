package com.lanou3g.testdemo.home.homepager;

import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
public class HomeItemActivity extends BaseActivity {
    private WebView itemWeb;

    @Override
    protected int setLayout() {
        return R.layout.activity_home_item;
    }

    @Override
    protected void initView() {
        itemWeb = bindView(R.id.web_home_item);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        itemWeb.loadUrl(url);

        String url_kind =intent.getStringExtra("url_kind");
        itemWeb.loadUrl(url_kind);

        WebSettings webSettings = itemWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        itemWeb.setWebViewClient(new WebViewClient());
    }
}

