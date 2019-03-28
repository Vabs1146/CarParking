package com.vaibhav.lenovo.carparking;

import android.content.Intent;
import android.os.PatternMatcher;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    TextView ref,name1,mobile,email,password;
    Button button;
    Boolean allOk=true,num=true;
    DatabaseReference ref1;
    users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ref=(TextView)findViewById(R.id.ref_id);
        name1=(TextView)findViewById(R.id.name);
        mobile=(TextView)findViewById(R.id.mobile_no);
        email=(TextView)findViewById(R.id.email_id);
        password=(TextView)findViewById(R.id.password);
        button=(Button)findViewById(R.id.button4);
        ref1=FirebaseDatabase.getInstance().getReference("users");
        user=new users();
    }

    private void getValues(){
            user.setName(name1.getText().toString());
            user.setEmail(email.getText().toString());
            user.setMobile(mobile.getText().toString());
            user.setRef(ref.getText().toString());
            user.setPassword(password.getText().toString());
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private boolean isEmailId(String emailid){
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN="^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n" +
                "                    + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher=pattern.matcher(emailid);
        return matcher.matches();
    }

    public void btnInsert(View view){
        ref1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(name1.length()==0) {
                    allOk=false;
                    name1.setError("please enter name");
                    return;
                }if(ref.length()==0){
                    allOk=false;ref.setError("please enter reference");
                    return;
                }if(mobile.length()!=10 && isNumeric(mobile.getText().toString())) {
                    allOk=false;mobile.setError("please enter valid mobile no");
                    return;
                }if(email.length()==0 && isEmailId(email.getText().toString())) {
                    allOk=false;email.setError("please enter email");
                    return;
                }if(password.length()==0) {
                    allOk=false;password.setError("please enter password");
                    return;
                }
                if (allOk){
                    getValues();
                    ref1.child(mobile.getText().toString()).setValue(user);
                    Toast.makeText(Register.this,"Registered Sucessfully",Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(Register.this, LoginActivity.class);
                    startActivity(in);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
