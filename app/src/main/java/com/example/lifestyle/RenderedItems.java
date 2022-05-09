package com.example.lifestyle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class RenderedItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendered_items);

        Intent intent = getIntent();
        Clothes[] clothes = (Clothes[]) intent.getExtras().getSerializable("clothes");

        TableLayout mainLayout = (TableLayout) findViewById(R.id.test);

        for (int i = 0; i < clothes.length; i++) {
            ImageView imageView = new ImageView(RenderedItems.this);
            Picasso.get()
                    .load(clothes[i].getImg_link())
                    .into(imageView);
            TextView textProduct = new TextView(RenderedItems.this);
            textProduct.setText(clothes[i].getName());

            mainLayout.addView(imageView);
            mainLayout.addView(textProduct);
        }
    }
}