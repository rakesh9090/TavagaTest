package com.example.tavagatest.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tavagatest.R;
import com.example.tavagatest.favDatabase.DatabaseClient;
import com.example.tavagatest.favDatabase.Task;
import com.example.tavagatest.pojo.Photo;

public class ViewImageFragment extends Fragment {

    private Photo photo;

    public ViewImageFragment(Photo photo) {
        this.photo = photo;
    }

    public ViewImageFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_image, container, false);
        setHasOptionsMenu(true);

        TextView txt = view.findViewById(R.id.image_view_txt);
        txt.setText(photo.getTitle());

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.set_fav) {
            setImageAsFav();
            return true;
        }else if (id == R.id.download){
            downloadImage();
            return true;
        }else if (id == R.id.show_info){
            showImfo();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showImfo() {
        Fragment showFav = new InfoFragment(photo);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame,
                showFav).addToBackStack(null).commit();
    }

    private void downloadImage() {
    }

    private void setImageAsFav() {
        @SuppressLint("StaticFieldLeak")
        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                Task task = new Task();
                task.setUserId(photo.getTitle());
                task.setTitle(photo.getTitle());
                task.setComplete(photo.getCompleted());

                DatabaseClient.getInstance(getActivity().getApplicationContext()).getAppDatabase()
                        .taskDao()
                        .insert(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                //getActivity().finish();
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));*/
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }
}
