package com.example.asus.waibao_test2.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable{
    private String title;
    private ArrayList<String> chuyiTitle;
    private ArrayList<KeCheng> kecheng;

    public Person(String title, ArrayList<String> chuyiTitle, ArrayList<KeCheng> kecheng) {
        this.title = title;
        this.chuyiTitle = chuyiTitle;
        this.kecheng = kecheng;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public ArrayList<String> getChuyiTitle() {
        return chuyiTitle;
    }

    public void setChuyiTitle(List<String> chuyiTitle) {
        chuyiTitle = chuyiTitle;
    }

    public ArrayList<KeCheng> getKecheng() {
        return kecheng;
    }

    public void setKecheng(ArrayList<KeCheng> kecheng) {
        this.kecheng = kecheng;
    }
}
