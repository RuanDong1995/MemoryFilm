package mvvm.com.memoryfilm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.databinding.ActivityLoginBinding;
import mvvm.com.memoryfilm.viewmodel.LoginViewModel;

/*******************************************************************
 * LoginActivity.java  2019/1/11
 * <P>
 * 登录Activity<br/>
 * <br/>
 * </p>
 * Copyright2016 by GNNT Company. All Rights Reserved.
 *
 * @author:Ruandong
 ******************************************************************/
public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mDataBinding;
    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        initView ();
    }


    @Override
    public void initView() {
        mDataBinding = DataBindingUtil.setContentView (this, R.layout.activity_login);
        mLoginViewModel = new LoginViewModel (this);
        mDataBinding.setLoginViewModel (mLoginViewModel);
    }
}
