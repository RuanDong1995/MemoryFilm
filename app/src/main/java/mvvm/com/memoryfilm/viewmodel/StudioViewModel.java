package mvvm.com.memoryfilm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import mvvm.com.memoryfilm.model.ImageVO;
import mvvm.com.memoryfilm.model.User;

public class StudioViewModel extends ViewModel {

    private static final String TAG = "StudioViewModel";

    public String title;
    public String name;
    public String info;

    public TextWatcher titleChangeWatcher = new TextWatcher () {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            title = s.toString ();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public TextWatcher nameChangeWatcher = new TextWatcher () {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            name = s.toString ();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public TextWatcher infoChangeWatcher = new TextWatcher () {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            info = s.toString ();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    public void onCommitClick(View view) {
        ImageVO imageVO = new ImageVO ();
        imageVO.setTitle (title);
        imageVO.setUserName (name);
        imageVO.setInfo (info);
        imageVO.setUser (BmobUser.getCurrentUser (User.class));
        imageVO.save (new SaveListener<String> () {
            @Override
            public void done(String s, BmobException e) {
                if(e == null) {
                    Log.d (TAG, "done: 上传成功");
                } else {
                    Log.d (TAG, "done: 上传失败" + e.toString ());
                    e.printStackTrace ();
                }
            }
        });
    }
}
