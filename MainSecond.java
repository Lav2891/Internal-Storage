package com.example.ashwin.internalstorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Ashwin on 10/20/2017.
 */

public class MainSecond extends AppCompatActivity {


    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv1 = (TextView)findViewById(R.id.textviewnamesave);
        tv2 = (TextView)findViewById(R.id.textviewpasswordsave);
    }

    public void LOAD(View view)  {

        try {
            FileInputStream fileobjectin = openFileInput("code.txt");

        int read = -1;
        StringBuffer buffer = new StringBuffer();

            while ((read = fileobjectin.read()) != -1) {
                buffer.append((char) read);
            }

            String name = buffer.substring(0, buffer.indexOf(" "));
            String pass = buffer.substring(buffer.indexOf(" ") + 1);
            tv1.setText(name);
            tv2.setText(pass);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Loaded", Toast.LENGTH_SHORT).show();

    }

    public void BACK(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
