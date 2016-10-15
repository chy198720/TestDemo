package com.lanou3g.testdemo.home.homepager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.MyApp;

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
 * Created by 程洪运 on 16/10/13.
 */
public class PopAdapter extends BaseAdapter{




    HomeBean mHomeBean;
    ArrayList<Fragment> mFragments = new ArrayList<>();

    public void setFragments(ArrayList<Fragment> fragments) {
        mFragments = fragments;
    }

    public void setHomeBean(HomeBean homeBean) {
        mHomeBean = homeBean;
    }

    @Override
    public int getCount() {
        return mHomeBean.getData().getChannels().size();
    }

    @Override
    public Object getItem(int i) {
        return mHomeBean.getData().getChannels().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PopHolder popHolder = null;
        if (view == null) {
            view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_pop,null);
            popHolder = new PopHolder(view);
            view.setTag(popHolder);
        }else {
            popHolder = (PopHolder) view.getTag();
        }

        popHolder.mPop_text.setText(mHomeBean.getData().getChannels().get(i).getName());


        return view;
    }


    class PopHolder{

        private final TextView mPop_text;

        public PopHolder(View popView){
            mPop_text = (TextView) popView.findViewById(R.id.pop_text);
        }
    }

}
