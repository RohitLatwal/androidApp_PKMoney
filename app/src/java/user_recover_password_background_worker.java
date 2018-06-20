package com.example.crazybeam.pkmoney_v7;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by crazybeam on 7/11/2017.
 */

public class user_recover_password_background_worker extends AsyncTask<String,Void,String>
{


    Context context;
    AlertDialog ad;




    private HttpURLConnection http_url_connection;

    user_recover_password_background_worker(Context ctx)
    {

        context = ctx;


    }


    // @Override shows it is an "Abstract method".

    @Override
    protected String doInBackground(String... registration_info) {

        String typeofoperation = registration_info[0];
        String registration_url = "http://wwwpkmoneyin.000webhostapp.com/password_recovery_mail.php"; // address of registration.php

        String response = "";


        //  if (typeofoperation.equals("registration")) {

        try
        {


            String user_emailid = registration_info[1];
            String user_phonenumber = registration_info[2];


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

            String post_data =
                    URLEncoder.encode("user_emailid", "UTF-8") + "=" + URLEncoder.encode(user_emailid, "UTF-8") + "&" +
                    URLEncoder.encode("user_phonenumber", "UTF-8") + "=" + URLEncoder.encode(user_phonenumber, "UTF-8");


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
                response = "Error during password recovery";
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



    }


    // to show the result in "Dialog Box" we will write code in onPostExecute method
    @Override
    protected void onPostExecute(String response)
    {

        String serverresponse;


        if(response.equals("1"))
        {
            serverresponse="Thanks,we will sent your new password through mail within 24hrs.";


        }


        else
        {
            serverresponse="Sorry!! Check your internet connection or Mail us at support@gmail.com";

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
