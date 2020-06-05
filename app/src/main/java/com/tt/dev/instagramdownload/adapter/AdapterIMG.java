package com.tt.dev.instagramdownload.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.tt.dev.instagramdownload.R;
import com.tt.dev.instagramdownload.model.FileInstagram;

import java.io.File;
import java.util.List;


public class AdapterIMG extends RecyclerView.Adapter<AdapterIMG.ViewIMG> {

    private List<FileInstagram> fileInstagramList;
    private Context context;

    public void delete(int index) {
        notifyItemRemoved(index);
        notifyItemRangeChanged(index, fileInstagramList.size());
    }

    public AdapterIMG(List<FileInstagram> fileInstagramList, Context context) {
        this.fileInstagramList = fileInstagramList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewIMG onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewIMG(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detais_ing, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewIMG holder, int position) {
        Log.e("P", position + "");
        try {
            Glide.with(context)
                    .asBitmap()
                    .load(Uri.fromFile(new File(fileInstagramList.get(position).getPath()))).listener(new RequestListener<Bitmap>() {
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
    }

    @Override
    public int getItemCount() {
        return fileInstagramList.size();
    }

    public class ViewIMG extends RecyclerView.ViewHolder {


        ImageView img;
        VideoView videoView;

        public ViewIMG(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            videoView = itemView.findViewById(R.id.video);
        }
    }
}
