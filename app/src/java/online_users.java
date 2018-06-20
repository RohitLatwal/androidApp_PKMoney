package com.example.crazybeam.pkmoney_v7;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.net.ssl.HttpsURLConnection;

import static android.R.attr.font;


public class online_users extends AppCompatActivity
{

    String list_of_user_freetime;
    String[] arr_list_of_user_freetime;


    String online_users_names;
    String state_names;
    String usersemailid;

    String[] username_arr;
    String[] userstate_arr;
    String[] emails_arr;

    String login_user_name;

    String login_user_emailid;



  public  ArrayList<String> al_names = new ArrayList<String>();
    public ArrayList<String> al_states = new ArrayList<String>();

    public ArrayList<String> al_emailids = new ArrayList<String>();

    public ArrayList<String> al_list_of_users_free_time = new ArrayList<String>();


    public ListView lv;

    //public ArrayAdapter<String> listAdapter;


   public String subject_code;
    public String subject_name;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_users);

        subject_code = getIntent().getStringExtra("subjectCode_str").toString();




       // Log.w("Rohit","Subject_code"+subject_code);

        if(subject_code.equals("pol01"))
        {

            //setTitle(Html.fromHtml("<font color=#343434>" + "Online Users:" + "</font>"));

            subject_name = "Polity";

            setTitle(Html.fromHtml("<font color = #17202a><b>" + "Online Users : " + "</b></font>"+"<font color =#1b4f72><b>" + "Polity"+"</b></font>"));



        }

       else if(subject_code.equals("geo02"))
        {

            subject_name = "Geography";
            setTitle(Html.fromHtml("<font color = #17202a><b>" + "Online Users : " + "</b></font>"+"<font color =#1b4f72><b>" + "Geography"+"</b></font>"));
        }

        else if(subject_code.equals("mh03"))
        {

            subject_name = "Modern History";
            setTitle(Html.fromHtml("<font color = #17202a><b>" + "Online Users : " + "</b></font>"+"<font color =#1b4f72><b>" + "Modern History"+"</b></font>"));
        }



        else if(subject_code.equals("ca04"))
        {

            subject_name = "Current Affairs";
            setTitle(Html.fromHtml("<font color = #17202a><b>" + "Online Users : " + "</b></font>"+"<font color =#1b4f72><b>" + "Current Affairs"+"</b></font>"));
        }


        else if(subject_code.equals("cs05"))
        {

            subject_name = "Computer Science";
            setTitle(Html.fromHtml("<font color = #17202a><b>" + "Online Users : " + "</b></font>"+"<font color =#1b4f72><b>" + "Computer Science"+"</b></font>"));
        }





        online_users_names = getIntent().getStringExtra("username_str").toString();
        state_names = getIntent().getStringExtra("userstate_str").toString();

       usersemailid = getIntent().getStringExtra("users_emailid").toString();

        username_arr = online_users_names.split(",");

        userstate_arr = state_names.split(",");

        emails_arr = usersemailid.split(",");



       for(int i =0; i<username_arr.length;i++)
       {

           //Adding object in arraylist
           al_names.add(username_arr[i].replaceAll("^\"|\"$", "").toString()); // to remove double quote (")) and whitespace.


       }
       /*

        Iterator itr = al_names.iterator();
        int n = 0;
        while (itr.hasNext())
        {
            Log.w("Rohit", "UserNames"+"("+n+") :" + itr.next());
            n++;
        }

*/
        for(int j =0; j<userstate_arr.length;j++)
        {

            al_states.add(userstate_arr[j].replaceAll("^\"|\"$", "").toString()); // to remove double quote (")) and whitespace.


        }

        /*
        //Traversing list through Iterator
        Iterator itr2 = al_states.iterator();

        while (itr2.hasNext())
        {
            Log.w("Rohit", "Debug2 : " + itr2.next());
        }

        */



        /*
        //Traversing list through Iterator
        Iterator itr3 = al_emailids.iterator();
int m = 0;
        while (itr3.hasNext())
        {
            Log.w("Rohit", "Emailids"+"("+m+") :" + itr3.next());
            m++;
        }

*/

/*********************Now we have all data in our arraylist, now inflate data in List view using Array Adapter *******
 * *******************/


        for(int k =0; k<emails_arr.length;k++)
        {

            al_emailids.add(emails_arr[k].replaceAll("^\"|\"$", "").toString()); // to remove double quote (")) and whitespace.


        }



        list_of_user_freetime = getIntent().getStringExtra("list_of_user_freetime").toString();

        list_of_user_freetime = list_of_user_freetime.replace("[","");

        list_of_user_freetime = list_of_user_freetime.replace("]","");

        arr_list_of_user_freetime = list_of_user_freetime.split(",");


        for(int i =0;i<arr_list_of_user_freetime.length;i++)

        {

           al_list_of_users_free_time.add(arr_list_of_user_freetime[i].replaceAll("^\"|\"$", "").toString()); // to remove double quote (")) and whitespace.

        }



        lv = (ListView) findViewById(R.id.listview);

        final myAdapter   ma = new myAdapter(this, al_names, al_states, al_emailids,subject_code,al_list_of_users_free_time);

        lv.setAdapter(ma);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


               // Toast.makeText(online_users.this,"Hello my Email Id = "+al_emailids.get(position) , Toast.LENGTH_SHORT).show();

                /**********Java program to capitalize first letter of each word in string******/

                StringBuilder sb_name2 = new StringBuilder(ma.getItem(position).length());
                String[] words2 = ma.getItem(position).split("\\ ");


                for (int i = 0; i < words2.length; i++) {
                    sb_name2.append(Character.toUpperCase(words2[i].charAt(0))).append(words2[i].substring(1)).append(" ");

                }


                /**********Ends Java program to capitalize first letter of each word in string******/


                // Toast.makeText(online_users.this,"Hello my Id = "+sb_name2 , Toast.LENGTH_SHORT).show();


                login_user_name = getIntent().getStringExtra("login_username").trim();


             //   Log.w("Rohit","Login User name :"+login_user_name.length());

                /**********Java program to capitalize first letter of each word in string******/


                StringBuilder sb_name3 = new StringBuilder(login_user_name.length());


                String[] words3 = login_user_name.split("\\ ");


                for (int k = 0; k < words3.length; k++)
                 {
                     sb_name3.append(Character.toUpperCase(words3[k].charAt(0))).append(words3[k].substring(1)).append(" ");

                }


               // Log.w("Rohit", "Login User name :" + sb_name3.toString());


                /**********Ends Java program to capitalize first letter of each word in string******/





                login_user_emailid = getIntent().getStringExtra("login_useremailid");


                Intent newactivity = new Intent(online_users.this, give_challange.class);


                newactivity.putExtra("user_name", sb_name2.toString());

                newactivity.putExtra("tabbed_emailid", al_emailids.get(position));


                newactivity.putExtra("subject_str", subject_name);


                // pass data to next activity

                newactivity.putExtra("login_username", sb_name3.toString());
                newactivity.putExtra("login_useremailid", login_user_emailid);

                online_users.this.startActivity(newactivity);

            }


        });


    }

}

/* As we need to fill data in two text veiw and one Image, So when we need to work on more than one
      view in our layout the best way to do is "Layout_Inflater", though it is resource consuming to use "Layout Inflater"
      but it makes code reusable, though we will do optimization upto in 175% in this code so Let's Start.
       */

 class  myAdapter extends  ArrayAdapter<String>
 {

     String default_pic;

     String load_images_url;

     public View row;

     myViewHolder holder;

     Context context;
     ArrayList<String> user_name;

     ArrayList<String> user_state;

     ArrayList<String> users_emailids;

     ArrayList<String> list_of_users_free_time;

     String challange_subject_code;

     String challange_subject;


     String avail_time;
     String avail_time_incr;
     String am_pm_morn = "AM";
     String am_pm_night = "PM";

     public String final_avail_time;

     public String get_free_time;


     public myAdapter(Context c, ArrayList<String> al_names, ArrayList<String> al_states, ArrayList<String> al_emailids, String subject_code,ArrayList<String> al_list_of_users_free_time) {
         super(c, R.layout.my_listview_style, R.id.username, al_names);

         this.context = c;
         this.user_name = al_names;
         this.user_state = al_states;
         this.users_emailids = al_emailids;
         this.challange_subject_code = subject_code;
         this.list_of_users_free_time =al_list_of_users_free_time;


     }



     class myViewHolder {

         /**** To make code 175% faster the best way is to use "ViewHOlder",Let's see how we can use it
          * Steps to create ViewHolder
          *
          * 1. Create a class called View Holder.
          *
          * 2. Create references to your Views.
          *
          * 3. perform findViewbyId initialisation  once in the constructor.
          *
          * 4. We need a view object in the constructor to call findViewById.
          *
          * **/

         ImageView img;
         TextView names;
         TextView states;
         TextView avail_time;


         myViewHolder(View view) {
        /* our purpose is to call "findViewById " only once as creating it everytime while creating new row
            * is very resource consuming as everytime we need to go in depth to see where is our textview or imageview */


             img = (ImageView) view.findViewById(R.id.profilepic);
             names = (TextView) view.findViewById(R.id.username);
             states = (TextView) view.findViewById(R.id.userstate);
             avail_time = (TextView) view.findViewById(R.id.free_time);
         }


     } //myViewHolder class ends.


     @NonNull
     @Override
     public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /* We are doing 150% optimisation, as calling "LayoutInflater" evertime is very resource consuming
            * so what we are doing is - to use "LayoutInflater" only first time itself, for other time
            * we will use already created object i.e say when we scroll up data in app, after scrolling user
            * doesn't see first row data as it get scrolled up, so instead of putting object of first row data in
            * garbage collection we will use that object for displaying new data that we get after scrolling up.
            *
            * In this "convertView" will help us as it get referenece of that unused object.first time it is null
            * so we will use layoutInflater but after that it has referenece.
            * */


         row = convertView;

         if (row == null)  // this condition makes code 150% faster by restricting the call of "LayoutInflater"
         {

        /* LayoutInflater class converts XML object into java objects and then we can modify it as per
           * our requirements */


             LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             //Above step we get reference of LayoutInflater.

        /* in below step we need to give file name that we want to convert from XML to java object as a first
         * parameter and in seecond parameter parent object in our case it is "ListView" which has reference in
          * ViewGroup Parent
          *
          * This layout inflater return java object that we will save in " View " as "row"
          *
          * This "row" contain reference of "RelativeLayout" in our XML file.
          * */

             row = inflater.inflate(R.layout.my_listview_style, parent, false);

             holder = new myViewHolder(row);

             row.setTag(holder); // now we need to store holder object so that we can use it againg so we use "setTag"
             // method to get reference of "holder" object and use it when we need it this will help us to no call
             //findByViewId again and again and this is what optimisation is .


         } else

         {
        /* This "getView" method is for every row i.e whenever any row created this method will automatically called.   */

             holder = (myViewHolder) row.getTag();

         }


/**************no need to use this unoptimised code where we call findViewBuId every time**
 * *************************************/

         //now get text view and imageview using "row" object

         // ImageView iv = (ImageView)row.findViewById(R.id.profilepic);
         // TextView profiler_name = (TextView)row.findViewById(R.id.username);
         // TextView profiler_state = (TextView) row.findViewById(R.id.userstate);


        /*  NO need to use loop for calling value from array, we have "position" parameter in "getView",
         * this "getView" method call for each row for first row its value will be '0' and so on. */

/**************no need to use above block unoptimised code where we call findViewBuId every time**
 * *************************************/


         /**********Java program to capitalize first letter of each word in string******/

         final StringBuilder sb_name = new StringBuilder(user_name.get(position).length());
         String[] words = user_name.get(position).split("\\ ");


         for (int i = 0; i < words.length; i++) {
             sb_name.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1)).append(" ");

         }


         /**********Ends Java program to capitalize first letter of each word in string******/


         /**********Java program to capitalize first letter of each word in string******/

         final StringBuilder sb_state = new StringBuilder(user_state.get(position).length());
         String[] words1 = user_state.get(position).split("\\ ");


         for (int i = 0; i < words1.length; i++) {
             sb_state.append(Character.toUpperCase(words1[i].charAt(0))).append(words1[i].substring(1)).append(" ");

         }


        /*********************************Code to show Users Available time ***************************************/

         String get_free_time=list_of_users_free_time.get(position);



         char free_time_hours_0 = get_free_time.charAt(0);

         char free_time_hours_1 = get_free_time.charAt(1);

         String str = Character.toString(free_time_hours_0).trim() + Character.toString(free_time_hours_1).trim();


         if(str.equals("00"))

         {
             avail_time = "00" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "01" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("01"))

         {
             avail_time = "01" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "02" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("02"))

         {
             avail_time = "02" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "03" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("03"))

         {
             avail_time = "03" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "04" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }
         else if(str.equals("04"))

         {
             avail_time = "04" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "05" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("05"))

         {
             avail_time = "05" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "06" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("06"))

         {
             avail_time = "06" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "07" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("07"))

         {
             avail_time = "07" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "08" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("08"))

         {
             avail_time = "08" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "09" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("09"))

         {
             avail_time = "09" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "10" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("10"))

         {
             avail_time = "10" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "11" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_morn;

         }

         else if(str.equals("11"))

         {
             avail_time = "11" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "12" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_morn + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("12"))

         {
             avail_time = "12" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "01" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("13"))

         {
             avail_time = "01" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "02" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("14"))

         {
             avail_time = "02" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "03" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("15"))

         {
             avail_time = "03" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "04" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("16"))

         {
             avail_time = "04" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "05" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;
         }

         else if(str.equals("17"))

         {
             avail_time = "05" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "06" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;
         }

         else if(str.equals("18"))

         {
             avail_time = "06" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "07" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;
         }

         else if(str.equals("19"))

         {
             avail_time = "07" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "08" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("20"))

         {
             avail_time = "08" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "09" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("21"))

         {
             avail_time = "09" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "10" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("22"))

         {
             avail_time = "10" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "11" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_night;

         }

         else if(str.equals("23"))

         {
             avail_time = "11" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));
             avail_time_incr = "00" + ":" + Character.toString(get_free_time.charAt(2)) + Character.toString(get_free_time.charAt(3));

             final_avail_time = avail_time + " " + am_pm_night + " to " + avail_time_incr + " " + am_pm_morn;

         }

         holder.avail_time.setText("Available Time : "+final_avail_time);

         Log.w("Rohit","Msg  "+final_avail_time);


         /**************************CODE Ends - to show avail time on tab and show in online users tabs****************************************/


        /*
        Code Ends : As we cant't access "Response" String outside the Response method so we are using above
        code trick to show avail time on tab on the basis of emailids.

         */

         load_images_url = "http://wwwpkmoneyin.000webhostapp.com/my_images/"+users_emailids.get(position)+".jpg";

         default_pic = "http://wwwpkmoneyin.000webhostapp.com/my_images/prema@gmail.com.jpg";


// some images are loaded from the disk cache
//  and for the others Picasso shows from the placeholder




         holder.names.setText(sb_name);


         holder.states.setText(sb_state);

         Picasso.with(context).load(load_images_url).error(R.mipmap.default_profile_pic).placeholder(R.mipmap.default_profile_pic).into(holder.img);

         return row;
     }



} //myAdapter class ends.

