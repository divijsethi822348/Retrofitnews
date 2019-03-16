package com.example.retrofitnews;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClass {

    public static String BaseAdress="https://newsapi.org/v2/";
    public static Retrofit retrofit=null;
    public static Retrofit api(){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BaseAdress).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
