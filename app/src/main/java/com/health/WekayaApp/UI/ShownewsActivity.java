package com.health.WekayaApp.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.health.WekayaApp.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ShownewsActivity extends AppCompatActivity {
    @BindView(R.id.imageUri_id)
    ImageView imageUriId;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progoBar)
    ProgressBar progoBar;
    @BindView(R.id.collapsing_ID)
    CollapsingToolbarLayout collapsingID;
    @BindView(R.id.title_id)
    TextView titleId;
    @BindView(R.id.description_id)
    TextView descriptionId;
    @BindView(R.id.puplishTime_id)
    TextView puplishTimeId;
    @BindView(R.id.source_id)
    TextView sourceId;
    private String name, title, description, image, time, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shownews);
        ButterKnife.bind(this);

        // recieve data from news activity
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        title = intent.getStringExtra("title");
        description = intent.getStringExtra("description");
        image = intent.getStringExtra("image");
        time = intent.getStringExtra("time");
        url = intent.getStringExtra("url");

        // set toolbar settings
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ShownewsActivity.this , MainActivity.class) ;
                startActivity(intent1);
                finish();
            }
        });

        // initialoze views like name,title,description,image,url and time
        collapsingID.setTitle(name);
        titleId.setText(title);
        descriptionId.setText(description);
        Picasso.get()
                .load(image)
                .placeholder(R.drawable.ic_virus)
                .error(R.drawable.ic_virus)
                .into(imageUriId, new Callback() {
                    @Override
                    public void onSuccess() {
                        progoBar.setVisibility(View.GONE);
                        imageUriId.setAlpha(Float.parseFloat("1"));
                    }

                    @Override
                    public void onError(Exception e) {
                        progoBar.setVisibility(View.VISIBLE);
                    }
                });
        // set action when user click on اضغط هنا
        sourceId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(url) ;
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW , uri) ;
                launchBrowser.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) ;
                startActivity(launchBrowser);
            }
        });

        // set time
        setTime(time) ;
    }

    private void setTime(String time) {
        String newTime = time.substring(0 , 10) ;
        puplishTimeId.setText(newTime);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ShownewsActivity.this , MainActivity.class) ;
        startActivity(intent); ;
        finish();
    }
}
