package nikhil.ayush.aditi.assgt0_final1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.content.Intent;
import android.app.Activity;
import android.widget.Button;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import org.w3c.dom.Text;


public class FinalScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        Bundle registrationData = getIntent().getExtras();
        if(registrationData == null){
            return;
        }

        String TeamName = registrationData.getString("TeamName");
        final TextView Team  = (TextView) findViewById(R.id.TeamName);
        Team.setText(TeamName);
//        Team.setTypeface(face);

        String FirstName = registrationData.getString("FirstName");
        final TextView Name_1  = (TextView) findViewById(R.id.Name_1);
        Name_1.setText(FirstName);

        String SecondName = registrationData.getString("SecondName");
        final TextView Name_2  = (TextView) findViewById(R.id.Name_2);
        Name_2.setText(SecondName);

        String ThirdName = registrationData.getString("ThirdName");
        final TextView Name_3  = (TextView) findViewById(R.id.Name_3);
        Name_3.setText(ThirdName);

        String FirstNumber = registrationData.getString("FirstNumber");
        final TextView Entry_1  = (TextView) findViewById(R.id.Entry1);
        Entry_1.setText(FirstNumber);

        String SecondNumber = registrationData.getString("SecondNumber");
        final TextView Entry_2  = (TextView) findViewById(R.id.Entry2);
        Entry_2.setText(SecondNumber);

        String ThirdNumber = registrationData.getString("ThirdNumber");
        final TextView Entry_3  = (TextView) findViewById(R.id.Entry3);
        Entry_3.setText(ThirdNumber);

        clockwise();
    }

    public void Register(View view){
    /** Onclick method for register another team option **/
        Intent i = new Intent(this, MyFirstAnimation.class);
        startActivity(i);
    }

    public void clockwise(){
        /** Animation **/
        TextView image = (TextView)findViewById(R.id.CongratsText);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        image.startAnimation(animation);
    }

}
