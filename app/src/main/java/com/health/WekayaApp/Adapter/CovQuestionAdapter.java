package com.health.WekayaApp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.health.WekayaApp.R;

import java.util.List;

public class CovQuestionAdapter extends RecyclerView.Adapter<CovQuestionAdapter.MyViewHolder> {
    private List<String> qauestionList  , answerList ;
    private Context context ;

    public CovQuestionAdapter(List<String> qauestionList, List<String> answerList, Context context) {
        this.qauestionList = qauestionList;
        this.answerList = answerList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.covques_list, parent , false) ;
        MyViewHolder viewHolder = new MyViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String question = qauestionList.get(position) ;
        String answer = answerList.get(position) ;
        holder.question_textview.setText(question);
        holder.answer_textview.setText(answer);
    }

    @Override
    public int getItemCount() {
        return qauestionList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
       private TextView question_textview , answer_textview ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question_textview = itemView.findViewById(R.id.question_textview_id) ;
            answer_textview = itemView.findViewById(R.id.answer_textview_id) ;
        }
    }
}
