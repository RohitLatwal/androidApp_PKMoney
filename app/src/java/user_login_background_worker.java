package com.example.crazybeam.pkmoney_v7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by crazybeam on 7/11/2017.
 */

public class user_login_background_worker extends AsyncTask<String,Void,String>
{
    Context context;
    String serverresponse;


    String user_emailid;
    String user_password1;

    private HttpURLConnection http_url_connection;

    user_login_background_worker(Context ctx)
    {

        context = ctx;


    }


    // @Override shows it is an "Abstract method".

    @Override
    protected String doInBackground(String... registration_info) {

        String typeofoperation = registration_info[0];
        String registration_url = "http://wwwpkmoneyin.000webhostapp.com/user_login.php"; // address of registration.php

        String response = "";


        //  if (typeofoperation.equals("registration")) {

        try
        {



            user_emailid = registration_info[1];

             user_password1 = registration_info[2];
            //  String user_password2 = registration_info[5];


            /*
            Free cloud messaging Token insertion/updation code.

             */


/*******************steps to create FCM servere TOken



 //SharedPreferences sharedPreferences = this.getSharedPreferences("Mypref_file", Context.MODE_PRIVATE);

 /*
 SharedPreferences.Editor editor = sharedPreferences.edit();
 editor.putString("reg_token", FirebaseInstanceId.getInstance().getToken());
 editor.apply();
 */

       /*delete token
        try {
            FirebaseInstanceId.getInstance().deleteToken("reg_token",FirebaseInstanceId.getInstance().getToken());
        } catch (IOException e) {
            e.printStackTrace();
        }

        */

            String token = sharedprefmanager_firebase.getInstance(context).getToken();

            Log.w("Rohit",token);

            if (token!= null)
            {
                //displaying the token
                //    Log.w("Rohit", "My Token New way - "+token);


            }
            else

            {
                //if token is null that means something wrong or it has already created or remain unchanged
                // Log.w("Rohit", "token is not generated or already there");


            }






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

                    URLEncoder.encode("user_password1", "UTF-8") + "=" + URLEncoder.encode(user_password1, "UTF-8")+ "&" +

            URLEncoder.encode("fcm_token", "UTF-8") + "=" + URLEncoder.encode(token, "UTF-8");

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


    }


    // to show the result in "Dialog Box" we will write code in onPostExecute method
    @Override
    protected void  onPostExecute(String response)
    {


        if(response.equals("11"))

        {


            /*
Purpose of this background worker is to fetch "User Name" and "Balance" of respective user

 */
           // Log.w("Rohit",user_emailid);
            //Log.w("Rohit",user_password1);





            login_landing_background_worker llbw = new  login_landing_background_worker(context);
            llbw.execute( user_emailid, user_password1);



            /************************************************************************/



        }

         else if(response.equals("12"))

        {


        /*-------------------Code to close dialog box automatically-------------------------------------*/
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Status");
            builder.setMessage("There is some technical error. Please contact us.");
            builder.setCancelable(true);

            final AlertDialog closedialog = builder.create();

            closedialog.show();

            final Timer timer2 = new Timer();
            timer2.schedule(new TimerTask() {
                public void run() {
                    closedialog.dismiss();
                    timer2.cancel(); //this will cancel the timer of the system
                }
            }, 4000); // the timer will count 1 seconds....

/*--------------------------------------------------------*/


        }

        else if(response.equals("0"))

        {

             /*-------------------Code to close dialog box automatically-------------------------------------*/
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Status");
            builder.setMessage("Either incorrect emailid/password or you are not a register user, please register first !!");
            builder.setCancelable(true);

            final AlertDialog closedialog = builder.create();

            closedialog.show();

            final Timer timer2 = new Timer();
            timer2.schedule(new TimerTask() {
                public void run() {
                    closedialog.dismiss();
                    timer2.cancel(); //this will cancel the timer of the system
                }
            }, 4000); // the timer will count 1 seconds....

/*--------------------------------------------------------*/

        }


    }


    @Override
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);

    }



}
