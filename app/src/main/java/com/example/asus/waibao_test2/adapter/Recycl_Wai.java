package com.example.asus.waibao_test2.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.waibao_test2.R;
import com.example.asus.waibao_test2.bean.Person;
import com.example.asus.waibao_test2.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class Recycl_Wai extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Person> persons;
    private Context context;
    private List<Fragment> fragmentList;
    private FragmentManager fragmentManager;
    private ArrayList<String> chuyiTitle;

    public Recycl_Wai(List<Person> persons, Context context, FragmentManager fragmentManager) {
        this.persons = persons;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflate = LayoutInflater.from(context);
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0:
                View inflate1 = inflate.inflate(R.layout.layout_recycl_wai, parent, false);
                holder = new ViewHolder1(inflate1);
                break;
            case 1:
                View inflate2 = inflate.inflate(R.layout.layout_recycl_er, parent, false);
                holder = new ViewHolder2(inflate2);
                break;
            case 2:
                View inflate3 = inflate.inflate(R.layout.layout_recycl_san, parent, false);
                holder = new ViewHolder3(inflate3);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        fragmentList = new ArrayList<>();

        if (holder instanceof ViewHolder1){
            ((ViewHolder1) holder).mclasses.setText(persons.get(position).getTitle());

            chuyiTitle = persons.get(position).getChuyiTitle();
            for (int i = 0; i < chuyiTitle.size(); i++) {
                TwoFragment oneFragment = new TwoFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("aa", persons.get(position));
                oneFragment.setArguments(bundle);
                fragmentList.add(oneFragment);
            }
            FVPAdapter fvpAdapter = new FVPAdapter(fragmentManager, chuyiTitle, fragmentList);
           ((ViewHolder1) holder).mViewpager.setAdapter(fvpAdapter);
            ((ViewHolder1) holder).mViewpager.setOffscreenPageLimit(fragmentList.size());

        }if(holder instanceof ViewHolder2){
            ((ViewHolder2) holder).mclasses.setText(persons.get(position).getTitle());

            chuyiTitle = persons.get(position).getChuyiTitle();
            for (int i = 0; i < chuyiTitle.size(); i++) {
                TwoFragment oneFragment = new TwoFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("aa", persons.get(position));
                oneFragment.setArguments(bundle);
                fragmentList.add(oneFragment);
            }
            FVPAdapter fvpAdapter = new FVPAdapter(fragmentManager, chuyiTitle, fragmentList);
            ((ViewHolder2) holder).mViewpager_Er.setAdapter(fvpAdapter);
            ((ViewHolder2) holder).mViewpager_Er.setOffscreenPageLimit(fragmentList.size());

        }if(holder instanceof ViewHolder3){
            ((ViewHolder3) holder).mclasses.setText(persons.get(position).getTitle());

            chuyiTitle = persons.get(position).getChuyiTitle();
            for (int i = 0; i < chuyiTitle.size(); i++) {
                TwoFragment oneFragment = new TwoFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("aa", persons.get(position));
                oneFragment.setArguments(bundle);
                fragmentList.add(oneFragment);
            }
            FVPAdapter fvpAdapter = new FVPAdapter(fragmentManager, chuyiTitle, fragmentList);
            ((ViewHolder3) holder).mViewpager_San.setAdapter(fvpAdapter);
            ((ViewHolder3) holder).mViewpager_San.setOffscreenPageLimit(fragmentList.size());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return null == persons ? 0 : persons.size();
    }


    public class ViewHolder1 extends RecyclerView.ViewHolder {

        public View rootView;
        public TabLayout mTab;
        public ViewPager mViewpager;
        public TextView mclasses;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mTab = (TabLayout) rootView.findViewById(R.id.mTab);
            this.mViewpager = (ViewPager) rootView.findViewById(R.id.mViewpager);
            this.mTab.setupWithViewPager(mViewpager);
            this.mclasses = (TextView) rootView.findViewById(R.id.mclasses);
        }
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView mclasses;
        public TabLayout mTab_Er;
        public ViewPager mViewpager_Er;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mclasses = (TextView) rootView.findViewById(R.id.mclasses);
            this.mTab_Er = (TabLayout) rootView.findViewById(R.id.mTab_Er);
            this.mViewpager_Er = (ViewPager) rootView.findViewById(R.id.mViewpager_Er);
            this.mTab_Er.setupWithViewPager(mViewpager_Er);
        }

    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView mclasses;
        public TabLayout mTab_San;
        public ViewPager mViewpager_San;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mclasses = (TextView) rootView.findViewById(R.id.mclasses);
            this.mTab_San = (TabLayout) rootView.findViewById(R.id.mTab_San);
            this.mViewpager_San = (ViewPager) rootView.findViewById(R.id.mViewpager_San);
            this.mTab_San.setupWithViewPager(mViewpager_San);
        }

    }
}
