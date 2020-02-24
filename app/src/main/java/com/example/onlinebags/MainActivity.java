package com.example.onlinebags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView shop;
    EditText email;
    EditText username;
    EditText password;
    Button register_now;
    Button sign_in;
    Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shop = findViewById(R.id.shop);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        sign_in = findViewById(R.id.sign_in);
        register_now = findViewById(R.id.register_now);

        sign_in.setOnClickListener(this);
        register_now.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.sign_in:
                Intent intent1 = new Intent(context, login.class);
                context.startActivity(intent1);


            case R.id.register_now:
                createUser();
                break;


        }

    }

    private void createUser() {
        String str = email.getText().toString();
        String str2 = password.getText().toString();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(str, str2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, login.class);
                context.startActivity(intent);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();

            }
        });
    }
}
