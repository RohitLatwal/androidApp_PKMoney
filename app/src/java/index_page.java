package com.example.crazybeam.pkmoney_v7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class index_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

         /* Code Starts : following code is to display Logo in Actionbar */

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.companylogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /* Code Ends : Above code is to display Logo in Actionbar */


        setContentView(R.layout.activity_index_page);

      // Log.w("Rohit","onCreatee was called");


    }


    /* Code Starts : following code is to display "Arrow" Button on index Page
    "ActionBar " */

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi = getMenuInflater(); // to provide memory.
        mi.inflate(R.menu.indexpage_actionbar_button,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Code Ends : Above code is to display "Arrow" Button on index Page
    "ActionBar " */


        /* Code Starts : following code is to navigate on new "Activity" using Menu Item,
        When "button" add to "ActionBar" it become MenuItem, So we use this method
          * */

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if(item.getItemId()==R.id.indexpage_actionbar_button)

        {

            Intent i = new Intent(index_page.this,must_read_page.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }


        /* Code Ends : Above code is to navigate on new "Activity" using Menu Item,
        When "button" add to "ActionBar" it become MenuItem, So we use this method
          * */

}





