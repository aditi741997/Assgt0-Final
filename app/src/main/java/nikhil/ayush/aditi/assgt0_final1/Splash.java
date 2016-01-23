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
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.graphics.Typeface;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private final int splash_time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /** Splash screen is the launcher activity which after starts the Main Activity **/

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Typeface face =Typeface.createFromAsset(getAssets(),"ELPHIN.TTF");
        TextView txtV = (TextView)findViewById(R.id.Text);
        txtV.setTypeface(face);
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
        /** Animation **/
        ImageView image = (ImageView)findViewById(R.id.image);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        image.startAnimation(animation);
    }

}
