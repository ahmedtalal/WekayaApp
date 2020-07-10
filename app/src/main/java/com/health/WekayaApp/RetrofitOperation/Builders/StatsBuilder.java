package com.health.WekayaApp.RetrofitOperation.Builders;

import com.health.WekayaApp.Models.RetrofilModels.ListstatsCases;
import com.health.WekayaApp.RetrofitOperation.Interfaces.StatsApiInterface;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StatsBuilder {
    private static final String BASE_URL = "https://api.covid19api.com/" ;


    public static Call<ListstatsCases> buildCallBack(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;

        StatsApiInterface statsApiInterface = retrofit.create(StatsApiInterface.class) ;
        return statsApiInterface.getStatistics() ;
    }

}
