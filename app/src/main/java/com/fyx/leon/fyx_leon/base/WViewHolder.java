package com.fyx.leon.fyx_leon.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/6<p>
 * <p>更改时间：2018/2/6<p>
 * <p>版本号：1<p>
 */
public class WViewHolder extends RecyclerView.ViewHolder {
    View convertView;
    Context context;

    public WViewHolder(View itemView, Context context) {
        super(itemView);
        this.convertView = itemView;
        this.context = context;
    }

    public View getItemView() {
        return convertView;
    }

    public void setText(int id, String text) {
        TextView tx = (TextView) convertView.findViewById(id);
        tx.setText(text);
    }

    public void setText(int id, String text, final OnClickListener onClickListener) {
        TextView tx = (TextView) convertView.findViewById(id);
        tx.setText(text);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClickListner(v);
            }
        });
    }

    public void setImageResource(Context context, int id, int resource) {
        ImageView img = (ImageView) convertView.findViewById(id);
        Glide.with(context).load(resource).into(img);
    }

    public void setImageResource(int id, int resouceId, final OnClickListener onClickListener) {
        ImageView img = (ImageView) convertView.findViewById(id);
        img.setImageResource(resouceId);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClickListner(v);
            }
        });
    }

    /*    public void setImageUrl(int id, Context context, String url) {
            ImageView img = (ImageView) convertView.findViewById(id);
            GlideUtils.load(context, url, img);
        }*/
    public View getView(int id) {
        return convertView.findViewById(id);
    }

    public interface OnClickListener {
        void onClickListner(View v);
    }

}
