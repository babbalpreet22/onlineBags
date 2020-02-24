package com.example.onlinebags;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.content.Intent;
import android.widget.Button;

import android.os.Bundle;

public class choose extends AppCompatActivity {
    Button btn1; Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn1:
                        Intent intent = new Intent(choose.this,products_main.class);
                        choose.this.startActivity(intent);
                        break;
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn2:
                        Intent intent = new Intent(choose.this, product_details.class);
                        choose.this.startActivity(intent);
                        break;
                }
            }
        });
    }
}
