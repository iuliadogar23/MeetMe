package com.project.meetme.repos;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.meetme.model.User;

public class UserRepository {

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    public UserRepository() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        this.databaseReference = database.getReference("users");
    }

    public void create(User user) {
        databaseReference.child("id").setValue(user);
    }

    public void updateCurrent(User user) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String id = currentUser.getUid();
        databaseReference.child(id).setValue(user);
    }
}
