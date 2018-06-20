package com.example.crazybeam.pkmoney_v7;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by crazybeam on 7/25/2017.
 */


/*


Storing Device Token
Saving Token

    First we will store the generated token in SharedPreferences.
    So, for managing the SharedPreferences we will create a class in Singleton Pattern.
    Create a class named "SharedPrefManager.java" and write the following code.


 */


//---------------------------------------------------------

/*
  Session help you when want to store user data outside your application, so that when
   the next time user use your application, you can easily get back his details and perform
   accordingly.

 This can be done in many ways. But the most easiest and nicest way of doing this is
  through Shared Preferences.

  Shared Preferences

 Shared Preferences allow you to save and retrieve data in the form of key,value pair.
    In order to use shared preferences, you have to call a method getSharedPreferences()
    that returns a SharedPreference instance pointing to the file that contains the values
    of preferences.

 SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

 You can save something in the sharedpreferences by using SharedPreferences.Editor class. You will call the edit method of SharedPreference instance and will receive it in an editor object. Its syntax is −

  Editor editor = sharedpreferences.edit();
  editor.putString("key", "value");
   editor.commit();

*/

public class sharedprefmanager_firebase
{



        private static final String SHARED_PREF_NAME = "FCMSharedPref";
        private static final String KEY_ACCESS_TOKEN = "fcm_token";

        private static sharedprefmanager_firebase mInstance;
        private static Context mCtx;

        private sharedprefmanager_firebase(Context context)
        {
            mCtx = context;
        }

        public static synchronized sharedprefmanager_firebase getInstance(Context context)
        {
            if (mInstance == null) {
                mInstance = new sharedprefmanager_firebase(context);
            }
            return mInstance;
        }

        //this method will save the device token to shared preferences

        public boolean storeToken(String token)
        {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_ACCESS_TOKEN, token);
            editor.apply();
            return true;
        }

        //this method will fetch the device token from shared preferences

        public String getToken()
        {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
           // Log.w("Rohit",TAG_TOKEN);

            return  sharedPreferences.getString(KEY_ACCESS_TOKEN, null); // If token is not available it will return null.


        }





}
