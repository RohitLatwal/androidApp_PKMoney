package com.example.crazybeam.pkmoney_v7;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by crazybeam on 7/25/2017.
 */

/*

Creating Messaging Service

    We have the device token, now we need one more class that will extend
    FirebaseMessagingService, this class will actually receive the notification.
    So create a new class named MyFirebaseMessagingService.java and write the
    following code.


 */



public class service_myFireBaseMessaging extends FirebaseMessagingService
{


    /*


    In the below code onMessageReceived(RemoteMessage remoteMessage)
    method will be called when the message is received by the push notification.

     */
    String myCustomKey;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {



        /*

        Firebase has three message types:

Notification messages : Notification message works on background or foreground. When app is in background,
Notification messages are delivered to the system tray. If the app is in the foreground, messages are handled by
onMessageReceived() or didReceiveRemoteNotification callbacks. These are essentially what is referred to as Display
messages.

Data messages: On Android platform, data message can work on background and foreground. The data message will be handled
 by onMessageReceived(). A platform specific note here would be: On Android, the data payload can be retrieved in the
 Intent used to launch your activity. To elaborate, if you have "click_action":"launch_Activity_1", you can retrieve
 this intent through getIntent() from only Activity_1.

Messages with both notification and data payloads: When in the background, apps receive the notification payload in
 the notification tray, and only handle the data payload when the user taps on the notification. When in the foreground,
  your app receives a message object with both payloads available. Secondly, the click_action parameter is often used in
  notification payload and not in data payload. If used inside data payload, this parameter would be treated as custom
  key-value pair and therefore you would need to implement custom logic for it to work as intended.


         */

        /*

        Remove notification payload completely from your server request. Send only data and handle it in onMessageReceived(),
            otherwise your onMessageReceived will not be triggered when the app is in background or killed.

        */

        Object obj = remoteMessage.getData().get("body");
        if (obj != null) {
            myCustomKey = obj.toString();

            Log.w("Rohit","custom data :"+myCustomKey);
        }

        // Manage data
        /*

        This method will be called only when application is in foreground.

         */

        /*


    In the below code onMessageReceived(RemoteMessage remoteMessage)
    method will be called when the message is received by the push notification.

     */


/*
If the application is in the foreground handle both data and notification message here.
Also if you intend on generating  your own notifications as a result of  a received FCM message,
here is where that should be initiated.

 */


    notifyuser(remoteMessage.getFrom(),obj.toString());    //remoteMessage.getNotification().getBody());

    }

    public void notifyuser(String from,String notification)
    {

        MyNotificationManager mynotificationmanager = new MyNotificationManager(getApplicationContext());

        mynotificationmanager.showSmallNotification("PkMoney Message",notification,new Intent(getApplicationContext(),index_page.class));
    }
}

