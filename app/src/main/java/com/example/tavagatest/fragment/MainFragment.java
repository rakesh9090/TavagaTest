package com.example.tavagatest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tavagatest.MainActivity;
import com.example.tavagatest.R;
import com.example.tavagatest.adapter.ImageRecAdapter;
import com.example.tavagatest.api.RetrofitClient;
import com.example.tavagatest.pojo.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private RecyclerView rec;

    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
        getActivity().setTitle("Tavaga");
        rec = view.findViewById(R.id.rec_view);

        getPhotos();

        return view;
    }

    private void getPhotos() {
        Call<List<Photo>> call = RetrofitClient.getInstance().getApi().getPhoto();

        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.body() != null){
                    int numberOfColumns = 2;
                    rec.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
                    ImageRecAdapter imageRecAdapter = new ImageRecAdapter(getContext(), response.body());
                    rec.setAdapter(imageRecAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.show_fav) {
            Fragment showFav = new FavFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame,
                    showFav).addToBackStack(null).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
