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

import com.health.WekayaApp.Adapter.ProtectionAdapter;
import com.health.WekayaApp.Models.ProtectionModel;
import com.health.WekayaApp.R;

import java.util.ArrayList;
import java.util.List;

public class ProtectionFragment extends Fragment {
    private Context context ;
    private List<ProtectionModel> list = new ArrayList<>();
    private RecyclerView recyclerView ;
    public ProtectionFragment(Context context) {
        this.context = context;
    }

    public ProtectionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_protection , container , false) ;
        recyclerView = view.findViewById(R.id.protection_recycler_id) ;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context , LinearLayoutManager.VERTICAL , false) ;
        recyclerView.setLayoutManager(linearLayoutManager);
        setData(list);
        ProtectionAdapter adapter = new ProtectionAdapter(list , context) ;
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void setData(List<ProtectionModel> list) {
        list.add(new ProtectionModel(getString(R.string.way1),R.drawable.setp1));
        list.add(new ProtectionModel(getString(R.string.way2),R.drawable.step2));
        list.add(new ProtectionModel(getString(R.string.way3),R.drawable.step3));
        list.add(new ProtectionModel(getString(R.string.way4),R.drawable.step4));
        list.add(new ProtectionModel(getString(R.string.way5),R.drawable.step5));
        list.add(new ProtectionModel(getString(R.string.way6),R.drawable.step6));
        list.add(new ProtectionModel(getString(R.string.way7),R.drawable.step7));
        list.add(new ProtectionModel(getString(R.string.way8),R.drawable.step8));
        list.add(new ProtectionModel(getString(R.string.way9),R.drawable.step9));
        list.add(new ProtectionModel(getString(R.string.way10),R.drawable.step10));
        list.add(new ProtectionModel(getString(R.string.way11),R.drawable.step11));
        list.add(new ProtectionModel(getString(R.string.way12),R.drawable.step12));

    }
}
