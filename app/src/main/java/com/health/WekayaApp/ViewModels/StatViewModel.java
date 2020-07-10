package com.health.WekayaApp.ViewModels;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.health.WekayaApp.Models.RetrofilModels.ListstatsCases;
import com.health.WekayaApp.Repositories.StatisticsRepository;

public class StatViewModel extends ViewModel {
    private MutableLiveData<ListstatsCases> listMutableLiveData ;
    private StatisticsRepository repository ;
    private Context getContext ;
        public void init(Context context){
            getContext = context ;
        if (listMutableLiveData != null){
            return;
        }
        repository = StatisticsRepository.getInstance(getContext) ;
        listMutableLiveData = repository.getCovidCases() ;
    }

    // this method is used to recieve stats from mutableLiveData class
    public LiveData<ListstatsCases> receiveStatCovid(){
        return listMutableLiveData ;
    }


}
