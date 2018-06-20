package com.example.crazybeam.pkmoney_v7;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class recover_password extends AppCompatActivity {


    EditText user_emailidET, user_phonenumberET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        user_emailidET = (EditText) findViewById(R.id.recover_emailid);
        user_phonenumberET = (EditText) findViewById(R.id.recover_mobilenumber);

    }

// when we click on Registration button this function will call


    public void onRecoverPassword(View v)
    {

        String user_emailid = user_emailidET.getText().toString();
        String user_phonenumber = user_phonenumberET.getText().toString();


        String typeofoperation = "recover_password";



      if(user_emailid.equals(""))
        {

            user_emailidET = (EditText) findViewById(R.id.recover_emailid);
            user_emailidET.requestFocus(R.id.recover_emailid);
            Toast toast =  Toast.makeText(this,"Please, enter email id.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_emailid.length()>50)
        {
            user_emailidET = (EditText) findViewById(R.id.recover_emailid);
            user_emailidET.requestFocus(R.id.recover_emailid);
            Toast toast =  Toast.makeText(this,"email id exceeds 50 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }


        else if(user_phonenumber.equals(""))
        {

           user_phonenumberET = (EditText) findViewById(R.id.recover_mobilenumber);
            user_phonenumberET.requestFocus(R.id.recover_mobilenumber);
            Toast toast =  Toast.makeText(this,"Please, enter mobile number.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_phonenumber.length()>10)
        {
            user_phonenumberET = (EditText) findViewById(R.id.recover_mobilenumber);
            user_phonenumberET.requestFocus(R.id.recover_mobilenumber);
            Toast toast =  Toast.makeText(this,"mobile number exceeds 10 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

        else
      {

            // background_processor class for connecting "Android" device from "MySql Database.


            //ad = new AlertDialog.Builder(this).create();

            //ad.setTitle("Registering...");
            // ad.setMessage("Please wait...");
            //ad.show();


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
            }, 3000); // the timer will count 1 seconds....

/*--------------------------------------------------------*/


          user_recover_password_background_worker urpbw = new user_recover_password_background_worker(this);
            urpbw.execute(typeofoperation,user_emailid, user_phonenumber);

        }



    }



}
