package com.health.WekayaApp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.health.WekayaApp.Models.RetrofilModels.Article;
import com.health.WekayaApp.R;
import com.health.WekayaApp.UI.MainActivity;
import com.health.WekayaApp.UI.ShownewsActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private Context context ;
    private List<Article> newsList ;

    public NewsAdapter(Context context, List<Article> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_list , parent , false) ;
        MyViewHolder viewHolder = new MyViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Article model = newsList.get(position) ;
        Log.i("name" , model.getSource().getName()) ;
        holder.newsTV.setText(model.getTitle());
        Picasso.get()
                .load(model.getUrlToImage())
                .placeholder(R.drawable.ic_virus)
                .error(R.drawable.ic_virus)
                .into(holder.newsImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.newsProgress.setVisibility(View.GONE);
                        holder.newsImage.setAlpha(Float.parseFloat("1"));
                    }

                    @Override
                    public void onError(Exception e) {
                        holder.newsProgress.setVisibility(View.VISIBLE);
                    }
                });
        holder.newsRipple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = model.getSource().getName() ;
                String title = model.getTitle() ;
                String description = model.getDescription() ;
                String image = model.getUrlToImage() ;
                String time = model.getPublishedAt() ;
                String url = model.getUrl() ;
                Intent intent = new Intent(context , ShownewsActivity.class) ;
                intent.putExtra("name" , name) ;
                intent.putExtra("title" , title) ;
                intent.putExtra("description" , description) ;
                intent.putExtra("image" , image) ;
                intent.putExtra("time" , time) ;
                intent.putExtra("url" , url) ;
                context.startActivity(intent);
                ((MainActivity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private MaterialRippleLayout newsRipple ;
        private ImageView newsImage ;
        private ProgressBar newsProgress ;
        private TextView newsTV ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            newsRipple = itemView.findViewById(R.id.news_ripple_id) ;
            newsImage = itemView.findViewById(R.id.news_image_id) ;
            newsProgress = itemView.findViewById(R.id.news_progressbar_id) ;
            newsTV = itemView.findViewById(R.id.news_article_id);
        }
    }
}
