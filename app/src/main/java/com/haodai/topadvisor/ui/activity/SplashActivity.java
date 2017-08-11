package com.haodai.topadvisor.ui.activity;

import com.ht.baselib.utils.SharedPreferencesUtils;
import com.ht.demo.R;
import com.ht.uilib.base.BaseActivity;
import com.ht.uilib.base.BaseGuideActivity;
import com.ht.uilib.base.BaseSplashActivity;


public class SplashActivity extends BaseSplashActivity {

    @Override
    protected boolean isIncludeStatus() {
        return false;
    }

    @Override
    protected int getSplashResId() {
        return R.mipmap.bg_splash;
    }

    @Override
    protected Class<? extends BaseActivity> getDescClass() {
        if (SharedPreferencesUtils.getBool(BaseGuideActivity.IS_FIRST_OPEN, true)){
            return GuideActivity.class;
        } else {
            return HomeActivity.class;
        }
    }
}
