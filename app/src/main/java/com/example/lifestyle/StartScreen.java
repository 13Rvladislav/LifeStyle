package com.example.lifestyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import java.util.ArrayList;

public class StartScreen extends AppCompatActivity {
Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.srartscreen);
        getSupportActionBar().hide();
        mainButton = (Button) findViewById(R.id.startScreenButton);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.startScreenButton:
                    default:
                        Intent intent = new Intent(StartScreen.this, ActivityAutorization.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        mainButton.setOnClickListener(onClickListener);
    }
}

