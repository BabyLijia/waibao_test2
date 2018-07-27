package com.example.asus.waibao_test2.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.waibao_test2.R;
import com.example.asus.waibao_test2.bean.Person;
import com.example.asus.waibao_test2.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class Recycl_Er extends RecyclerView.Adapter<Recycl_Er.ViewHolder> {
    private List<Person> persons;
    private Context context;
    private List<Fragment> fragmentList;
    private FragmentManager fragmentManager;
    private ArrayList<String> chuyiTitle;

    public Recycl_Er(List<Person> persons, Context context, FragmentManager fragmentManager) {
        this.persons = persons;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recycl_wai, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        fragmentList = new ArrayList<>();
        holder.mclasses.setText(persons.get(position).getTitle());
        //todo 给Viewpager重新设置一个Id，避免重复使用同一个xml布局id只显示一条数据
        holder.mViewpager.setId(position+1);
        chuyiTitle = persons.get(position).getChuyiTitle();
        //Fragment复用
        for (int i = 0; i < chuyiTitle.size(); i++) {
            TwoFragment twoFragment = new TwoFragment();
            Bundle bundle = new Bundle();
            //使用Bundle传类序列化接口
            bundle.putSerializable("aa", persons.get(position));
            twoFragment.setArguments(bundle);
            fragmentList.add(twoFragment);
        }
        FVPAdapter fvpAdapter = new FVPAdapter(fragmentManager, chuyiTitle, fragmentList);
        holder.mViewpager.setAdapter(fvpAdapter);
        //todo 预加载，点击TabLayout后几个Item条目时自动保存前面选中的数据
        holder.mViewpager.setOffscreenPageLimit(fragmentList.size());
        Log.e("", fragmentList.size()+"" );

    }

    @Override
    public int getItemCount() {
        return null == persons ? 0 : persons.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View rootView;
        public TabLayout mTab;
        public ViewPager mViewpager;
        public TextView mclasses;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mTab = (TabLayout) rootView.findViewById(R.id.mTab);
            this.mViewpager = (ViewPager) rootView.findViewById(R.id.mViewpager);
            this.mTab.setupWithViewPager(mViewpager);
            this.mclasses = (TextView) rootView.findViewById(R.id.mclasses);
        }
    }
}
