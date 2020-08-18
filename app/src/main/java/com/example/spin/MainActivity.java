package com.example.spin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button spin;
    ImageView bottle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin=findViewById(R.id.spin);
        bottle=findViewById(R.id.imageView);

        spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int degress;
                Random r=new Random();

                degress=r.nextInt(3600);
                RotateAnimation rotatebottle= new RotateAnimation(0,degress, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotatebottle.setDuration(3000);
                    rotatebottle.setFillAfter(true);
                    rotatebottle.setInterpolator(new AccelerateDecelerateInterpolator());
                    bottle.startAnimation(rotatebottle);
                     rotatebottle.setAnimationListener(new Animation.AnimationListener() {
                         @Override
                         public void onAnimationStart(Animation animation) {

                         }

                         @Override
                         public void onAnimationEnd(Animation animation) {
                             if (degress % 360 >180){
                                 Toast.makeText(MainActivity.this,"THE LEFT PERSON IS SELECTED",Toast.LENGTH_SHORT).show();

                             }

                             else
                             {
                                 Toast.makeText(MainActivity.this,"THE RIGHT PERSON IS SELECTED",Toast.LENGTH_SHORT).show();
                             }

                         }

                         @Override
                         public void onAnimationRepeat(Animation animation) {

                         }
                     });








            }
        });
    }
}
