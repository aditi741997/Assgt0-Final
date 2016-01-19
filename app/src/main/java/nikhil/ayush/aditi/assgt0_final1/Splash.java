package nikhil.ayush.aditi.assgt0_final1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private final int splash_time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        clockwise();
//        slide();

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, splash_time);
    }

    public void clockwise(){
        ImageView image = (ImageView)findViewById(R.id.image);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        image.startAnimation(animation);
    }

//    public void slide(){
//        ImageView image = (ImageView)findViewById(R.id.block);
//        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
//        image.startAnimation(animation1);
//    }
}
