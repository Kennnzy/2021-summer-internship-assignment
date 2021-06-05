package com.example.imagegallery;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imagegallery.adapter.ImageAdapter;
import com.example.imagegallery.model.ImageModel;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        RecyclerView imageRecyclerView = view.findViewById(R.id.imageRecyclerView);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        imageRecyclerView.setLayoutManager(
                layoutManager
        );

        ArrayList<ImageModel> list = new ArrayList<>();
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image1.jpg?alt=media&token=0c2e0401-b043-408c-b3d7-e7b22812bebb"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image2.jpg?alt=media&token=1a78bad5-5ce4-4d4e-8eaa-7739e3ce452b"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image3.jpg?alt=media&token=8c0e3639-5be4-4888-bcb8-7406387a5f5b"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image4.jpg?alt=media&token=f0c44489-f9a7-44f6-b92d-94128e4d7421"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image5.jpg?alt=media&token=64184eec-4489-4dd1-9ac9-926e9e46ca7f"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image6.jpg?alt=media&token=05078327-63d1-4b18-8163-15507d2e6710"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image7.jpg?alt=media&token=1e01acca-cf0f-4931-b83d-4dfd1e81cf05"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image8.jpg?alt=media&token=e69578e6-84c7-460c-a16f-469eddc89d54"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image9.jpg?alt=media&token=a5bb72b1-ec4d-4f00-ae97-019ab7ed9953"));
        list.add(new ImageModel("https://firebasestorage.googleapis.com/v0/b/image-gallery-internship.appspot.com/o/image10.jpg?alt=media&token=ae3bf809-ab25-4ba0-af31-35890586d1d2"));

        imageRecyclerView.setAdapter(new ImageAdapter(list, getContext()));

        return view;
    }
}