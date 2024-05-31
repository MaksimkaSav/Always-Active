package com.example.alwaysactive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class Today_activity extends AppCompatActivity {

    Button bt_add;
    Button bt_main;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        bt_add = findViewById(R.id.add_bt_t);
        bt_main = findViewById(R.id.main_bt_t);



        ArrayList<String> list = getIntent().getStringArrayListExtra("d");
        String[] events = new String[list.size()];
        for (int i = 0; i < events.length; i++) {
            events[i] = list.get(i);
        }

        EventsAdapter ea = new EventsAdapter(this, events);
        lv = findViewById(R.id.lv_today);
        lv.setAdapter(ea);



        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Today_activity.this, AddActivity_activity.class);
                startActivity(intent);
            }
        });

        bt_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Today_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}