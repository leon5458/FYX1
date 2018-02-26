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
public class VerticalProBarTwoActivity extends BaseActivity{
    @BindView(R.id.step_view2)
    VerticalStepView mSetpview;
    @BindView(R.id.test1)
    TextView test1;

    @BindView(R.id.test2)
    TextView test2;

    @BindView(R.id.test3)
    TextView test3;

    @BindView(R.id.test4)
    TextView test4;

    @BindView(R.id.test5)
    TextView test5;

    @BindView(R.id.test6)
    TextView test6;

    @BindView(R.id.test7)
    TextView test7;

    @BindView(R.id.test8)
    TextView test8;

    @BindView(R.id.test9)
    TextView test9;
    @Override
    protected int getLayout() {
        return R.layout.vertacalpro2_layout;
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
        test1.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/>"+
        "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
        test2.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/> "+
                "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
        test3.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/> "+
                "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
        test4.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/> "+
                "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
        test5.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/> "+
                "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
        test6.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/> "+
                "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
        test7.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/> "+
                "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
        test8.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/> "+
                "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
        test9.setText(Html.fromHtml("\t<strong><font color=\"#FFFFFF\" >下单</font><strong>\n <br/>"+
                "<font color=\"#FF949494\"  size=\"11px\">实际完成日:2018-1-28</font\n "));
    }

    private void showSetpView() {
        List<String> list0 = new ArrayList<>();
        for(int i =0;i<10;i++){
            list0.add("");
        }
        mSetpview.setStepsViewIndicatorComplectingPosition(list0.size() - 1)//设置完成的步数
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
