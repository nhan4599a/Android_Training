package com.example.sepp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Login);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document().get().addOnCompleteListener(task -> {
            Logger.getLogger("DEBUG").warning(Objects.requireNonNull(task.getResult()).getString("username"));
        });
    }
}