package com.atharv.houserentalmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Home extends AppCompatActivity {
//    String name,email;
    String document_name;
    String get_DBName;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Intent i=getIntent();
//        name=i.getStringExtra("NAME");
//        email=i.getStringExtra("Email");

        singleToneClass singleToneClass = com.atharv.houserentalmanagement.singleToneClass.getInstance();
        document_name=singleToneClass.getData();

        db=FirebaseFirestore.getInstance();

        DocumentReference documentReference=db.collection("User").document(document_name);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    get_DBName=documentSnapshot.getString("Name");
                    Toast.makeText(getApplicationContext(), "Welcome "+get_DBName, Toast.LENGTH_SHORT).show();
                    ActionBar actionBar=getSupportActionBar();
                    ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#f08b26"));
                    assert actionBar != null;
                    actionBar.setTitle("Hello,"+get_DBName);
                    actionBar.setBackgroundDrawable(colorDrawable);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {}
        });
    }
    public void rent_house(View view){
        Intent intent=new Intent(Home.this,Rent_House.class);
//        intent.putExtra("NAME",name);
//        intent.putExtra("Email",email);
        startActivity(intent);
    }
    public void rent_room(View view){
        Intent intent=new Intent(Home.this,Rent_room.class);
//        intent.putExtra("NAME",name);
//        intent.putExtra("Email",email);
        startActivity(intent);
    }
}