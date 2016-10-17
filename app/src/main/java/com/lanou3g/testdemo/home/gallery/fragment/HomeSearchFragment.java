package com.lanou3g.testdemo.home.gallery.fragment;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lanou3g.testdemo.R;
import com.lanou3g.testdemo.base.BaseFragment;
import com.lanou3g.testdemo.home.gallery.bean.HomeNameBean;
import com.lanou3g.testdemo.task.NetTool;
import com.lanou3g.testdemo.task.NetTool.NetInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Created by 程洪运 on 16/10/17.
 */
public class HomeSearchFragment extends BaseFragment {
    private String strUrl;
    private ListView edit_home_fragment;
    NetTool mTool = new NetTool();

    @Override
    protected int setLayout() {
        return R.layout.edit_home_fragment;
    }

    @Override
    protected void initView() {
        edit_home_fragment = bindView(R.id.edit_home_fragment);
    }

    @Override
    protected void initData() {
        wordData();
    }


    public void setUrl(String url) {
        this.strUrl = url;
        wordData();
    }

    private void wordData() {
        mTool.getData(strUrl, HomeNameBean.class, new NetInterface<HomeNameBean>() {
            @Override
            public void onSuccess(HomeNameBean homeNameBean) {
                List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < homeNameBean.getData().getWords().size(); i++) {
                    Map<String, Object> listItem = new HashMap<String, Object>();
                    listItem.put("name", homeNameBean.getData().getWords().get(i));
                    listItems.add(listItem);
                }

                SimpleAdapter adapter = new SimpleAdapter(getContext(), listItems, R.layout.simple_item,
                        new String[]{"name"}, new int[]{R.id.tv_search_slimply});
                edit_home_fragment.setAdapter(adapter);

            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}

