package com.example.crazybeam.pkmoney_v7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.LightingColorFilter;
import android.os.AsyncTask;
import android.os.RecoverySystem;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.CheckedOutputStream;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by crazybeam on 7/8/2017.
 */

// AsyncTask<Params,Progress,Result>
public class user_registration_background_worker extends AsyncTask<String,Void,String>
{

    Context context;
 AlertDialog ad;




    private HttpURLConnection http_url_connection;

    user_registration_background_worker(Context ctx)
    {

        context = ctx;


    }


    // @Override shows it is an "Abstract method".

    @Override
    protected String doInBackground(String... registration_info) {

        String typeofoperation = registration_info[0];
        String registration_url = "http://wwwpkmoneyin.000webhostapp.com/user_registration.php"; // address of registration.php

        String response = "";


        //  if (typeofoperation.equals("registration")) {

        try
        {


            String user_name = registration_info[1];
            String user_emailid = registration_info[2];
            String user_phonenumber = registration_info[3];
            String user_password1 = registration_info[4];
            //  String user_password2 = registration_info[5];
            String user_state = registration_info[6];
            String user_nationality = registration_info[7];


            URL reg_url = new URL(registration_url);

            HttpURLConnection http_url_connection = (HttpURLConnection) reg_url.openConnection();

            http_url_connection.setReadTimeout(15000);
            http_url_connection.setConnectTimeout(15000);

            http_url_connection.setRequestMethod("POST");

            http_url_connection.setDoOutput(true);

            http_url_connection.setDoInput(true);

            OutputStream os = http_url_connection.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            //URLEncoder.encode(key,value)

            String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                    URLEncoder.encode("user_emailid", "UTF-8") + "=" + URLEncoder.encode(user_emailid, "UTF-8") + "&" +
                    URLEncoder.encode("user_phonenumber", "UTF-8") + "=" + URLEncoder.encode(user_phonenumber, "UTF-8") + "&" +
                    URLEncoder.encode("user_password1", "UTF-8") + "=" + URLEncoder.encode(user_password1, "UTF-8") + "&" +
                    URLEncoder.encode("user_state", "UTF-8") + "=" + URLEncoder.encode(user_state, "UTF-8") + "&" +
                    URLEncoder.encode("user_nationality", "UTF-8") + "=" + URLEncoder.encode(user_nationality, "UTF-8");



            bw.write(post_data);

            bw.flush();

            bw.close();

            os.close();


            // Now once we post some data on server, we must expect some response from server now code to read that response

            int responsecode = http_url_connection.getResponseCode();

            if(responsecode == HttpsURLConnection.HTTP_OK)
            {

                InputStream is = http_url_connection.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                response = br.readLine();

                br.close();
                is.close();
                http_url_connection.disconnect();
            }

            else
            {
                response = "Error during Registration";
            }


        }

        catch (Exception e) // exception handler for "HttpURLConnection"
        {
            e.printStackTrace();
        }


        return response;
    }

    @Override
    protected void onPreExecute()
    {

        // initiate "Alert Dialog" object

   //ad = new AlertDialog.Builder(context).create();


       //ad.setTitle("Registration Status");


    }


    // to show the result in "Dialog Box" we will write code in onPostExecute method
    @Override
    protected void onPostExecute(String response)
    {

       String serverresponse;


   if(response.equals("1"))
    {
        serverresponse="User with same emailid already exist, use different emailid to register.";


    }

       else if(response.equals("2"))
        {
             serverresponse="Congratulation!! You have registered successfully.";

          //  ad.setMessage(serverresponse);
          //  ad.show();
        }
   else if(response.equals("0"))
        {
            serverresponse="Sorry!! Check your internet connection or contact us.";

           // ad.setMessage(serverresponse);
           // ad.show();
        }

        else
   {
       serverresponse="Sorry!! There is some technical error, please contact us.";
   }

  //ad.dismiss();
/*-------------------Code to close dialog box automatically-------------------------------------*/
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Status");

        builder.setMessage(serverresponse);
        builder.setCancelable(true);


        final AlertDialog closedialog= builder.create();

        closedialog.show();

        final Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
          public void run() {
               closedialog.dismiss();

               timer2.cancel(); //this will cancel the timer of the system
           }
        }, 4000); // the timer will count 2 seconds....

/*--------------------------------------------------------*/

    }



    @Override
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);

    }



}

