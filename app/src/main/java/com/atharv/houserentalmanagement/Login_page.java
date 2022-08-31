package com.atharv.houserentalmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login_page extends AppCompatActivity {
    EditText uname, pass;
    String email_regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseFirestore db;
    public static String get_DBName,get_DBEmail;
//    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        uname = (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.pass);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        assert firebaseUser != null;
        String id=firebaseUser.getUid();
        db=FirebaseFirestore.getInstance();
    }

    public void Login(View view) {
        String email = uname.getText().toString();
        String psw = pass.getText().toString();

        if (!email.matches(email_regex)) {
            uname.setError("Enter correct Email");
        } else if (psw.length() < 6) {
            pass.setError("Password Length must be greater than 5");
        } else {

            firebaseAuth.signInWithEmailAndPassword(email,psw).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {

                    DocumentReference documentReference=db.collection("User").document(email);
                    documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if(documentSnapshot.exists()){
                                get_DBName=documentSnapshot.getString("Name");
                                get_DBEmail=documentSnapshot.getString("Email");

                                singleToneClass singleToneClass = com.atharv.houserentalmanagement.singleToneClass.getInstance();
                                singleToneClass.setData(get_DBEmail);//Store the email.

                                Toast.makeText(getApplicationContext(), "Login in Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login_page.this, Home.class);
//                                intent.putExtra("NAME",get_DBName);
//                                intent.putExtra("Email",get_DBEmail);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Login in Failed\nPlease Recheck Username and Password", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Login in Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}