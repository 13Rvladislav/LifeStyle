package com.example.lifestyle;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreen extends AppCompatActivity {
    Button mainButton;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

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
                        Intent intent = new Intent(StartScreen.this, LoadingActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        mainButton.setOnClickListener(onClickListener);

    }
}





