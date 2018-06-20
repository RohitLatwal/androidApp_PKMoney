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
 * Created by crazybeam on 7/22/2017.
 */

public class online_users_background_worker extends AsyncTask<String,Void,String>
{
    Context context;
    String serverresponse;

    String emailids_list_serverresponse;

    String subject_id;
    String line;

    String line_2;

     String username;
    String userstate;
    String useremailid;

    String login_user_name;

    String login_user_emailid;


    private HttpURLConnection http_url_connection;

    online_users_background_worker(Context ctx)
    {

        context = ctx;


    }


    // @Override shows it is an "Abstract method".

    @Override
    protected String doInBackground(String... registration_info) {



        String registration_url = "http://wwwpkmoneyin.000webhostapp.com/fetch_online_users.php"; // address of registration.php



        try
        {

            subject_id = registration_info[0];

            login_user_emailid = registration_info[1];

            login_user_name = registration_info[2];



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

                    URLEncoder.encode("subject_code", "UTF-8") + "=" + URLEncoder.encode(subject_id, "UTF-8")+ "&" +
            URLEncoder.encode("login_useremailid", "UTF-8") + "=" + URLEncoder.encode(login_user_emailid, "UTF-8");

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

                serverresponse = sb.toString();

                br.close();
                is.close();
                http_url_connection.disconnect();            }

            else
            {
                serverresponse = "0";
            }


        }

        catch (Exception e) // exception handler for "HttpURLConnection"
        {
            e.printStackTrace();
        }


        return serverresponse;
    }

    @Override
    protected void onPreExecute()
    {


    }


    // to show the result in "Dialog Box" we will write code in onPostExecute method
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

            userstate = parts[1]; // User stateexample -  ["Delhi","Bihar"]

            useremailid = parts[2]; // list of all emails id - ["abc@gmail.com, aa@gmail.com"]



            // example -  ["Rohit Latwal","raj latwal"]


            username = parts[0].replace("[", "");
            username = username.replace("]", ""); // After this String we have - "Rohit Latwal","raj latwal" .


/***********************************same as above for userstate**********************/

// example -  ["Delhi","Haryana"]

            userstate = parts[1].replace("[", "");
            userstate=  userstate.replace("]", "").trim(); // After this String we have - "Delhi","Bihar" .


/********************************************************************************/

/***********************************same as above for useremailids**********************/

// example -  ["abc@gmail.com, aa@gmail.com"]

            useremailid = parts[2].replace("[", "");
            useremailid=  useremailid.replace("]", "").trim(); // After this String we have - "Delhi","Bihar" .


/********************************************************************************/

// Pass data from backgroundworker to another backgroundworker.

            get_UserFreeTime_BackgroundWorker get_userFreeTime_backgroundWorker = new get_UserFreeTime_BackgroundWorker(context);
            get_userFreeTime_backgroundWorker.execute(username,userstate,useremailid,subject_id,login_user_name,login_user_emailid);


        }


    }


    @Override
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);

    }



}
