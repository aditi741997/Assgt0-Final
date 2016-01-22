package nikhil.ayush.aditi.assgt0_final1;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jagdish on 1/22/2016.
 */
public class AppGlobal extends Application
{
    /**
     * Constructed TO MAKE A GLOBAL REQUEST QUEUE, RATHER THAN CREATING A NEW QUEUE WITH EACH ACTIVITY INITIALIZATION. **/
    private static RequestQueue GlobalQueue;
    @Override
    public void onCreate()
    {
        super.onCreate();
        GlobalQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public RequestQueue getQueue()
    {
        /** returns the global queue object **/
        return  GlobalQueue;
    }


}
