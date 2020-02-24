package com.example.onlinebags;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class product_details extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    EditText product_name;
    EditText product_description;
    EditText product_price;
    Button add_to_cart_button;
    Button retrieve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        imageView = findViewById(R.id.imageView);
        product_name = findViewById(R.id.product_name);
        product_description = findViewById(R.id.product_description);
        product_price = findViewById(R.id.product_price);
        add_to_cart_button = findViewById(R.id.add_to_cart_button);
        retrieve = findViewById(R.id.retrieve);

        add_to_cart_button.setOnClickListener(this);
        retrieve.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_to_cart_button:
                sendData();
                break;
            case R.id.retrieve:
                sendData();
                Intent intent = new Intent(product_details.this, retrieve.class);
                product_details.this.startActivity(intent);
                break;

        }

    }

    private void sendData() {
        String Name=product_name.getText().toString();
        String Description=product_description.getText().toString();
        String Price=product_price.getText().toString();

        HashMap<String,String> order=new HashMap<>();
        order.put("Name", Name);
        order.put("Description", Description);
        order.put("Price", Price);

        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("Orders").add(order)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(product_details.this, "Successfully added to cart",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(product_details.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
    }

