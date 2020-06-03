package com.example.tavagatest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tavagatest.R;
import com.example.tavagatest.pojo.Photo;

public class InfoFragment extends Fragment {
    private View view;
    private Photo photo;

    public InfoFragment(Photo photo) {
        this.photo = photo;
    }

    public InfoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_image, container, false);
        setHasOptionsMenu(true);

        TextView title =  view.findViewById(R.id.image_title);
        TextView imageText = view.findViewById(R.id.image_txt);

        title.setText(photo.getId());
        imageText.setText(photo.getTitle());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}
