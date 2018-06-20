package com.example.crazybeam.pkmoney_v7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.font;

public class set_challange_time extends AppCompatActivity

{

    /*******for AM-PM************/

    public Button btn;
    public Button btn_geo;
    public Button btn_his;
    public Button btn_ca;
    public Button btn_cs;

    /*******for AM-PM Ends************/

    public Button btnh_pol;
    public Button btnm_pol;

    public Button btnh_geo;
    public Button btnm_geo;

    public Button btnh_his;
    public Button btnm_his;


    public Button btnh_ca;
    public Button btnm_ca;

   String login_user_emailid;

    public Button btnh_cs;
    public Button btnm_cs;

    TextView last_avail_time_pol;

    TextView last_avail_time_geo;

    TextView last_avail_time_his;

    TextView last_avail_time_ca;

    TextView last_avail_time_cs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_challange_time);
        setTitle(Html.fromHtml("<font color = #566573><b>" + "Available Time" + "</b></font>"));

        btn = (Button) findViewById(R.id.am_pm);
        btn_geo = (Button) findViewById(R.id.am_pm_geo);
        btn_his = (Button) findViewById(R.id.am_pm_his);
        btn_ca = (Button) findViewById(R.id.am_pm_ca);
        btn_cs = (Button) findViewById(R.id.am_pm_cs);

        btnh_pol = (Button) findViewById(R.id.Hours);
        btnm_pol = (Button) findViewById(R.id.minutes);

        btnh_geo = (Button) findViewById(R.id.geo_Hours);
        btnm_geo = (Button) findViewById(R.id.geo_minutes);

        btnh_his = (Button) findViewById(R.id.his_Hours);
        btnm_his = (Button) findViewById(R.id.his_minutes);

        btnh_ca = (Button) findViewById(R.id.ca_Hours);
        btnm_ca = (Button) findViewById(R.id.ca_minutes);

        btnh_cs = (Button) findViewById(R.id.cs_Hours);
        btnm_cs = (Button) findViewById(R.id.cs_minutes);



        login_user_emailid = getIntent().getStringExtra("emailid");


        last_avail_time_pol = (TextView) findViewById(R.id.msg1);

        last_avail_time_geo = (TextView) findViewById(R.id.msg_geo);

        last_avail_time_his = (TextView) findViewById(R.id.msg_his);

        last_avail_time_ca = (TextView) findViewById(R.id.msg_ca);

        last_avail_time_cs = (TextView) findViewById(R.id.msg_cs);

        onActivityLoadPol();
        onActivityLoadGeo();

        onActivityLoadHis();
        onActivityLoadCA();
        onActivityLoadCS();

    }


    /*************************************This is for polity*****************************/

    public void onPlus(View v1) {


        setTime st = new setTime("hours", btnh_pol);
        st.onPlusCall(v1);

    }

    public void onMinus(View v2) {


        setTime st = new setTime("hours", btnh_pol);
        st.onMinusCall(v2);
    }


    public void onMinutePlus(View v3) {


        setTime st = new setTime("minutes", btnm_pol);
        st.onMinutePlusCall(v3);

    }


    public void onMinuteMinus(View v4) {


        setTime st = new setTime("minutes", btnm_pol);
        st.onMinuteMinusCall(v4);
    }

    /**************************************FOr Geography section****************************************************************/

    public void onPlus_geo(View v1) {


        setTime st = new setTime("hours", btnh_geo);
        st.onPlusCall(v1);

    }

    public void onMinus_geo(View v2) {


        setTime st = new setTime("hours", btnh_geo);
        st.onMinusCall(v2);
    }


    public void onMinutePlus_geo(View v3) {


        setTime st = new setTime("minutes", btnm_geo);
        st.onMinutePlusCall(v3);

    }


    public void onMinuteMinus_geo(View v4) {


        setTime st = new setTime("minutes", btnm_geo);
        st.onMinuteMinusCall(v4);
    }


    /**************************************FOr History section****************************************************************/

    public void onPlus_his(View v1) {


        setTime st = new setTime("hours", btnh_his);
        st.onPlusCall(v1);

    }

    public void onMinus_his(View v2) {


        setTime st = new setTime("hours", btnh_his);
        st.onMinusCall(v2);
    }


    public void onMinutePlus_his(View v3) {


        setTime st = new setTime("minutes", btnm_his);
        st.onMinutePlusCall(v3);

    }


    public void onMinuteMinus_his(View v4) {


        setTime st = new setTime("minutes", btnm_his);
        st.onMinuteMinusCall(v4);
    }


    /**************************************FOr current affairs section****************************************************************/

    public void onPlus_ca(View v1) {


        setTime st = new setTime("hours", btnh_ca);
        st.onPlusCall(v1);

    }

    public void onMinus_ca(View v2) {


        setTime st = new setTime("hours", btnh_ca);
        st.onMinusCall(v2);
    }


    public void onMinutePlus_ca(View v3) {


        setTime st = new setTime("minutes", btnm_ca);
        st.onMinutePlusCall(v3);

    }


    public void onMinuteMinus_ca(View v4) {


        setTime st = new setTime("minutes", btnm_ca);
        st.onMinuteMinusCall(v4);
    }


    /*************************************This is for Computer Scienece*****************************/

    public void onPlus_cs(View v1) {


        setTime st = new setTime("hours", btnh_cs);
        st.onPlusCall(v1);

    }

    public void onMinus_cs(View v2) {


        setTime st = new setTime("hours", btnh_cs);
        st.onMinusCall(v2);
    }


    public void onMinutePlus_cs(View v3) {


        setTime st = new setTime("minutes", btnm_cs);
        st.onMinutePlusCall(v3);

    }


    public void onMinuteMinus_cs(View v4) {


        setTime st = new setTime("minutes", btnm_cs);
        st.onMinuteMinusCall(v4);
    }

    /******************code ends for computer sciencee*******************************/


    public void onAm_Pm(View v5) {


        String str;

        // Log.w("Rohit", "I am in AM PM");


        str = btn.getText().toString().trim();


        if (str.equals("AM")) {

            btn.setText("PM");

        } else

        {
            btn.setText("AM");


        }


    }


    public void onAm_Pm_geo(View v5) {


        String str;

        // Log.w("Rohit", "I am in AM PM");


        str = btn_geo.getText().toString().trim();


        if (str.equals("AM")) {

            btn_geo.setText("PM");

        } else

        {
            btn_geo.setText("AM");


        }


    }


    public void onAm_Pm_his(View v5) {


        String str;

        // Log.w("Rohit", "I am in AM PM");


        str = btn_his.getText().toString().trim();


        if (str.equals("AM")) {

            btn_his.setText("PM");

        } else

        {
            btn_his.setText("AM");


        }


    }


    public void onAm_Pm_ca(View v5) {


        String str;

        // Log.w("Rohit", "I am in AM PM");


        str = btn_ca.getText().toString().trim();


        if (str.equals("AM")) {

            btn_ca.setText("PM");

        } else

        {
            btn_ca.setText("AM");


        }


    }


    public void onAm_Pm_cs(View v5) {


        String str;

        // Log.w("Rohit", "I am in AM PM");


        str = btn_cs.getText().toString().trim();


        if (str.equals("AM")) {

            btn_cs.setText("PM");

        } else

        {
            btn_cs.setText("AM");


        }


    }

    public  void onActivityLoadPol()
    {

        final String  subject_name = "polity";


        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/avail_time_onLoad.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                       // Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_pol.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);

                params.put("subject_name",subject_name);

                return params;
            }
        };
        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);
        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);



    }


    public  void onActivityLoadGeo()
    {


        final String  subject_name = "geography";


        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/avail_time_onLoad.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_geo.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);


                params.put("subject_name",subject_name);

                return params;
            }
        };
        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);
        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);





    }



    public  void onActivityLoadHis()
    {


        final String  subject_name = "history";



        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/avail_time_onLoad.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_his.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);


                params.put("subject_name",subject_name);

                return params;
            }
        };
        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);
        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);





    }


    public  void onActivityLoadCA()
    {


        final String  subject_name = "current_affairs";



        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/avail_time_onLoad.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_ca.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);


                params.put("subject_name",subject_name);

                return params;
            }
        };
        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);
        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);





    }




    public  void onActivityLoadCS()
    {


        final String  subject_name = "computer_science";



        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/avail_time_onLoad.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_cs.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);


                params.put("subject_name",subject_name);

                return params;
            }
        };
        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);
        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);





    }

    public void onSavePolity(View view)
    {


    final String  subject_name = "polity";

        String hours =  btnh_pol.getText().toString();

        String minutes = btnm_pol.getText().toString();

        String am_pm = btn.getText().toString();

        //        Log.w("Rohit","Time :"+ hours+":"+minutes+" "+am_pm);

       if(am_pm.equals("PM"))
       {

           if(hours.equals("01"))
           {
               hours="13";
           }

           else if(hours.equals("02"))
           {
               hours="14";
           }

           else if(hours.equals("03"))
           {
               hours="15";
           }

           else if(hours.equals("04"))
           {
               hours="16";
           }

           else if(hours.equals("05"))
           {
               hours="17";
           }

           else if(hours.equals("06"))
           {
               hours="18";
           }

           else if(hours.equals("07"))
           {
               hours="19";
           }

           else if(hours.equals("08"))
           {
               hours="20";
           }

           else if(hours.equals("09"))
           {
               hours="21";
           }

           else if(hours.equals("10"))
           {
               hours="22";
           }

           else if(hours.equals("11"))
           {
               hours="23";
           }

           else if(hours.equals("12"))
           {
               hours="24";
           }



       }

       final String time_24f = (hours+minutes);

        // int int_time_24f = Integer.parseInt(time_24f);

        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/save_avail_time.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                     int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                          incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                         if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                      else if(final_hrs.equals("13"))
                       {
                           final_hrs="01";

                           am_pm = "PM";

                           incr_final_hrs="02";

                           am_pm_incr="PM";

                       }

                       else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                       else if(final_hrs.equals("15"))
                       {
                           final_hrs="03";
                           am_pm = "PM";

                           incr_final_hrs="04";
                           am_pm_incr="PM";
                       }

                       else if(final_hrs.equals("16"))
                       {
                           final_hrs="04";
                           am_pm = "PM";

                           incr_final_hrs="05";
                           am_pm_incr="PM";
                       }

                       else if(final_hrs.equals("17"))
                       {
                           final_hrs="05";
                           am_pm = "PM";

                           incr_final_hrs="06";
                           am_pm_incr="PM";

                       }

                       else if(final_hrs.equals("18"))
                       {
                           final_hrs="06";
                           am_pm = "PM";

                           incr_final_hrs="07";
                           am_pm_incr="PM";
                       }

                       else if(final_hrs.equals("19"))
                       {
                           final_hrs="07";
                           am_pm = "PM";

                           incr_final_hrs="08";
                           am_pm_incr="PM";

                       }

                       else if(final_hrs.equals("20"))
                       {
                           final_hrs="08";
                           am_pm = "PM";

                           incr_final_hrs="09";
                           am_pm_incr="PM";
                       }

                       else if(final_hrs.equals("21"))
                       {
                           final_hrs="09";
                           am_pm = "PM";

                           incr_final_hrs="10";
                           am_pm_incr="PM";
                       }

                       else if(final_hrs.equals("22"))
                       {
                           final_hrs="10";
                           am_pm = "PM";

                           incr_final_hrs="11";
                           am_pm_incr="PM";
                       }

                       else if(final_hrs.equals("23"))
                       {
                           final_hrs="11";
                           am_pm = "PM";

                           incr_final_hrs="12";
                           am_pm_incr="AM";
                       }

                       else if(final_hrs.equals("24"))
                       {
                           final_hrs="12";

                           am_pm = "AM";

                           incr_final_hrs="01";
                           am_pm_incr="AM";

                       }


                        last_avail_time_pol.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                       String error_Str = error.toString();

                       Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

                )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);

                params.put("save_time",time_24f);

                params.put("subject_name",subject_name);

                return params;
            }
        };
        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);

        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);


    }




    public void onSaveGeo(View view)
    {

        final String  subject_name = "geography";

        String hours =  btnh_geo.getText().toString();

        String minutes = btnm_geo.getText().toString();

        String am_pm = btn_geo.getText().toString();

        //        Log.w("Rohit","Time :"+ hours+":"+minutes+" "+am_pm);

        if(am_pm.equals("PM"))
        {

            if(hours.equals("01"))
            {
                hours="13";
            }

            else if(hours.equals("02"))
            {
                hours="14";
            }

            else if(hours.equals("03"))
            {
                hours="15";
            }

            else if(hours.equals("04"))
            {
                hours="16";
            }

            else if(hours.equals("05"))
            {
                hours="17";
            }

            else if(hours.equals("06"))
            {
                hours="18";
            }

            else if(hours.equals("07"))
            {
                hours="19";
            }

            else if(hours.equals("08"))
            {
                hours="20";
            }

            else if(hours.equals("09"))
            {
                hours="21";
            }

            else if(hours.equals("10"))
            {
                hours="22";
            }

            else if(hours.equals("11"))
            {
                hours="23";
            }

            else if(hours.equals("12"))
            {
                hours="24";
            }



        }

        final String time_24f = (hours+minutes);

        // int int_time_24f = Integer.parseInt(time_24f);

        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/save_avail_time.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_geo.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);

                params.put("save_time",time_24f);

                params.put("subject_name",subject_name);

                return params;
            }
        };
        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);
        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);


    }

    public void onSaveHis(View view)
    {

        final String  subject_name = "history";

        String hours =  btnh_his.getText().toString();

        String minutes = btnm_his.getText().toString();

        String am_pm = btn_his.getText().toString();

        //        Log.w("Rohit","Time :"+ hours+":"+minutes+" "+am_pm);

        if(am_pm.equals("PM"))
        {

            if(hours.equals("01"))
            {
                hours="13";
            }

            else if(hours.equals("02"))
            {
                hours="14";
            }

            else if(hours.equals("03"))
            {
                hours="15";
            }

            else if(hours.equals("04"))
            {
                hours="16";
            }

            else if(hours.equals("05"))
            {
                hours="17";
            }

            else if(hours.equals("06"))
            {
                hours="18";
            }

            else if(hours.equals("07"))
            {
                hours="19";
            }

            else if(hours.equals("08"))
            {
                hours="20";
            }

            else if(hours.equals("09"))
            {
                hours="21";
            }

            else if(hours.equals("10"))
            {
                hours="22";
            }

            else if(hours.equals("11"))
            {
                hours="23";
            }

            else if(hours.equals("12"))
            {
                hours="24";
            }



        }

        final String time_24f = (hours+minutes);

        // int int_time_24f = Integer.parseInt(time_24f);

        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/save_avail_time.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_his.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);

                params.put("save_time",time_24f);

                params.put("subject_name",subject_name);

                return params;
            }
        };
        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);

        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);




    }

    public void onSaveCa(View view)
    {

        final String  subject_name = "current_affairs";

        String hours =  btnh_ca.getText().toString();

        String minutes = btnm_ca.getText().toString();

        String am_pm = btn_ca.getText().toString();

        //        Log.w("Rohit","Time :"+ hours+":"+minutes+" "+am_pm);

        if(am_pm.equals("PM"))
        {

            if(hours.equals("01"))
            {
                hours="13";
            }

            else if(hours.equals("02"))
            {
                hours="14";
            }

            else if(hours.equals("03"))
            {
                hours="15";
            }

            else if(hours.equals("04"))
            {
                hours="16";
            }

            else if(hours.equals("05"))
            {
                hours="17";
            }

            else if(hours.equals("06"))
            {
                hours="18";
            }

            else if(hours.equals("07"))
            {
                hours="19";
            }

            else if(hours.equals("08"))
            {
                hours="20";
            }

            else if(hours.equals("09"))
            {
                hours="21";
            }

            else if(hours.equals("10"))
            {
                hours="22";
            }

            else if(hours.equals("11"))
            {
                hours="23";
            }

            else if(hours.equals("12"))
            {
                hours="24";
            }



        }

        final String time_24f = (hours+minutes);

        // int int_time_24f = Integer.parseInt(time_24f);

        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/save_avail_time.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_ca.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);

                params.put("save_time",time_24f);

                params.put("subject_name",subject_name);

                return params;
            }
        };

        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);

        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);


    }


    public void onSaveCs(View view)
    {

        final String  subject_name = "computer_science";

        String hours =  btnh_cs.getText().toString();

        String minutes = btnm_cs.getText().toString();

        String am_pm = btn_cs.getText().toString();

        //        Log.w("Rohit","Time :"+ hours+":"+minutes+" "+am_pm);

        if(am_pm.equals("PM"))
        {

            if(hours.equals("01"))
            {
                hours="13";
            }

            else if(hours.equals("02"))
            {
                hours="14";
            }

            else if(hours.equals("03"))
            {
                hours="15";
            }

            else if(hours.equals("04"))
            {
                hours="16";
            }

            else if(hours.equals("05"))
            {
                hours="17";
            }

            else if(hours.equals("06"))
            {
                hours="18";
            }

            else if(hours.equals("07"))
            {
                hours="19";
            }

            else if(hours.equals("08"))
            {
                hours="20";
            }

            else if(hours.equals("09"))
            {
                hours="21";
            }

            else if(hours.equals("10"))
            {
                hours="22";
            }

            else if(hours.equals("11"))
            {
                hours="23";
            }

            else if(hours.equals("12"))
            {
                hours="24";
            }



        }

        final String time_24f = (hours+minutes);

        // int int_time_24f = Integer.parseInt(time_24f);

        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/save_avail_time.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                        String incr_final_hrs;

                        String last_avail_time = response.trim();

                        Log.w("Rohit","Timestamp from Server : "+last_avail_time);

                        String am_pm;

                        String am_pm_incr;

                        char hours_index_0 = last_avail_time.charAt(0);
                        char hours_index_1 = last_avail_time.charAt(1);




                        char minute_index_0 = last_avail_time.charAt(2);
                        char minute_index_1 = last_avail_time.charAt(3);

                        //Log.w("Rohit","Final Hrs1 : "+hours_index_0+hours_index_1+ "Mins1 :"+minute_index_0+minute_index_1);


                        String final_hrs = Character.toString(hours_index_0)+ Character.toString(hours_index_1);

                        String final_mins = Character.toString(minute_index_0)+ Character.toString(minute_index_1);



                        int int_final_hrs = Integer.parseInt(final_hrs.trim());

                        int incr_int_final_hrs = int_final_hrs + 01;

                        //Log.w("Rohit", "value : "+incr_int_final_hrs);

                        if(incr_int_final_hrs!=10 && incr_int_final_hrs!=11 && incr_int_final_hrs!=12 )
                        {

                            incr_final_hrs = "0"+Integer.toString(incr_int_final_hrs);

                        }
                        else
                        {
                            incr_final_hrs = Integer.toString(incr_int_final_hrs);
                        }
                        //Log.w("Rohit","Final Hrs2 : "+final_hrs+" Incr Final Hrs :"+incr_final_hrs);

                        am_pm = "AM";
                        am_pm_incr ="AM";



                        if(incr_final_hrs.equals("12"))
                        {
                            am_pm_incr ="PM";
                        }
                        else
                        {

                        }

                        /***************************************/


                        if(final_hrs.equals("12"))
                        {

                            am_pm = "PM";
                            am_pm_incr="PM";

                            incr_final_hrs="01";



                        }


                        else if(final_hrs.equals("13"))
                        {
                            final_hrs="01";

                            am_pm = "PM";

                            incr_final_hrs="02";

                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("14"))
                        {
                            final_hrs="02";
                            am_pm = "PM";

                            incr_final_hrs="03";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("15"))
                        {
                            final_hrs="03";
                            am_pm = "PM";

                            incr_final_hrs="04";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("16"))
                        {
                            final_hrs="04";
                            am_pm = "PM";

                            incr_final_hrs="05";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("17"))
                        {
                            final_hrs="05";
                            am_pm = "PM";

                            incr_final_hrs="06";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("18"))
                        {
                            final_hrs="06";
                            am_pm = "PM";

                            incr_final_hrs="07";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("19"))
                        {
                            final_hrs="07";
                            am_pm = "PM";

                            incr_final_hrs="08";
                            am_pm_incr="PM";

                        }

                        else if(final_hrs.equals("20"))
                        {
                            final_hrs="08";
                            am_pm = "PM";

                            incr_final_hrs="09";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("21"))
                        {
                            final_hrs="09";
                            am_pm = "PM";

                            incr_final_hrs="10";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("22"))
                        {
                            final_hrs="10";
                            am_pm = "PM";

                            incr_final_hrs="11";
                            am_pm_incr="PM";
                        }

                        else if(final_hrs.equals("23"))
                        {
                            final_hrs="11";
                            am_pm = "PM";

                            incr_final_hrs="12";
                            am_pm_incr="AM";
                        }

                        else if(final_hrs.equals("24"))
                        {
                            final_hrs="12";

                            am_pm = "AM";

                            incr_final_hrs="01";
                            am_pm_incr="AM";

                        }


                        last_avail_time_cs.setText(Html.fromHtml("<font color=#1a5276>Yours set challange time : </font>"+"<font color= #145a32><b>"+final_hrs+"</b></font>"+"<font color= #145a32>"+" : "+"</font>"+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm+"</font>"+"<font color=#5dade2<b>"+" to "+"</b></font>"+"<font color= #145a32><b>"+incr_final_hrs+"</b></font>"+" : "+"<font color= #145a32><b>"+final_mins+"</b></font>"+" "+"<font color= #145a32>"+am_pm_incr+"</font>"));


                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(set_challange_time.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("user_emailid",login_user_emailid);

                params.put("save_time",time_24f);

                params.put("subject_name",subject_name);

                return params;
            }
        };

        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);

        MySingleton.getInstance(set_challange_time.this).addToRequestQue(stringRequest);

    }
}
