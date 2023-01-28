package com.deveant.broahlemkhng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class LyricActivity extends AppCompatActivity {

    private WebView webView;
    private Bundle extras;
    private Toolbar toolbar;
    private TextView toolBarTitle;
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric);

        webView = findViewById(R.id.lyric_web_view);
        toolbar = findViewById(R.id.lyrics_toolbar);
        toolBarTitle = findViewById(R.id.lyrics_toolbar_title);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        toolBarTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LyricActivity.this, "developed by \n Ant Bone Kyaw", Toast.LENGTH_SHORT).show();
            }
        });

        setSupportActionBar(toolbar);

        extras = getIntent().getExtras();
        if(extras != null){
            String songNameTitle = extras.getString("songNameTitle");
            String url = "file:///android_asset/"+songNameTitle+".html";
            webView.loadUrl(url);
            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);


        }

        hideNotiBarWhenLandscape();
    }

    private void hideNotiBarWhenLandscape() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
