package com.example.crazybeam.pkmoney_v7;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by crazybeam on 7/29/2017.
 */

//Singleton class used when we need to  perform network function more frequently.

    //In singleton class we create "requestqueue" for life time of your app.

public class MySingleton
{

        private static MySingleton mInstnce;

        private RequestQueue requestQueue;

        private static Context mctx;


// create constructor.
        private MySingleton(Context context)
        {
            this.mctx=context;
            this.requestQueue=getRequestQueue();

        }

    // Now we need to get Application context for initialising request queue so that it last for lifetime

        // If requeest queue is null, then Initialise request queue.

        public RequestQueue getRequestQueue()
        {
            if (requestQueue==null)
            {
                requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
            }
            return requestQueue;
        }


        // get an instance of MySingleTon class.

        public static synchronized MySingleton getInstance(Context context)
        {
            if (mInstnce==null)
            {
              mInstnce=new MySingleton(context);
            }
            return mInstnce;
        }


        //now add request to request queue.

        public<T> void addToRequestQue(Request<T> request)
        {
            requestQueue.add(request);

        }




}
