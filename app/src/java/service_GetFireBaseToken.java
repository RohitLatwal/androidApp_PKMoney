package com.example.crazybeam.pkmoney_v7;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by crazybeam on 7/25/2017.
 */

/*

 /*
Generating Device Token

        Every device generates a unique token to receive notifications. And for this we
        have to create a class that will extend the class FirebaseInstanceIdService. This
        part is same as we did in the previous Firebase Cloud Messaging Tutorial.
        So create a class named "getFirebase_Token.java" and write the following code.


*/

public class service_GetFireBaseToken extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";


    // This method is called only when token is changed or newly generated.

    // If you want to call it again for testing purpose then first Clear app data and then
    // uninstall your app



    //@Override
    public void onTokenRefresh()
    {

        //Log.w("Rohit","Firebase ID service class called");
        //Getting registration token

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        //Displaying token on logcat
        //Log.w("Rohit", "Refreshed token: " + refreshedToken);

        //calling the method store token and passing token
        storeToken(refreshedToken);


    }

    private void storeToken(String token)
    {


        //we will save the token in shared preferences later

        //getting token from shared preferences

        sharedprefmanager_firebase.getInstance(getApplicationContext()).storeToken(token);



    }


}
