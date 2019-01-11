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
import mvvm.com.memoryfilm.databinding.StudioFragmentBinding;
import mvvm.com.memoryfilm.viewmodel.StudioViewModel;

/*******************************************************************
 * StudioFragment.java  2019/1/11
 * <P>
 * <br/>
 * <br/>
 * </p>
 * Copyright2016 by GNNT Company. All Rights Reserved.
 *
 * @author:Ruandong
 ******************************************************************/
public class StudioFragment extends Fragment {

    private StudioViewModel mViewModel;
    private StudioFragmentBinding mBinding;


    public static StudioFragment newInstance() {
        return new StudioFragment ();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate (inflater, R.layout.studio_fragment, container, false);
        return mBinding.getRoot ();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = new StudioViewModel ();
        mBinding.setStudioViewModel (mViewModel);
        // TODO: Use the ViewModel
    }

}
