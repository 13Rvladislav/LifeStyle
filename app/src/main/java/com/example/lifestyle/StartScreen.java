package com.example.lifestyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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
                        Intent intent = new Intent(StartScreen.this, ActivityAutorization.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        mainButton.setOnClickListener(onClickListener);

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
        String key = "";
        String url = "http://18.132.46.198:5000/clothes";
        new GetUrl().execute(url);
    }

    private class GetUrl extends AsyncTask<String, String, String> {
        Context context;

        private void MyAsyncTask(Context context) {
            this.context = context.getApplicationContext();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
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
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    protected void NewAct(JSONObject jsonobj) {
        Intent intent = new Intent(StartScreen.this, RenderedItems.class);

        try {
            Clothes []clothesArray = new Clothes[3];
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

class Clothes implements Serializable {
    private String address;
    private Integer cost;
    private String img_link;
    private String name;

    public Clothes(String address, Integer cost, String img_link, String name) {
        this.address = address;
        this.cost = cost;
        this.img_link = img_link;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

