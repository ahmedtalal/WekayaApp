package com.health.WekayaApp.UI;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.health.WekayaApp.Adapter.NewsAdapter;
import com.health.WekayaApp.Models.RetrofilModels.Article;
import com.health.WekayaApp.Models.RetrofilModels.ListOfArticles;
import com.health.WekayaApp.R;
import com.health.WekayaApp.ViewModels.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private RecyclerView newsRecyclerView ;
    private ProgressBar progressBar;
    private Context context ;
    private NewsAdapter newsAdapter ;
    private List<Article> articleList = new ArrayList<>() ;
    // constructor contain one parameter
    public NewsFragment(Context context) {
        this.context = context;

    }

    // empty constructor
    public NewsFragment() {
    }

    /// create view to news fragment --------------->>>>>>>>>>>>>>
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news , container , false) ;

        // recyclerview settings --------------->>>>>>>>>>>>>>>>>>>
        newsRecyclerView = view.findViewById(R.id.news_recycler_id) ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false) ;
        layoutManager.setStackFromEnd(false);
        newsRecyclerView.setLayoutManager(layoutManager);

        // progressBar settings ------------->>>>>>>>>>
        progressBar = view.findViewById(R.id.news_progressbar_ID) ;
        progressBar.setVisibility(View.VISIBLE);

        // ViewModel settings --------------------->>>>>>>>
        NewsViewModel newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        newsViewModel.init(context);
        newsViewModel.receiveNews().observe(this, new Observer<ListOfArticles>() {
            @Override
            public void onChanged(ListOfArticles listOfArticles) {
                articleList.clear();
                for (Article article : listOfArticles.getArticles()){
                    articleList.add(article) ;
                }
                Log.i("sizenews",  articleList.size() + "");
                newsAdapter = new NewsAdapter(context , articleList) ;
                newsRecyclerView.setAdapter(newsAdapter);
                newsAdapter.notifyDataSetChanged();
                if (newsAdapter.getItemCount() > 0){
                    progressBar.setVisibility(View.GONE);
                }else {
                    Toast.makeText(context , "لا يوجد اتصال بالانترنت" , Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}
