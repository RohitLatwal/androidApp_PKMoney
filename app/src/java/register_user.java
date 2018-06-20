package com.example.crazybeam.pkmoney_v7;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class register_user extends AppCompatActivity
{

    //declaring "EditText Class objects"

    EditText user_nameET,user_emailidET, user_phonenumberET, user_password1ET, user_password2ET,user_stateET, user_nationalityET;
    Button register_btn;


    //AlertDialog ad;
  // Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

       user_nameET = (EditText) findViewById(R.id.user_name);
        user_emailidET = (EditText) findViewById(R.id.user_emailid);
        user_phonenumberET = (EditText) findViewById(R.id.user_phonenumber);
        user_password1ET = (EditText) findViewById(R.id.user_password1);
        user_password2ET = (EditText) findViewById(R.id.user_password2);
        user_stateET = (EditText) findViewById(R.id.user_state);
        user_nationalityET = (EditText) findViewById(R.id.user_nationality);

        register_btn = (Button)findViewById(R.id.register);

        register_btn.setText("Register");

    }

// when we click on Registration button this function will call




    public void onRegistration(View v)
    {

        String user_name = user_nameET.getText().toString();
        String user_emailid = user_emailidET.getText().toString();
        String user_phonenumber = user_phonenumberET.getText().toString();
        String user_password1 = user_password1ET.getText().toString();
        String user_password2 = user_password2ET.getText().toString();
        String user_state = user_stateET.getText().toString();
        String user_nationality = user_nationalityET.getText().toString();


        String typeofoperation = "registration";



        if(user_name.equals(""))
        {

            user_nameET = (EditText) findViewById(R.id.user_name);
            user_nameET.requestFocus(R.id.user_name);
           Toast toast =  Toast.makeText(this,"Please, enter user name.", Toast.LENGTH_LONG);
             toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();

        }
        else if(user_name.length()>50)
        {
            user_nameET = (EditText) findViewById(R.id.user_name);
            user_nameET.requestFocus(R.id.user_name);
            Toast toast =  Toast.makeText(this,"User name exceeds 50 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

        else if(user_emailid.equals(""))
        {

            user_emailidET = (EditText) findViewById(R.id.user_emailid);
            user_emailidET.requestFocus(R.id.user_emailid);
            Toast toast =  Toast.makeText(this,"Please, enter email id.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_emailid.length()>50)
        {
            user_emailidET = (EditText) findViewById(R.id.user_emailid);
            user_emailidET.requestFocus(R.id.user_emailid);
            Toast toast =  Toast.makeText(this,"email id exceeds 50 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }


        else if(user_phonenumber.equals(""))
        {

            user_phonenumberET = (EditText) findViewById(R.id.user_phonenumber);
            user_phonenumberET.requestFocus(R.id.user_phonenumber);
            Toast toast =  Toast.makeText(this,"Please, enter mobile number.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_phonenumber.length()>10)
        {
            user_phonenumberET = (EditText) findViewById(R.id.user_phonenumber);
            user_phonenumberET.requestFocus(R.id.user_phonenumber);
            Toast toast =  Toast.makeText(this,"mobile number exceeds 10 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

        else if(user_password1.equals(""))
        {

            user_password1ET = (EditText) findViewById(R.id.user_password1);
            user_password1ET.requestFocus(R.id.user_password1);
            Toast toast =  Toast.makeText(this,"Please, enter password.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_password1.length()<8)
        {
            user_password1ET = (EditText) findViewById(R.id.user_password1);
            user_password1ET.requestFocus(R.id.user_password1);
            Toast toast =  Toast.makeText(this,"Password can't be less than 8 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

        else if(user_password1.length()>20)
        {
            user_password1ET = (EditText) findViewById(R.id.user_password1);
            user_password1ET.requestFocus(R.id.user_password1);
            Toast toast =  Toast.makeText(this,"Password exceeds 20 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

        else if(user_state.equals(""))
        {

            user_stateET = (EditText) findViewById(R.id.user_state);
            user_stateET.requestFocus(R.id.user_state);
            Toast toast =  Toast.makeText(this,"Please, enter state.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_state.length()>20)
        {
            user_stateET = (EditText) findViewById(R.id.user_state);
            user_stateET.requestFocus(R.id.user_state);
            Toast toast =  Toast.makeText(this,"State exceeds 20 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

        else if(user_nationality.equals(""))
        {

            user_nationalityET = (EditText) findViewById(R.id.user_nationality);
            user_nationalityET.requestFocus(R.id.user_nationality);
            Toast toast =  Toast.makeText(this,"Please, enter nationality.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();


        }
        else if(user_nationality.length()>20)
        {
            user_nationalityET = (EditText) findViewById(R.id.user_nationality);
            user_nationalityET.requestFocus(R.id.user_nationality);
            Toast toast =  Toast.makeText(this,"Nationality exceeds 20 characters.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

        else if(user_password1.equals(user_password2))
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


            user_registration_background_worker urbw = new user_registration_background_worker(this);
            urbw.execute(typeofoperation, user_name, user_emailid, user_phonenumber, user_password1, user_password2, user_state, user_nationality);

        }

        else
        {
            user_password2ET = (EditText) findViewById(R.id.user_password2);
            user_password2ET.requestFocus(R.id.user_password2);
            Toast toast =  Toast.makeText(this,"Passwords do not match.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();
        }

    }


}
