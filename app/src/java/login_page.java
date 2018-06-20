package com.example.crazybeam.pkmoney_v7;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class login_page extends AppCompatActivity
{
    EditText user_emailidET,  user_password1ET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);



        user_emailidET = (EditText) findViewById(R.id.editText1);

        user_password1ET = (EditText) findViewById(R.id.editText2);


    }


    /* Code Starts : following code makes text clickable and we can navigate to next activity */

    public void onTextClick(View v) {


        if (v.getId() == R.id.newuser1) {
            Intent i = new Intent(login_page.this, register_user.class);
            startActivity(i);
        }

/* Code Ends : Above code makes text clickable and we can navigate to next activity */


    }

    /* Code Starts : following code makes text clickable and we can navigate to next activity */

    public void onTextClick2(View v) {


        if (v.getId() == R.id.recover_password) {
            Intent i = new Intent(login_page.this, recover_password.class);
            startActivity(i);
        }

/* Code Ends : Above code makes text clickable and we can navigate to next activity */


    }


    //AlertDialog ad;
    // Context context;


// when we click on Registration button this function will call


    public void onLogin(View view)
    {


        String user_emailid = user_emailidET.getText().toString();

        String user_password1 = user_password1ET.getText().toString();

        String typeofoperation = "user_login";


        if(user_emailid.equals(""))
        {

            user_emailidET = (EditText) findViewById(R.id.editText1);
            user_emailidET.requestFocus(R.id.editText1);
            Toast toast =  Toast.makeText(this,"Please, enter email id.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_emailid.length()>50)
        {
            user_emailidET = (EditText) findViewById(R.id.editText1);
            user_emailidET.requestFocus(R.id.editText1);
            Toast toast =  Toast.makeText(this,"email id exceeds 50 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }



        else if(user_password1.equals(""))
        {

            user_password1ET = (EditText) findViewById(R.id.editText2);
            user_password1ET.requestFocus(R.id.editText2);
            Toast toast =  Toast.makeText(this,"Please, enter password.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_password1.length()<8)
        {
            user_password1ET = (EditText) findViewById(R.id.editText2);
            user_password1ET.requestFocus(R.id.editText2);
            Toast toast =  Toast.makeText(this,"Password can't be less than 8 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

        else if(user_password1.length()>20)
        {
            user_password1ET = (EditText) findViewById(R.id.editText2);
            user_password1ET.requestFocus(R.id.editText2);
            Toast toast =  Toast.makeText(this,"Password exceeds 20 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }




      else {

            // background_processor class for connecting "Android" device from "MySql Database.


        /*-------------------Code to close dialog box automatically-------------------------------------*/
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Processing...");
            builder.setMessage("Please Wait...");
            builder.setCancelable(true);

            final AlertDialog closedialog = builder.create();

            closedialog.show();

            final Timer timer2 = new Timer();
            timer2.schedule(new TimerTask() {
                public void run() {
                    closedialog.dismiss();
                    timer2.cancel(); //this will cancel the timer of the system
                }
            }, 10000); // the timer will count 1 seconds....

/*
Purpose of this background worker is to validate login details and reedirect user to
"Account details" page

 */





            user_login_background_worker urlbw = new user_login_background_worker(this);
            urlbw.execute(typeofoperation, user_emailid, user_password1);

        }



        }


}





