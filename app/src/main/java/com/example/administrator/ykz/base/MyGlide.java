package com.example.administrator.ykz.base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.ykz.R;
import com.youth.banner.loader.ImageLoader;

public class MyGlide extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).placeholder(R.mipmap.ic_launcher).into(imageView);
    }
}
