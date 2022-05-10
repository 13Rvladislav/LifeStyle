package com.example.lifestyle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lifestyle.models.Clothes;
import com.squareup.picasso.Picasso;

public class RenderedItems extends AppCompatActivity {
int number=0;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendered_items);

        Intent intent = getIntent();
        Clothes[] clothes = (Clothes[]) intent.getExtras().getSerializable("clothes");

        TableLayout layout = (TableLayout) findViewById(R.id.test);

        for (int i = 0; i < clothes.length; i++) {
             number += 1;

            ImageButton tabletext1 = new ImageButton(RenderedItems.this);
            tabletext1.setBackgroundResource (R.color.nv);
            ImageButton tabletext2 = new ImageButton(RenderedItems.this);
            tabletext2.setBackgroundResource (R.color.nv);
            ImageButton tabletext3 = new ImageButton(RenderedItems.this);
            tabletext3.setBackgroundResource (R.color.nv);

            TextView textProduct = new TextView(RenderedItems.this);
            textProduct.setText("образ№" +" "+ number);
            textProduct.setTextSize(24);
            textProduct.setTextColor(Color.parseColor("#FFFFFFFF"));
            textProduct.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER);

            layout.addView(textProduct);
            TableRow newrow = new TableRow(RenderedItems.this);

            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(330, 330);
            layoutParams.setMargins(20, 5, 0, 10);
            tabletext1.setLayoutParams(layoutParams);
            tabletext2.setLayoutParams(layoutParams);
            tabletext3.setLayoutParams(layoutParams);

            layout.addView(newrow);
            Picasso.get()
                    .load(clothes[i].getImg_link())
                    .resize(0, 330)
                    .into(tabletext1);
            Picasso.get()
                    .load(clothes[i].getImg_link())
                    .resize(0, 330)
                    .into(tabletext2);
            Picasso.get()
                    .load(clothes[i].getImg_link())
                    .resize(0, 330)
                    .into(tabletext3);


            newrow.addView(tabletext1);
            newrow.addView(tabletext2);
            newrow.addView(tabletext3);
        }
    }
}