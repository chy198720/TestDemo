package com.lanou3g.testdemo.classification.sku;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.squareup.picasso.Picasso;

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
 * Created by 程洪运 on 16/9/26.
 */
public class RecycleAdapter extends Adapter<RecycleAdapter.RecyViewHolder> {
    Context mContext;
    private int number;
    private SKUItemBean mSkuItemBean;

    public RecycleAdapter(Context context, SKUItemBean skuItemBean, int number) {
        mContext = context;
        mSkuItemBean = skuItemBean;
        this.number = number;
    }

    @Override
    public RecyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycle, parent, false);
        RecyViewHolder holder = new RecyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyViewHolder holder, int position) {

        Picasso.with(mContext).load
                (mSkuItemBean.getData().getCategories()
                        .get(number).getSubcategories().get(position).getIcon_url()).into(holder.mImg);

        holder.mName.setText(mSkuItemBean.getData().getCategories()
                .get(number).getSubcategories().get(position)
                .getName());

    }

    @Override
    public int getItemCount() {
        return mSkuItemBean.getData().getCategories().get(number).getSubcategories().size();
    }

    public class RecyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImg;
        private final TextView mName;

        public RecyViewHolder(View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.recycle_icon_url);
            mName = (TextView) itemView.findViewById(R.id.recycle_name);
        }
    }
}
