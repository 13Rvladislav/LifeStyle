package com.example.lifestyle;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lifestyle.models.ProfileU;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SelectionOfParameters extends AppCompatActivity {
    String color = "";
    String style;
    String brand;
    String size;
    String gender;
    String season;
    String price;
    String print;

    Button BtnColors;
    Button BtnStyle;
    Button BtnBrand;
    Button BtnSize;
    Button BtnGender;
    Button BtnSeason;
    Button BtnPrice;
    Button BtnPrint;
    Button collect_the_onion;
    Dialog dialog;//диалоговое окно

    int checker = 0;

    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;
    int str;
  //  ProfileU me = new ProfileU();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_of_parameters);
        getSupportActionBar().hide();

        BtnColors = findViewById(R.id.Sbutton1);
        BtnStyle = findViewById(R.id.Sbutton2);
        BtnBrand = findViewById(R.id.Sbutton3);
        BtnSize = findViewById(R.id.Sbutton4);
        BtnGender = findViewById(R.id.Sbutton5);
        BtnSeason = findViewById(R.id.Sbutton6);
        BtnPrice = findViewById(R.id.Sbutton7);
        BtnPrint = findViewById(R.id.Sbutton8);
        collect_the_onion = findViewById(R.id.collect_the_onion);
///////////////////////////////////////////////////////////////////////////////////////
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        String UID = user1.getUid();
///////////////////////////////////////////////////////////////////////////////////////
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Sbutton1:
                        //кнопка  цвет
                    {
                        dialog = new Dialog(SelectionOfParameters.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_colors);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна

                        color = "";
                        checker = 0;

                        CheckBox checkbox1 = dialog.findViewById(R.id.checkBox1);
                        CheckBox checkbox2 = dialog.findViewById(R.id.checkBox2);
                        CheckBox checkbox3 = dialog.findViewById(R.id.checkBox3);
                        CheckBox checkbox4 = dialog.findViewById(R.id.checkBox4);
                        CheckBox checkbox5 = dialog.findViewById(R.id.checkBox5);
                        CheckBox checkbox6 = dialog.findViewById(R.id.checkBox6);
                        CheckBox checkbox7 = dialog.findViewById(R.id.checkBox7);
                        CheckBox checkbox8 = dialog.findViewById(R.id.checkBox8);
                        CheckBox checkbox9 = dialog.findViewById(R.id.checkBox9);
                        CheckBox checkbox10 = dialog.findViewById(R.id.checkBox10);

                        Button back_to_houses1 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (checkbox1.isChecked()) {
                                    color += checkbox1.getText() + " ";
                                    checker++;
                                }
                                if (checkbox2.isChecked()) {
                                    color += checkbox2.getText() + " ";
                                    checker++;
                                }
                                if (checkbox3.isChecked()){
                                    color += checkbox3.getText() + " ";
                                    checker++;
                                }
                                if (checkbox4.isChecked()) {
                                    color += checkbox4.getText() + " ";
                                    checker++;
                                }
                                if (checkbox5.isChecked()) {
                                    color += checkbox5.getText() + " ";
                                    checker++;
                                }
                                if (checkbox6.isChecked()) {
                                    color += checkbox6.getText() + " ";
                                    checker++;
                                }
                                if (checkbox7.isChecked()) {
                                    color += checkbox7.getText() + " ";
                                    checker++;
                                }
                                if (checkbox8.isChecked()) {
                                    color += checkbox8.getText() + " ";
                                    checker++;
                                }
                                if (checkbox9.isChecked()) {
                                    color += checkbox9.getText() + " ";
                                    checker++;
                                }
                                if (checkbox10.isChecked()) {
                                    color += checkbox10.getText() + " ";
                                    checker++;
                                }
                                if (checker!=0) {
                                    color = color.substring(1);
                                    color = color.substring(1);
                                    color = color.substring(0, color.length() - 1);
                                }
                                dialog.dismiss();//скрыть окно
                            }
                        });
                    }
                    break;
                    case R.id.Sbutton2:
                        //кнопка стиль
                        Button BtnPrint1;
                        dialog = new Dialog(SelectionOfParameters.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_style);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна

                        Button back_to_houses2 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();//скрыть окно
                            }
                        });
                        break;
                    case R.id.Sbutton3:

                        //кнопка бренд
                        dialog = new Dialog(SelectionOfParameters.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_brand);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        Button back_to_houses3 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();//скрыть окно
                            }
                        });
                        break;
                    case R.id.Sbutton4:
                        //кнопка размер
                        dialog = new Dialog(SelectionOfParameters.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_size);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        Button back_to_houses4 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();//скрыть окно
                            }
                        });
                        break;
                    case R.id.Sbutton5:
                        //кнопка пол
                        dialog = new Dialog(SelectionOfParameters.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_gender);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        Button back_to_houses5 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();//скрыть окно
                            }
                        });
                        break;
                    case R.id.Sbutton6:
                        //кнопка  сезон
                        dialog = new Dialog(SelectionOfParameters.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_season);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        Button back_to_houses6 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();//скрыть окно
                            }
                        });
                        break;
                    case R.id.Sbutton7:
                        //кнопка цена
                        dialog = new Dialog(SelectionOfParameters.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_price);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        Button back_to_houses7 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();//скрыть окно
                            }
                        });
                        break;
                    case R.id.Sbutton8:
                        //кнопка принт
                        dialog = new Dialog(SelectionOfParameters.this);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_other);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        Button back_to_houses8 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();//скрыть окно
                            }
                        });
                        break;
                    case R.id.collect_the_onion:
                        //кнопка принт
                        if (color.length()<1) {
                            Toast toast = Toast.makeText(SelectionOfParameters.this, "Параметр цвет не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        users.child(UID).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {


                                    users.child(UID).child("color").setValue(color);

                                   // users.child(UID).child("algorithm").setValue(a);

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        break;
                }
            }
        };
        BtnColors.setOnClickListener(onClickListener);
        BtnStyle.setOnClickListener(onClickListener);
        BtnBrand.setOnClickListener(onClickListener);
        BtnSize.setOnClickListener(onClickListener);
        BtnGender.setOnClickListener(onClickListener);
        BtnSeason.setOnClickListener(onClickListener);
        BtnPrice.setOnClickListener(onClickListener);
        BtnPrint.setOnClickListener(onClickListener);
        collect_the_onion.setOnClickListener(onClickListener);
    }
}