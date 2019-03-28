package com.vaibhav.lenovo.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class park_vehicle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_vehicle);
        Calendar c=Calendar.getInstance();
        System.out.println("current_time="+c.getTime());
        SimpleDateFormat df=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String formattedDate=df.format(c.getTime());
        Toast.makeText(this,formattedDate,Toast.LENGTH_SHORT).show();
        TextView tvCurrentSlot= (TextView)findViewById(R.id.tv_selected_slot);
        TextView tvCurrentTime= (TextView)findViewById(R.id.tv_current_time_stamp);
        Intent intent=getIntent();

        Bundle bundle = intent.getExtras();
        int Id= bundle != null ? bundle.getInt("slotId") : 0;

        tvCurrentSlot.setText(String.valueOf(Id));
        tvCurrentTime.setText(formattedDate);
    }
}
