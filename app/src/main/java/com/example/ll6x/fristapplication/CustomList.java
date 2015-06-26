package com.example.ll6x.fristapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Laemy.Y.Li on 2015/6/24.
 */
public class CustomList extends ArrayAdapter<String> {
    private Activity context;
    private String[] web;
    private Integer[] imageId;

    public CustomList(Activity context, String[] web, Integer[] imageId) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web =web;
        this.imageId = imageId;
    }


    public CustomList(Context context, int resource) {
        super(context, resource);
    }

    public CustomList(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);


    }

    public CustomList(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public CustomList(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public CustomList(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public CustomList(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single,null,true);
        TextView txtTitle =(TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
