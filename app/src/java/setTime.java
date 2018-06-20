package com.example.crazybeam.pkmoney_v7;

import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by crazybeam on 7/29/2017.
 */

public class setTime
{

    //set_challange_time sct = new set_challange_time();

    public Button btnhrs;

    public Button btnmins;

public setTime(String msg,Button btn)
{

    if(msg.equals("hours"))
    {
        this.btnhrs = btn;
    }
    else
    {
        this.btnmins=btn;
    }


}


    public  void onPlusCall(View v1)
    {

       // Log.w("Rohit", "I am in Plus Call");

        String str = btnhrs.getText().toString();



        //Log.w("Rohit", "I am in down");

        if (str.equals("00")) {


            btnhrs.setText("01");
        }


        else if (str.equals("01")) {

            btnhrs.setText("02");
        }

        else if (str.equals("02")) {

            btnhrs.setText("03");
        }

        else if (str.equals("03")) {

            btnhrs.setText("04");
        }

        else if (str.equals("04")) {

            btnhrs.setText("05");

        }

        else if (str.equals("05")) {

            btnhrs.setText("06");

        }

        else if (str.equals("06")) {

            btnhrs.setText("07");

        }


        else if (str.equals("07")) {

            btnhrs.setText("08");

        }

        else if (str.equals("08")) {

            btnhrs.setText("09");

        }

        else if (str.equals("09")) {

            btnhrs.setText("10");

        }
        else if (str.equals("10")) {

            btnhrs.setText("11");

        }

        else if (str.equals("11")) {

            btnhrs.setText("12");

        }

        else if (str.equals("12")) {

            btnhrs.setText("00");

        }


    }


    public  void onMinusCall(View v2) {


        String str =    btnhrs.getText().toString().trim();

        if (str.equals("00")) {

            btnhrs.setText("12");
        }

        else if (str.equals("01")) {

            btnhrs.setText("00");
        }

        else if (str.equals("02")) {

            btnhrs.setText("01");
        }

        else if (str.equals("03")) {

            btnhrs.setText("02");
        }

        else if (str.equals("04")) {

            btnhrs.setText("03");

        }

        else if (str.equals("05")) {

            btnhrs.setText("04");

        }

        else if (str.equals("06")) {

            btnhrs.setText("05");

        }


        else if (str.equals("07")) {

            btnhrs.setText("06");

        }

        else if (str.equals("08")) {

            btnhrs.setText("07");

        }

        else if (str.equals("09")) {

            btnhrs.setText("08");

        }
        else if (str.equals("10")) {

            btnhrs.setText("09");

        }

        else if (str.equals("11")) {

            btnhrs.setText("10");

        }

        else if (str.equals("12")) {

            btnhrs.setText("11");

        }

    }


    public  void onMinutePlusCall(View v3)
    {


        String str = btnmins.getText().toString().trim();


      int firstchar = Character.getNumericValue(str.charAt(0));

        int secondchar = Character.getNumericValue(str.charAt(1));


        if((firstchar==0 && secondchar!=9) || (firstchar==1 && secondchar!=9 )|| (firstchar==2 && secondchar!=9 )|| (firstchar==3 && secondchar!=9 )|| (firstchar==4 && secondchar!=9 )|| (firstchar==5 && secondchar!=9 ))
        {
            secondchar++;

            String text =   (Character.toString((Character.forDigit(firstchar,10))))+(Character.toString((Character.forDigit(secondchar,10))));

            //Log.w("Rohit", "Text = "+text);

            btnmins.setText(text);
        }


        else if(firstchar==5 && secondchar==9)

        {

            firstchar=0;
            secondchar = 0;

            String text =   (Character.toString((Character.forDigit(firstchar,10))))+(Character.toString((Character.forDigit(secondchar,10))));

          //  Log.w("Rohit", "Text = "+text);

            btnmins.setText(text);

        }

        else
        {

            firstchar++;

            secondchar=0;

            String text =   (Character.toString((Character.forDigit(firstchar,10))))+(Character.toString((Character.forDigit(secondchar,10))));

            btnmins.setText(text);
        }




    }



    public  void onMinuteMinusCall(View v4)
    {


        String str = btnmins.getText().toString().trim();


        int firstchar = Character.getNumericValue(str.charAt(0));

        int secondchar = Character.getNumericValue(str.charAt(1));


        if ((firstchar == 0 && secondchar != 0) || (firstchar == 1 && secondchar != 0) || (firstchar == 2 && secondchar != 0) || (firstchar == 3 && secondchar != 0) || (firstchar == 4 && secondchar != 0) || (firstchar == 5 && secondchar != 0))
        {
            secondchar--;

            String text = (Character.toString((Character.forDigit(firstchar, 10)))) + (Character.toString((Character.forDigit(secondchar, 10))));

            //Log.w("Rohit", "Text = "+text);

            btnmins.setText(text);
        }


        else if (firstchar == 0 && secondchar==0)

        {

            firstchar = 5;
            secondchar = 9;

            String text = (Character.toString((Character.forDigit(firstchar, 10)))) + (Character.toString((Character.forDigit(secondchar, 10))));

            //  Log.w("Rohit", "Text = "+text);

            btnmins.setText(text);
        }




        /*
           if (firstchar == 6 )

        {

            firstchar = 5;
            secondchar = 9;

            String text = (Character.toString((Character.forDigit(firstchar, 10)))) + (Character.toString((Character.forDigit(secondchar, 10))));

            //  Log.w("Rohit", "Text = "+text);

            btnmins.setText(text);

        }

        */

        else {

            firstchar--;

            secondchar = 9;

            String text = (Character.toString((Character.forDigit(firstchar, 10)))) + (Character.toString((Character.forDigit(secondchar, 10))));

            btnmins.setText(text);
        }


    }
    }


