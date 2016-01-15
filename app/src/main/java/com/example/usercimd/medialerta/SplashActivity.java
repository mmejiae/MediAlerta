package com.example.usercimd.medialerta;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
private final int DURACION_SPLAH=7000;
   private ProgressBar progressBar;
    private int mProgressStatus=0;
    private Handler mHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
progressBar=(ProgressBar)findViewById(R.id.prograssbar);
mProgressStatus=0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus<100){
                    mProgressStatus +=1;

                    try{
                        Thread.sleep(100);
                         }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(mProgressStatus);

                        }
                    });
                }
            }
        }).start();
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent=new Intent(SplashActivity.this,Medicamentos.class);
                startActivity(intent);
                finish();
            };
        },DURACION_SPLAH);
    }
}
