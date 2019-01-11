package mvvm.com.memoryfilm.viewmodel;

import android.arch.lifecycle.ViewModel;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import mvvm.com.memoryfilm.model.ImageVO;

public class MyViewModel extends ViewModel {

    public OnDataChangedListener onDataChangedListener;

    public MyViewModel(OnDataChangedListener listener) {
        this.onDataChangedListener = listener;
    }

    public void queryImage() {
        BmobQuery<ImageVO> query = new BmobQuery<> ();
        query.setLimit (8).setSkip (1).order ("-createdAt")
                .findObjects (new FindListener<ImageVO> () {
                    @Override
                    public void done(List<ImageVO> list, BmobException e) {
                        if(e == null) {
                            onDataChangedListener.onDataChange (list);
                        } else {
                            e.printStackTrace ();
                        }
                    }
                });
    }

    public interface OnDataChangedListener {
        void onDataChange(List<ImageVO> list);
    }
}
