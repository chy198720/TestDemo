package com.lanou3g.testdemo.task;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

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
 * Created by 程洪运 on 16/10/14.
 */
public class NetTool {
    // 正常图片带缩放
    public void getImg(String url, ImageView imageView) {

        ImageLoader imageLoader = SingLQueue.getInstance().getmImageLoader();

        imageLoader.get(url, new MyImageListener1(imageView));

    }

    public class MyImageListener1 implements ImageLoader.ImageListener {
        private ImageView imageView;

        public MyImageListener1(ImageView imageView) {
            this.imageView = imageView;
        }

        // 图片请求成功的回调
        @Override
        public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

            Bitmap bitmap = response.getBitmap();
            if (bitmap == null) {

            } else {
                if (imageView.getWidth() == 0) {
                    bitmap = getSmallBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight());
                } else if (imageView.getWidth() > bitmap.getWidth()) {
                    bitmap = getSmallBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight());
                } else {
                    bitmap = getSmallBitmap(bitmap, imageView.getWidth(), imageView.getHeight());
                }
                imageView.setImageBitmap(bitmap);
            }
        }

        @Override
        public void onErrorResponse(VolleyError error) {
        }
    }

    private Bitmap getSmallBitmap(Bitmap bitmap, int reqW, int reqH) {
        Matrix matrix = new Matrix();
        float scale = Math.min((reqW * 1.0f / bitmap.getWidth()), (reqH * 1.0f / bitmap.getHeight()));
        matrix.postScale(scale, scale);
        Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        return result;
    }


    public <T> void getData(String url, final Class<T> clazz, final NetInterface<T> netInterface) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                netInterface.onSuccess(gson.fromJson(response, clazz));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                netInterface.onError(error.getMessage());
            }
        });

        SingLQueue.getInstance().addRequest(stringRequest);

    }

    // 网络请求的接口，有成功方法， 有失败方法
    public interface NetInterface<T> {
        void onSuccess(T t); // 网络请求成功 返回的是解析完成的实体类

        void onError(String errorMsg);
    }
}

