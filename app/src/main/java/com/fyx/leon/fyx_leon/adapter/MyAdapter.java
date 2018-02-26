package com.fyx.leon.fyx_leon.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/6<p>
 * <p>更改时间：2018/2/6<p>
 * <p>版本号：1<p>
 */
public class MyAdapter<T> extends BaseQuickAdapter<T,BaseViewHolder> {

    public MyAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public MyAdapter(@Nullable List<T> data) {
        super(data);
    }

    public MyAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }
    OnCallBackData onCallBackData;
    @Override
    protected void convert(BaseViewHolder helper, T item) {
        if (onCallBackData != null) {
            onCallBackData.convertView(helper, item);
        }
    }

    public void setOnCallBackData(OnCallBackData onCallBackData) {
        this.onCallBackData = onCallBackData;
    }

    public interface OnCallBackData<T> {
        public abstract void convertView(BaseViewHolder helper, T item);
    }
}
