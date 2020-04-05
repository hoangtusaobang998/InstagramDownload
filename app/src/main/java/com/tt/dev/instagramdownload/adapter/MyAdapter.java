package com.tt.dev.instagramdownload.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.makeramen.roundedimageview.RoundedImageView;
import com.tt.dev.instagramdownload.R;
import com.tt.dev.instagramdownload.model.FileInstagram;

import java.io.File;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<FileInstagram> fileInstagramList;

    public List<FileInstagram> getFileInstagramList() {
        return fileInstagramList;
    }

    private Context context;

    public void setFileInstagram(FileInstagram fileInstagram) {
        if (fileInstagramList.isEmpty()) {
            fileInstagramList.add(0, fileInstagram);
        } else {
            fileInstagramList.add(1, fileInstagram);
        }
        notifyDataSetChanged();
    }

    private int wid;

    public MyAdapter(List<FileInstagram> fileInstagramList, Context context, int wid) {
        this.fileInstagramList = fileInstagramList;
        this.context = context;
        this.wid = wid;
    }

    private ClickItem clickItem;

    public void setClickItem(ClickItem clickItem) {
        this.clickItem = clickItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RelativeLayout relativeLayout = holder.layout.findViewById(R.id.layout);
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.width = wid / 2 - 12;
        layoutParams.height = (int) (wid / 1.5);
        holder.itemView.setLayoutParams(layoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
        marginLayoutParams.setMargins(5, 5, 5, 5);

        if (position == 0) {
            holder.img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Glide.with(context).load(R.drawable.in_copy).into(holder.img);
        } else {
            FileInstagram fileInstagram = fileInstagramList.get(position);
            try {
                Glide.with(context)
                        .asBitmap()
                        .load(Uri.fromFile(new File(fileInstagram.getPath()))).listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                }).into(holder.img);
            } catch (Exception e) {
                Log.e("NullPoin", e.toString());
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position != 0) {
                        clickItem.clickItem(fileInstagramList, position);
                    }

                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return fileInstagramList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout layout;
        private ImageView img;
        private ProgressBar spinKit;
        private RelativeLayout video;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = (RelativeLayout) itemView.findViewById(R.id.layout);
            img = (ImageView) itemView.findViewById(R.id.img);
            spinKit = (ProgressBar) itemView.findViewById(R.id.spin_kit);
            video = (RelativeLayout) itemView.findViewById(R.id.video);
        }
    }


    public interface ClickItem {
        void clickItem(List<FileInstagram> fileInstagrams, int index);
    }
}
