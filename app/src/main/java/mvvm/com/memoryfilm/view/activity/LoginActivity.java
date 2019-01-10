package mvvm.com.memoryfilm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.databinding.ActivityLoginBinding;
import mvvm.com.memoryfilm.viewmodel.LoginViewModel;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView (this, R.layout.activity_login);
        LoginViewModel loginViewModel = new LoginViewModel ();
        binding.setLoginViewModel (loginViewModel);
    }


}
