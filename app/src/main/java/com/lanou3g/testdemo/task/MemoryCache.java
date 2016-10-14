package com.lanou3g.testdemo.task;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

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
public class MemoryCache implements ImageLoader.ImageCache {
    // LruCache 是实现了 最近最少使用算法的缓存类
    // key 是url value 是需要缓存的图片
    private LruCache<String, Bitmap> mLruCache;

    public MemoryCache() {
        // 获取Android 为我们的应用提供的最大内存空间
        // 我们只使用最大内存的空间的 1/8 来作为缓存
        int maxSize = (int) Runtime.getRuntime().maxMemory() / 8 / 1024;
        // LruCache 在初始化的时候 需要指定最大容量
        mLruCache = new LruCache<String, Bitmap>(maxSize){
            // LruCache 需要复写sizeOf方法，来指定每一个value 所占空间的大小
            @Override
            protected int sizeOf(String key, Bitmap value) {
                // 除1024 是为了将字节转换成kb
                int valueSize = value.getByteCount() / 1024;
                return valueSize;
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {

        return mLruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mLruCache.put(url, bitmap);
    }
}