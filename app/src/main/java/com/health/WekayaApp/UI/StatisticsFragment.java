package com.health.WekayaApp.UI;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.health.WekayaApp.Models.RetrofilModels.Country;
import com.health.WekayaApp.Models.RetrofilModels.Global;
import com.health.WekayaApp.Models.RetrofilModels.ListstatsCases;
import com.health.WekayaApp.R;
import com.health.WekayaApp.ViewModels.StatViewModel;
import java.util.ArrayList;
import java.util.List;

public class StatisticsFragment extends Fragment {

    private Context context ;
    private TextView totalConfirm , totalDeath , totalRecovered ;
    private TextView newConfirm , newDeath , newRecovered ;
    private TextView totalNewConfirm , totalNewDeath , totalNewRecovered ;
    private Spinner countrySpinner ;
    private ArrayList<String> countrNameLit = new ArrayList<>() ;
    private List<Country> countryCasesList =  new ArrayList<>() ;

    // constructors ---------------->>>>>>>>>>>>>
    public StatisticsFragment(Context context) {
        this.context = context;
    }
    public StatisticsFragment() {
    }

    // create view to statistices fragment ----------------->>>>>>>>>>>>>>>>
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics , container , false) ;
        // initialize all views
        initializeViews(view) ;
        // get covid cases
        getStatsCovid() ;

        // set action on spinner
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String countryName = parent.getItemAtPosition(position).toString() ;
                //Toast.makeText(context , countryName , Toast.LENGTH_LONG).show();
                setCovidCases(countryName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String countryName = parent.getItemAtPosition(0).toString() ;
                //Toast.makeText(context , countryName , Toast.LENGTH_LONG).show();
                setCovidCases(countryName);
            }
        });
        return view ;
    }

    // this method is used to pass values to views ------------------------>>>>>>>>>>>>>>>>
    private void setCovidCases(String countryName) {
        for (Country country : countryCasesList){
            if (country.getCountry().equals(countryName)){
                newConfirm.setText(country.getNewConfirmed().toString());
                newDeath.setText(country.getNewDeaths().toString());
                newRecovered.setText(country.getNewRecovered().toString());
                totalNewConfirm.setText(country.getTotalConfirmed().toString());
                totalNewDeath.setText(country.getTotalDeaths().toString());
                totalNewRecovered.setText(country.getTotalRecovered().toString());
            }
        }
    }

    // get covid cases ---------------------->>>>>>>>>>
    private void getStatsCovid() {
        StatViewModel statViewModel = new ViewModelProvider(this).get(StatViewModel.class) ;
        statViewModel.init(context);
        statViewModel.receiveStatCovid().observe(this, new Observer<ListstatsCases>() {
            @Override
            public void onChanged(ListstatsCases listCovidCases) {
                countryCasesList.clear();
                countrNameLit.clear();
                Global global = listCovidCases.getGlobal() ;
                totalConfirm.setText(global.getTotalConfirmed().toString());
                totalDeath.setText(global.getTotalDeaths().toString());
                totalRecovered.setText(global.getTotalRecovered().toString());
                for (Country country : listCovidCases.getCountries()){
                    countrNameLit.add(country.getCountry()) ;
                    countryCasesList.add(country);
                    Log.i("country", country.getCountry());
                }
                Log.i("countrys", countrNameLit.size() +"" );
                Log.i("countryss", countryCasesList.size() +"" );


                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context , android.R.layout.simple_spinner_item , countrNameLit) ;
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                countrySpinner.setAdapter(arrayAdapter);
            }
        });
    }

    // initialize all views -------------------------->>>>>>>>>>>>>>
    private void initializeViews(View view) {
        totalConfirm = view.findViewById(R.id.total_confirm_id) ;
        totalDeath = view.findViewById(R.id.total_death_id) ;
        totalRecovered = view.findViewById(R.id.total_recoverd_id) ;
        newConfirm = view.findViewById(R.id.new_confirm_id) ;
        newDeath = view.findViewById(R.id.new_death_id) ;
        newRecovered = view.findViewById(R.id.new_recoverd_id) ;
        totalNewConfirm = view.findViewById(R.id.total_new_confirm_id) ;
        totalNewDeath = view.findViewById(R.id.total_new_death_id) ;
        totalNewRecovered = view.findViewById(R.id.total_new_recoverd_id) ;
        countrySpinner = view.findViewById(R.id.spinner_id) ;
    }
}
