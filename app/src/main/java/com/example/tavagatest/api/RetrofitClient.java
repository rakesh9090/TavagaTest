package com.example.tavagatest.api;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

private static final String BASE_URL = "https://jsonplaceholder.typicode.com/ ";
private static RetrofitClient mInstance = null;
private final Retrofit retrofit;


private RetrofitClient() {

    OkHttpClient.Builder okhttpclintBuilder = new OkHttpClient.Builder();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    okhttpclintBuilder.addInterceptor(logging);


    retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpclintBuilder.build())
            .build();
}


    public static synchronized RetrofitClient getInstance() {
    if (mInstance == null) {
        mInstance = new RetrofitClient();
    }
    return mInstance;
}

public APIServices getApi(){
    return retrofit.create(APIServices.class);
}
}
