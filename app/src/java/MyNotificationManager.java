/*


A PendingIntent is a token that you give to a foreign application (e.g. NotificationManager, AlarmManager,
Home Screen AppWidgetManager, or other 3rd party applications), which allows the foreign application to use your
 application's permissions to execute a predefined piece of code.

If you give the foreign application an Intent, and that application sends/broadcasts the Intent you gave, they
will execute the Intent with their own permissions. But if you instead give the foreign application a PendingIntent
 you created using your own permission, that application will execute the contained Intent using your application's
 permission.


 */




package com.example.crazybeam.pkmoney_v7;

/**
 * Created by crazybeam on 7/26/2017.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.text.Html;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyNotificationManager
{

    String remoteMessage;

    public static final int ID_BIG_NOTIFICATION = 234;
    public static final int ID_SMALL_NOTIFICATION = 235;

    private Context mCtx;

    public MyNotificationManager(Context mCtx)
    {
        this.mCtx = mCtx;
    }

    //the method will show a big notification with an image
    //parameters are title for message title, message for message text, url of the big image and an intent that will open
    //when you will tap on the notification


    public void showBigNotification(String title, String message, String url, Intent intent)
    //  it requires "url" as one of its parameter.
    {
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        mCtx,
                        ID_BIG_NOTIFICATION,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();

       bigPictureStyle.setBigContentTitle(title);


       bigPictureStyle.setSummaryText(Html.fromHtml(message).toString());

       bigPictureStyle.bigPicture(getBitmapFromURL(url));

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx);// creating notification
        Notification notification;

        notification = mBuilder.setSmallIcon(R.mipmap.companylogo).setTicker(title).setWhen(0)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .setContentTitle(title)
                .setStyle(bigPictureStyle)
                .setSmallIcon(R.mipmap.companylogo)
                .setLargeIcon(BitmapFactory.decodeResource(mCtx.getResources(), R.mipmap.companylogo))
                .setContentText(message)

                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;
        /*

        |= reads the same way as +=.

notification.defaults |= Notification.DEFAULT_SOUND;

is the same as

notification.defaults = notification.defaults | Notification.DEFAULT_SOUND;

where | is the bit-wise OR operator.


         */

/* Notification manager object to notify user.  */
        NotificationManager notificationManager = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(ID_BIG_NOTIFICATION, notification);
    }


    //the method will show a small notification
    //parameters are title for message title, message for message text and an intent that will open
    //when you will tap on the notification

    public void showSmallNotification(String title, String message, Intent intent)
    {



        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        mCtx,
                        ID_SMALL_NOTIFICATION,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx);
        Notification notification;
        notification = mBuilder.setSmallIcon(R.mipmap.companylogo).setTicker(title).setWhen(0)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.companylogo)
                .setLargeIcon(BitmapFactory.decodeResource(mCtx.getResources(), R.mipmap.companylogo))
                .setContentText(message)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;

        NotificationManager notificationManager = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(ID_SMALL_NOTIFICATION, notification);



    }




    //The method will return Bitmap from an image URL
    private Bitmap getBitmapFromURL(String strURL)
    {
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
