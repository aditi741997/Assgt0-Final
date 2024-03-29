package nikhil.ayush.aditi.assgt0_final1;

import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.util.DisplayMetrics;
import android.view.animation.TranslateAnimation;
import android.graphics.drawable.TransitionDrawable;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //Edit it
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
/**      This function includes the code to make the activity full screen.
 *
 */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**Handle action bar item clicks here. The action bar will
        * automatically handle clicks on the Home/Up button, so long
        * as you specify a parent activity in AndroidManifest.xml**/

        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

         if(id==R.id.action_aboutus)
        {Toast.makeText(MainActivity.this,"App has been made by Ayush,Nikhil,Aditi",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(id==R.id.action_aboutapp)
        {Toast.makeText(MainActivity.this,"App allows the user to register their team on the server",Toast.LENGTH_LONG).show();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public void Add(View view)
    {
        /**
         * Handles OnClick event of + Button i.e Appearing of third member and - button along with its disappearance **/
        EditText Name = (EditText) findViewById(R.id.Entry3);
        EditText entry = (EditText) findViewById(R.id.Name3);
        Button add=(Button) findViewById(R.id.add);
        Button sub=(Button) findViewById(R.id.sub);
        TextView addMember=(TextView) findViewById(R.id.addmember);
        addMember.setVisibility(View.INVISIBLE);
        TextView Member3=(TextView) findViewById(R.id.textView3);
        Member3.setVisibility(View.VISIBLE);
        Name.setVisibility(View.VISIBLE);
        entry.setVisibility(View.VISIBLE);
        sub.setVisibility(View.VISIBLE);
        add.setVisibility(View.INVISIBLE);

//        fade() ANIMATES THE BUTTONS.
        fadein();

    }
    public void fadein()
    {
        /**
         * Animation **/
        Button image4 = (Button)findViewById(R.id.add);
        Button image5 = (Button)findViewById(R.id.sub);
        TextView image3 = (TextView)findViewById(R.id.textView3);
        EditText image = (EditText)findViewById(R.id.Name3);
        EditText image2 = (EditText)findViewById(R.id.Entry3);
        TextView image6 = (TextView)findViewById(R.id.addmember);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade2);
        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
        image.startAnimation(animation2);
        image2.startAnimation(animation2);
        image3.startAnimation(animation2);
        image4.startAnimation(animation3);
        image5.startAnimation(animation2);
        image6.startAnimation(animation3);
    }

    public void pop()
    {
        /**
         * Animation **/
        TextView image3 = (TextView)findViewById(R.id.msg);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeinout);
        image3.startAnimation(animation1);
    }

    public void fadeout()
    {
        /**
         * Animation **/
        Button image5 = (Button)findViewById(R.id.sub);
        TextView image3 = (TextView)findViewById(R.id.textView3);
        EditText image = (EditText)findViewById(R.id.Name3);
        EditText image2 = (EditText)findViewById(R.id.Entry3);
        TextView image4 = (TextView)findViewById(R.id.addmember);
        Button image6 = (Button)findViewById(R.id.add);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade2);
        image.startAnimation(animation1);
        image2.startAnimation(animation1);
        image3.startAnimation(animation1);
        image4.startAnimation(animation2);
        image5.startAnimation(animation1);
        image6.startAnimation(animation2);
    }


    private void moveViewToScreenCenter()
    {
        /**
         * Animation **/
        Button view = (Button)findViewById(R.id.add);
        RelativeLayout root = (RelativeLayout) findViewById( R.id.mainlayout);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics( dm );
        int statusBarOffset = dm.heightPixels - root.getMeasuredHeight();

        int originalPos[] = new int[2];
        view.getLocationOnScreen( originalPos );

        int xDest = dm.widthPixels/2;
        xDest -= (view.getMeasuredWidth()/2);
        int yDest = dm.heightPixels/2 - (view.getMeasuredHeight()/2) - statusBarOffset;

        TranslateAnimation anim = new TranslateAnimation( 0, xDest - originalPos[0] , 0, yDest - originalPos[1] );
        anim.setDuration(1000);
        anim.setFillAfter( true );
        view.startAnimation(anim);
    }
//    public void movebutton(){
//    View PlusButton = findViewById(R.id.add);
//     //Change the size of the button
//        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        positionRules.addRule(RelativeLayout.TRANSLATION_X, RelativeLayout.TRUE);
//        positionRules.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
//        PlusButton.setLayoutParams(positionRules);
//
//    //Change size and shape
//        ViewGroup.LayoutParams sizeRules = PlusButton.getLayoutParams();
//        sizeRules.height = 120;
//        sizeRules.width = 120;
//        PlusButton.setLayoutParams(sizeRules);
//    }

    public void sub(View view)
    {
        /**
         * Handles OnClick event of - Button **/
        EditText Name = (EditText) findViewById(R.id.Entry3);
        EditText entry = (EditText) findViewById(R.id.Name3);
        Button add=(Button) findViewById(R.id.add);
        Button sub=(Button) findViewById(R.id.sub);
        TextView addMember=(TextView) findViewById(R.id.addmember);
        addMember.setVisibility(View.VISIBLE);
        TextView Member3=(TextView) findViewById(R.id.textView3);
        Member3.setVisibility(View.INVISIBLE);
        Name.setVisibility(View.INVISIBLE);
        entry.setVisibility(View.INVISIBLE);
        sub.setVisibility(View.INVISIBLE);
        add.setVisibility(View.VISIBLE);
        fadeout();
    }



    public void SendData(View view) throws JSONException {
/**        fetches data of all fields. then send json to server.
*        this method uses the VOLLEY module and
*        Check_constraints class instance used to check validity of user input **/

        String regis="Registering ...";
        Toast.makeText(MainActivity.this,regis,Toast.LENGTH_SHORT).show();
        String url = "http://agni.iitd.ernet.in/cop290/assign0/register/";
        final EditText Name1 = (EditText) findViewById(R.id.Name1);
        final EditText Entry1 = (EditText) findViewById(R.id.Entry1);

        final EditText Name2 = (EditText) findViewById(R.id.Name2);
        final EditText Entry2 = (EditText) findViewById(R.id.Entry2);
        final EditText Name3 = (EditText) findViewById(R.id.Name3);
        final EditText Entry3 = (EditText) findViewById(R.id.Entry3);
        Button add=(Button) findViewById(R.id.add);
        Button sub=(Button) findViewById(R.id.sub);
        boolean b=(add.getVisibility()==View.VISIBLE); //return true if + visible
        final EditText teamname = (EditText) findViewById(R.id.TeamText);
        final TextView message=(TextView) findViewById(R.id.msg);
        final Intent i=new Intent(this,FinalScreen.class);

/** Check_constraints objct created**/
        Check_constraints checker=new Check_constraints();

        if(b)
        {
            Name3.setText("");Entry3.setText("");
        }
        if(!checker.teamname(teamname.getText().toString()))
        {   message.setVisibility(View.INVISIBLE);
            Log.i("this", teamname.getText().toString());
            message.setText("Enter your TeamName");
            pop();
        }
        else if(!((checker.NAME(Name1.getText().toString(),false))&&(checker.NAME(Name2.getText().toString(),false))&&(checker.NAME(Name3.getText().toString(),b))))
        {   message.setVisibility(View.INVISIBLE);
            Log.i("this", Name1.getText().toString());
            message.setText("Enter a valid name");
            pop();
        }
        else if(!((checker.EntryNo(Entry1.getText().toString(),false))&&checker.EntryNo(Entry2.getText().toString(),false)&&checker.EntryNo(Entry3.getText().toString(),b)))
        { Log.i("this",Entry1.getText().toString());
            message.setVisibility(View.INVISIBLE);
            message.setText("Enter a valid Entry Number");
            pop();
        }

        //        Request.Method.POST :
        else if(!checker.Diff_EntryNo(Entry1.getText().toString(),Entry2.getText().toString(),Entry3.getText().toString(),b))
        {   message.setVisibility(View.INVISIBLE);
            message.setText("All Entry No. should be different");
            pop();
        }
        else{b=false;
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            String str=response.toString();
                            String regis=" Registering...";
                            String success="{\"RESPONSE_SUCCESS\": 1, \"RESPONSE_MESSAGE\": \"Registration completed\"}";
                            Log.i("yo",str);
                            String Already_reg="{\"RESPONSE_SUCCESS\": 0, \"RESPONSE_MESSAGE\": \"User already registered\"}";
                            String data_not_posted="{\"RESPONSE_SUCCESS\": 0, \"RESPONSE_MESSAGE\": \"Data not posted!\"}";
                            //Toast.makeText(MainActivity.this, regis, Toast.LENGTH_SHORT).show();
                            if(str.equals(success))
                            {String TeamName = teamname.getText().toString();
                                i.putExtra("TeamName", TeamName);
                                String FirstName = Name1.getText().toString();
                                i.putExtra("FirstName", FirstName);
                                String SecondName = Name2.getText().toString();
                                i.putExtra("SecondName", SecondName);
                                String ThirdName = Name3.getText().toString();
                                i.putExtra("ThirdName", ThirdName);
                                String FirstNumber = Entry1.getText().toString();
                                i.putExtra("FirstNumber", FirstNumber);
                                String SecondNumber = Entry2.getText().toString();
                                i.putExtra("SecondNumber", SecondNumber);
                                String ThirdNumber = Entry3.getText().toString();
                                i.putExtra("ThirdNumber", ThirdNumber);
                            /** New activity is called to Start the final activity once data is posted on the net**/
                                startActivity(i);


                            }
                            //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();


                            else if(str.equals(Already_reg))
                            {   message.setVisibility(View.VISIBLE);
                                message.setText("Team or team members are already registered");
                                pop();
                            }

                            else
                            {   message.setVisibility(View.VISIBLE);
                                message.setText("Data not posted!! Check your Net connection and try again");


                            }
                            //   tt.setText(response.toString() + " is the response from the server.");

                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                            message.setVisibility(View.VISIBLE);
                            message.setText("Data not posted!! Check your Net connection and try again");


                        }
                    }) {
                @Override
                protected Map<String, String> getParams()
                {
//                params to be sent
                /** Data to be sent to the Server **/
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("teamname", teamname.getText().toString());
                    params.put("entry1", Entry1.getText().toString());
                    params.put("name1", Name1.getText().toString());
                    params.put("entry2", Entry2.getText().toString());
                    params.put("name2", Name2.getText().toString());
                    params.put("entry3", Entry3.getText().toString());
                    params.put("name3", Name3.getText().toString());
                    return params;
                }
            };
            AppGlobal myapp = (AppGlobal)getApplicationContext();
            RequestQueue addtoQueue = myapp.getQueue();
            addtoQueue.add(stringRequest);
        }}


    @Override
    public void onStart() {
        super.onStart();
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://nikhil.ayush.aditi.assgt0_final1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();
                Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://nikhil.ayush.aditi.assgt0_final1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    ;
}
