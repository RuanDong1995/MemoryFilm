package mvvm.com.memoryfilm.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.viewmodel.StudioViewModel;

public class StudioFragment extends Fragment {

    private StudioViewModel mViewModel;

    public static StudioFragment newInstance() {
        return new StudioFragment ();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.studio_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = ViewModelProviders.of (this).get (StudioViewModel.class);
        // TODO: Use the ViewModel
    }

}
