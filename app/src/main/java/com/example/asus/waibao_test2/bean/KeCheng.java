package com.example.asus.waibao_test2.bean;

import java.io.Serializable;

public class KeCheng implements Serializable{
    private String className;
    private String techer;
    private boolean isselect;

    public KeCheng() {
    }


    public boolean isIsselect() {
        return isselect;
    }

    public void setIsselect(boolean isselect) {
        this.isselect = isselect;
    }

    public KeCheng(String className, String techer, boolean isselect) {
        this.className = className;

        this.techer = techer;
        this.isselect = isselect;
    }

    public KeCheng(String className, String techer) {

        this.className = className;
        this.techer = techer;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTecher() {
        return techer;
    }

    public void setTecher(String techer) {
        this.techer = techer;
    }
}
