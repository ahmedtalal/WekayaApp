package com.health.WekayaApp.RetrofitOperation.Interfaces;

import com.health.WekayaApp.Models.RetrofilModels.ListstatsCases;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StatsApiInterface {

    // this method is used to get all statistics from the api
    @GET("summary")
    Call<ListstatsCases> getStatistics();
}
