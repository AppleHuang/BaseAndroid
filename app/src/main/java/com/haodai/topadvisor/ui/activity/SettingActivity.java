package com.haodai.topadvisor.ui.activity;

import android.view.View;

import com.ht.baselib.utils.ActivityUtils;
import com.ht.baselib.utils.UIUtils;
import com.ht.demo.R;
import com.ht.uilib.base.BaseOperatorActivity;
import com.ht.uilib.bean.OperatorBean;


/**
 * Created by huangtao on 16/9/14.
 */
public class SettingActivity extends BaseOperatorActivity {

    @Override
    protected void initTitleBar() {
        mTitleBarView.setTitleText("设置");
    }

    @Override
    protected View getHeaderView() {
        return null;
    }

    @Override
    protected void loadData() {
        add(true, R.mipmap.test_setting, "TabActivity", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                ActivityUtils.startActivity(SettingActivity.this, TestTabActivity.class);
            }
        });

        add(true, R.mipmap.test_setting, "网络请求", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                ActivityUtils.startActivity(SettingActivity.this, NetActivity.class);
            }
        });
        add(R.mipmap.test_setting, "摇一摇", new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {
                UIUtils.showToast("摇一摇");
            }
        });

        add(true, "退出登录", true, new OperatorBean.OnItemClickListener() {
            @Override
            public void onClick(boolean isChecked) {

            }
        });
    }
}
