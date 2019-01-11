package mvvm.com.memoryfilm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import cn.bmob.v3.BmobUser;
import mvvm.com.memoryfilm.model.User;
import mvvm.com.memoryfilm.view.activity.LoginActivity;

public class UserViewModel extends ViewModel {

    private static final String TAG = "UserViewModel";
    private Context context;
    public ObservableInt loginVisible = new ObservableInt (View.GONE);
    public ObservableInt logoutVisible = new ObservableInt (View.GONE);
    private User user;
    public ObservableField<String> loginInfo = new ObservableField<> ();

    public UserViewModel(Context context) {
        this.context = context;
        checkLogin ();
    }

    public void gotoLogin(View view){
        Log.d (TAG, "gotoLogin: gotoLogin");
        context.startActivity (new Intent (context,LoginActivity.class));
    }

    public void checkLogin() {
        Boolean isLogin = BmobUser.isLogin ();
        if(isLogin) {
            user = BmobUser.getCurrentUser (User.class);
            loginInfo.set ("当前登录名:" + user.getUsername ());
            loginVisible.set (View.GONE);
            logoutVisible.set (View.VISIBLE);
        }else {
            loginInfo.set ("当前未登录!");
            loginVisible.set (View.VISIBLE);
            logoutVisible.set (View.GONE);
        }
    }

    public void logout(View view) {
        BmobUser.logOut ();
        checkLogin ();
    }

}
