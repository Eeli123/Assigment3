package com.example.assigment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adapter extends ArrayAdapter<Date> {

    private Context context;
    int resource;
    ArrayList<Date> objects;

    public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<Date> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custom_layout, parent, false);
        TextView teksti = convertView.findViewById(R.id.teksti);
        teksti.setText(objects.get(position).toString());

        Button remove = convertView.findViewById(R.id.Remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objects.clear();
            }
        });
        return convertView;
    }
}
