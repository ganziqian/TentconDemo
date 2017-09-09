package com.zwg.tentcondemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zwg.tentcondemo.MyAdapter;
import com.zwg.tentcondemo.R;
import com.zwg.tentcondemo.utils.NDKtest;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private List<String> list=new ArrayList<>();
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);




        list.add("BouncingView,底部弹出");
        list.add("deckview卡片层叠效果");
        list.add("上拉弹出效果");
        list.add("流程进度查询");
        list.add("安全键盘");


        ListView lv= (ListView) findViewById(R.id.index_list);
        myAdapter=new MyAdapter(list,this);

        lv.setAdapter(myAdapter);

        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
               mystartactivity(TanchuActivity.class);
                break;
            case 1:
                mystartactivity(DeckViewSampleActivity.class);
                break;
            case 2:
                mystartactivity(SlideUpchangeActivity.class);
                break;
            case 3:
                mystartactivity(SetpViewActivity.class);
                break;
            case 4:
                mystartactivity(KeyActivity.class);
                break;
        }
    }

    public void mystartactivity(Class<?> cls){
        startActivity(new Intent(IndexActivity.this,cls));
    }
}
