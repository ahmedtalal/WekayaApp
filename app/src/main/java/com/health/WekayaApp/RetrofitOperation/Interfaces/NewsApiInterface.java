package com.health.WekayaApp.RetrofitOperation.Interfaces;

import com.health.WekayaApp.Models.RetrofilModels.ListOfArticles;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApiInterface {
    // this method is used to get news data from the server and return items in call form
    @GET("v2/top-headlines?country=eg&category=health&apiKey=5e32da73771b4565b18f8cb9560a45e2")
    public Call<ListOfArticles> getHealthyNews();
}
