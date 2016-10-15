package com.lanou3g.testdemo.classification;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.classification.sku.SKUFragment;
import com.lanou3g.testdemo.classification.strategy.StrategyFragment;
import com.lanou3g.testdemo.task.BaseFragment;

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
 * <p>
 * Created by 程洪运 on 16/9/19.
 */
public class ClassificationFragment extends BaseFragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    ArrayList<String> mArrayLists = new ArrayList<>();
    ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int setLayout() {
        return R.layout.fragment_classification;
    }

    @Override
    protected void initView() {

        mTabLayout = bindView(R.id.classification_Tab);
        mViewPager = bindView(R.id.classification_pager);

    }

    @Override
    protected void initData() {

        mArrayLists.add("攻略");
        mArrayLists.add("单品");

        mFragments.add(new StrategyFragment());
        mFragments.add(new SKUFragment());


        ClassificationAdapter adapter = new ClassificationAdapter(getChildFragmentManager(),mArrayLists,mFragments);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(adapter);
    }
}
