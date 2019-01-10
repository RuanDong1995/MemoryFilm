package mvvm.com.memoryfilm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import cn.bmob.v3.BmobUser;
import mvvm.com.memoryfilm.view.activity.LoginActivity;

public class UserViewModel extends ViewModel {

    private static final String TAG = "UserViewModel";
    private final Context context;
    public ObservableInt loginVisible = new ObservableInt (View.GONE);

    public UserViewModel(Context context) {
        this.context = context;
    }

    public void gotoLogin(View view){
        Log.d (TAG, "gotoLogin: gotoLogin");
        context.startActivity (new Intent (context,LoginActivity.class));
    }

    public void checkLogin(View view){
        if(BmobUser.isLogin ()){
            loginVisible.set (View.INVISIBLE);
        }else {
            loginVisible.set (View.VISIBLE);
        }
    }

}
