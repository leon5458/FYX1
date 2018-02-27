package com.fyx.leon.fyx_leon.ui;

import android.view.Gravity;
import android.widget.TextView;

import com.fyx.leon.fyx_leon.base.BaseActivity;
import com.google.android.flexbox.FlexboxLayout;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/9<p>
 * <p>更改时间：2018/2/9<p>
 * <p>版本号：1<p>
 */
public class TableActivity extends BaseActivity {
    private FlexboxLayout flex;

    @Override
    protected int getLayout() {
        return R.layout.table_layout;
    }

    @Override
    protected void findByid() {
        flex = findViewById(R.id.seller_item_flex);
        flex.removeAllViews();
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void getData() {
        /**
         * 这里模拟了数据,后期搜获的标签需要请求后台添加
         */
        String arr[] = new String[]{"java","c#","php","c++","android","phython"};
        for (int i = 0; i < arr.length; i++) {
            TextView textView = new TextView(this);
            textView.setBackgroundResource(R.drawable.text_circle_gray2);
            textView.setText(arr[i]);
            textView.setTextColor(0xffa8c4d7);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(10, 5, 10, 5);
            textView.setTextSize(13);
            FlexboxLayout.LayoutParams params = new FlexboxLayout.LayoutParams(FlexboxLayout.LayoutParams.WRAP_CONTENT, FlexboxLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(20, 10, 0, 0);
            textView.setLayoutParams(params);
            flex.addView(textView);


    }
    }
}
