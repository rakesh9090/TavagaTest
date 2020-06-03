package com.example.tavagatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.tavagatest.adapter.ImageRecAdapter;
import com.example.tavagatest.api.RetrofitClient;
import com.example.tavagatest.fragment.FavFragment;
import com.example.tavagatest.fragment.MainFragment;
import com.example.tavagatest.pojo.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Tavaga");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame,
                    new MainFragment()).commit();
        }

    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.show_fav) {
            //((ConstraintLayout)findViewById(R.id.rootView)).removeAllViews();
            Fragment showFav = new FavFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame,
                    showFav).addToBackStack(null).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}