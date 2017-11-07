package com.example.ashwin.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.edittextname);
        et2 = (EditText)findViewById(R.id.edittextpassword);
    }

    public void SAVE(View view) throws IOException {
        File file = null;
        String name = et1.getText().toString();
        String password = et2.getText().toString();
        FileOutputStream fileobject = null;
        try {
            name = name + " ";
           // password = password + " ";
            file = getFilesDir();
            fileobject = openFileOutput("code.txt", Context.MODE_PRIVATE);
            fileobject.write(name.getBytes());
            fileobject.write(password.getBytes());
           // Toast.makeText(this, "Saved \n" + "Path --" + file + "\tCode.txt", Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
            return;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                fileobject.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void NEXT(View view)
    {
        Intent intent = new Intent(this,MainSecond.class);
        startActivity(intent);
    }
}
