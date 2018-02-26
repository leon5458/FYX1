package com.fyx.leon.fyx_leon.ui;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.fyx.leon.fyx_leon.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class FyxLoginActivity extends BaseActivity {
    @BindView(R.id.cancel_accout)
    ImageView Image_Cancel;
    @BindView(R.id.accout)
    EditText Edit_Accout;
    @BindView(R.id.show_pw)
    ImageView Image_Show;
    @BindView(R.id.pw)
    EditText Edit_Pw;
    @Override
    protected int getLayout() {
        return R.layout.activity_fyx_login;
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
       if(Edit_Accout.equals("请输入账号")){
           Image_Cancel.setVisibility(View.GONE);
       }else{
           Image_Cancel.setVisibility(View.VISIBLE);
       }
       if (Edit_Pw.equals("请输入密码")){
           Image_Show.setVisibility(View.GONE);
           }else{
           Image_Show.setVisibility(View.VISIBLE);
       }
    }
    @OnClick({R.id.show_pw,R.id.cancel_accout,R.id.forget_pw,R.id.fyx_login})
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.show_pw:
                if (Image_Show == null || Edit_Pw ==null){
                    return;
                }
                if (Image_Show.isSelected()){
                    Image_Show.setSelected(false);
                    Edit_Pw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    Edit_Pw.setSelection(Edit_Pw.getText().length());
                }else{
                    Image_Show.setSelected(true);
                    Edit_Pw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    Edit_Pw.setSelection(Edit_Pw.getText().length());
                }
                break;
            case R.id.cancel_accout:
                Edit_Accout.setText("");
                break;
            case R.id.fyx_login:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.forget_pw:
                startActivity(new Intent(this,ForgetPwActivity.class));
                break;
        }
    }
}
