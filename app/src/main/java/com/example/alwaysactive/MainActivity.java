package com.example.alwaysactive;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String day = String.valueOf(new Date().getDate());
    String month = String.valueOf(new Date().getMonth() + 1);
    String year = String.valueOf(new Date().getYear() + 1900);
    String now = year + "-" + month + "-" + day;
    int date = new Date(new Date().getYear(), new Date().getMonth(), 1).getDay();
    Button bt_add;
    Button bt_today;
    TextView tv_mouth, next_tv, now_tv, next_t, now_t;
    String currentDate = (new Date().getYear() + 1900) + "-" + (new Date().getMonth() + 1);
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23, bt24, bt25, bt26, bt27, bt28, bt29, bt30, bt31, bt32, bt33, bt34, bt35;
    DBAlwaysActive alwaysActive;
    String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    int[] monthD = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alwaysActive = new DBAlwaysActive(this);

        if(getIntent().getStringExtra("Event") != null){
            String str = getIntent().getStringExtra("Event");
            alwaysActive.insertEvent(str);
        }

        if (((Integer.parseInt(currentDate.split("-")[0]) + 1900) % 4 == 0 && (Integer.parseInt(currentDate.split("-")[0]) + 1900) % 100 != 0) || (Integer.parseInt(currentDate.split("-")[0]) + 1900) % 400 == 0){
            monthD[1] = 29;
        }

        next_tv = findViewById(R.id.activity_next_text);
        next_t = findViewById(R.id.activity_next_time);

        now_tv = findViewById(R.id.activity_now_text);
        now_t = findViewById(R.id.activity_now_time);

        bt1 = findViewById(R.id._1);
        bt2 = findViewById(R.id._2);
        bt3 = findViewById(R.id._3);
        bt4 = findViewById(R.id._4);
        bt5 = findViewById(R.id._5);
        bt6 = findViewById(R.id._6);
        bt7 = findViewById(R.id._7);
        bt8 = findViewById(R.id._8);
        bt9 = findViewById(R.id._9);
        bt10 = findViewById(R.id._10);
        bt11 = findViewById(R.id._11);
        bt12 = findViewById(R.id._12);
        bt13 = findViewById(R.id._13);
        bt14 = findViewById(R.id._14);
        bt15 = findViewById(R.id._15);
        bt16 = findViewById(R.id._16);
        bt17 = findViewById(R.id._17);
        bt18 = findViewById(R.id._18);
        bt19 = findViewById(R.id._19);
        bt20 = findViewById(R.id._20);
        bt21 = findViewById(R.id._21);
        bt22 = findViewById(R.id._22);
        bt23 = findViewById(R.id._23);
        bt24 = findViewById(R.id._24);
        bt25 = findViewById(R.id._25);
        bt26 = findViewById(R.id._26);
        bt27 = findViewById(R.id._27);
        bt28 = findViewById(R.id._28);
        bt29 = findViewById(R.id._29);
        bt30 = findViewById(R.id._30);
        bt31 = findViewById(R.id._31);
        bt32 = findViewById(R.id._32);
        bt33 = findViewById(R.id._33);
        bt34 = findViewById(R.id._34);
        bt35 = findViewById(R.id._35);

        bt_add = findViewById(R.id.add_bt);
        bt_today = findViewById(R.id.today_bt);
        tv_mouth = findViewById(R.id.mouth);

        tv_mouth.setText("" + months[Integer.parseInt(currentDate.substring(5)) - 1] + " " + currentDate.substring(0, 4));

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity_activity.class);
                startActivity(intent);
            }
        });

        bt_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = alwaysActive.getDayEvents(now);
                Intent intent = new Intent(MainActivity.this, Today_activity.class);
                intent.putStringArrayListExtra("d", list);
                startActivity(intent);
            }
        });

        if (date > 1){
            bt1.setTextColor(Color.GRAY);
            String str = String.valueOf(monthD[(Integer.parseInt(currentDate.split("-")[1]) + 10) % 12] - date + 2);
            bt1.setText(str);
        }else {
            bt1.setText(2 - date);
        }

        if (date > 2){
            bt2.setTextColor(Color.GRAY);
            String str = String.valueOf(monthD[(Integer.parseInt(currentDate.split("-")[1]) + 10) % 12] - date + 3);
            bt2.setText(str);
        }else {
            bt1.setText(3 - date);
        }

        if (date > 3){
            bt3.setTextColor(Color.GRAY);
            String str = String.valueOf(monthD[(Integer.parseInt(currentDate.split("-")[1]) + 10) % 12] - date + 4);
            bt3.setText(str);
        }else {
            bt3.setText((4 - date) + "");
        }

        if (date > 4){
            bt4.setTextColor(Color.GRAY);
            String str = String.valueOf(monthD[(Integer.parseInt(currentDate.split("-")[1]) + 10) % 12] - date + 5);
            bt4.setText(str);
        }else {
            bt4.setText((5 - date) + "");
        }

        if (date > 5){
            bt5.setTextColor(Color.GRAY);
            String str = String.valueOf(monthD[(Integer.parseInt(currentDate.split("-")[1]) + 10) % 12] - date + 6);
            bt5.setText(str);
        }else {
            bt5.setText((6 - date) + "");
        }

        if (date > 6){
            bt6.setTextColor(Color.GRAY);
            String str = String.valueOf(monthD[(Integer.parseInt(currentDate.split("-")[1]) + 10) % 12] - date + 7);
            bt6.setText(str);
        }else {
            bt6.setText((7 - date) + "");
        }

        if (date > 7){
            bt7.setTextColor(Color.GRAY);
            String str = String.valueOf(monthD[(Integer.parseInt(currentDate.split("-")[1]) + 10) % 12] - date + 8);
            bt7.setText(str);
        }else {
            bt7.setText((8 - date) + "");
        }

        bt8.setText((9 - date) + "");
        bt9.setText((10 - date) + "");
        bt10.setText((11 - date) + "");
        bt11.setText((12 - date) + "");
        bt12.setText((13 - date) + "");
        bt13.setText((14 - date) + "");
        bt14.setText((15 - date) + "");
        bt15.setText((16 - date) + "");
        bt16.setText((17 - date) + "");
        bt17.setText((18 - date) + "");
        bt18.setText((19 - date) + "");
        bt19.setText((20 - date) + "");
        bt20.setText((21 - date) + "");
        bt21.setText((22 - date) + "");
        bt22.setText((23 - date) + "");
        bt23.setText((24 - date) + "");
        bt24.setText((25 - date) + "");
        bt25.setText((26 - date) + "");
        bt26.setText((27 - date) + "");
        bt27.setText((28 - date) + "");
        bt28.setText((29 - date) + "");

        if (30 - date  > monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1]) {
            bt29.setTextColor(Color.GRAY);
            String str = 30 - date - monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1] + "";
            bt29.setText(str);
        }else {
            bt29.setText((30 - date) + "");
        }

        if (31 - date  > monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1]) {
            bt30.setTextColor(Color.GRAY);
            String str = 31 - date - monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1] + "";
            bt30.setText(str);
        }else {
            bt30.setText((31 - date) + "");
        }

        if (32 - date  > monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1]) {
            bt31.setTextColor(Color.GRAY);
            String str = 32 - date - monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1] + "";
            bt31.setText(str);
        }else {
            bt31.setText((32 - date) + "");
        }

        if (33 - date  > monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1]) {
            bt32.setTextColor(Color.GRAY);
            String str = 33 - date - monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1] + "";
            bt32.setText(str);
        }else {
            bt32.setText((33 - date) + "");
        }

        if (34 - date  > monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1]) {
            bt33.setTextColor(Color.GRAY);
            String str = 34 - date - monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1] + "";
            bt33.setText(str);
        }else {
            bt33.setText((34 - date) + "");
        }

        if (35 - date  > monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1]) {
            bt34.setTextColor(Color.GRAY);
            String str = 35 - date - monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1] + "";
            bt34.setText(str);
        }else {
            bt34.setText((35 - date) + "");
        }

        if (36 - date  > monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1]) {
            bt35.setTextColor(Color.GRAY);
            String str = 36 - date - monthD[(Integer.parseInt(currentDate.split("-")[1])) - 1] + "";
            bt35.setText(str);
        }else {
            bt35.setText((36 - date) + "");
        }

        switch (new Date().getDate() + date - 1){
            case 1:
                bt1.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 2:
                bt2.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 3:
                bt3.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 4:
                bt4.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 5:
                bt5.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 6:
                bt6.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 7:
                bt7.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 8:
                bt8.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 9:
                bt9.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 10:
                bt10.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 11:
                bt11.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 12:
                bt12.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 13:
                bt13.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 14:
                bt14.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 15:
                bt15.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 16:
                bt16.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 17:
                bt17.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 18:
                bt18.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 19:
                bt19.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 20:
                bt20.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 21:
                bt21.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 22:
                bt22.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 23:
                bt23.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 24:
                bt24.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 25:
                bt25.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 26:
                bt26.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 27:
                bt27.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 28:
                bt28.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 29:
                bt29.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 30:
                bt30.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 31:
                bt31.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 32:
                bt32.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 33:
                bt33.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 34:
                bt34.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
            case 35:
                bt35.setBackgroundColor(Color.rgb(83, 203, 83));
                break;
        }
    }

}