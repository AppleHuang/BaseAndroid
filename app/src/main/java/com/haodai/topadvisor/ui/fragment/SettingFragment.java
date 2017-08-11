package com.haodai.topadvisor.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.haodai.topadvisor.ui.activity.ArticleActivity;
import com.haodai.topadvisor.ui.activity.SettingActivity;
import com.haodai.topadvisor.ui.activity.WebViewActivity;
import com.ht.baselib.utils.ActivityUtils;
import com.ht.baselib.utils.UIUtils;
import com.ht.demo.R;
import com.ht.pushlib.PushManager;
import com.ht.uilib.base.BaseOperatorFragment;
import com.ht.uilib.bean.OperatorBean;
import com.ht.uilib.dialog.TipsDialog;


public class SettingFragment extends BaseOperatorFragment {


    @Override
    protected boolean isShowTitleBarView() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        mTitleBarView
                .setTitleText("设置")
                .setLeftBtnVisibility(View.GONE);
    }

    @Override
    protected View getHeaderView() {
        return null;
    }

    @Override
    protected void loadData() {
        add(true, R.mipmap.test_setting, "打开网页", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                Bundle bundle = new Bundle();
                bundle.putString(WebViewActivity.TITLE, "网页");
                bundle.putString(WebViewActivity.URL, "file:///android_asset/demo.html");
//                bundle.putString(WebViewActivity.URL, "http://xzjr.haodai.com/agent");
                ActivityUtils.startActivity(mContext, WebViewActivity.class, bundle);
            }
        });
        add(R.mipmap.test_setting, "文章列表", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                ActivityUtils.startActivity(mContext, ArticleActivity.class);
            }
        });

        add(true, R.mipmap.test_setting, "获取推送RegisterId", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                UIUtils.showToast("id = "+ PushManager.getRegisterId());
            }
        });

        add(true, R.mipmap.test_setting, "设置界面", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                ActivityUtils.startActivity(mContext, SettingActivity.class);
            }
        });

        add(true, "地区", "中国", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                UIUtils.showToast("地区");
            }
        });
        add("个人签名", "我的未来不是梦", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                UIUtils.showToast("个人签名");
            }
        });


        add(true, "声音", true, true, new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                if (isChecked) {
                    UIUtils.showToast("声音    打开");
                } else {
                    UIUtils.showToast("声音    关闭");
                }
            }
        });

        add(true, "退出登录", true, new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                TipsDialog
                        .newInstance(mContext)
                        .setTitle("提示")
                        .setContent("确定退出？").setOnDialogTipsClickListener(new TipsDialog.OnDialogTipsClickListener() {
                            @Override
                            public void doEnter() {
                                UIUtils.showToast("退出登陆");
                            }

                            @Override
                            public void doCancel() {

                            }
                        }).show();
            }
        });
    }
}