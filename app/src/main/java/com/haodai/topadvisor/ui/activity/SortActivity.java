package com.haodai.topadvisor.ui.activity;

import com.ht.baselib.utils.LogUtils;
import com.ht.uilib.base.BaseActivity;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/8/7 14:42
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class SortActivity extends BaseActivity {

    @Override
    protected boolean isStaticPage() {
        return true;
    }

    @Override
    protected void initTitleBar() {

    }

    @Override
    protected int initContentView() {
        return com.ht.uilib.R.layout.activity_base_splash;
    }

    @Override
    protected void initChildView() {

    }

    @Override
    protected void initChildData() {
        selectSort(8,4,6,2,0,4,2,20,13);
    }

    @Override
    protected void setChildViewListener() {

    }

    public void selectSort(int ... arr){
        int minIndex, temp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        print(arr);
    }

    public void print(int[] arr){
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            temp.append(arr[i]+",");
        }
        LogUtils.error(temp.deleteCharAt(temp.lastIndexOf(",")).toString());
    }

}
