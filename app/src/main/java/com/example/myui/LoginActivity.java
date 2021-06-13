package com.example.myui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    private TextView tvLoginResult;
    private FirebaseAuth auth;

    @Override
    protected void onStart() {
        super.onStart();
        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_login);
        tvLoginResult = findViewById(R.id.tvLoginResult);
        findViewById(R.id.btnLogin).setOnClickListener(this::login);
    }

    private void login(View view){
        OAuthProvider.Builder builder = OAuthProvider.newBuilder("microsoft.com");
        Task<AuthResult> pendingAuthResultTask = auth.getPendingAuthResult();

        if (pendingAuthResultTask != null){
            pendingAuthResultTask.addOnSuccessListener(this::onLoginSuccess).addOnFailureListener(this::onLoginFailure);
        }else{
            auth.startActivityForSignInWithProvider(this, builder.build())
                    .addOnSuccessListener(this::onLoginSuccess)
                    .addOnFailureListener(this::onLoginFailure);
        }
    }

    private void onLoginSuccess(AuthResult result){
        tvLoginResult.setText(String.format(Locale.US, "Login wiith email" + result.getUser().getEmail()));
    }

    private void onLoginFailure(Exception exception){
        exception.printStackTrace();
        tvLoginResult.setText(String.format(Locale.US, "Login failed ", exception.getMessage()));
    }
}
