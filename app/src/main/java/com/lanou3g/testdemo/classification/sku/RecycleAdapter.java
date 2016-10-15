package com.lanou3g.testdemo.classification.sku;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.classification.sku.RecycleAdapter.RecyclesViewHolder;
import com.lanou3g.testdemo.task.LmClickListener;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;

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
public class RecycleAdapter extends Adapter<RecyclesViewHolder> {
    private int number;
    private SKUItemBean mSkuItemBean;

    private LmClickListener lmClickListener;

    public void setLmClickListener(LmClickListener lmClickListener) {
        this.lmClickListener = lmClickListener;
    }

    public RecycleAdapter( SKUItemBean skuItemBean, int number) {
        mSkuItemBean = skuItemBean;
        this.number = number;
    }

    @Override
    public RecyclesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_recycle, parent, false);
        RecyclesViewHolder holder = new RecyclesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclesViewHolder holder, final int position) {

        NetTool tool = new NetTool();
        tool.getImg(mSkuItemBean.getData().getCategories().get(number)
                .getSubcategories().get(position).getIcon_url(),holder.mImg);
        holder.mName.setText(mSkuItemBean.getData().getCategories()
                .get(number).getSubcategories().get(position)
                .getName());
        holder.mName.setTextColor(Color.BLUE);

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lmClickListener.onClick
                        (mSkuItemBean.getData().getCategories().get(number).getSubcategories().get(position).getId()
                                , mSkuItemBean.getData().getCategories().get(number).getSubcategories().get(position).getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSkuItemBean.getData().getCategories().get(number).getSubcategories().size();
    }

    public class RecyclesViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImg;
        private final TextView mName;
        private final LinearLayout mLinearLayout;

        public RecyclesViewHolder(View itemView) {
            super(itemView);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.ll_Recycle);
            mImg = (ImageView) itemView.findViewById(R.id.recycle_icon_url);
            mName = (TextView) itemView.findViewById(R.id.recycle_name);
        }
    }
}
