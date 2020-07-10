package com.health.WekayaApp.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.health.WekayaApp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutusActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.about_toolbar_id)
    Toolbar aboutToolbarId;
    @BindView(R.id.facebook_ripple_id)
    LinearLayout facebookRippleId;
    @BindView(R.id.twitter_ripple_id)
    LinearLayout twitterRippleId;
    @BindView(R.id.youtube_ripple_id)
    LinearLayout youtubeRippleId;
    @BindView(R.id.google_ripple_id)
    LinearLayout googleRippleId;
    @BindView(R.id.github_ripple_id)
    LinearLayout githubRippleId;
    @BindView(R.id.instagram_ripple_id)
    LinearLayout instagramRippleId;

    private Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme4);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        ButterKnife.bind(this);

        intent = new Intent(AboutusActivity.this , MainActivity.class) ;
        setSupportActionBar(aboutToolbarId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        aboutToolbarId.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });

        facebookRippleId.setOnClickListener(this::onClick);
        twitterRippleId.setOnClickListener(this::onClick);
        googleRippleId.setOnClickListener(this::onClick);
        youtubeRippleId.setOnClickListener(this::onClick);
        githubRippleId.setOnClickListener(this::onClick);
        instagramRippleId.setOnClickListener(this::onClick);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
                case R.id.facebook_ripple_id :
                    String link = "https://www.facebook.com/ahmd.talal.5?ref=bookmarks";
                    goToUrl(link);
                    break;
                case R.id.google_ripple_id :
                    String link1 = "https://mail.google.com/mail/u/0/#inbox";
                    goToUrl(link1);
                    break;
                case R.id.youtube_ripple_id :
                    String link2 = "https://www.youtube.com/channel/UCxjsmxYugcfGrjRaP2gteiQ?view_as=subscriber";
                    goToUrl(link2);
                    break;
                case R.id.github_ripple_id :
                    String link3 = "https://github.com/ahmedtalal?tab=repositories";
                    goToUrl(link3);
                    break;
                case R.id.twitter_ripple_id :
                    String link4 = "https://twitter.com/BashMobarmg?s=08";
                    goToUrl(link4);
                    break;
            case R.id.instagram_ripple_id :
                String link5 = "https://www.instagram.com/ahmedtalal98/";
                goToUrl(link5);
        }
    }

    private void goToUrl(String link4) {
        Uri uriUrl = Uri.parse(link4);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        //launchBrowser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(launchBrowser);
    }
}
