package mvvm.com.memoryfilm.viewmodel;

import mvvm.com.memoryfilm.model.ImageVO;

public class ImageItemViewModel {

    private ImageVO imageVO;

    public String title;
    public String name;
    public String info;

    public ImageItemViewModel(ImageVO imageVO){
        this.imageVO = imageVO;
        this.title = imageVO.getTitle ();
        this.name = imageVO.getUserName ();
        this.info = imageVO.getInfo ();
    }

    public void setImageVO(ImageVO imageVO) {
        this.imageVO = imageVO;
    }

    public void loadImage(){

    }
}
