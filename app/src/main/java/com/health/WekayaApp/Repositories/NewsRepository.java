package com.health.WekayaApp.Repositories;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.health.WekayaApp.Models.RetrofilModels.ListOfArticles;
import com.health.WekayaApp.R;
import com.health.WekayaApp.RetrofitOperation.Builders.NewsBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    private static NewsRepository repository ;
    private MutableLiveData<ListOfArticles> listMutableLiveData = new MutableLiveData<>() ;
    private static Context getContext ;

    // this method is used to create one instance from NewsRepository class
    public static NewsRepository getNewsInstance(Context context){
        getContext = context ;
        if (repository == null){
            repository = new NewsRepository() ;
        }
        return repository ;
    }

    // this method is used to get the news from the server
    public MutableLiveData<ListOfArticles> getNews(){
        NewsBuilder.generateCallback().enqueue(new Callback<ListOfArticles>() {
            @Override
            public void onResponse(Call<ListOfArticles> call, Response<ListOfArticles> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ListOfArticles> call, Throwable t) {
                Log.i("ERROR_NEWS" , t.getMessage()) ;
                Toast.makeText(getContext , getContext.getString(R.string.ERROR) , Toast.LENGTH_LONG).show();
            }
        });
        return listMutableLiveData ;
    }
}