package mvvm.com.memoryfilm.view.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.adapter.MyImageAdapter;
import mvvm.com.memoryfilm.databinding.MyFragmentBinding;
import mvvm.com.memoryfilm.model.ImageVO;
import mvvm.com.memoryfilm.viewmodel.MyViewModel;

public class MyFragment extends Fragment implements MyViewModel.OnDataChangedListener {

    private MyViewModel mViewModel;
    private MyFragmentBinding mBinding;

    public static MyFragment newInstance() {
        return new MyFragment ();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate (inflater, R.layout.my_fragment, container, false);
        return mBinding.getRoot ();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = new MyViewModel (this);
        mBinding.setMyViewModel (mViewModel);
        // TODO: Use the ViewModel
    }

    @Override
    public void onStart() {
        super.onStart ();
        mViewModel.queryImage ();
    }

    @Override
    public void onDataChange(List<ImageVO> list) {
        MyImageAdapter adapter = new MyImageAdapter (getActivity (),list);
        mBinding.rvMyFragment.setAdapter (adapter);
        mBinding.rvMyFragment.setLayoutManager (new LinearLayoutManager (getActivity ()));
    }
}
