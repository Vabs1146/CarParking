package com.vaibhav.lenovo.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Book_slot extends AppCompatActivity implements View.OnClickListener {

    Button btnSlot1,btnSlot2,btnSlot3,btnSlot4,btnSlot5,btnSlot6,btnSlot7,btnSlot8,btnSlot9,btnSlot10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_slot);

        btnSlot1=(Button)findViewById(R.id.btn_slot_1);
        btnSlot2=(Button)findViewById(R.id.btn_slot_2);
        btnSlot3=(Button)findViewById(R.id.btn_slot_3);
        btnSlot4=(Button)findViewById(R.id.btn_slot_4);
        btnSlot5=(Button)findViewById(R.id.btn_slot_5);

        btnSlot1.setOnClickListener(this);
        btnSlot2.setOnClickListener(this);
        btnSlot3.setOnClickListener(this);
        btnSlot4.setOnClickListener(this);
        btnSlot5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Book_slot.this,park_vehicle.class);
        switch (v.getId()){
            case R.id.btn_slot_1:

                intent.putExtra("slotId",1);
                startActivity(intent);
                break;
            case R.id.btn_slot_2:
                intent.putExtra("slotId",2);
                startActivity(intent);
                break;
            case R.id.btn_slot_3:
                intent.putExtra("slotId",3);
                startActivity(intent);
                break;
            case R.id.btn_slot_4:
                intent.putExtra("slotId",4);
                startActivity(intent);
                break;
            case R.id.btn_slot_5:
                intent.putExtra("slotId",5);
                startActivity(intent);
                break;
        }
    }
}
