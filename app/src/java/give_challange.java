package com.example.crazybeam.pkmoney_v7;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.support.*;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class give_challange extends AppCompatActivity
{

    String user_name;
    String subject_name;

    public EditText usrname;

    public EditText subjectname;

    Context ctx;

    String login_user_name;

    String login_user_emaild;

    String tabbed_useremailid;

    String message;

    TextView text1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_challange);

        /* for the time being we don't require below code as it the code to getname from listview row*/

        user_name = getIntent().getStringExtra("user_name").toString();

        tabbed_useremailid = getIntent().getStringExtra("tabbed_emailid").toString().trim();

        Toast.makeText(this,"Hello my Id = "+tabbed_useremailid , Toast.LENGTH_SHORT).show();

        login_user_name = getIntent().getStringExtra("login_username");

        login_user_emaild= getIntent().getStringExtra("login_emailid");

        subject_name = getIntent().getStringExtra("subject_str");

        setTitle(Html.fromHtml("<font color =#1b4f72><b>" +user_name+"</b></font>"));

        usrname = (EditText)findViewById(R.id.name);

        subjectname = (EditText)findViewById(R.id.subject);

        text1 = (TextView)findViewById(R.id.text1);

        usrname.setText(login_user_name);

        usrname.setFocusable(false);


        // usrname.setBackgroundColor(10852131);

        subjectname.setText(subject_name);

        subjectname.setFocusable(false);

        //subjectname.setBackgroundColor(10852131);

        message = login_user_name+text1.getText().toString()+" "+subjectname.getText().toString();

      //  Log.w("Rohit","Challange msg : "+message);


    }

public void onGivechallange(View view)
{

    String url ="http://wwwpkmoneyin.000webhostapp.com/send_pushnotification.php";

// Formulate the request and handle the response.

    // we will add this "stringrequest" in singleton class.

    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

            new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    // Do something with the response
                    Toast t2 = Toast.makeText(give_challange.this,"Challange request has been successfully sent to "+user_name.trim()+".",Toast.LENGTH_LONG);
                    t2.show();
                }
            },
            new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    // Handle error
                    String error_Str = error.toString();

                    Toast t2 = Toast.makeText(give_challange.this,error_Str,Toast.LENGTH_SHORT);
                    t2.show();
                }
            }

    )
    {

        @Override
        protected Map<String, String> getParams() throws AuthFailureError
        {

            Map<String,String> params = new HashMap<String, String>();

            params.put("user_emailid",tabbed_useremailid);
            params.put("message",message);


            return params;


        }
    };


    int socketTimeout = 10000; // 10 seconds. You can change it
    RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

    stringRequest.setRetryPolicy(policy);
    MySingleton.getInstance(give_challange.this).addToRequestQue(stringRequest);




}

}