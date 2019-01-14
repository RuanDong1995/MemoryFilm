package mvvm.com.memoryfilm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import mvvm.com.memoryfilm.model.ImageVO;
import mvvm.com.memoryfilm.model.User;

public class MyViewModel extends ViewModel {

    private static final String TAG = "MyViewModel";

    public OnDataChangedListener onDataChangedListener;

    public MyViewModel(OnDataChangedListener listener) {
        this.onDataChangedListener = listener;
    }

    public void queryImage() {
        if(!BmobUser.isLogin ()){
            onDataChangedListener.onDataChange (new ArrayList<ImageVO> ());
            return;
        }
        BmobQuery<ImageVO> query = new BmobQuery<> ();
        query.order ("-createdAt").addWhereEqualTo ("user",BmobUser.getCurrentUser (User.class)).include ("user")
                .findObjects (new FindListener<ImageVO> () {
                    @Override
                    public void done(List<ImageVO> list, BmobException e) {
                        if(e == null) {
                            onDataChangedListener.onDataChange (list);
                            Log.d (TAG, "查询结束: 查询到数据"+list.size ()+"条");
                        } else {
                            e.printStackTrace ();
                        }
                    }
                });
    }

    public interface OnDataChangedListener {
        void onDataChange(List<ImageVO> list);
    }

    public SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener () {
        @Override
        public void onRefresh() {
            queryImage ();
        }
    };


}
