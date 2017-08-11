package com.haodai.topadvisor.ui.activity;

import android.webkit.WebView;

import com.ht.baselib.application.HTApplication;
import com.ht.baselib.utils.DeviceUtils;
import com.ht.baselib.utils.LogUtils;
import com.ht.baselib.utils.UIUtils;
import com.ht.jsbridgelib.BridgeHandler;
import com.ht.jsbridgelib.CallBackFunction;
import com.ht.jsbridgelib.CustomerWebViewClient;
import com.ht.uilib.base.BaseWebViewActivity;

/**
 * Created by huangtao on 16/10/19.
 */
public class WebViewActivity extends BaseWebViewActivity {

    @Override
    protected CustomerWebViewClient getWebViewClient() {
        return new CustomerWebViewClient(){
            @Override
            public void shouldOverrideUrlLoadingInner(WebView view, String url) {
                LogUtils.error(url);
            }
        };
    }

    @Override
    protected void registerJsFun() {
        registerHandler("getVersionName",new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                function.onCallBack(DeviceUtils.getAppVersionName());
            }
        });

        registerHandler("getVersionCode",new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                function.onCallBack(DeviceUtils.getAppVersionCode()+"");
            }
        });

        registerHandler("isDebugMode",new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                function.onCallBack(HTApplication.IS_DEBUG_MODE ? "0" : "1");
            }
        });

        registerHandler("JavaFunction",new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                function.onCallBack("这条信息来自于java星球"+ UIUtils.isRunInMainThread());
            }
        });
    }


}