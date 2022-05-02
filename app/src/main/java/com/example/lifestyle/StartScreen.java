package com.example.lifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartScreen extends AppCompatActivity {
Button mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        /// Test API

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<Weather> call = apiInterface.getWeatherInformation("35", "139", "c00d724545894ac3d6c9508c9e52825f");

        System.out.println("asdasdasd");

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                System.out.println(response.body().getCoord());
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                System.out.println(t);
            }
        });

        ////
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

