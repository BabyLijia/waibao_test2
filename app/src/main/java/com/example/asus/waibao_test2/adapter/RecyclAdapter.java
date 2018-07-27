package com.example.asus.waibao_test2.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus.waibao_test2.R;
import com.example.asus.waibao_test2.bean.Person;
import com.example.asus.waibao_test2.fragment.OneFragment;

import java.util.ArrayList;
import java.util.List;

public class RecyclAdapter extends RecyclerView.Adapter<RecyclAdapter.ViewHolder> {
    private List<Person> chuyiTitle;
    private Context context;
    private FragmentManager fragmentManager;

    public RecyclAdapter(List<Person> chuyiTitle, Context context, FragmentManager fragmentManager) {
        this.chuyiTitle = chuyiTitle;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recycladapter,null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.classes.setText(chuyiTitle.get(position).getTitle());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        OneFragment oneFragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("aa",chuyiTitle.get(position));
        oneFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.mfameLayout,oneFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public int getItemCount() {
        return chuyiTitle.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RelativeLayout mfameLayout;
        public TextView classes;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mfameLayout = (RelativeLayout) rootView.findViewById(R.id.mfameLayout);
            this.classes = (TextView) rootView.findViewById(R.id.classes);
        }
    }
}
