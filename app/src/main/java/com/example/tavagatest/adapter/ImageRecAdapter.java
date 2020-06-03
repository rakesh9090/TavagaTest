package com.example.tavagatest.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tavagatest.R;
import com.example.tavagatest.fragment.FavFragment;
import com.example.tavagatest.fragment.ViewImageFragment;
import com.example.tavagatest.pojo.Photo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageRecAdapter extends RecyclerView.Adapter<ImageRecAdapter.viewHolder>  {

    private static List<Photo> photoList;
    private Context context;


    public ImageRecAdapter(Context cxt, List<Photo> photosList) {
       photoList = photosList;
       context = cxt;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_rec_view, viewGroup, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {

        holder.txt.setText(photoList.get(position).getTitle());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int g = holder.getLayoutPosition();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment showFav = new ViewImageFragment(photoList.get(g));
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame,
                        showFav).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return photoList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public static class viewHolder extends RecyclerView.ViewHolder{
        final TextView txt;
        final ConstraintLayout layout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            txt = itemView.findViewById(R.id.textDisp);
            layout = itemView.findViewById(R.id.image_layout);
        }
    }
}
