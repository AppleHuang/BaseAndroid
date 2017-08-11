package com.haodai.topadvisor.ui.fragment;

import android.view.View;

import com.ht.baselib.utils.UIUtils;
import com.ht.demo.R;
import com.ht.uilib.base.BaseFragment;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/3/14 14:42
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class SelfFragment extends BaseFragment {

    @Override
    protected boolean isStaticPage() {
        return true;
    }

    @Override
    protected View initContentView() {
        return UIUtils.inflate(R.layout.frag_self);
    }

    @Override
    protected void initChildView() {

    }

    @Override
    protected void setChildViewListener() {

    }

    @Override
    protected void load() {

    }
}
