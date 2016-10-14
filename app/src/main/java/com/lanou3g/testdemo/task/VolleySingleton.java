package com.lanou3g.testdemo.task;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

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
 * Created by 程洪运 on 16/9/20.
 */
public class VolleySingleton {

    private static VolleySingleton mVolleySingleton;
    // 把请求队列.放到单例类里面,这样整个项目就只有一个requestQueue了
    private RequestQueue mRequestQueue;

    private VolleySingleton(){
        mRequestQueue = Volley.newRequestQueue(MyApp.getContext());
    }

    public static VolleySingleton getInstance(){

        if (mVolleySingleton == null) {
            synchronized (VolleySingleton.class){
                if (mVolleySingleton == null) {
                    mVolleySingleton = new VolleySingleton();
                }
            }
        }
        return mVolleySingleton;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    /**
     * 把请求,加到请求队列中
     * @param request
     */
    public void addRequest(Request request){
        mRequestQueue.add(request);
    }
}
