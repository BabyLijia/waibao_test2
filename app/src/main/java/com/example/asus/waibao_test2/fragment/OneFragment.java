package com.example.asus.waibao_test2.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.waibao_test2.R;
import com.example.asus.waibao_test2.adapter.FVPAdapter;
import com.example.asus.waibao_test2.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    private TabLayout mTab;
    private ViewPager mViewpager;
    private List<Fragment> fragmentList;
    private FVPAdapter fvpAdapter;
    private Person person;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_one2, container, false);
        Bundle arguments = getArguments();
        fragmentList=new ArrayList<>();
        person = (Person) arguments.getSerializable("aa");
        initView(inflate);
        return inflate;
    }


    private void initView(View inflate) {
        ArrayList<String> chuyiTitle = person.getChuyiTitle();
        for (int i = 0; i < chuyiTitle.size(); i++) {
            TwoFragment twoFragment = new TwoFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("aa",person.getKecheng());
            twoFragment.setArguments(bundle);
            fragmentList.add(twoFragment);
        }
        mTab = (TabLayout) inflate.findViewById(R.id.mTab);
        mViewpager = (ViewPager) inflate.findViewById(R.id.mViewpager);
        mViewpager.setOffscreenPageLimit(fragmentList.size());
        mTab.setupWithViewPager(mViewpager);
        fvpAdapter = new FVPAdapter(getChildFragmentManager(),chuyiTitle, fragmentList);
        mViewpager.setAdapter(fvpAdapter);

    }
}
