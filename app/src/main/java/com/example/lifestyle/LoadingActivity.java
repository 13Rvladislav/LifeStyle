package com.example.lifestyle;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class LoadingActivity extends AppCompatActivity {
    TextView result_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Intent intent = getIntent();
        String color= intent.getStringExtra("color");
        String style= intent.getStringExtra("style");
        String brand= intent.getStringExtra("brand");
        String size= intent.getStringExtra("size");
        String gender= intent.getStringExtra("gender");
        String season= intent.getStringExtra("season");
        String price= intent.getStringExtra("price");

        String age= intent.getStringExtra("age");
        String monotone= intent.getStringExtra("monotone");
        String region= intent.getStringExtra("region");
        String climate= intent.getStringExtra("climate");
        String patterns= intent.getStringExtra("patterns");
        String prints= intent.getStringExtra("prints");
        result_info = findViewById(R.id.Loader);
        String key = "";
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=c00d724545894ac3d6c9508c9e52825f";
        new GetUrl().execute(url);
    }

    private class GetUrl extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            result_info.setText("жди брат...");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpsURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(strings[0]);
                connection = (HttpsURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line;
                //  while ((line = reader.readLine()) != null)

                buffer.append(reader.readLine());
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    connection.disconnect();

                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject jsonobj = new JSONObject(result);
               // for (int i = 0; i < jsonobj.Length; i++)
                    result_info.setText("Температура" + jsonobj.getJSONObject("main").getDouble("temp"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}