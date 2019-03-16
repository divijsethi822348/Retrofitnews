package com.example.retrofitnews;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("top-headlines?country=in&apiKey=b4f0614a42bc491498fa9fc73943a173")
    Call<NewsModel> getData();
}
