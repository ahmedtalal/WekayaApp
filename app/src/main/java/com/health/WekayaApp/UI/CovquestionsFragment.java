package com.health.WekayaApp.UI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.health.WekayaApp.Adapter.CovQuestionAdapter;
import com.health.WekayaApp.R;

import java.util.ArrayList;
import java.util.List;

public class CovquestionsFragment extends Fragment {
    List<String> questions = new ArrayList<>() ;
    List<String> answers = new ArrayList<>() ;
    private RecyclerView infoRecyclerView;
    private Context context ;

    public CovquestionsFragment(Context context) {
        this.context = context;
    }

    public CovquestionsFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_covquestions, container , false) ;
        infoRecyclerView = view.findViewById(R.id.info_recycler_id) ;
        setData(questions , answers) ;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false);
        infoRecyclerView.setLayoutManager(linearLayoutManager);
        CovQuestionAdapter covQuestionAdapter = new CovQuestionAdapter(questions , answers , context) ;
        infoRecyclerView.setAdapter(covQuestionAdapter);
        return view ;
    }

    private void setData(List<String> questions, List<String> answers) {
        //questions
        questions.add(getString(R.string.q1)) ;
        questions.add(getString(R.string.q2)) ;
        questions.add(getString(R.string.q3)) ;
        questions.add(getString(R.string.q4)) ;
        questions.add(getString(R.string.q5)) ;
        questions.add(getString(R.string.q6)) ;
        questions.add(getString(R.string.q7)) ;

        //answers
        answers.add(getString(R.string.a1));
        answers.add(getString(R.string.a2));
        answers.add(getString(R.string.a3));
        answers.add(getString(R.string.a4));
        answers.add(getString(R.string.a5));
        answers.add(getString(R.string.a6));
        answers.add(getString(R.string.a7));
    }
}
