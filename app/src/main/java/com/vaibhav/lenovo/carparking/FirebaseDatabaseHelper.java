package com.vaibhav.lenovo.carparking;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mdatabase;
    private DatabaseReference mRefUser;
    private List<User>usersList=new ArrayList<>();
    String Mobile;

    public FirebaseDatabaseHelper() {
        mdatabase=FirebaseDatabase.getInstance();
        mRefUser=mdatabase.getReference("users");
    }

    public void readUser(){
        mRefUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    users ur=new users();
                    ur.setName(ds.child(Mobile).getValue(users.class).getName());
                    ur.setPassword(ds.child(Mobile).getValue(users.class).getPassword());
                    ur.setMobile(ds.child(Mobile).getValue(users.class).getMobile());
                    ur.setEmail(ds.child(Mobile).getValue(users.class).getEmail());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
