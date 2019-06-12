package com.a9jahotstars.httpwww.a9jahotstars;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
   // private InterstitialAd interstitial;
    SwipeRefreshLayout swipe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mytoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("Auction45");


        swipe = (SwipeRefreshLayout)findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                LoadWeb();
            }
        });

        LoadWeb();

        /*// Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        prepareAd();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run(){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (interstitial.isLoaded()) {
                          interstitial.show();
                        }
                        prepareAd();
                    }
                });
            }
        },10,60, TimeUnit.SECONDS); */

    }

    /*public void prepareAd(){
        //Prepare the Interstitial Ad
        interstitial = new InterstitialAd(MainActivity.this);
        //Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        // Load an ad into the AdMob interstitial view.
        interstitial.loadAd(new AdRequest.Builder().build());
    }*/
    public void LoadWeb(){

        myWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings =myWebView.getSettings();
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        swipe.setRefreshing(true);
        myWebView.loadUrl("http://auction45.com/registration/login.php");
        myWebView.setWebViewClient(new com.a9jahotstars.httpwww.a9jahotstars.MyAppWebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingurl){
                myWebView.loadUrl("file:///android_asset/error.html");
            }
            public void onPageFinished(WebView view, String url) {
                swipe.setRefreshing(false);
            }

        });
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}