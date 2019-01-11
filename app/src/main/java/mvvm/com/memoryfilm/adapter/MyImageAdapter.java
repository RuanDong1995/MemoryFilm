package mvvm.com.memoryfilm.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import mvvm.com.memoryfilm.R;
import mvvm.com.memoryfilm.databinding.ItemMyImageBinding;
import mvvm.com.memoryfilm.model.ImageVO;
import mvvm.com.memoryfilm.viewmodel.ImageItemViewModel;

public class MyImageAdapter extends RecyclerView.Adapter<MyImageAdapter.MyHolder> {

    private List<ImageVO> mDataList;
    private Context mContext;

    public MyImageAdapter(Context context,List<ImageVO> mDataList) {
        mContext = context;
        this.mDataList = mDataList;
    }

    public void setmDataList(List<ImageVO> mDataList) {
        this.mDataList = mDataList;
        notifyDataSetChanged ();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemMyImageBinding imageBinding =
                DataBindingUtil.inflate (LayoutInflater.from (mContext), R.layout.item_my_image, viewGroup, false);
        MyHolder holder = new MyHolder (imageBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        ImageVO imageVO = mDataList.get (i);
        myHolder.bindData (imageVO);

    }

    @Override
    public int getItemCount() {
        return mDataList.isEmpty () ? 0 : mDataList.size ();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        ItemMyImageBinding binding;

        public MyHolder(ItemMyImageBinding binding) {
            super (binding.getRoot ());
            this.binding = binding;
        }

        public void bindData(ImageVO imageVO) {
            if(binding.getImageItemViewModel () == null) {
                binding.setImageItemViewModel (new ImageItemViewModel (imageVO));
            } else {
                binding.getImageItemViewModel ().setImageVO (imageVO);
            }

        }
    }
}
