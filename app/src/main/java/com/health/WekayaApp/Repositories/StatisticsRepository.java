package com.health.WekayaApp.Repositories;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.health.WekayaApp.Models.RetrofilModels.ListstatsCases;
import com.health.WekayaApp.R;
import com.health.WekayaApp.RetrofitOperation.Builders.StatsBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticsRepository {
    private static StatisticsRepository repository ;
    private MutableLiveData<ListstatsCases> mutableLiveData = new MutableLiveData<>() ;
    private static Context getContext ;
    // this method is used to create one instance from statisticsRepository class
    public static StatisticsRepository getInstance(Context context){
        getContext = context ;
        if (repository == null){
            repository = new StatisticsRepository() ;
        }
        return repository ;
    }

    public MutableLiveData<ListstatsCases> getCovidCases(){
        StatsBuilder.buildCallBack().enqueue(new Callback<ListstatsCases>() {
            @Override
            public void onResponse(Call<ListstatsCases> call, Response<ListstatsCases> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ListstatsCases> call, Throwable t) {
                Log.i("ERROR_STATISTICS" , t.getMessage()) ;
                Toast.makeText(getContext , getContext.getString(R.string.ERROR) , Toast.LENGTH_LONG).show();
            }
        });

        return mutableLiveData ;
    }
}
