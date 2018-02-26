package com.fyx.leon.fyx_leon.ui;

import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.widget.TextView;

import com.baoyachi.stepview.VerticalStepView;
import com.fyx.leon.fyx_leon.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/8<p>
 * <p>更改时间：2018/2/8<p>
 * <p>版本号：1<p>
 */
public class VerticalProgressBarActivity extends BaseActivity{
   @BindView(R.id.step_view)
   VerticalStepView mSetpview;

    @Override
    protected int getLayout() {
        return R.layout.vertacalpro_layout;
    }

    @Override
    protected void findByid() {
        ButterKnife.bind(this);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void getData() {
        showSetpView();



    }

    private void showSetpView() {
        List<String> list0 = new ArrayList<>();
        list0.add("下单 \n 实际完成日:2018-1-2");
        list0.add("生产运输 \n 计划完成日:2018-1-29");
        list0.add("资料准备 \n 实际完成日:2017-1-29");
        list0.add("资料审核\n 实际完成日:2018-2-18");
        list0.add("首付款\n 实际完成日:2018-2-18");
        list0.add("买税上牌\n 实际完成日:2018-2-18");
        list0.add("精品\n 实际完成日:2018-2-18");
        list0.add("交车准备\n 实际完成日:2018-2-18");
        list0.add("放款\n 实际完成日:2018-2-18");
        list0.add("交车\n 实际完成日:2018-2-18");
        list0.add("感谢您的购车，欢迎您下次光临！");
        mSetpview.setStepsViewIndicatorComplectingPosition(list0.size() - 2)//设置完成的步数
                .reverseDraw(false)//default is true
                .setTextSize(14)
                .setStepViewTexts(list0)//总步骤
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.drawable.complted))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.drawable.attention));//设置StepsViewIndicator AttentionIcon

    }
}
