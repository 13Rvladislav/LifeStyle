package com.example.lifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityAutorization extends AppCompatActivity {
    Button regButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorization);
        regButton = (Button) findViewById(R.id.buttonReg);
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonReg:
                    default:
                        Intent intent = new Intent(ActivityAutorization.this, ActivityRegistration.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        regButton.setOnClickListener(onClickListener);
    }
}