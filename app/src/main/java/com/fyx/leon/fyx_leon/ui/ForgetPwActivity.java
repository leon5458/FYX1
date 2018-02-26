package com.fyx.leon.fyx_leon.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyx.leon.fyx_leon.base.BaseActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * <p>文件描述：<p>
 * <p>作者：leon<p>
 * <p>创建时间：2018/2/23<p>
 * <p>更改时间：2018/2/23<p>
 * <p>版本号：1<p>
 */
public class ForgetPwActivity extends BaseActivity {

    @BindView(R.id.input_phone)
    EditText InputPhone;
    @BindView(R.id.cancel_input)
    ImageView CancelImage;
    @BindView(R.id.vertical_code)
    TextView Code;


    @OnClick({R.id.vertical_code,R.id.cancel_input})
    public void OnClick(View v){
        switch(v.getId()){
            case R.id.cancel_input:
                InputPhone.setText("");
                break;
            case R.id.vertical_code:
                VerticalCode();
        }
    }
    long TIME = 60;
    Subscription s;
    public void VerticalCode() {
        Flowable.interval(0, 1, TimeUnit.SECONDS)
                .take(TIME - 1)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return TIME - aLong;
                    }
                })
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return aLong + "s";
                    }
                }).doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Code.setClickable(false);

            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        ForgetPwActivity.this.s = s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(String string) {
                        Code.setText(string);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        Code.setClickable(true);
                        Code.setText("获取验证码");
                    }
                });
    }

    @Override
    protected int getLayout() {
        return R.layout.forget_pw_layout;
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
        initTitleBar(R.mipmap.jifen, "重置密码", 0, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        }, null);


        if (InputPhone.equals("请输入手机号")){
            CancelImage.setVisibility(View.GONE);
        }else{
            CancelImage.setVisibility(View.VISIBLE);
        }

    }


}
