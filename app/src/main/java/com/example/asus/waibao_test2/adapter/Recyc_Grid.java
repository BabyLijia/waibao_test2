package com.example.asus.waibao_test2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.waibao_test2.R;
import com.example.asus.waibao_test2.bean.KeCheng;

import java.util.ArrayList;

public class Recyc_Grid extends RecyclerView.Adapter<Recyc_Grid.ViewHolder> {
    private ArrayList<KeCheng> kecheng;
    private Context context;

    public Recyc_Grid(ArrayList<KeCheng> kecheng, Context context) {
        this.kecheng = kecheng;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recycl__grid, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mClassesName.setText(kecheng.get(position).getClassName());
        holder.mTecher.setText(kecheng.get(position).getTecher());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.getData(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null==kecheng?0:kecheng.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView mClassesName;
        public TextView mTecher;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mClassesName = (TextView) rootView.findViewById(R.id.mClassesName);
            this.mTecher = (TextView) rootView.findViewById(R.id.mTecher);
        }

    }
    MyCallBack myCallBack;
    public interface  MyCallBack{
        void getData(View view,int id);
    }

    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }
}
