package com.dinesh.json_test;

/**
 * Created by gspl-dd on 6/2/18.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by geetham38 on 5/2/18.
 */

public class Listviewadapter extends ArrayAdapter<Something> {


    private List<Something> s;

    private Context c;

    TextView t1, t2, t3;


    public Listviewadapter(List<Something> s, Context c) {
        super(c, R.layout.list_items, s);
        this.s = s;
        this.c = c;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(c);

        View lv = layoutInflater.inflate(R.layout.list_items,null,true);

        t1 =lv.findViewById(R.id.textViewName);
        t2=lv.findViewById(R.id.textViewImageUrl);
        t3 =lv.findViewById(R.id.textViewtest);


        Something some = s.get(position);


        t1.setText(some.getName());
        t2.setText(some.getImageurl());
        t3.setText(some.getAge());

        return lv;
    }
}




