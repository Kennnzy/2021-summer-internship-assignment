package com.example.imagegallery.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imagegallery.MainActivity;
import com.example.imagegallery.PictureFragment;
import com.example.imagegallery.R;
import com.example.imagegallery.model.ImageModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageAdapterHolder> {

    private List<ImageModel> imageItems;
    Context context;

    public ImageAdapter(List<ImageModel> imageItems, Context context) {
        this.imageItems = imageItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageAdapterHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.image_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapterHolder holder, int position) {
        holder.setImage(imageItems.get(position));
        holder.itemView.setOnClickListener(v -> {
            Fragment selectedFragment = new PictureFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", imageItems.get(position).getImage());
            selectedFragment.setArguments(bundle);
            ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_holder, selectedFragment)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    class ImageAdapterHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ImageAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }

        void setImage(ImageModel imageModel) {
            Glide.with(context).load(imageModel.getImage()).fitCenter().into(imageView);
        }
    }

}
