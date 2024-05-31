package com.example.alwaysactive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity_activity extends AppCompatActivity {

    Button bt_main, bt_today, button_add;
    EditText etn, etd, ets, ete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);

        bt_main = findViewById(R.id.main_bt_a);
        bt_today = findViewById(R.id.today_bt_a);
        button_add = findViewById(R.id.button_add);

        etn = findViewById(R.id.editText);
        etd = findViewById(R.id.editText_date);
        ets = findViewById(R.id.editText_start);
        ete = findViewById(R.id.editText_end);

        bt_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bt_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity_activity.this, Today_activity.class);
                startActivity(intent);
            }
        });

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "";
                String timeS = "";
                String timeE = "";
                if (etd.getText().toString().indexOf('-') == -1) {
                    day = Integer.parseInt(etd.getText().toString().substring(0, 4)) + "-" + Integer.parseInt(etd.getText().toString().substring(4, 6)) + "-" + Integer.parseInt(etd.getText().toString().substring(6));
                }
                if (etd.getText().toString().indexOf('-') != -1) {
                    day = etd.getText().toString();
                }
                if (ets.getText().toString().indexOf(':') == -1) {
                    timeS = ets.getText().toString().substring(0, ets.getText().toString().length() - 2) + ":" + ets.getText().toString().substring(ets.getText().toString().length() - 2);
                }
                if (ets.getText().toString().indexOf(':') != -1){
                    timeS = ets.getText().toString();
                }
                if (ete.getText().toString().indexOf(':') == -1) {
                    timeE = ete.getText().toString().substring(0, ete.getText().toString().length() - 2) + ":" + ete.getText().toString().substring(ete.getText().toString().length() - 2);
                }
                if (ete.getText().toString().indexOf(':') != -1){
                    timeE = ete.getText().toString();
                }
                String str = day + " " + timeS + " " + timeE + " " + etn.getText().toString();
                Intent intent = new Intent(AddActivity_activity.this, MainActivity.class);
                intent.putExtra("Event", str);
                startActivity(intent);
            }
        });


    }
}