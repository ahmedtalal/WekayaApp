package com.health.WekayaApp.RetrofitOperation.Builders;

import com.health.WekayaApp.Models.RetrofilModels.ListOfArticles;
import com.health.WekayaApp.RetrofitOperation.Interfaces.NewsApiInterface;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsBuilder {
    private static final String BASE_URL = "http://newsapi.org/" ;

    public static Call<ListOfArticles> generateCallback(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;

        NewsApiInterface newsApiInterface = retrofit.create(NewsApiInterface.class) ;
        return newsApiInterface.getHealthyNews();
    }
}
