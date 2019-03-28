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

    public FirebaseDatabaseHelper() {
        mdatabase=FirebaseDatabase.getInstance();
        mRefUser=mdatabase.getReference("users");
    }

    public void readUser(){
        mRefUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users ur=new users();
                ur.setPassword(dataSnapshot.child());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
