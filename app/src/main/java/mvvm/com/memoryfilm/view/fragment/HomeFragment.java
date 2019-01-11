package mvvm.com.memoryfilm.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.adapter.HomeTabAdapter;
import mvvm.com.memoryfilm.databinding.HomeFragmentBinding;
import mvvm.com.memoryfilm.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private HomeFragmentBinding mBinding;
    private HomeTabAdapter mAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment ();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate (inflater,R.layout.home_fragment,container,false);
        return mBinding.getRoot ();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = new HomeViewModel ();
    }

    @Override
    public void onStart() {
        super.onStart ();
        mAdapter = new HomeTabAdapter (getFragmentManager ());
        mBinding.viewPagerHome.setAdapter (mAdapter);
        mBinding.tabLayoutHome.setupWithViewPager (mBinding.viewPagerHome);
        for (int i = 0; i < mBinding.tabLayoutHome.getTabCount (); i++) {
            mBinding.tabLayoutHome.getTabAt (i).setText (String.valueOf (i));
        }
    }
}
