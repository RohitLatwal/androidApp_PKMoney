package com.example.crazybeam.pkmoney_v7;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class must_read_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_must_read_page);
    }


    public void onButtonClick(View v)
    {

        if(v.getId() == R.id.btn1)
        {
            Intent i = new Intent(must_read_page.this,login_page.class);


            startActivity(i);
        }

    }

/* Code Ends : Above code is to navigate on new activity on button click */


}
