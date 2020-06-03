package com.example.tavagatest.api;

import com.example.tavagatest.pojo.Photo;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices {
    @GET("todos")
    Call<List<Photo>> getPhoto();
}
