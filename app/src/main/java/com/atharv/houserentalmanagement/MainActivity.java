package com.atharv.houserentalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view){
        Intent intent=new Intent(MainActivity.this,Login_page.class);
        startActivity(intent);
//        finish();
    }
    public void signin(View view){
        Intent intent=new Intent(MainActivity.this,signup_page.class);
        startActivity(intent);
//        finish();
    }
}