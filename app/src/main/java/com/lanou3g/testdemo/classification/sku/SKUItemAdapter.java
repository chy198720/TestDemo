package com.lanou3g.testdemo.classification.sku;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.LmClickListener;
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
 * Created by 程洪运 on 16/9/29.
 */
public class SKUItemAdapter extends BaseAdapter{
    private RecycleAdapter mRecycleAdapter;
    private SKUItemBean mSKUItemBean;

    private LmClickListener lmClickListener;

    public void setLmClickListener(LmClickListener lmClickListener) {
        this.lmClickListener = lmClickListener;
    }



    public void setSKUItemBean(SKUItemBean SKUItemBean) {
        mSKUItemBean = SKUItemBean;
    }

    @Override
    public int getCount() {
        return mSKUItemBean.getData().getCategories().size();
    }

    @Override
    public Object getItem(int i) {
        return mSKUItemBean.getData().getCategories().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_sku_two,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }



        mRecycleAdapter = new RecycleAdapter(mSKUItemBean,i);
        GridLayoutManager manager = new GridLayoutManager(MyApp.getContext(), 3);
        viewHolder.mRecycle.setLayoutManager(manager);
        mRecycleAdapter.setLmClickListener(new LmClickListener() {
            @Override
            public void onClick(int id, String title) {
                lmClickListener.onClick(id, title);
            }
        });
        viewHolder.mRecycle.setAdapter(mRecycleAdapter);
        viewHolder.mTextName.setText(mSKUItemBean.getData().getCategories().get(i).getName());



        if (i == 0) {
            viewHolder.mTextName.setVisibility(View.GONE);
            viewHolder.mViewL.setVisibility(View.GONE);
            viewHolder.mViewR.setVisibility(View.GONE);
        } else {
            viewHolder.mTextName.setVisibility(View.VISIBLE);
            viewHolder.mViewL.setVisibility(View.VISIBLE);
            viewHolder.mViewR.setVisibility(View.VISIBLE);
        }

        return view;
    }


    class ViewHolder{

        private final RecyclerView mRecycle;
        private final TextView mTextName;
        private final View mViewL;
        private final View mViewR;

        public ViewHolder(View view){

            mTextName = (TextView) view.findViewById(R.id.text_name);
            mRecycle = (RecyclerView) view.findViewById(R.id.sku_recycle);
            mViewL = view.findViewById(R.id.view_left);
            mViewR = view.findViewById(R.id.view_right);

        }
    }

}
