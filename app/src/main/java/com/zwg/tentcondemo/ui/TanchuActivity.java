package com.zwg.tentcondemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.zwg.tentcondemo.MyAdapter;
import com.zwg.tentcondemo.R;

import java.util.ArrayList;
import java.util.List;

public class TanchuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanchu);


        TextView tv= (TextView) findViewById(R.id.tanchu_tv);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


}
