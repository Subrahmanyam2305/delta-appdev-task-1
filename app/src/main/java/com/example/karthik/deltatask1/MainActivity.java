package com.example.karthik.deltatask1;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int r, b, g;
    TextView txt1, txt2, txt3;
    SharedPreferences sharedpreferences;                    // To restore values even after app is closed
    public static final String fileName = "Rgb color";
    public static final String x = "Red";
    public static final String y = "Blue";
    public static final String z = "Green";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.red_textview);
        txt2 = (TextView) findViewById(R.id.blue_textview);
        txt3 = (TextView) findViewById(R.id.green_textview);
        sharedpreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(x))
            txt1.setText(sharedpreferences.getString(x, ""));
        if (sharedpreferences.contains(y))
            txt2.setText(sharedpreferences.getString(y, ""));
        if (sharedpreferences.contains(z))
            txt3.setText(sharedpreferences.getString(z, ""));
    }

    public void changeBgcolor() {
        RelativeLayout A = (RelativeLayout) findViewById(R.id.activity_main);
        A.setBackgroundColor(Color.argb(255, r, g, b));
    }

    //for red

    public void clickRed(View view) {
        r = r + 5;
        if (r <= 255)
            displayRed(r);
        else
            r = 0;
        changeBgcolor();
    }

    private void displayRed(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.red_textview);
        quantityTextView.setText("" + number);
    }

    //for blue

    public void clickBlue(View view) {
        b = b + 5;
        if (b <= 255)
            displayBlue(b);
        else
            b = 0;
        changeBgcolor();
    }

    private void displayBlue(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.blue_textview);
        quantityTextView.setText("" + number);
    }

    //for green

    public void clickGreen(View view) {
        g = g + 5;
        if (g <= 255)
            displayGreen(g);
        else
            g = 0;
        changeBgcolor();
    }

    private void displayGreen(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.green_textview);
        quantityTextView.setText("" + number);
    }

    //for reset

    public void clickReset(View view) {
        r = g = b = 0;
        displayBlue(0);
        displayGreen(0);
        displayRed(0);
        changeBgcolor();
    }

    //for save (used for retrieving data )

    public void clickSave(View view) {
        String Red = txt1.getText().toString();
        String Blue = txt2.getText().toString();
        String Green = txt3.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(x, Red);
        editor.putString(y, Blue);
        editor.putString(z, Green);
        editor.commit();
        r = Integer.parseInt(Red);
        b = Integer.parseInt(Blue);
        g = Integer.parseInt(Green);
        changeBgcolor();
    }


}
