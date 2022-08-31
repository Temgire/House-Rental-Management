package com.atharv.houserentalmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Rent_House extends AppCompatActivity {

    String name,email;
    Boolean flag;
    TextView h1,h2,h3,h4,h5,h6;
    TextView th1,th2,th3,th4,th5,th6;
    CardView c1,c2,c3,c4,c5,c6;
    FirebaseFirestore db;
    SwipeRefreshLayout swipeRefreshLayout;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_house);

        ActionBar actionBar=getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#f08b26"));
        actionBar.setTitle("View Houses");
        actionBar.setBackgroundDrawable(colorDrawable);

        Intent i=getIntent();
        name=i.getStringExtra("NAME");
        email=i.getStringExtra("Email");
        db=FirebaseFirestore.getInstance();

//        h1=(TextView)findViewById(R.id.hh1);
//        h2=(TextView)findViewById(R.id.hh2);
//        h3=(TextView)findViewById(R.id.hh3);
//        h4=(TextView)findViewById(R.id.hh4);
//        h5=(TextView)findViewById(R.id.hh5);
//        h6=(TextView)findViewById(R.id.hh6);

//        c1=(CardView)findViewById(R.id.cd1);
//        c2=(CardView)findViewById(R.id.cd2);
//        c3=(CardView)findViewById(R.id.cd3);
//        c4=(CardView)findViewById(R.id.cd4);
//        c5=(CardView)findViewById(R.id.cd5);
//        c6=(CardView)findViewById(R.id.cd6);

        DocumentReference documentReference1=db.collection("Houses").document("house1");
        documentReference1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    h1=(TextView)findViewById(R.id.hh1);
                    c1=(CardView)findViewById(R.id.cd1);
                    flag=documentSnapshot.getBoolean("available");
                    if(Boolean.TRUE.equals(flag)){
                        h1.setText("Available");
                        c1.setClickable(true);
                        c1.setCardBackgroundColor(Color.WHITE);
                    }
                    else{
                        h1.setText("Unavailable");
                        c1.setClickable(false);
                        c1.setCardBackgroundColor(Color.GRAY);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {}
        });
        DocumentReference documentReference2=db.collection("Houses").document("house2");
        documentReference2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    h2=(TextView)findViewById(R.id.hh2);
                    c2=(CardView)findViewById(R.id.cd2);
                    flag=documentSnapshot.getBoolean("available");
                    if(Boolean.TRUE.equals(flag)){
                        h2.setText("Available");
                        c2.setClickable(true);
                        c2.setCardBackgroundColor(Color.WHITE);
                    }
                    else{
                        h2.setText("Unavailable");
                        c2.setClickable(false);
                        c2.setCardBackgroundColor(Color.GRAY);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {}
        });
        DocumentReference documentReference3=db.collection("Houses").document("house3");
        documentReference3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    h3=(TextView)findViewById(R.id.hh3);
                    c3=(CardView)findViewById(R.id.cd3);
                    flag=documentSnapshot.getBoolean("available");
                    if(Boolean.TRUE.equals(flag)){
                        h3.setText("Available");
                        c3.setClickable(true);
                        c3.setCardBackgroundColor(Color.WHITE);
                    }
                    else{
                        h3.setText("Unavailable");
                        c3.setClickable(false);
                        c3.setCardBackgroundColor(Color.GRAY);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {}
        });
        DocumentReference documentReference4=db.collection("Houses").document("house4");
        documentReference4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    h4=(TextView)findViewById(R.id.hh4);
                    c4=(CardView)findViewById(R.id.cd4);
                    flag=documentSnapshot.getBoolean("available");
                    if(Boolean.TRUE.equals(flag)){
                        h4.setText("Available");
                        c4.setClickable(true);
                        c4.setCardBackgroundColor(Color.WHITE);
                    }
                    else{
                        h4.setText("Unavailable");
                        c4.setClickable(false);
                        c4.setCardBackgroundColor(Color.GRAY);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {}
        });
        DocumentReference documentReference5=db.collection("Houses").document("house5");
        documentReference5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    h5=(TextView)findViewById(R.id.hh5);
                    c5=(CardView)findViewById(R.id.cd5);
                    flag=documentSnapshot.getBoolean("available");
                    if(Boolean.TRUE.equals(flag)){
                        h5.setText("Available");
                        c5.setClickable(true);
                        c5.setCardBackgroundColor(Color.WHITE);
                    }
                    else{
                        h5.setText("Unavailable");
                        c5.setClickable(false);
                        c5.setCardBackgroundColor(Color.GRAY);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {}
        });
        DocumentReference documentReference6=db.collection("Houses").document("house6");
        documentReference6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    c6=(CardView)findViewById(R.id.cd6);
                    h6=(TextView)findViewById(R.id.hh6);
                    flag=documentSnapshot.getBoolean("available");
                    if(Boolean.TRUE.equals(flag)){
                        h6.setText("Available");
                        c6.setClickable(true);
                        c6.setCardBackgroundColor(Color.WHITE);
                    }
                    else{
                        h6.setText("Unavailable");
                        c6.setClickable(false);
                        c6.setCardBackgroundColor(Color.GRAY);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {}
        });


        swipeRefreshLayout = findViewById(R.id.refreshlayout);
        swipeRefreshLayout.setColorSchemeColors(Color.RED);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recreate();
            }
        });
    }
    public void Book1(View view){
        th1=(TextView)findViewById(R.id.h1);
        String price=th1.getText().toString();
        intent=new Intent(Rent_House.this,Book_House.class);
        intent.putExtra("Image",R.drawable.h1);
        intent.putExtra("Price",price);
        intent.putExtra("Name","house1");
        startActivity(intent);
    }
    public void Book2(View view){
        th2=(TextView)findViewById(R.id.h2);
        String price=th2.getText().toString();
        intent=new Intent(Rent_House.this,Book_House.class);
        intent.putExtra("Image",R.drawable.h2);
        intent.putExtra("Price",price);
        intent.putExtra("Name","house2");
        startActivity(intent);
    }
    public void Book3(View view){
        th3=(TextView)findViewById(R.id.h3);
        String price=th3.getText().toString();
        intent=new Intent(Rent_House.this,Book_House.class);
        intent.putExtra("Image",R.drawable.h3);
        intent.putExtra("Price",price);
        intent.putExtra("Name","house3");
        startActivity(intent);
    }
    public void Book4(View view){
        th4=(TextView)findViewById(R.id.h4);
        String price=th4.getText().toString();
        intent=new Intent(Rent_House.this,Book_House.class);
        intent.putExtra("Image",R.drawable.h4);
        intent.putExtra("Price",price);
        intent.putExtra("Name","house4");
        startActivity(intent);
    }
    public void Book5(View view){
        th5=(TextView)findViewById(R.id.h5);
        String price=th5.getText().toString();
        intent=new Intent(Rent_House.this,Book_House.class);
        intent.putExtra("Image",R.drawable.h5);
        intent.putExtra("Price",price);
        intent.putExtra("Name","house5");
        startActivity(intent);
    }
    public void Book6(View view){
        th6=(TextView)findViewById(R.id.h6);
        String price=th6.getText().toString();
        intent=new Intent(Rent_House.this,Book_House.class);
        intent.putExtra("Image",R.drawable.h6);
        intent.putExtra("Price",price);
        intent.putExtra("Name","house6");
        startActivity(intent);
    }
}