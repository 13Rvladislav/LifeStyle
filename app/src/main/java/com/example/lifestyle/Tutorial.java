package com.example.lifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.ViewFlipper;
import android.view.Gravity;
import android.view.View;

public class Tutorial extends AppCompatActivity {
    Button mainButton;
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        getSupportActionBar().hide();
        mainButton = (Button) findViewById(R.id.button);
        viewFlipper = findViewById(R.id.view_flipper);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.startScreenButton:
                    default:
                        Intent intent = new Intent(Tutorial.this, SelectionOfParameters.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        mainButton.setOnClickListener(onClickListener);
    }
    public void previousView(View view) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showPrevious();
    }
    public void nextView(View view) {
        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        viewFlipper.showNext();
    }
}