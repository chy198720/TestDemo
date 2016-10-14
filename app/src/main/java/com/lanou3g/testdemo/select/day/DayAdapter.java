package com.lanou3g.testdemo.select.day;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
 * Created by 程洪运 on 16/9/23.
 */
public class DayAdapter extends Adapter<DayAdapter.DayViewHolder> {
    Context mContext;
    private OnItemClickListener recommendOnItemClickListener;


    public void setRecommendOnItemClickListener(OnItemClickListener recommendOnItemClickListener) {
        this.recommendOnItemClickListener = recommendOnItemClickListener;
    }


    public interface OnItemClickListener {
        void OnItemClickListener(View view, int position);
    }


    public DayAdapter(Context context) {
        mContext = context;
    }

    ArrayList<DayBean> mDayBeen = new ArrayList<>();

    public void setDayBeen(ArrayList<DayBean> dayBeen) {
        mDayBeen = dayBeen;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_day, null);
        DayViewHolder viewHolder = new DayViewHolder(view);
//        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final DayViewHolder holder, int position) {
        DayBean dayBean = mDayBeen.get(position);
        Picasso.with(mContext).
                load(dayBean.getData().getItems().get(position).getCover_image_url())
                .into(holder.mCover_image_url);
        holder.mShort_description.setText(dayBean.getData().getItems().get(position).getShort_description());
        holder.mName.setHint(dayBean.getData().getItems().get(position).getName());
        holder.mPrice.setText("¥" + dayBean.getData().getItems().get(position).getPrice());
        if (recommendOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recommendOnItemClickListener.OnItemClickListener
                            (holder.itemView, holder.getLayoutPosition());
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mDayBeen.size();
    }

    public class DayViewHolder extends ViewHolder {

        private final ImageView mCover_image_url;
        private final TextView mShort_description;
        private final TextView mName;
        private final TextView mPrice;

        public DayViewHolder(View itemView) {
            super(itemView);
            mCover_image_url = (ImageView) itemView.findViewById(R.id.cover_image_url);
            mShort_description = (TextView) itemView.findViewById(R.id.short_description);
            mName = (TextView) itemView.findViewById(R.id.name);
            mPrice = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
