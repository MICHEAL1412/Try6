package com.example.atry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class Food extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_beverage);
        Intent intent = getIntent();
    }
    public void back4(View view){
        // This is go new page
        /*Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);*/
        ///////////////////////////////////////////
        // This is close page
        finish();
    }
}
