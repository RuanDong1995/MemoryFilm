package mvvm.com.memoryfilm.viewmodel;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import mvvm.com.memoryfilm.model.User;

/*******************************************************************
 * LoginViewModel.java  2019/1/10
 * <P>
 * 登录ViewModel<br/>
 * <br/>
 * </p>
 * Copyright2016 by GNNT Company. All Rights Reserved.
 *
 * @author:Ruandong
 ******************************************************************/
public class LoginViewModel extends ViewModel {


    private static final String TAG = "LoginViewModel";
    private User user;
    private String userName;
    private String userPsw;
    private Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public TextWatcher userNameChangeListener = new TextWatcher () {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            userName = s.toString ();
            Log.d (TAG, "onTextChanged: " + s.toString ());
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d (TAG, "afterTextChanged: " + s.toString ());
        }
    };


    public TextWatcher pwdChangeListener = new TextWatcher () {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            userPsw = s.toString ();
            Log.d (TAG, "onTextChanged: " + s.toString ());
        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d (TAG, "afterTextChanged: " + s.toString ());
        }
    };


    /**
     * 账号密码注册
     */
    public void signUp(final View view) {
        if(user == null) {
            user = new User ();
        }
        user.setUsername (userName);
        user.setPassword (userPsw);
        user.signUp (new SaveListener<User> () {
            @Override
            public void done(User user, BmobException e) {
                if(e == null) {
                    Snackbar.make (view, "注册成功", Snackbar.LENGTH_LONG).show ();
                } else {
                    Snackbar.make (view, "尚未失败：" + e.getMessage (), Snackbar.LENGTH_LONG).show ();
                }
            }
        });
    }

    /**
     * 账号密码登录
     */
    public void login(final View view) {
        if(BmobUser.isLogin ()) {
            user = BmobUser.getCurrentUser (User.class);
            Snackbar.make (view, "已经登录：" + user.getUsername (), Snackbar.LENGTH_LONG).show ();
        } else {
            if(user == null) {
                user = new User ();
            }
            user.setUsername (userName);
            user.setPassword (userPsw);
            user.login (new SaveListener<User> () {
                @Override
                public void done(User bmobUser, BmobException e) {
                    if(e == null) {
                        User user = BmobUser.getCurrentUser (User.class);
                        Snackbar.make (view, "登录成功：" + user.getUsername (), Snackbar.LENGTH_LONG).show ();
                        Activity activity = (Activity) context;
                        activity.finish ();
                    } else {
                        Snackbar.make (view, "登录失败：" + e.getMessage (), Snackbar.LENGTH_LONG).show ();
                    }
                }
            });
        }
    }

    public void logout(View view) {
        BmobUser.logOut ();
    }
}
