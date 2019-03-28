package com.vaibhav.lenovo.carparking;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.google.firebase.firestore.auth.User;

public class LoginActivity extends AppCompatActivity {
    Button button, btnmove;
    TextView Mobile,Password;
    DatabaseReference ref1;
    Bundle bundle;
    users user;
    String mobileNo="",password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnmove = (Button) findViewById(R.id.register_page);
        button = (Button) findViewById(R.id.btn_login);
        Mobile=(TextView)findViewById(R.id.input_mobile);
        Password=(TextView)findViewById(R.id.input_password);
        ref1=FirebaseDatabase.getInstance().getReference("users");

        Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileNo=Mobile.getText().toString();
                ref1.child(mobileNo).child("password").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        password=dataSnapshot.getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                if (Password.getText().toString().equals(password)){
                    Toast.makeText(LoginActivity.this,"Login Sucessfull",Toast.LENGTH_SHORT).show();
                    Bundle bundle =new Bundle();
                    bundle.putString("ab",mobileNo);
                    Intent in = new Intent(LoginActivity.this, HomeActivity.class);
                    in.putExtras(bundle);
                    startActivity(in);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent(LoginActivity.this, Register.class);
                startActivity(inn);
            }
        });
    }
}
