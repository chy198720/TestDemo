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
    Context mContext;
    private RecycleAdapter mRecycleAdapter;
    private SKUItemBean mSKUItemBean;

    public SKUItemAdapter(Context context) {
        mContext = context;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_sku_two,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }



        mRecycleAdapter = new RecycleAdapter(mContext,mSKUItemBean,i);
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        viewHolder.mRecycle.setLayoutManager(manager);
        viewHolder.mRecycle.setAdapter(mRecycleAdapter);
        viewHolder.mTextName.setText(mSKUItemBean.getData().getCategories().get(i).getName());

        return view;
    }


    class ViewHolder{

        private final RecyclerView mRecycle;
        private final TextView mTextName;

        public ViewHolder(View view){

            mTextName = (TextView) view.findViewById(R.id.text_name);
            mRecycle = (RecyclerView) view.findViewById(R.id.sku_recycle);

        }
    }

}
