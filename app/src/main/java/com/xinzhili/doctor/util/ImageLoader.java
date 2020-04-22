package com.xinzhili.doctor.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.xinzhili.doctor.R;

import androidx.annotation.Nullable;

public class ImageLoader {

    private volatile static ImageLoader INSTANCE;

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (INSTANCE == null) {
            synchronized (ImageLoader.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ImageLoader();
                }
            }
        }
        return INSTANCE;
    }

    public void display(ImageView imageView, String url, int placeHolder) {
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(placeHolder);
        Glide.with(imageView)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public void displayBitMap(ImageView imageView, Bitmap bitmap, int placeHolder){
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(placeHolder);
        Glide.with(imageView)
                .load(bitmap)
                .apply(options)
                .into(imageView);
    }

    public void displayb(ImageView imageView, String url, int placeHolder) {
        Bitmap bitmap;
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(placeHolder);
        Glide.with(imageView).asBitmap()
                .load(url).listener(new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
               // bitmap=resource;
                return false;
            }
        })
                .apply(options)
                .into(imageView);
    }


    public void display(ImageView imageView, String url) {
        display(imageView, url, DiskCacheStrategy.ALL);
    }

    public void display(ImageView imageView, String url, DiskCacheStrategy strategy) {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(strategy);
        Glide.with(imageView)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public void loadLocalPath(ImageView iv, String localPath) {
        RequestOptions options = new RequestOptions()
                .signature(new ObjectKey(System.currentTimeMillis()));
        Glide.with(iv)
                .load(localPath)
                .apply(options)
                .into(iv);
    }

    public void displayTarget(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(imageView)
                .load(url)
                .apply(options)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                        imageView.setImageDrawable(drawable);
                    }
                });
    }

    /**
     * 加载正常图片
     * @param context context
     * @param iv ImageView
     * @param url pic url
     * @param placeHolder 占位图
     */
    public void loadNormalPic(Context context, ImageView iv, String url, int placeHolder){
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(placeHolder);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    /**
     * 加载正常图片
     * @param context context
     * @param iv ImageView
     * @param url pic url
     * @param placeHolder 占位图
     */
    public void loadCornerPic(Context context, ImageView iv, String url, int corner, int placeHolder){
        RequestOptions options = RequestOptions
                .bitmapTransform(new RoundedCorners(corner))
                .placeholder(placeHolder)
                .error(placeHolder);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    /**
     * 加载正常图片
     * @param context context
     * @param iv ImageView
     * @param url pic url
     * @param placeHolder 占位图
     */
    public void loadNormalPicWithWH(Context context, ImageView iv, String url, int placeHolder, int width, int height){
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(placeHolder)
                .override(width, height);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    /**
     * 加载正常图片
     * @param context context
     * @param iv ImageView
     * @param url pic url
     * @param placeHolder 占位图
     * @param errorPlaceHolder 加载失败占位图
     */
    public void loadNormalPic(Context context, ImageView iv, String url, int placeHolder, int errorPlaceHolder){
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(errorPlaceHolder);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    /**
     * 加载正常图片
     * @param context context
     * @param iv ImageView
     * @param url pic url
     * @param placeHolder 占位图
     */
    public void loadPicAnim(Context context, ImageView iv, String url, int placeHolder){
        if(TextUtils.isEmpty(url)){
            return;
        }
        RequestOptions options = new RequestOptions()
                .placeholder(placeHolder)
                .error(placeHolder)
                .dontAnimate();

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }


    /**
     * 加载正常图片
     * @param context context
     * @param iv ImageView
     * @param url pic url
     */
    public void loadPatientAvatar(Context context, ImageView iv, String url){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_default_photo)
                .error(R.drawable.ic_default_photo);

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }
}
