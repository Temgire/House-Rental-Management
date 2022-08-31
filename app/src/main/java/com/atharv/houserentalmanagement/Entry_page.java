package com.atharv.houserentalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Entry_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_page);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent=new Intent(Entry_page.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}