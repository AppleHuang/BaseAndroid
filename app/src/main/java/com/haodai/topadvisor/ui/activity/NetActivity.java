package com.haodai.topadvisor.ui.activity;

import android.app.ProgressDialog;
import android.os.Environment;
import android.view.View;

import com.haodai.topadvisor.bean.User;
import com.ht.baselib.utils.LogUtils;
import com.ht.baselib.utils.UIUtils;
import com.ht.demo.R;
import com.ht.netlib.RequestManager;
import com.ht.netlib.callback.FileCallback;
import com.ht.netlib.callback.JsonCallback;
import com.ht.netlib.callback.JsonPackageCallback;
import com.ht.netlib.callback.StringCallback;
import com.ht.netlib.progress.ProgressResponseBody;
import com.ht.uilib.base.BaseActivity;

import java.io.File;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/4/11 15:24
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class NetActivity extends BaseActivity {

    private ProgressDialog mUpdateDialog;

    @Override
    protected boolean isStaticPage() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        mTitleBarView.setTitleText("访问网络示例");
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initChildView() {

    }

    @Override
    protected void initChildData() {

    }

    @Override
    protected void setChildViewListener() {
        findViewById(R.id.get).setOnClickListener(this);
        findViewById(R.id.post).setOnClickListener(this);

        findViewById(R.id.postJson).setOnClickListener(this);

        findViewById(R.id.formAndFile).setOnClickListener(this);
        findViewById(R.id.formAndFiles).setOnClickListener(this);
        findViewById(R.id.formAndFileList).setOnClickListener(this);

        findViewById(R.id.download).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.get:
                get();
                break;
            case R.id.post:
                post();
                break;

            case R.id.postJson:
                postJson();
                break;
            case R.id.formAndFile:
                formAndFile();
                break;
            case R.id.formAndFiles:
                formAndFiles();
                break;
            case R.id.formAndFileList:
                formAndFileList();
                break;

            case R.id.download:
                download();
                break;
        }
    }

    private void download() {
        mUpdateDialog = new ProgressDialog(this);
        mUpdateDialog.setTitle("下载最新安装包");
        mUpdateDialog.setMessage("正在下载，请稍后...");
        mUpdateDialog.setMax(100);
        mUpdateDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mUpdateDialog.show();

        String imgUrl = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1598552568,4236159349&fm=58";
        RequestManager
                .download(new ProgressResponseBody.OnProgressListener(){
                    @Override
                    public void update(final long bytesRead, final long contentLength, boolean done) {
                        UIUtils.runOnMainThread(new Runnable() {
                            @Override
                            public void run() {
                                int progress = (int) (1.0 * bytesRead * 100 / contentLength);
                                mUpdateDialog.setProgress(progress);
                            }
                        });
                    }
                })
                .url(imgUrl)
                .build()
                .execute(new FileCallback(Environment.getExternalStorageDirectory().getAbsolutePath(), "ht/okhttp/a.png") {

                    @Override
                    public void onSuccess(File file) {

                    }

                    @Override
                    public void onFinishMainThread(boolean isSuccess) {
                        mUpdateDialog.dismiss();
                    }
                });
    }

    private void formAndFileList() {
        File file1 = new File(Environment.getExternalStorageDirectory(), "ht/jkm/photo/fileA.jpg");
        File file2 = new File(Environment.getExternalStorageDirectory(), "ht/jkm/photo/fileB.jpg");
        RequestManager
                .post()//
                .url("http://192.168.1.168:8888/net/formAndFileList")
                .addParams("name", "黄涛啦啦啦")
                .addParams("password", "123456")
                .addParams("age", 25)
                .addFiles("logos", file1, file2)
                .build()
                .execute(new JsonCallback<User>() {
                    @Override
                    public void onSuccess(User user) {

                    }
                });
    }

    private void formAndFiles() {
        File file1 = new File(Environment.getExternalStorageDirectory(), "ht/jkm/photo/fileA.jpg");
        File file2 = new File(Environment.getExternalStorageDirectory(), "ht/jkm/photo/fileB.jpg");
        RequestManager
                .post()//
                .url("http://192.168.1.168:8888/net/formAndFiles")
                .addParams("name", "黄涛啦啦啦")
                .addParams("password", "123456")
                .addParams("age", 25)
                .addFile("logo", file1)
                .addFile("logo1", file2)
                .build()
                .execute(new JsonCallback<User>() {
                    @Override
                    public void onSuccess(User user) {

                    }
                });
    }

    private void formAndFile() {
        File file1 = new File(Environment.getExternalStorageDirectory(), "ht/jkm/photo/fileB.jpg");
        RequestManager
                .post()//
                .url("http://192.168.1.168:8081/requestInfo.action")
                .addParams("name", "黄涛")
                .addParams("password", "123456")
                .addParams("age", 25)
                .addFile("logo", file1)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String string) {
                        LogUtils.error(string+"    ===");
                    }
                });
    }

    private void postJson() {
        User user = new User();
        user.name = "黄涛啦啦啦";
        user.password = "123456";
        RequestManager
                .postJson()//
                .url("http://192.168.1.168:8888/net/json")
                .content(user)//
                .build()
                .execute(new JsonCallback<User>() {
                    @Override
                    public void onSuccess(User user) {

                    }
                });
    }

    private void post() {
        RequestManager
                .post()//
                .url("http://192.168.1.168:8888/net/post")
                .addParams("name", "黄涛啦啦啦")
                .addParams("password", "123456")
                .addParams("age", 25)
                .build()
                .execute(new JsonPackageCallback<User>() {
                    @Override
                    public void onSuccess(User user) {
                        LogUtils.error("onSuccess "+user);
                    }
                });
    }

    private void get() {
        RequestManager//
                .get()//
                .url("http://192.168.1.168:8888/net/get")//
                .addParams("name", "ht")//
                .addParams("password", "root")//
                .addHeader("token", "8008208820")//
                .build()//
                .execute(new JsonCallback<User>() {
                    @Override
                    public void onSuccess(User user) {

                    }
                });
    }
}
