package com.zwg.tentcondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ScrollZoomListview lv;
    private ImageView iv;

    private List<String> list=new ArrayList<>();
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CollapsingToolbarLayout

        //思路:listview+headerview


        lv= (ScrollZoomListview) findViewById(R.id.lv);
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        list.add("哈呵呵呵呵呵呵呵呵呵呵呵呵好或或");
        adapter=new MyAdapter(list,this);


        View header=View.inflate(this,R.layout.list_head,null);
        iv= (ImageView) header.findViewById(R.id.beijing_iv);
        lv.setIv(iv);
        lv.addHeaderView(header);



        lv.setAdapter(adapter);



    }
}
