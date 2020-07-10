package com.health.WekayaApp.ViewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.health.WekayaApp.Models.RetrofilModels.ListOfArticles;
import com.health.WekayaApp.Repositories.NewsRepository;

public class NewsViewModel extends ViewModel {
    MutableLiveData<ListOfArticles> mLists  ;
    NewsRepository repository ;
    private Context getContext ;

    // this method is used to initialize NewsRepository class
    public void init(Context context){
        getContext = context ;
        if (mLists != null){
            return;
        }

        repository = NewsRepository.getNewsInstance(context) ;
        mLists = repository.getNews() ;
    }

    // this method is used to recieve news from mutableLiveData class
    public LiveData<ListOfArticles>  receiveNews(){
        return mLists ;
    }
}
