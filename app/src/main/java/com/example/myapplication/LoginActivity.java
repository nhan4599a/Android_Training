package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;

import java.util.logging.Logger;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        if (auth.getCurrentUser() != null)
            startActivity(new Intent(this, SplashScreenActivity.class));
        findViewById(R.id.btnLogin).setOnClickListener(this::loginCallback);
    }

    private void loginCallback(View v) {
        OAuthProvider.Builder provider = OAuthProvider.newBuilder("microsoft.com");
        provider.addCustomParameter("prompt", "consent");
        provider.addCustomParameter("tenant", "3011a54b-0a5d-4929-bf02-a00787877c6a");
        Task<AuthResult> pendingAuthResult = auth.getPendingAuthResult();
        if (pendingAuthResult != null) {
            pendingAuthResult
                    .addOnSuccessListener(this::onLoginSuccess)
                    .addOnFailureListener(this::onLoginFailure);
        } else {
            auth.startActivityForSignInWithProvider(this, provider.build())
                    .addOnSuccessListener(this::onLoginSuccess)
                    .addOnFailureListener(this::onLoginFailure);
        }
    }

    private void onLoginSuccess(AuthResult authResult) {
        startActivity(new Intent(this, SplashScreenActivity.class));
    }

    private void onLoginFailure(Exception e) {
        e.printStackTrace();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
