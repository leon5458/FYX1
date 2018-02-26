package com.fyx.leon.fyx_leon.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyx.leon.fyx_leon.base.WViewHolder;
import com.fyx.leon.fyx_leon.bean.CarServiceBean;
import com.fyx.leon.fyx_leon.bean.Hpbean;
import com.fyx.leon.fyx_leon.ui.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/6<p>
 * <p>更改时间：2018/2/6<p>
 * <p>版本号：1<p>
 */
public class MultiHomeAdapter extends RecyclerView.Adapter<WViewHolder> {
    Context context;
    List<Hpbean> list;

    public MultiHomeAdapter(Context context, List<Hpbean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public WViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        WViewHolder holder = null;
        View v;
        switch (viewType) {
            case 1:
                v = LayoutInflater.from(context).inflate(R.layout.home_item1, parent, false);
                holder = new WViewHolder(v, context);
                break;
            case 2:
                v = LayoutInflater.from(context).inflate(R.layout.home_item2, parent, false);
                holder = new WViewHolder(v, context);
                break;
            case 3:
                v = LayoutInflater.from(context).inflate(R.layout.home_item3, parent, false);
                holder = new WViewHolder(v, context);
                break;
            case 4:
                v = LayoutInflater.from(context).inflate(R.layout.home_item4, parent, false);
                holder = new WViewHolder(v, context);
                break;

        }
        return holder;
    }



    @Override
    public void onBindViewHolder(final WViewHolder holder, int position) {
        if (callBack != null)
            callBack.back(holder, position, getItemViewType(position));
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListner.click(holder.getPosition());
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack {
        void back(RecyclerView.ViewHolder holder, int position, int type);
    }

    OnItemClickListner onItemClickListner;

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public interface OnItemClickListner {
        void click(int position);
    }

}
