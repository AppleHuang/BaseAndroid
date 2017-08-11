package com.haodai.topadvisor.ui.fragment;

import android.view.View;
import android.widget.BaseAdapter;

import com.haodai.topadvisor.bean.ArticleBean;
import com.haodai.topadvisor.ui.adapter.ArticleAdapter;
import com.ht.netlib.RequestManager;
import com.ht.netlib.callback.JsonCallback;
import com.ht.uilib.base.BaseRefreshListViewFragment;

import java.util.List;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/3/16 14:45
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class ArticleNoTitleFragment extends BaseRefreshListViewFragment<ArticleBean> {
    private int mLoadTime;
    private boolean mHasMoreData = true;

    @Override
    protected View getHeaderView() {
        return null;
    }

    @Override
    protected void initChildDataFromCache() {

    }

    @Override
    protected boolean isShowTitleBarView() {
        return false;
    }

    @Override
    protected BaseAdapter getAdapter() {
        return new ArticleAdapter(mContext, mDataList);
    }

    @Override
    protected void loadData() {
        mLoadTime = 0;
        mHasMoreData = true;
        loadListformNet(mLoadTime);
    }

    private void loadListformNet(final int loadTime) {
        RequestManager
                .get()
                .url("https://www.yodedu.com/api/listApiArticle")
                .addParams("id", "5")
                .addParams("loadTime", loadTime)
                .build()
                .execute(new JsonCallback<List<ArticleBean>>() {

                    @Override
                    public void onSuccess(List<ArticleBean> articleBeenList) {
                        if (loadTime == 0){
                            if (articleBeenList.size()>0){
                                mDataList.clear();
                                mDataList.addAll(articleBeenList);
                                onRefreshCompleteSuccess();
                            } else {
                                onRefreshCompleteEmpty();
                            }
                        }else {
                            if (articleBeenList.size()>0){
                                mDataList.addAll(articleBeenList);
                            } else {
                                mHasMoreData = false;
                            }
                        }
                    }

                    @Override
                    public void onFinishMainThread(boolean isSuccess) {
                        if (loadTime == 0){
                            if (!isSuccess){
                                onRefreshCompleteError();
                            }
                        } else {
                            onLoadMoreComplete();
                        }
                    }
                });
    }

    @Override
    protected void onLoadMore() {
        mLoadTime++;
        loadListformNet(mLoadTime);
    }

    @Override
    protected boolean hasMoreData() {
        return mHasMoreData;
    }
}
