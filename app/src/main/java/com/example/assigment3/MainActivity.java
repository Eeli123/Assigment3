package com.example.assigment3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    Button button;

    ArrayList<Date> lista;
    ArrayAdapter<Date> dateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();
        button = findViewById(R.id.button);
        listview = findViewById(R.id.Lista);
        dateAdapter = new ArrayAdapter<>(this, R.layout.custom_layout, lista);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
              alertDialog.setTitle("Hello");
              alertDialog.setMessage("Add current time to list");

              alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Add", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      Calendar kalenteri = new GregorianCalendar();
                      lista.add(kalenteri.getTime());
                  }
              });
            alertDialog.show();
            }


        });

        listview.setAdapter(dateAdapter);



    }
}
