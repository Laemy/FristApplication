package com.example.ll6x.fristapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Laemy.Y.Li on 2015/6/29.
 */
public class ImageAdapter extends BaseAdapter {

    //實作ImageAdapter類別並且繼承BaseAdapter類別。包含實作建構子、取得數量、取得項目和取得項目編號。
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }


    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }

    //實作取得View物件，設定圖片長寬為200X200

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


    //宣告整數陣列，用來存放所有圖片資源檔資訊。
    // Keep all Images in array
    // 有挑圖片，某些圖片會當掉
    public Integer[] mThumbIds = {
            R.drawable.a01, R.drawable.a02,
            R.drawable.a03, R.drawable.a04,
            R.drawable.a05, R.drawable.a06,
            R.drawable.a07
    };

}
