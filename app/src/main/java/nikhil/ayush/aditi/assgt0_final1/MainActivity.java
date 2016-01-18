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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
//    RequestQueue Rq = Volley.newRequestQueue(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Add(View view)
    {
        EditText Name = (EditText) findViewById(R.id.Entry3);
        EditText entry = (EditText) findViewById(R.id.Name3);
        Button add=(Button) findViewById(R.id.add);
        Button sub=(Button) findViewById(R.id.sub);

        Name.setVisibility(View.VISIBLE);
        entry.setVisibility(View.VISIBLE);
        sub.setVisibility(View.VISIBLE);
        add.setVisibility(View.INVISIBLE);
//        add.setChecked(false);
//        sub.setChecked(false);
    }
    public void sub(View view)
    {   //TextView name_3=(TextView) findViewById(R.id.name3);
        //TextView entry3=(TextView) findViewById(R.id.entry3);
        EditText Name = (EditText) findViewById(R.id.Entry3);
        EditText entry = (EditText) findViewById(R.id.Name3);
        Button add=(Button) findViewById(R.id.add);
        Button sub=(Button) findViewById(R.id.sub);

        //name_3.setVisibility(View.INVISIBLE);
        //entry3.setVisibility(View.INVISIBLE);
        Name.setVisibility(View.INVISIBLE);
        entry.setVisibility(View.INVISIBLE);
        sub.setVisibility(View.INVISIBLE);
        add.setVisibility(View.VISIBLE);
    }

    public void SendData(View view) throws JSONException {
//        fetch data of all fields. then send json to server.
        String url = "http://agni.iitd.ernet.in/cop290/assign0/register/";
        //EditText teamname = (EditText) findViewById(R.id.Name1);
       // TextView name_1=(TextView) findViewById(R.id.name1);
       // TextView entry1=(TextView) findViewById(R.id.entry1);
       // TextView name_2=(TextView) findViewById(R.id.name2);
       // TextView entry2=(TextView) findViewById(R.id.entry2);
       // TextView name_3=(TextView) findViewById(R.id.name3);
        //TextView entry3=(TextView) findViewById(R.id.entry3);
        EditText Name1 = (EditText) findViewById(R.id.Name1);
        EditText Entry1 = (EditText) findViewById(R.id.Entry1);

        EditText Name2 = (EditText) findViewById(R.id.Name2);
        EditText Entry2 = (EditText) findViewById(R.id.Entry2);
        EditText Name3 = (EditText) findViewById(R.id.Name3);
        EditText Entry3 = (EditText) findViewById(R.id.Entry3);
        Button add=(Button) findViewById(R.id.add);
        Button sub=(Button) findViewById(R.id.sub);
        boolean b=(add.getVisibility()==View.VISIBLE);
        EditText teamname = (EditText) findViewById(R.id.Name1);
        final TextView message=(TextView) findViewById(R.id.msg);

        Check_constraints checker=new Check_constraints();

        if(b)
        {
            Name3.setText("");Entry3.setText("");
        }
        if(!checker.teamname(teamname.getText().toString()))
        {
            Log.i("this",teamname.getText().toString());
            message.setText("TeamName should contain only Albhabets");
        }
        else if(!((checker.NAME(Name1.getText().toString()))&&(checker.NAME(Name1.getText().toString()))&&(checker.NAME(Name1.getText().toString()))))
        {
            Log.i("this",Name1.getText().toString());
            message.setText("Enter a valid name");
        }
        else if(!((checker.EntryNo(Entry1.getText().toString()))&&checker.EntryNo(Entry2.getText().toString())&&checker.EntryNo(Entry3.getText().toString())))
        { Log.i("this",Entry1.getText().toString());
            message.setText("Enter a valid Entry Number");}

        //        Request.Method.POST :
        else if(!checker.Diff_EntryNo(Entry1.getText().toString(),Entry2.getText().toString(),Entry3.getText().toString(),b))
        {
            message.setText("All Entry no. should be different");
        }
        else{
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                            TextView tt = (TextView) findViewById(R.id.msg);
                            String str=response.toString();
                       /* if(str.equals())
                        {
                            message.setText("Team Not Registered : Team name already exists");
                        }
                        else if(str.equals())
                        {//use of intents to start a new screen

                        }*/
                            tt.setText(response.toString() + " is the response from the server.");

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams()
                { EditText Name1 = (EditText) findViewById(R.id.Name1);
                    EditText Entry1 = (EditText) findViewById(R.id.Entry1);

                    EditText Name2 = (EditText) findViewById(R.id.Name2);
                    EditText Entry2 = (EditText) findViewById(R.id.Entry2);

                    EditText Name3 = (EditText) findViewById(R.id.Name3);
                    EditText Entry3 = (EditText) findViewById(R.id.Entry3);

//                params to be sent
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("teamname", "");
                    params.put("entry1", Entry1.getText().toString());
                    params.put("name1", Name1.getText().toString());
                    params.put("entry2", Entry2.getText().toString());
                    params.put("name2", Name2.getText().toString());
                    params.put("entry3", Entry3.getText().toString());
                    params.put("name3", Name3.getText().toString());


                    return params;
                }
            };
            Volley.newRequestQueue(this).add(stringRequest);
        }}
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
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
