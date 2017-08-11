package com.haodai.topadvisor.ui.activity;

import android.support.v4.app.Fragment;

import com.haodai.topadvisor.ui.fragment.ArticleNoTitleFragment;
import com.ht.uilib.base.BaseTabActivity;

import java.util.ArrayList;
import java.util.List;


public class TestTabActivity extends BaseTabActivity {


    @Override
    protected void initTitleBar() {
        mTitleBarView.setTitleText("TabActivity");
    }

    protected List<String> getTabTitleList(){
        List<String> tabList = new ArrayList<>();
        tabList.add("文章1");
        tabList.add("文章2");
        tabList.add("文章3");
        tabList.add("文章4");
        return tabList;
    }

    @Override
    protected List<Fragment> getFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ArticleNoTitleFragment());
        fragmentList.add(new ArticleNoTitleFragment());
        fragmentList.add(new ArticleNoTitleFragment());
        fragmentList.add(new ArticleNoTitleFragment());
        return fragmentList;
    }

}
