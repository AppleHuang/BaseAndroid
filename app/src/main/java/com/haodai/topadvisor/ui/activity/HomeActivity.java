package com.haodai.topadvisor.ui.activity;

import android.support.v4.app.Fragment;

import com.haodai.topadvisor.ui.fragment.ArticleFragment;
import com.haodai.topadvisor.ui.fragment.SelfFragment;
import com.haodai.topadvisor.ui.fragment.SettingFragment;
import com.ht.demo.R;
import com.ht.uilib.base.BaseHomeActivity;

import java.util.List;
import java.util.Map;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/3/13 17:19
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class HomeActivity extends BaseHomeActivity {

    @Override
    protected void addHomeFragment(List<Fragment> fragmentList) {
        fragmentList.add(new ArticleFragment());
        fragmentList.add(new SettingFragment());
        fragmentList.add(new SelfFragment());
    }

    @Override
    protected void addHomeTabInfo(Map<String, Integer> homeTabInfoMap) {
        homeTabInfoMap.put("文章", R.drawable.home_tab0_icon_selector);
        homeTabInfoMap.put("设置", R.drawable.home_tab1_icon_selector);
        homeTabInfoMap.put("我", R.drawable.home_tab2_icon_selector);
    }
}