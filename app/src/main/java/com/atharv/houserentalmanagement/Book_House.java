package com.atharv.houserentalmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Book_House extends AppCompatActivity {
    ImageView imageView;
    int resId;
    Boolean flag;
    String Price,Name;
    TextView availability,price;
    FirebaseFirestore db;
    Button book;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_house);
        ActionBar actionBar=getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#f08b26"));
        assert actionBar != null;
        actionBar.setTitle("Book House");
        actionBar.setBackgroundDrawable(colorDrawable);

        imageView=(ImageView)findViewById(R.id.image);
        price=(TextView)findViewById(R.id.rate);
        availability=(TextView)findViewById(R.id.availability);

        Intent intent=getIntent();
        Price=intent.getStringExtra("Price");
        Name=intent.getStringExtra("Name");
        Bundle bundle=intent.getExtras();
        if (bundle != null) {
            resId= bundle.getInt("Image");
            imageView.setImageResource(resId);
        }
        price.setText(Price);

        db=FirebaseFirestore.getInstance();

        DocumentReference documentReference=db.collection("Houses").document(Name);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    flag=documentSnapshot.getBoolean("available");
                    if(Boolean.TRUE.equals(flag)){
                        availability.setText("Available");
                    }
                    else{
                        availability.setText("Booked");
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {}
        });
//        swipeRefreshLayout = findViewById(R.id.refreshlayout);
//        swipeRefreshLayout.setColorSchemeColors(Color.RED);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                recreate();
//            }
//        });
    }
    public void Book(View view){
        book=(Button)findViewById(R.id.book);
        Boolean f=false;
        String av="available";
        Map data=new HashMap<>();
        data.put("available", false);
        db.collection("Houses")
                .document(Name)
                .update(data)
                .addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(Book_House.this, "Booked Successfully", Toast.LENGTH_SHORT).show();
                        book.setText("Booked");
                        book.setClickable(false);
                        recreate();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        recreate();
                        Toast.makeText(Book_House.this, "Unable to book an error occurred", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}