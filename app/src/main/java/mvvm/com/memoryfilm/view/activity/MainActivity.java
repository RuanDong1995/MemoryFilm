package mvvm.com.memoryfilm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import cn.bmob.v3.Bmob;
import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.adapter.HomeTabAdapter;
import mvvm.com.memoryfilm.databinding.ActivityMainBinding;
import mvvm.com.memoryfilm.view.fragment.HomeFragment;
import mvvm.com.memoryfilm.viewmodel.MainViewModel;

/*******************************************************************
 * MainActivity.java  2019/1/10
 * <P>
 * <br/>
 * <br/>
 * </p>
 * Copyright2016 by GNNT Company. All Rights Reserved.
 *
 * @author:Ruandong
 ******************************************************************/
public class MainActivity extends BaseActivity {

    private ActivityMainBinding mDataBinding;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        //初始化后端云
        Bmob.initialize (this, "68c7f391ee648bc942c93d06420e40a1");
        initView ();
    }

    @Override
    public void initView() {
        mDataBinding = DataBindingUtil.setContentView (this, R.layout.activity_main);
        mMainViewModel = new MainViewModel (getSupportFragmentManager ());
        mDataBinding.setMainViewModel (mMainViewModel);
        mMainViewModel.showFragment (HomeFragment.newInstance (),"home");
        initBottom ();
    }

    private void initBottom() {
        mDataBinding.rgMainBottom.check (R.id.rb_studio);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        mMainViewModel.logout();
    }
}
