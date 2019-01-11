package mvvm.com.memoryfilm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;

import java.util.List;

import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.view.fragment.HomeFragment;
import mvvm.com.memoryfilm.view.fragment.StudioFragment;
import mvvm.com.memoryfilm.view.fragment.UserFragment;


/*******************************************************************
 * MainViewModel.java  2019/1/10
 * <P>
 * <br/>
 * <br/>
 * </p>
 * Copyright2016 by GNNT Company. All Rights Reserved.
 *
 * @author:Ruandong
 ******************************************************************/
public class MainViewModel extends ViewModel {


    private FragmentActivity activity;
    private FragmentManager mFragmentManager;
    private HomeFragment homeFragment = HomeFragment.newInstance ();
    private StudioFragment studioFragment = StudioFragment.newInstance ();
    private UserFragment userFragment = UserFragment.newInstance ();

    public MainViewModel(Context context) {
        this.activity = (FragmentActivity) context;
        mFragmentManager = activity.getSupportFragmentManager ();
    }

    public RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener () {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId) {
                case R.id.rb_home:
                    showFragment (homeFragment, "home");
                    break;
                case R.id.rb_studio:
                    showFragment (studioFragment, "studio");
                    break;
                case R.id.rb_user:
                    showFragment (userFragment, "user");
                    break;
                default:
                    break;
            }

        }

        private void showFragment(Fragment fragment, String tag) {
            List<Fragment> fragments = mFragmentManager.getFragments ();
            if(mFragmentManager == null){
                return;
            }
            for (Fragment f : fragments) {
                mFragmentManager.beginTransaction ().hide (f).commitAllowingStateLoss ();
            }
            if(!fragments.contains (fragment)) {
                mFragmentManager.beginTransaction ().add (R.id.fl_main, fragment, tag).commit ();
            }
            mFragmentManager.beginTransaction ().show (fragment).commit ();
        }
    };



}
