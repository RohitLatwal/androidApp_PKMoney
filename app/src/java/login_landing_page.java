package com.example.crazybeam.pkmoney_v7;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import static com.example.crazybeam.pkmoney_v7.R.id.checkbox;
import static com.example.crazybeam.pkmoney_v7.R.id.user_emailid;

public class login_landing_page extends AppCompatActivity
{

    public Bitmap bitmap;

    public   Bitmap rotatedbitmap;

    Bitmap resizedBitmap;

    private final  int IMG_REQUEST=1;

    public ImageView chooseprofilepic;


    TextView tvlogin_username, tvlogin_userbalance;
    String login_user_name;
    String login_user_balance;
    int balance;

CheckBox cbPolity;
    CheckBox cbGeography;
    CheckBox cbMhistory;
    CheckBox cbCA;
    CheckBox cbProgramming;

    String subject_id;

    String user_emailid;

    String[] getfreetime_emailids_arr;
    public ArrayList<String> al_getfreetime_emailids = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_landing_page);
        setTitle(Html.fromHtml("<font color = #566573><b>" + "Dashboard " + "</b></font>"));

        chooseprofilepic = (ImageView)findViewById(R.id.profile_pic);


        /**********Get Data from "Login_landing_background_worker activity"*****************/

       // String[] login_user_name = getIntent().getStringArrayExtra("username_array");

         login_user_name = getIntent().getStringExtra("username");

       login_user_balance = getIntent().getStringExtra("userbalance");

        user_emailid = getIntent().getStringExtra("emailid"); // this is login user emailid

        //String[] login_user_password = getIntent().getStringArrayExtra("userbalance_array");

        login_user_name = login_user_name.replaceAll("^\"|\"$", ""); /* String contain double quotes ("), to remove this we have used

        "replaceall()" with special pattern for replacing double quote i.e (^"|"$)
        */




        /**********Java program to capitalize first letter of each word in string******/


        StringBuilder sb_name = new StringBuilder(login_user_name.length());


        String[] words = login_user_name.split("\\ ");


        for (int k = 0; k < words.length; k++)
        {
            sb_name.append(Character.toUpperCase(words[k].charAt(0))).append(words[k].substring(1)).append(" ");

        }


      //  Log.w("Rohit", "Login User name :" + sb_name.toString());


        /**********Ends Java program to capitalize first letter of each word in string******/



        login_user_balance = login_user_balance.replaceAll("^\"|\"$", "").trim();

/* trim() is very important before converting into integer as string contains extra whitespace.If theree is any whitespace
 * it will give numberformat exception. */


    balance = Integer.parseInt(login_user_balance);



        tvlogin_username = (TextView) findViewById(R.id.name_value);
        tvlogin_username.setText(sb_name.toString());

        tvlogin_userbalance = (TextView) findViewById(R.id.balance_value);
        tvlogin_userbalance.setText("Rs."+login_user_balance);

        /*************************************************************/

     // int counter = login_user_name.length;

        /*
        for(int i =0; i<counter;i++)
        {
           Log.w("Rohit","Final" + login_user_name[i]);
        }
*/

     /**************************************************************************/


        setProfilePicOnLoad();

        /* Code to  "Call backround service" to get user free time */

        // pass data from "activity" to "backround service"


    }

public  void  onGivechallange(View view)
{

    if(balance<10)
    {
        Toast toast =  Toast.makeText(this,"Minimum amount required is Rs.10, please recharge your account.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
        toast.show();
    }
    else
    {

    int count = 0;
        /* At a time user can select only one subject, so code for that is   */


            cbPolity = (CheckBox) findViewById(R.id.pol01);
            cbGeography = (CheckBox) findViewById(R.id.geo02);
            cbMhistory = (CheckBox) findViewById(R.id.mh03);
            cbCA = (CheckBox) findViewById(R.id.ca04);
            cbProgramming = (CheckBox) findViewById(R.id.cs05);


        if(cbPolity.isChecked())
        {

          subject_id = "pol01";

            count ++;

        }

      if(cbGeography.isChecked())
        {

           subject_id= "geo02";

            count ++;
        }

         if(cbMhistory.isChecked())
        {

           subject_id = "mh03";

            count ++;
        }



         if(cbCA.isChecked())
        {

            subject_id = "ca04";

            count ++;
        }


         if(cbProgramming.isChecked())
        {

            subject_id= "cs05";

            count ++;
        }

        if( count == 0)
         {
             Toast toast =  Toast.makeText(this,"Please select any one subject.", Toast.LENGTH_LONG);
             toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
             toast.show();

         }

         if(count > 1)
         {
             Toast toast = Toast.makeText(this, "You can take one subject challange at a time.Thanks !!", Toast.LENGTH_LONG);
             toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL, 0, 0);
             toast.show();
         }

         if (count==1)
         {
/*
             Toast toast = Toast.makeText(this, "Hello Dear, Welcom .Thanks !!", Toast.LENGTH_LONG);
             toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL, 0, 0);
             toast.show();

             */



             online_users_background_worker oubw = new online_users_background_worker(this);
             oubw.execute(subject_id,user_emailid,login_user_name);
         }
    }

}



public void ondownloadpdfs(View view)
{



    if(balance<10)
    {
        Toast toast =  Toast.makeText(this,"Minimum amount required is Rs.10, please recharge your account.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
        toast.show();
    }
    else
    {

        int count = 0;
        /* At a time user can select only one subject, so code for that is   */


        cbPolity = (CheckBox) findViewById(R.id.pol01);
        cbGeography = (CheckBox) findViewById(R.id.geo02);
        cbMhistory = (CheckBox) findViewById(R.id.mh03);
        cbCA = (CheckBox) findViewById(R.id.ca04);
        cbProgramming = (CheckBox) findViewById(R.id.cs05);


        if(cbPolity.isChecked())
        {

            subject_id = "pol01";

            count ++;

        }

        if(cbGeography.isChecked())
        {

            subject_id= "geo02";

            count ++;
        }

        if(cbMhistory.isChecked())
        {

            subject_id = "mh03";

            count ++;
        }



        if(cbCA.isChecked())
        {

            subject_id = "ca04";

            count ++;
        }


        if(cbProgramming.isChecked())
        {

            subject_id= "cs05";

            count ++;
        }

        if( count == 0)
        {
            Toast toast =  Toast.makeText(this,"Please select any one subject.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL,0,0);
            toast.show();

        }

        if(count > 1)
        {
            Toast toast = Toast.makeText(this, "You can take one subject challange at a time.Thanks !!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL, 0, 0);
            toast.show();
        }

        if (count==1)//i.e if one subject is selected.
        {
/*
             Toast toast = Toast.makeText(this, "Hello Dear, Welcom .Thanks !!", Toast.LENGTH_LONG);
             toast.setGravity(Gravity.DISPLAY_CLIP_VERTICAL, 0, 0);
             toast.show();

             */
            Intent intent = new Intent(login_landing_page.this,download_pdfs.class);

            intent.putExtra("bal",login_user_balance);
            intent.putExtra("sub_id",subject_id);

            login_landing_page.this.startActivity(intent);
        }
    }





}

public void onInbox(View view)
{

    Intent intent = new Intent(login_landing_page.this,pending_challange_inbox.class);
    login_landing_page.this.startActivity(intent);
}

public void onAccountRecharge(View view)
{
    Intent intent = new Intent(login_landing_page.this,account_recharge.class);
    login_landing_page.this.startActivity(intent);




}


public  void onscheduletime(View view)
{

    Intent intent = new Intent(login_landing_page.this,set_challange_time.class);

    intent.putExtra("emailid",user_emailid);
    login_landing_page.this.startActivity(intent);


}


    public  void onSelectProfilePic(View view)
    {



        /***************Code for select image from gallery : STARTS*******************/


Intent intent = new Intent();
        intent.setType("image/*");

        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST); // this will initiate "onActivityResult" Abstract method



         /*******************************CODE ENDS*****************************************/


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)

    {



        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMG_REQUEST && resultCode==RESULT_OK && data!=null)
        {


/*

            Drawable is something which can be drawn. E.g. layout, vector image (line, circle), font, image and so on

            Bitmap - is specific type of Drawable which is image, like: PNG, JPEG or so

*/
            Uri path = data.getData();


            /*********to get Actual Path from URI***********************/

            Cursor cursor = getContentResolver().query(path, null, null, null, null);
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            String absolute_path = cursor.getString(idx);


/*********Code Ends : to get Actual Path from URI***********************/

            try
            {
                // this will hold the image path from gallery.

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),path);


           //     bitmap.getAb


                /******code Statrs : to show pic in landscape mode in portrait mode**************/


                /****** What is "ExifInterfacee" class *****************************



    [ExifInterface] is a class for reading and writing Exif tags in a JPEG file or a RAW image file.

                Exif is a specification for supporting metadata in a file, mostly used for JPEG, TIFF, and other
                image formats.
                    The TAG_-prefixed constants on ExifInterface identify common tags, though not every image will
                have every tag.
                    Tags that are popular among developers include TAG_ORIENTATION (indicating the
                orientation of the camera when the image was captured) and the TAG_GPS_-prefixed family (for geotagging).


                 *************************************************************/
                //First you need to create an ExifInterface:

                ExifInterface exifInterface = null;

                exifInterface = new ExifInterface(absolute_path);


                //You can then grab the orientation of the image:

                int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,1);

              //  Log.w("Rohit","Orientation :"+orientation);

                //So, the most important values are 0, 5, 6,7 and 8. If the orientation is 6,
                // for example, you can rotate the image like this:


Matrix matrix = new Matrix();

                   if(orientation==0 ||orientation==5 || orientation==6 || orientation==7 || orientation ==8)
                   {
                       matrix.postRotate(90);
                   }


               rotatedbitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);

               // rotatedbitmap = Bitmap.createBitmap(bitmap,0,0,200,200,matrix,true);



                /******code Ends : to show pic in landscape mode in portrait mode**************/




                /**********************aspect ratio code- Best way to resize image*********************************/


                float aspectRatio = rotatedbitmap.getWidth() /
                        (float) rotatedbitmap.getHeight();
                int width = 700;
                int height = Math.round(width / aspectRatio);

                rotatedbitmap = Bitmap.createScaledBitmap(
                       rotatedbitmap, width, height, false);


                /****************code ends - Aspect Ratio******************************/


                chooseprofilepic.setImageBitmap(rotatedbitmap);
                chooseprofilepic.setVisibility(View.VISIBLE);


            }

            catch (IOException e)
            {
                Toast.makeText(login_landing_page.this," Image Error, Try again ",Toast.LENGTH_SHORT).show();
            }

        }

    }


    public  void onUploadProfilePic(View view)

    {

       //String str = convert_imageTostring(rotatedbitmap);



    //Log.w("Rohit","Bitmap length :"+str.length());

        String url ="http://wwwpkmoneyin.000webhostapp.com/upload_image.php";

// Formulate the request and handle the response.

        // we will add this "stringrequest" in singleton class.

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,

                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        // Do something with the response

                            Toast t2 = Toast.makeText(login_landing_page.this,response,Toast.LENGTH_SHORT);
                            t2.show();

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        // Handle error
                        String error_Str = error.toString();
                      //  Log.w("Rohit","Error :"+error_Str);

                        Toast t2 = Toast.makeText(login_landing_page.this,"Network error,Try Again.",Toast.LENGTH_SHORT);
                        t2.show();
                    }
                }

        )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> params = new HashMap<String, String>();

                params.put("imagetostring",convert_imageTostring(rotatedbitmap));

                params.put("emailid",user_emailid);

                return params;
            }
        };


        int socketTimeout = 10000; // 10 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        stringRequest.setRetryPolicy(policy);

        MySingleton.getInstance(login_landing_page.this).addToRequestQue(stringRequest);

    }



    public String convert_imageTostring(Bitmap bitmaptoconvert)
    {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        bitmaptoconvert.compress(Bitmap.CompressFormat.JPEG,80,byteArrayOutputStream);// "80" indicates quality



        // Now we compress image to jpeg format and now that image is avialable in " byteArrayoutputstream"

        // convert bytearrayoutputstream to bytes, Now image is available in "imgbytes"
        byte[] imgbytes = byteArrayOutputStream.toByteArray();


        //now convert "imgbytes" to String.

        return Base64.encodeToString(imgbytes,Base64.DEFAULT);


    }


    public void setProfilePicOnLoad()
    {

        String request_image_url;

        request_image_url = "http://wwwpkmoneyin.000webhostapp.com/my_images/"+user_emailid+".jpg";

        Log.w("Rohit",request_image_url);

        ImageRequest imageRequest = new ImageRequest(request_image_url,


                new Response.Listener<Bitmap>() {

                    @Override
                    public void onResponse(Bitmap response)
                    {

                  chooseprofilepic.setImageBitmap(response);

                    }


                }, 0, 0, null,

                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast t2 = Toast.makeText(login_landing_page.this,"Network error,Try Again.",Toast.LENGTH_SHORT);
                        t2.show();
                        Log.w("Rohit","Volley error : "+error);
                    }
                }


        );
        int socketTimeout = 10000; // 30 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

        imageRequest.setRetryPolicy(policy);

        MySingleton.getInstance(login_landing_page.this).addToRequestQue(imageRequest);
    }

    }
