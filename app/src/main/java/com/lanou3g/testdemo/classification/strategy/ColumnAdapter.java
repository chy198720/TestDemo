package com.lanou3g.testdemo.classification.strategy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.task.MyApp;
import com.lanou3g.testdemo.task.NetTool;
import com.squareup.picasso.Picasso;

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
 * Created by 程洪运 on 16/10/12.
 */
public class ColumnAdapter extends BaseAdapter{

    StrategyBean mStrategyBean;

    public void setStrategyBean(StrategyBean strategyBean) {
        mStrategyBean = strategyBean;
    }

    @Override
    public int getCount() {
        return mStrategyBean.getData().getColumns().size();
    }

    @Override
    public Object getItem(int i) {
        return mStrategyBean.getData().getColumns().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ColumnHolder columnHolder = null;
        if (view == null) {
            view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.item_column,null);
            columnHolder = new ColumnHolder(view);
            view.setTag(columnHolder);
        }else {
            columnHolder = (ColumnHolder) view.getTag();
        }

        NetTool tool = new NetTool();
        tool.getImg(mStrategyBean.getData().getColumns().get(i)
                .getBanner_image_url(),columnHolder.mImg_column);
        columnHolder.mText_column.setText(mStrategyBean.getData()
                .getColumns().get(i).getTitle());
        columnHolder.mText_view_column.setText(mStrategyBean.getData()
                .getColumns().get(i).getAuthor());


        return view;
    }

    class ColumnHolder{

        private final ImageView mImg_column;
        private final TextView mText_column;
        private final TextView mText_view_column;

        public ColumnHolder(View columnView){

            mImg_column = (ImageView) columnView.findViewById(R.id.img_column);
            mText_column = (TextView) columnView.findViewById(R.id.text_column);
            mText_view_column = (TextView) columnView.findViewById(R.id.text_View_column);

        }
    }
}
