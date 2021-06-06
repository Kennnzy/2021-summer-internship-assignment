package com.example.imagegallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.imagegallery.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

public class PictureFragment extends Fragment {

    private String url;

    private ImageView imageView, back;

    public PictureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picture, container, false);

        // Initialize views
        imageView = view.findViewById(R.id.image_view);
        back = view.findViewById(R.id.back_button);

        // Get argument
        url = getArguments().getString("url");

        // Load image
        if (url != null) {
            Glide.with(getContext()).load(url).fitCenter().into(imageView);
        }

        // Set back button functionality
        back.setOnClickListener(v -> {
            Fragment selectedFragment = new GalleryFragment();
            ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_holder, selectedFragment)
                    .commit();
        });

        return view;
    }
}