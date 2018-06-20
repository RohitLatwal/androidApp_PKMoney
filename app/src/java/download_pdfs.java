package com.example.crazybeam.pkmoney_v7;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class download_pdfs extends AppCompatActivity
{

    public ArrayList<String> al_subject_code = new ArrayList<String>();

    public ArrayList<String> al_link_name = new ArrayList<String>();

    public ArrayList<String> al_download_url = new ArrayList<String>();

   public String subject_id;

    public  String user_balance;

   static int balance;


    ListView lv;

    DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_pdfs);
        setTitle(Html.fromHtml("<font color = #566573><b>" + "Polity PDFs" + "</b></font>"));

        user_balance = getIntent().getStringExtra("bal");

        subject_id = getIntent().getStringExtra("sub_id");




        balance = Integer.parseInt(user_balance);


        /*************Get data from table*********************/

       getdownload_files_detail(subject_id,balance);



    }


    public  void getdownload_files_detail(final String sub_id,int balance)
    {


        //Log.w("Rohit","subjeect id : "+sub_id);

        //Log.w("Rohit","balance : "+balance);

        /***************CODE for DB work through VOlley*********************/

        String url ="http://wwwpkmoneyin.000webhostapp.com/load_pdfs.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                      //Log.w("Rohit","Pdfs list : "+response);

                        String parts[] = response.split(":");

                        String link_names_list =  parts[0]; // list of linlk_names


                        String urls_list =  parts[1]; // list of urls

                       String temp_str = link_names_list.replace("[","");

                        link_names_list=temp_str.replace("]","");

                        String link_names_list_arr[] = link_names_list.split(",");

                        for(int i = 0 ; i<link_names_list_arr.length;i++)

                        {
                            al_link_name.add(link_names_list_arr[i].replaceAll("^\"|\"$", "").trim());


                        }

/*
        //Traversing list through Iterator
        Iterator itr2 = al_link_name.iterator();

        while (itr2.hasNext())
        {
            Log.w("Rohit", "link_names : " + itr2.next());
        }
*/

/********************now list all urls in arraylist***************************/


                        String temp_str_2 = urls_list.replace("[","");

                        urls_list=temp_str_2.replace("]","");

                        String urls_list_arr[] = urls_list.split(",");

                        for(int i = 0 ; i<urls_list_arr.length;i++)

                        {
                            al_download_url.add(urls_list_arr[i].replaceAll("^\"|\"$", "").trim());


                            // to remove backslash in string replace("\\ ","")
                        }

/*
                        //Traversing list through Iterator
                        Iterator itr3 = al_download_url.iterator();

                        while (itr3.hasNext())
                        {
                            Log.w("Rohit", "URL : " + itr3.next());
                        }
*/

/******************Now we have data now put this data in view***************************************/

                        lv = (ListView) findViewById(R.id.listview);

                        final  myPdfAdapter mpa = new myPdfAdapter(download_pdfs.this,al_link_name);

                        lv.setAdapter(mpa);



                        /*************onclicklistener codes starts here*************************/


                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()

                        {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
                            {

/***********code for starting download on clicking items********************/


                                String url = "http://wwwpkmoneyin.000webhostapp.com/My_Pdfs/"+al_download_url.get(position);

                             // Log.w("Rohit",url);

                                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

                               // Log.w("Rohit","2");

                             // only download via WIFI
                               // request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE);

                               // Log.w("Rohit","3");

                                request.setTitle(al_link_name.get(position));

                                //Log.w("Rohit","4");
                                //request.setDescription("Downloading a very large zip");

                              //  Log.w("Rohit","5");


                                request.setVisibleInDownloadsUi(true);

                            //    Log.w("Rohit","6");

                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                                //Log.w("Rohit","7");

                                request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, al_link_name.get(position));

                                //Log.w("Rohit","8");

// enqueue this request
                                 downloadManager = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

                               // Log.w("Rohit","9");

                                downloadManager.enqueue(request);


/***********code Ends for starting download on clicking items********************/


                            }


                        });




                        /*******onclicklistener codes ends here ***************************/


                    }


                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();

                        Toast t2 = Toast.makeText(download_pdfs.this,error_Str,Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                //Log.w("Rohit","subjeect id : "+sub_id);

                params.put("sub_id",sub_id);

                return params;
            }
        };

        int socketTimeout = 20000; // 30 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);

        MySingleton.getInstance(download_pdfs.this).addToRequestQue(stringRequest);



    }


}


/* As we need to fill data in two text veiw and one Image, So when we need to work on more than one
      view in our layout the best way to do is "Layout_Inflater", though it is resource consuming to use "Layout Inflater"
      but it makes code reusable, though we will do optimization upto in 175% in this code so Let's Start.
       */

class  myPdfAdapter extends ArrayAdapter<String>
{

    Context context;
    ArrayList<String> al_linkNames;



    public myPdfAdapter(Context c,ArrayList<String> al_link_names)
    {
        super(c, R.layout.my_listview_style,R.id.username,al_link_names);

        this.context = c;
        this.al_linkNames = al_link_names;



    }


    class myPdfsViewHolder
    {

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
        TextView link_names;




        myPdfsViewHolder(View view)
        {
        /* our purpose is to call "findViewById " only once as creating it everytime while creating new row
            * is very resource consuming as everytime we need to go in depth to see where is our textview or imageview */


            img = (ImageView) view.findViewById(R.id.img_pdf);
            link_names = (TextView) view.findViewById(R.id.username);

        }


    } //myViewHolder class ends.


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        /* We are doing 150% optimisation, as calling "LayoutInflater" evertime is very resource consuming
            * so what we are doing is - to use "LayoutInflater" only first time itself, for other time
            * we will use already created object i.e say when we scroll up data in app, after scrolling user
            * doesn't see first row data as it get scrolled up, so instead of putting object of first row data in
            * garbage collection we will use that object for displaying new data that we get after scrolling up.
            *
            * In this "convertView" will help us as it get referenece of that unused object.first time it is null
            * so we will use layoutInflater but after that it has referenece.
            * */

        View row = convertView;
        myPdfsViewHolder holder = null;

        if(row==null)  // this condition makes code 150% faster by restricting the call of "LayoutInflater"
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

            row = inflater.inflate(R.layout.listview_download_pdfs, parent, false);

            holder = new myPdfsViewHolder(row);

            row.setTag(holder); // now we need to store holder object so that we can use it againg so we use "setTag"
            // method to get reference of "holder" object and use it when we need it this will help us to no call
            //findByViewId again and again and this is what optimisation is .


        }

        else

        {
        /* This "getView" method is for every row i.e whenever any row created this method will automatically called.   */

            holder = (myPdfsViewHolder) row.getTag();

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

        StringBuilder sb_name = new StringBuilder(al_linkNames.get(position).length());
        String[] words = al_linkNames.get(position).split("\\ ");


        for (int i = 0; i < words.length; i++) {
            sb_name.append(Character.toUpperCase(words[i].charAt(0))).append(words[i].substring(1)).append(" ");

        }


        /**********Ends Java program to capitalize first letter of each word in string******/


        holder.link_names.setText(sb_name);


        return row;



    }



} //myAdapter class ends.




