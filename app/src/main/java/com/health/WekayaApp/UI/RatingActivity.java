package com.health.WekayaApp.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.health.WekayaApp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RatingActivity extends AppCompatActivity {

    @BindView(R.id.rateToolbar_id)
    Toolbar rateToolbarId;
    @BindView(R.id.rate_id)
    RatingBar rateId;
    @BindView(R.id.rateBtn_ID)
    Button rateBtnID;

    private Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme4);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ButterKnife.bind(this);

        intent = new Intent(RatingActivity.this , MainActivity.class) ;
        setSupportActionBar(rateToolbarId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // when user click on back button in toolbare , it will go back main activty
        rateToolbarId.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });

        rateBtnID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW) ;
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.health.WekayaApp.UI")) ;
                Log.v("Uri" , "https://play.google.com/store/apps/details?id=com.health.WekayaApp.UI") ;
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(intent);
        finish();
    }
}
