package mvvm.com.memoryfilm.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import cn.bmob.v3.Bmob;
import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.adapter.MainTabAdapter;
import mvvm.com.memoryfilm.databinding.ActivityMainBinding;
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

    private MainTabAdapter mMainAdapter;
    private ActivityMainBinding mDataBinding;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        Bmob.initialize (this, "68c7f391ee648bc942c93d06420e40a1");
        mDataBinding = DataBindingUtil.setContentView (this, R.layout.activity_main);
        mMainViewModel = new MainViewModel (this);
        mDataBinding.setMainViewModel (mMainViewModel);
        mMainAdapter = new MainTabAdapter (getSupportFragmentManager ());
        mDataBinding.viewPagerMain.setAdapter (mMainAdapter);
        mDataBinding.tabLayoutMain.setupWithViewPager (mDataBinding.viewPagerMain);

    }
}
