package com.example.tavagatest.fragment;

import android.os.Bundle;
import android.util.Log;
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
    private static Photo photo;

    public InfoFragment(Photo photo) {
        InfoFragment.photo = photo;
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
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        setHasOptionsMenu(true);
        getActivity().setTitle("Image Info");

        TextView title =  view.findViewById(R.id.txt_title);
        TextView imageText = view.findViewById(R.id.image_txt);

        title.setText(photo.getTitle());
        imageText.setText(photo.getTitle());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}
