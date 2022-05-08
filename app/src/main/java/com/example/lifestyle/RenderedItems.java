package com.example.lifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class RenderedItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendered_items);
        Intent intent = getIntent();
        String color= intent.getStringExtra("jsonItems");
        color= intent.getStringExtra("jsonItems");
    }
}