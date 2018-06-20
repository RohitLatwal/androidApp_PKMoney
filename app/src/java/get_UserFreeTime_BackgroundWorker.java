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
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by crazybeam on 8/11/2017.
 */

public class get_UserFreeTime_BackgroundWorker extends AsyncTask<String,Void,String>
{

String challange_subject;
    Context context;
    String serverresponse;

    String emailids_list_serverresponse;


    String line;

    String list_of_user_freetime;

    String list_username;
    String list_userstate;
    String list_useremailid;

    String login_user_name;

    String login_user_emailid;

    String[] emails_arr;

    public ArrayList<String> al_emailids = new ArrayList<String>();

   String subject_code;

    get_UserFreeTime_BackgroundWorker(Context ctx)
    {

        context = ctx;


    }


    // @Override shows it is an "Abstract method".

    @Override
    protected String doInBackground(String... registration_info)
    {

        //String url = "http://wwwpkmoneyin.000webhostapp.com/get_avail_time.php";

        String url = "http://wwwpkmoneyin.000webhostapp.com/get_avail_time.php";

        list_username = registration_info[0];

            list_userstate = registration_info[1];


            list_useremailid = registration_info[2];


/***************************************************************/
        subject_code = registration_info[3].trim();

        login_user_name = registration_info[4].trim();

        login_user_emailid = registration_info[5].trim();





        if (subject_code.equals("pol01"))
        {
            challange_subject = "polity";
        }
        else if (subject_code.equals("geo02"))
        {

            challange_subject = "geography";
        }
        else if (subject_code.equals("mh03"))
        {

            challange_subject = "history";
        }
        else if (subject_code.equals("ca04"))
        {

            challange_subject = "current_affairs";


        }
        else if (subject_code.equals("cs05"))
        {

            challange_subject = "computer_science";

        }

/***************************************************************/

            emails_arr = list_useremailid.split(","); //list of email_ids excluding login username.



/*********************Now we have all data in our arraylist, now inflate data in List view using Array Adapter *******
 * *******************/


            for (int k = 0; k < emails_arr.length; k++) {



              //al_emailids.add(emails_arr[k].replaceAll("^\"|\"$", "").toString().trim()); // to remove double quote (")) and whitespace.

                emails_arr[k] = emails_arr[k].replaceAll("^\"|\"$", "").toString().trim();

            }

       // StringBuilder sb_name = new StringBuilder(al_emailids.get(position).length())


        try
        {



            URL reg_url = new URL(url);

            HttpURLConnection http_url_connection = (HttpURLConnection) reg_url.openConnection();

            http_url_connection.setReadTimeout(15000);
            http_url_connection.setConnectTimeout(15000);

            http_url_connection.setRequestMethod("POST");

            http_url_connection.setDoOutput(true);

            http_url_connection.setDoInput(true);

            OutputStream os = http_url_connection.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            //URLEncoder.encode(key,value)

            //convert array to string i.e "user_emailid" array to String.
        String post_data =

               URLEncoder.encode("subject_name", "UTF-8") + "=" + URLEncoder.encode(challange_subject.trim(), "UTF-8") + "&" +

                      URLEncoder.encode("user_emailid", "UTF-8") + "=" + URLEncoder.encode(java.util.Arrays.toString(emails_arr), "UTF-8");

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

            //    Log.w("Rohit","My Server Response :"+serverresponse);



                br.close();
                is.close();
                http_url_connection.disconnect();
            }

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

        list_of_user_freetime = response;


        //Log.w("Rohit","Login User name :"+login_user_name);

        //Log.w("Rohit","Login User emailid :"+login_user_emailid);

       //Log.w("Rohit","User Name :"+list_username);

        //Log.w("Rohit","User State :"+list_userstate);

        //Log.w("Rohit","Subject Code :"+subject_code);

        //Log.w("Rohit","User Emailids :"+list_useremailid);

        //Log.w("Rohit","User Free Time :"+list_of_user_freetime);




            Intent intent = new Intent(context, online_users.class);


            /*****Pass data to "online_users_page"*********/



            intent.putExtra("username_str",list_username); // these are list of users
            intent.putExtra("userstate_str",list_userstate); // these are list of objects

            intent.putExtra("subjectCode_str",subject_code);

            intent.putExtra("login_useremailid",login_user_emailid.trim());
            intent.putExtra("login_username",login_user_name.trim());

            intent.putExtra("users_emailid",list_useremailid); // this will contain list of all emailid of users online for respective users.

        intent.putExtra("list_of_user_freetime",list_of_user_freetime.toString());

            context.startActivity( intent);





    }


    @Override
    protected void onProgressUpdate(Void... values)
    {
        super.onProgressUpdate(values);

    }



}



