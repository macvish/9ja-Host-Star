package com.a9jahotstars.httpwww.a9jahotstars;

/**
 * Created by MacAnthony on 9/1/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private ImageView iv;
    //int progress = 0;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iv = (ImageView) findViewById(R.id.iv);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();


        //call ProgressBar function
        /* setProgressValue(progress); */
       /* Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        iv.startAnimation(myanim);


        Thread t = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i =new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };
        t.start(); */
    }

    private void doWork() {
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(intent);
    }
    /*private void setProgressValue(final int progress){
        //set the progress
        progressBar.setProgress(progress);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    setProgressValue(progress + 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{

                    Intent i =new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
        thread.start();
    }*/

    @Override
    public void onPause(){
        super.onPause();
        finish();
    }

}