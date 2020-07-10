package com.health.WekayaApp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.health.WekayaApp.Models.ProtectionModel;
import com.health.WekayaApp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProtectionAdapter extends RecyclerView.Adapter<ProtectionAdapter.MyViewHolder> {

    private List<ProtectionModel> list ;
    Context context ;

    public ProtectionAdapter(List<ProtectionModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.protectionways_list , parent , false) ;
        MyViewHolder viewHolder = new MyViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProtectionModel model = list.get(position) ;
        holder.textView.setText(model.getText());
        Picasso.get()
                .load(model.getImage())
                .placeholder(R.drawable.corn)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView ;
        private TextView textView ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.photo_way_id) ;
            textView = itemView.findViewById(R.id.text_ways_id) ;
        }
    }
}
