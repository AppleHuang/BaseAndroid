package com.haodai.topadvisor.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.haodai.topadvisor.ui.holder.RecycleViewViewHolder;
import com.ht.baselib.utils.UIUtils;
import com.ht.demo.R;

import java.util.List;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/5/5 14:06
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewViewHolder> {

    public List<String> mDataList;

    public RecycleViewAdapter(List<String> dataList) {
        this.mDataList = dataList;
    }

    @Override
    public RecycleViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = UIUtils.inflate(R.layout.list_text_item, parent);
        RecycleViewViewHolder recycleViewViewHolder = new RecycleViewViewHolder(inflate);
        return recycleViewViewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewViewHolder holder, int position) {
        holder.mContentView.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
