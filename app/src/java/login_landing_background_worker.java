package com.example.crazybeam.pkmoney_v7;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

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
 * Created by crazybeam on 7/21/2017.
 */

public class login_landing_background_worker extends AsyncTask<String,Void,String>
{
    Context context;
    String serverresponse;


    String user_emailid;
    String user_password1;
    String line;
    String username;
    String userbalance;

    private HttpURLConnection http_url_connection;

    login_landing_background_worker(Context ctx)
    {

        context = ctx;


    }


    // @Override shows it is an "Abstract method".

    @Override
    protected String doInBackground(String... registration_info) {


        String registration_url = "http://wwwpkmoneyin.000webhostapp.com/user_profile.php"; // address of registration.php

        String response = "";



        try
        {



            user_emailid = registration_info[0];

            user_password1 = registration_info[1];



            //Log.w("Rohit","Next Session 1"+user_emailid);
            //Log.w("Rohit","Next Session 2"+user_password1);

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

                            URLEncoder.encode("user_password1", "UTF-8") + "=" + URLEncoder.encode(user_password1, "UTF-8");



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

                StringBuilder sb = new StringBuilder();
                while((line = br.readLine())!=null)
                {
                    sb.append(line+"\n");

                    /*We will get data in form of javascript object i.e
                    ["Rohit Latwal","raj latwal"]:["0","0"]   */

                }

                // use toString to get data into the result.

                response = sb.toString();

                br.close();
                is.close();
                http_url_connection.disconnect();


            }

            else
            {
                response = "0";
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


    @Override
    protected void  onPostExecute(String response)
    {

  if(response.equals("0"))
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


  else

  {

      String[] parts = response.split(":");

      username = parts[0];  // User name example -  ["Rohit Latwal","raj latwal"]

      userbalance = parts[1]; // User Balance example -  ["0","0"]

      // example -  ["Rohit Latwal","raj latwal"]

      username = parts[0].replace("[", "");
      username = username.replace("]", ""); // After this String we have - "Rohit Latwal","raj latwal"

     // String[] username_array = username.split(",");


/***********************************same as above for userbalance**********************/

// example -  ["Rohit Latwal","raj latwal"]

      userbalance = parts[1].replace("[", "");
      userbalance = userbalance.replace("]", ""); // After this String we have - "Rohit Latwal","raj latwal"

    //  String[] userbalance_array = userbalance.split(",");



/********************************************************************************/





       Intent intent = new Intent(context, login_landing_page.class);

      //Log.w("Rohit",user_emailid);
      //Log.w("Rohit",user_password1);

      // Pass data to "login_landing_page"

      /*

      intent.putExtra("username_array",username_array);
      intent.putExtra("userbalance_array",userbalance_array);
*/

      intent.putExtra("username",username);
      intent.putExtra("userbalance",userbalance);
      intent.putExtra("emailid",user_emailid);

      context.startActivity( intent);
  }

    }


    @Override
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);

    }
}
