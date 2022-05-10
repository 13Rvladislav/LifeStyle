package com.example.lifestyle;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lifestyle.models.Clothes;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadingActivity extends AppCompatActivity {
    TextView result_info;
    JSONObject Json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Intent intent = getIntent();

        String color = intent.getStringExtra("color");
        String style = intent.getStringExtra("style");
        String brand = intent.getStringExtra("brand");
        String size = intent.getStringExtra("size");
        String gender = intent.getStringExtra("gender");
        String season = intent.getStringExtra("season");
        String price = intent.getStringExtra("price");

        String age = intent.getStringExtra("age");
        String monotone = intent.getStringExtra("monotone");
        String region = intent.getStringExtra("region");
        String climate = intent.getStringExtra("climate");
        String patterns = intent.getStringExtra("patterns");
        String prints = intent.getStringExtra("prints");
        result_info = findViewById(R.id.Loader);
        String key = "";
        String url = "http://18.132.46.198:5000/clothes";
        new GetUrl().execute(url);

/*
        Intent intent1 = new Intent(LoadingActivity.this, RenderedItems.class);
        intent.putExtra("jsonItems", (Parcelable) Json);
        startActivity(intent1);
        System.out.println(str);

 */
    }

    private class GetUrl extends AsyncTask<String, String, String> {
        Context context;

        private void MyAsyncTask(Context context) {
            this.context = context.getApplicationContext();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            result_info.setText("жди брат...");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
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
                NewAct(jsonobj);
                // for (int i = 0; i < jsonobj.Length; i++)
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

        protected void NewAct(JSONObject jsonobj) {
            Intent intent = new Intent(LoadingActivity.this, RenderedItems.class);

            try {
                Clothes[]clothesArray = new Clothes[3];
                clothesArray[0] = new Clothes(jsonobj.getString("address"), jsonobj.getInt("cost"), jsonobj.getString("img_link"), jsonobj.getString("name"));
                clothesArray[1] = new Clothes(jsonobj.getString("address"), jsonobj.getInt("cost"), jsonobj.getString("img_link"), jsonobj.getString("name"));
                clothesArray[2] = new Clothes(jsonobj.getString("address"), jsonobj.getInt("cost"), jsonobj.getString("img_link"), jsonobj.getString("name"));

                intent.putExtra("clothes", clothesArray);
                startActivity(intent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
