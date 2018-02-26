package com.fyx.leon.fyx_leon.ui;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;
import com.fyx.leon.fyx_leon.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/7<p>
 * <p>更改时间：2018/2/7<p>
 * <p>版本号：1<p>
 */
public class ProgressBarActivity extends BaseActivity {



  @OnClick({R.id.btn,R.id.btn2})
  public void OnClick(View v){
      switch(v.getId()){
          case R.id.btn:
            Intent intent = new Intent(this,VerticalProgressBarActivity.class);
              startActivity(intent);
              break;
          case R.id.btn2:
              Intent intent2 = new Intent(this,VerticalProBarTwoActivity.class);
              startActivity(intent2);
              break;
      }

  }

    @Override
    protected int getLayout() {
        return R.layout.progressbar_layout;
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
        showSetpView0();
        showSetpView1();
    }

    private void showSetpView1() {
        HorizontalStepView setpview = findViewById(R.id.step_view1);
        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("待入库",1);
        StepBean stepBean1 = new StepBean("作业中",1);
        StepBean stepBean2 = new StepBean("洗车等待",0);
        StepBean stepBean3 = new StepBean("洗车中",1);
        StepBean stepBean4 = new StepBean("轿车准备",1);
        StepBean stepBean5 = new StepBean("可交车",1);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);
        stepsBeanList.add(stepBean4);
        stepsBeanList.add(stepBean5);
        setpview.setStepViewTexts(stepsBeanList)
                .setTextSize(13)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.drawable.complted))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.drawable.attention));//设置StepsViewIndicator AttentionIcon

    }

    private void showSetpView0() {
        HorizontalStepView setpview = findViewById(R.id.step_view0);
        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("选车选点",1);
        StepBean stepBean1 = new StepBean("预约的项目",1);
        StepBean stepBean2 = new StepBean("到店时间",0);
        StepBean stepBean3 = new StepBean("确认",1);
        StepBean stepBean4 = new StepBean("提交",1);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);
        stepsBeanList.add(stepBean4);
        setpview.setStepViewTexts(stepsBeanList)
                .setTextSize(13)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(this, android.R.color.white))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.uncompleted_text_color))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.drawable.complted))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.drawable.attention));//设置StepsViewIndicator AttentionIcon
    }
}
