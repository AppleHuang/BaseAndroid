package com.haodai.topadvisor.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ht.demo.R;

/**
 * **************************************************************
 * [好刷刷]
 * **************************************************************
 * Authors: 黄涛 on 17/5/5 14:07
 * QQ：876046815
 * Email:876046815@qq.com
 */
public class RecycleViewViewHolder extends RecyclerView.ViewHolder {
    public TextView mContentView;

    public RecycleViewViewHolder(View itemView) {
        super(itemView);
        mContentView = (TextView) itemView.findViewById(R.id.tv_list_text_item);
    }
}
