package com.example.vlunotifyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private Toolbar tbNameUser;

    @Override
    protected void onStart(){
        super.onStart();
        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tbNameUser = findViewById(R.id.ToolBar);
        findViewById(R.id.btnLogin).setOnClickListener(this::login);
    }


    private void login(View view){
        OAuthProvider.Builder builder = OAuthProvider.newBuilder("microsoft.com");
        Map<String,String> params = new HashMap<>();
        params.put("prompt", "consent");
        params.put("tenant", "3011a54b-0a5d-4929-bf02-a00787877c6a");
        builder.addCustomParameters(params);
        Task<AuthResult> pendingAuthResult = auth.getPendingAuthResult();
        if(pendingAuthResult != null){
            pendingAuthResult.addOnSuccessListener(this::onLoginSuccess);

        }else {
            auth.startActivityForSignInWithProvider(this, builder.build()).addOnSuccessListener(this::onLoginSuccess);
        }
    }

    private void onLoginSuccess(AuthResult result){
        Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

}