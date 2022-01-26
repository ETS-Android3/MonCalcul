package com.example.moncalcul;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN_TIMEOUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
       WindowManager.LayoutParams.FLAG_FULLSCREEN);
       setContentView(R.layout.splash_activity);
       Animation fadeOut = new AlphaAnimation(1,0);
       fadeOut.setInterpolator(new AccelerateInterpolator());
       fadeOut.setStartOffset(500);
       fadeOut.setDuration(1800);
        ImageView image = findViewById(R.id.imageView);
        image.setAnimation(fadeOut);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(SplashActivity.this,MainActivity.class);
               startActivity(intent);
               finish();

           }
       },SPLASH_SCREEN_TIMEOUT);
    }
}
