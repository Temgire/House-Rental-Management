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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Rent_room extends AppCompatActivity {
    String name,email;
    Boolean flag;
    TextView h1,h2;
    TextView th1,th2;
    CardView c1,c2;
    FirebaseFirestore db;
    SwipeRefreshLayout swipeRefreshLayout;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_room);

        ActionBar actionBar=getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#f08b26"));
        actionBar.setTitle("View Rooms");
        actionBar.setBackgroundDrawable(colorDrawable);

        Intent i=getIntent();
        name=i.getStringExtra("NAME");
        email=i.getStringExtra("Email");
        db=FirebaseFirestore.getInstance();

        DocumentReference documentReference1=db.collection("Rooms").document("room1");
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
        DocumentReference documentReference2=db.collection("Rooms").document("room2");
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
        intent=new Intent(Rent_room.this,Book_Room.class);
        intent.putExtra("Image",R.drawable.r1);
        intent.putExtra("Price",price);
        intent.putExtra("Name","room1");
        startActivity(intent);
    }
    public void Book2(View view){
        th2=(TextView)findViewById(R.id.h2);
        String price=th2.getText().toString();
        intent=new Intent(Rent_room.this,Book_Room.class);
        intent.putExtra("Image",R.drawable.r2);
        intent.putExtra("Price",price);
        intent.putExtra("Name","room2");
        startActivity(intent);
    }
}