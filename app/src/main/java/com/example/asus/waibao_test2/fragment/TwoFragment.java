package com.example.asus.waibao_test2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.waibao_test2.R;
import com.example.asus.waibao_test2.adapter.Recyc_Grid;
import com.example.asus.waibao_test2.bean.KeCheng;
import com.example.asus.waibao_test2.bean.Person;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    private RecyclerView mrecycl_two;
    private Person bb;
    private ArrayList<KeCheng> kecheng;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        Bundle arguments = getArguments();
        bb = (Person) arguments.getSerializable("aa");
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        kecheng = bb.getKecheng();
        Recyc_Grid recyc_grid = new Recyc_Grid(kecheng,getActivity());
        mrecycl_two.setAdapter(recyc_grid);
        recyc_grid.setMyCallBack(new Recyc_Grid.MyCallBack() {
            @Override
            public void getData(View view,int id) {
                LinearLayout viewById = view.findViewById(R.id.mll);
                TextView classesName = view.findViewById(R.id.mClassesName);
                TextView techer = view.findViewById(R.id.mTecher);
                boolean isselect = kecheng.get(id).isIsselect();
                kecheng.get(id).setIsselect(!isselect);
                if(isselect){
                    viewById.setBackgroundResource(R.drawable.shape_two);
                    classesName.setTextColor(R.drawable.shape_two);
                    techer.setTextColor(R.drawable.shape_two);

                }else {
                    viewById.setBackgroundResource(R.drawable.shape_one);
                    classesName.setTextColor(R.drawable.shape_two);
                    techer.setTextColor(R.drawable.shape_two);

                }
            }
        });
    }

    private void initView(View inflate) {
        mrecycl_two = (RecyclerView) inflate.findViewById(R.id.mrecycl_two);
        mrecycl_two.setLayoutManager(new GridLayoutManager(getActivity(),3));

    }
}
