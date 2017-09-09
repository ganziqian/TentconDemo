package com.zwg.tentcondemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zwg.tentcondemo.MyAdapter;
import com.zwg.tentcondemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideUpchangeFragment extends BaseFragment {


    public SlideUpchangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_slide_upchange, container, false);
        init(v);

        return v;
    }

    private void init(View v) {
        ListView lv= (ListView) v.findViewById(R.id.upchen_lv);

        final View footView = getActivity().getLayoutInflater()
                .inflate(R.layout.slidedetails_marker_default_layout, null);

        List<String> list=new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add("hhhhhhhhhhhhh"+i);
        }
        MyAdapter myAdapter=new MyAdapter(list,getActivity());

        footView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(true);
            }
        });
        lv.addFooterView(footView);
        lv.setAdapter(myAdapter);

    }

}
