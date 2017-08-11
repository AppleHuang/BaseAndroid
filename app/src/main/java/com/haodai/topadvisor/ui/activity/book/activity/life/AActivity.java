package com.haodai.topadvisor.ui.activity.book.activity.life;

import android.app.Activity;
import android.os.Bundle;

import com.ht.baselib.utils.ActivityUtils;
import com.ht.baselib.utils.LogUtils;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/6/2 17:43
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class AActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.error(getClass().getSimpleName()+"    onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.error(getClass().getSimpleName()+"    onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.error(getClass().getSimpleName()+"    onResume()");
        ActivityUtils.startActivity(this, BActivity.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.error(getClass().getSimpleName()+"    onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.error(getClass().getSimpleName()+"    onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.error(getClass().getSimpleName()+"    onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.error(getClass().getSimpleName()+"    onRestart()");
    }
}
