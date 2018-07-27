package com.example.asus.waibao_test2.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.asus.waibao_test2.R;
import com.example.asus.waibao_test2.adapter.RecyclAdapter;
import com.example.asus.waibao_test2.adapter.Recycl_Er;
import com.example.asus.waibao_test2.adapter.Recycl_Wai;
import com.example.asus.waibao_test2.bean.KeCheng;
import com.example.asus.waibao_test2.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ImageView mimg_wenhao;
    private RecyclerView mRecyclView;
    //person集合
    private List<Person>persons=new ArrayList();
    private ArrayList<String> chuyiTitle=new ArrayList<>();
    private ArrayList<KeCheng> keCheng=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        //显示沉浸式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }

    private void initData() {
        initChuyiKeCheng();
        initChuyiTab();
        persons.add(new Person("初一",chuyiTitle,keCheng));
        persons.add(new Person("初二",chuyiTitle,keCheng));
        persons.add(new Person("特殊名称的...班",chuyiTitle,keCheng));
       /* Recycl_Wai recycl_wai = new Recycl_Wai(persons, MainActivity.this, getSupportFragmentManager());
        mRecyclView.setAdapter(recycl_wai);*/
       //recyclAdapter崩
       /* RecyclAdapter recyclAdapter = new RecyclAdapter(persons, MainActivity.this, getSupportFragmentManager());
       mRecyclView.setAdapter(recyclAdapter);*/
        Recycl_Er recycl_Er = new Recycl_Er(persons, MainActivity.this, getSupportFragmentManager());
        mRecyclView.setAdapter(recycl_Er);

    }

    private void initChuyiTab() {
        for (int i = 0; i <6 ; i++) {
            chuyiTitle.add(i+1+"班");
        }
    }

    private void initChuyiKeCheng() {
        keCheng.add(new KeCheng("张欣然","语文"));
        keCheng.add(new KeCheng("张欣然","中国近代史..."));
        keCheng.add(new KeCheng("苏天天","数学"));
        keCheng.add(new KeCheng("王蜀君","英语"));
        keCheng.add(new KeCheng("张欣然","音乐"));
        keCheng.add(new KeCheng("苏天天","数学"));
        keCheng.add(new KeCheng("张欣然","音乐"));
        keCheng.add(new KeCheng("苏天天","数学"));
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        mimg_wenhao = (ImageView) findViewById(R.id.mimg_wenhao);
        mRecyclView = (RecyclerView) findViewById(R.id.RecyclView);
        mRecyclView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}
