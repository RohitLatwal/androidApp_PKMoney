package com.example.crazybeam.pkmoney_v7;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class test_download extends AppCompatActivity {

    DownloadManager downloadManager;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_download);
    }

    public void ondownload(View view)
    {

        String url = "http://wwwpkmoneyin.000webhostapp.com/test_pdf_10.pdf";

        Log.w("Rohit","1");
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        Log.w("Rohit","2");

// only download via WIFI
        //request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);

        Log.w("Rohit","3");
        request.setTitle("Your file is being downloaded........");
        Log.w("Rohit","4");
        //request.setDescription("Downloading a very large zip");

        Log.w("Rohit","5");

// we just want to download silently
        request.setVisibleInDownloadsUi(true);
        Log.w("Rohit","6");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Log.w("Rohit","7");
        request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, "test_pdf_10.pdf");
        Log.w("Rohit","8");

// enqueue this request
        DownloadManager downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);
        Log.w("Rohit","9");
         downloadManager.enqueue(request);

    }



}
