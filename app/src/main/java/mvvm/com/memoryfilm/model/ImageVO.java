package mvvm.com.memoryfilm.model;

import cn.bmob.v3.BmobObject;

public class ImageVO extends BmobObject {

    private String userName;
    private String title;
    private String info;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
