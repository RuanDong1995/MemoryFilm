package mvvm.com.memoryfilm.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.databinding.UserFragmentBinding;
import mvvm.com.memoryfilm.viewmodel.UserViewModel;

public class UserFragment extends Fragment {

    private UserViewModel mViewModel;
    private UserFragmentBinding mBinding;


    public static UserFragment newInstance() {
        return new UserFragment ();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate (inflater,R.layout.user_fragment,container,false);
        return mBinding.getRoot ();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = new UserViewModel (getActivity ());
        mViewModel.checkLogin (getView ());

    }

}
