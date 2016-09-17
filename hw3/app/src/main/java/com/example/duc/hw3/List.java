package com.example.duc.hw3;

import java.io.Serializable;

/**
 * Created by DUC on 9/17/2016.
 */
public class List implements Serializable{
    private String name;
    private int count;

    private boolean activity;

    public List(String name, int count){
        this.name = name;
        this.count = count;
        this.activity = true;
    }

    public List(String name, int count, boolean activity){
        this.name = name;
        this.count = count;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return this.name +" ("+ this.count+")";
    }
}
