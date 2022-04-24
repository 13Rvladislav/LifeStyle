package com.example.lifestyle.ui.Params;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestyle.R;

import com.example.lifestyle.databinding.FragmentParamsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ParamsFragment extends Fragment {

    //основные параметры
    String color = "";
    String style = "";
    String brand = "";
    String size = "";
    String gender = "";
    String season = "";
    String price = "";
    //прочие параметры
    String age = "";
    String monotone = "";
    String region = "";
    String climate = "";
    String patterns = "";
    String prints = "";

    int CheckInputSize = 0;
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
    String Ot;
    String Do;
    int IntOt;
    int IntDo;
    int Intage;
    String promezh;
    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;
    int str;
    //  ProfileU me = new ProfileU();


    //private ParamsViewModel paramsViewModel;
    private FragmentParamsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_params,
                container, false);
        BtnColors =(Button) view.findViewById(R.id.Sbutton1);
        BtnStyle =(Button) view.findViewById(R.id.Sbutton2);
        BtnBrand =(Button) view.findViewById(R.id.Sbutton3);
        BtnSize = (Button)view.findViewById(R.id.Sbutton4);
        BtnGender =(Button) view.findViewById(R.id.Sbutton5);
        BtnSeason =(Button) view.findViewById(R.id.Sbutton6);
        BtnPrice =(Button) view.findViewById(R.id.Sbutton7);
        BtnPrint =(Button) view.findViewById(R.id.Sbutton8);
        collect_the_onion =(Button) view.findViewById(R.id.collect_the_onion);
///////////////////////////////переменные записиси в бд////////////////////////////////////////////////////////
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
                        dialog = new Dialog(ParamsFragment.this.getActivity());
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
                                if (checkbox3.isChecked()) {
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
                                if (checker != 0) {
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
                    {
                        Button BtnPrint1;
                        dialog = new Dialog(ParamsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_style);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна

                        style = "";
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
                                    style += checkbox1.getText() + " ";
                                    checker++;
                                }
                                if (checkbox2.isChecked()) {
                                    style += checkbox2.getText() + " ";
                                    checker++;
                                }
                                if (checkbox3.isChecked()) {
                                    style += checkbox3.getText() + " ";
                                    checker++;
                                }
                                if (checkbox4.isChecked()) {
                                    style += checkbox4.getText() + " ";
                                    checker++;
                                }
                                if (checkbox5.isChecked()) {
                                    style += checkbox5.getText() + " ";
                                    checker++;
                                }
                                if (checkbox6.isChecked()) {
                                    style += checkbox6.getText() + " ";
                                    checker++;
                                }
                                if (checkbox7.isChecked()) {
                                    style += checkbox7.getText() + " ";
                                    checker++;
                                }
                                if (checkbox8.isChecked()) {
                                    style += checkbox8.getText() + " ";
                                    checker++;
                                }
                                if (checkbox9.isChecked()) {
                                    style += checkbox9.getText() + " ";
                                    checker++;
                                }
                                if (checkbox10.isChecked()) {
                                    style += checkbox10.getText() + " ";
                                    checker++;
                                }
                                if (checker != 0) {
                                    style = style.substring(1);
                                    style = style.substring(1);
                                    style = style.substring(0, style.length() - 1);
                                }
                                dialog.dismiss();//скрыть окно
                            }
                        });
                    }
                    break;
                    case R.id.Sbutton3: {
                        //кнопка бренд
                        dialog = new Dialog(ParamsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_brand);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        brand = "";
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
                        CheckBox checkbox11 = dialog.findViewById(R.id.checkBox11);
                        CheckBox checkbox12 = dialog.findViewById(R.id.checkBox12);
                        CheckBox checkbox13 = dialog.findViewById(R.id.checkBox13);
                        CheckBox checkbox14 = dialog.findViewById(R.id.checkBox14);

                        CheckBox checkbox15 = dialog.findViewById(R.id.checkBox15);

                        checkbox15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (!checkbox15.isChecked()) {
                                    checkbox1.setEnabled(true);
                                    checkbox2.setEnabled(true);
                                    checkbox3.setEnabled(true);
                                    checkbox4.setEnabled(true);
                                    checkbox5.setEnabled(true);
                                    checkbox6.setEnabled(true);
                                    checkbox7.setEnabled(true);
                                    checkbox8.setEnabled(true);
                                    checkbox9.setEnabled(true);
                                    checkbox10.setEnabled(true);
                                    checkbox11.setEnabled(true);
                                    checkbox12.setEnabled(true);
                                    checkbox13.setEnabled(true);
                                    checkbox14.setEnabled(true);
                                    checkbox1.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox2.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox3.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox4.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox5.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox6.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox7.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox8.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox9.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox10.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox11.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox12.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox13.setTextColor(Color.parseColor("#FF000000"));
                                    checkbox14.setTextColor(Color.parseColor("#FF000000"));

                                } else {
                                    checkbox1.setEnabled(false);
                                    checkbox2.setEnabled(false);
                                    checkbox3.setEnabled(false);
                                    checkbox4.setEnabled(false);
                                    checkbox5.setEnabled(false);
                                    checkbox6.setEnabled(false);
                                    checkbox7.setEnabled(false);
                                    checkbox8.setEnabled(false);
                                    checkbox9.setEnabled(false);
                                    checkbox10.setEnabled(false);
                                    checkbox11.setEnabled(false);
                                    checkbox12.setEnabled(false);
                                    checkbox13.setEnabled(false);
                                    checkbox14.setEnabled(false);

                                    checkbox1.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox2.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox3.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox4.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox5.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox6.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox7.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox8.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox9.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox10.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox11.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox12.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox13.setTextColor(Color.parseColor("#c0c0c0"));
                                    checkbox14.setTextColor(Color.parseColor("#c0c0c0"));

                                    checkbox1.setChecked(false);
                                    checkbox2.setChecked(false);
                                    checkbox3.setChecked(false);
                                    checkbox4.setChecked(false);
                                    checkbox5.setChecked(false);
                                    checkbox6.setChecked(false);
                                    checkbox7.setChecked(false);
                                    checkbox8.setChecked(false);
                                    checkbox9.setChecked(false);
                                    checkbox10.setChecked(false);
                                    checkbox11.setChecked(false);
                                    checkbox12.setChecked(false);
                                    checkbox13.setChecked(false);
                                    checkbox14.setChecked(false);
                                }
                            }
                        });

                        Button back_to_houses1 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (checkbox1.isChecked()) {
                                    brand += checkbox1.getText() + " ";
                                    checker++;
                                }
                                if (checkbox2.isChecked()) {
                                    brand += checkbox2.getText() + " ";
                                    checker++;
                                }
                                if (checkbox3.isChecked()) {
                                    brand += checkbox3.getText() + " ";
                                    checker++;
                                }
                                if (checkbox4.isChecked()) {
                                    brand += checkbox4.getText() + " ";
                                    checker++;
                                }
                                if (checkbox5.isChecked()) {
                                    brand += checkbox5.getText() + " ";
                                    checker++;
                                }
                                if (checkbox6.isChecked()) {
                                    brand += checkbox6.getText() + " ";
                                    checker++;
                                }
                                if (checkbox7.isChecked()) {
                                    brand += checkbox7.getText() + " ";
                                    checker++;
                                }
                                if (checkbox8.isChecked()) {
                                    brand += checkbox8.getText() + " ";
                                    checker++;
                                }
                                if (checkbox9.isChecked()) {
                                    brand += checkbox9.getText() + " ";
                                    checker++;
                                }
                                if (checkbox10.isChecked()) {
                                    brand += checkbox10.getText() + " ";
                                    checker++;
                                }
                                if (checkbox11.isChecked()) {
                                    brand += checkbox11.getText() + " ";
                                    checker++;
                                }
                                if (checkbox12.isChecked()) {
                                    brand += checkbox12.getText() + " ";
                                    checker++;
                                }
                                if (checkbox12.isChecked()) {
                                    brand += checkbox12.getText() + " ";
                                    checker++;
                                }
                                if (checkbox13.isChecked()) {
                                    brand += checkbox13.getText() + " ";
                                    checker++;
                                }
                                if (checkbox14.isChecked()) {
                                    brand += checkbox14.getText() + " ";
                                    checker++;
                                }
                                if (checkbox15.isChecked()) {
                                    brand += checkbox15.getText() + " ";
                                    checker++;
                                }
                                if (checker != 0) {
                                    if (!brand.equals(" Неважно ")) {
                                        brand = brand.substring(1);
                                        brand = brand.substring(1);
                                    }
                                    brand = brand.substring(1);

                                }
                                dialog.dismiss();//скрыть окно
                            }
                        });
                    }
                    break;
                    case R.id.Sbutton4: {
                        //кнопка размер
                        dialog = new Dialog(ParamsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_size);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        size = "";
                        checker = 0;
                        CheckInputSize = 0;
                        RadioButton checkbox1 = dialog.findViewById(R.id.radioButton1);
                        RadioButton checkbox2 = dialog.findViewById(R.id.radioButton2);

                        RadioButton checkbox1_1 = dialog.findViewById(R.id.radioButton1_1);
                        RadioButton checkbox1_2 = dialog.findViewById(R.id.radioButton1_2);
                        RadioButton checkbox1_3 = dialog.findViewById(R.id.radioButton1_3);
                        RadioButton checkbox1_4 = dialog.findViewById(R.id.radioButton1_4);
                        RadioButton checkbox1_5 = dialog.findViewById(R.id.radioButton1_5);

                        RadioButton checkbox2_1 = dialog.findViewById(R.id.radioButton2_1);
                        RadioButton checkbox2_2 = dialog.findViewById(R.id.radioButton2_2);
                        RadioButton checkbox2_3 = dialog.findViewById(R.id.radioButton2_3);
                        RadioButton checkbox2_4 = dialog.findViewById(R.id.radioButton2_4);
                        RadioButton checkbox2_5 = dialog.findViewById(R.id.radioButton2_5);

                        checkbox1_1.setEnabled(false);
                        checkbox1_2.setEnabled(false);
                        checkbox1_3.setEnabled(false);
                        checkbox1_4.setEnabled(false);
                        checkbox1_5.setEnabled(false);
                        checkbox2_1.setEnabled(false);
                        checkbox2_2.setEnabled(false);
                        checkbox2_3.setEnabled(false);
                        checkbox2_4.setEnabled(false);
                        checkbox2_5.setEnabled(false);

                        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (checkbox1.isChecked()) {
                                    checkbox1_1.setEnabled(true);
                                    checkbox1_2.setEnabled(true);
                                    checkbox1_3.setEnabled(true);
                                    checkbox1_4.setEnabled(true);
                                    checkbox1_5.setEnabled(true);
                                } else {
                                    checkbox1_1.setEnabled(false);
                                    checkbox1_2.setEnabled(false);
                                    checkbox1_3.setEnabled(false);
                                    checkbox1_4.setEnabled(false);
                                    checkbox1_5.setEnabled(false);

                                    checkbox1_1.setChecked(false);
                                    checkbox1_2.setChecked(false);
                                    checkbox1_3.setChecked(false);
                                    checkbox1_4.setChecked(false);
                                    checkbox1_5.setChecked(false);
                                }
                            }
                        });
                        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (checkbox2.isChecked()) {
                                    checkbox2_1.setEnabled(true);
                                    checkbox2_2.setEnabled(true);
                                    checkbox2_3.setEnabled(true);
                                    checkbox2_4.setEnabled(true);
                                    checkbox2_5.setEnabled(true);
                                } else {
                                    checkbox2_1.setEnabled(false);
                                    checkbox2_2.setEnabled(false);
                                    checkbox2_3.setEnabled(false);
                                    checkbox2_4.setEnabled(false);
                                    checkbox2_5.setEnabled(false);

                                    checkbox2_1.setChecked(false);
                                    checkbox2_2.setChecked(false);
                                    checkbox2_3.setChecked(false);
                                    checkbox2_4.setChecked(false);
                                    checkbox2_5.setChecked(false);
                                }
                            }
                        });


                        Button back_to_houses1 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (checkbox1.isChecked()) {
                                    size += checkbox1.getText() + " ";
                                    checker++;
                                }
                                if (checkbox2.isChecked()) {
                                    size += checkbox2.getText() + " ";
                                    checker++;
                                }
                                if (checkbox1_1.isChecked()) {
                                    size += checkbox1_1.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox1_2.isChecked()) {
                                    size += checkbox1_2.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox1_3.isChecked()) {
                                    size += checkbox1_3.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox1_4.isChecked()) {
                                    size += checkbox1_4.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox1_5.isChecked()) {
                                    size += checkbox1_5.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox2_1.isChecked()) {
                                    size += checkbox2_1.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox2_2.isChecked()) {
                                    size += checkbox2_2.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox2_3.isChecked()) {
                                    size += checkbox2_3.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox2_4.isChecked()) {
                                    size += checkbox2_4.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (checkbox2_5.isChecked()) {
                                    size += checkbox2_5.getText() + " ";
                                    checker++;
                                    CheckInputSize++;
                                }
                                if (CheckInputSize == 0) {
                                    Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Выберите размер!", Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                if (checker != 0) {
                                    size = size.substring(0, size.length() - 1);
                                }
                                dialog.dismiss();//скрыть окно
                            }
                        });
                    }
                    break;
                    case R.id.Sbutton5:
                        //кнопка пол
                    {
                        dialog = new Dialog(ParamsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_gender);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна

                        gender = "";
                        checker = 0;

                        RadioButton checkbox1 = dialog.findViewById(R.id.radioButton1);
                        RadioButton checkbox2 = dialog.findViewById(R.id.radioButton2);


                        Button back_to_houses1 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (checkbox1.isChecked()) {
                                    gender += checkbox1.getText() + " ";
                                    checker++;
                                }
                                if (checkbox2.isChecked()) {
                                    gender += checkbox2.getText() + " ";
                                    checker++;
                                }

                                if (checker != 0) {
                                    gender = gender.substring(0, gender.length() - 1);
                                }
                                dialog.dismiss();//скрыть окно
                            }
                        });
                    }
                    break;
                    case R.id.Sbutton6:
                        //кнопка  сезон
                    {
                        dialog = new Dialog(ParamsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_season);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна

                        season = "";
                        checker = 0;

                        CheckBox checkbox1 = dialog.findViewById(R.id.checkBox1);
                        CheckBox checkbox2 = dialog.findViewById(R.id.checkBox2);
                        CheckBox checkbox3 = dialog.findViewById(R.id.checkBox3);
                        CheckBox checkbox4 = dialog.findViewById(R.id.checkBox4);


                        Button back_to_houses1 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (checkbox1.isChecked()) {
                                    season += checkbox1.getText() + " ";
                                    checker++;
                                }
                                if (checkbox2.isChecked()) {
                                    season += checkbox2.getText() + " ";
                                    checker++;
                                }
                                if (checkbox3.isChecked()) {
                                    season += checkbox3.getText() + " ";
                                    checker++;
                                }
                                if (checkbox4.isChecked()) {
                                    season += checkbox4.getText() + " ";
                                    checker++;
                                }

                                if (checker != 0) {
                                    season = season.substring(1);
                                    season = season.substring(1);
                                    season = season.substring(0, season.length() - 1);
                                }
                                dialog.dismiss();//скрыть окно
                            }
                        });
                    }
                    break;
                    case R.id.Sbutton7:
                        //кнопка цена
                        dialog = new Dialog(ParamsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_price);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        EditText priceOT;
                        EditText priceDO;

                        priceOT = dialog.findViewById(R.id.priceot);
                        priceDO = dialog.findViewById(R.id.pricedo);


                        Button back_to_houses7 = dialog.findViewById(R.id.BtnBackSelect);
                        back_to_houses7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (TextUtils.isEmpty(priceOT.getText().toString())) {
                                    Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Поле 'стоимость от' не заполнено", Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                if (TextUtils.isEmpty(priceDO.getText().toString())) {
                                    Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Поле 'стоимость до' не заполнено", Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                Ot = priceOT.getText().toString();
                                Do = priceDO.getText().toString();

                                String regex = "\\d+";
                                boolean check = true;
                                if (!Ot.matches(regex)) {
                                    check = false;
                                }
                                if (!Do.matches(regex)) {
                                    check = false;
                                }
                                if (check == false) {
                                    Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "неверный формат цены", Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                IntOt= Integer.parseInt (Ot);
                                IntDo= Integer.parseInt (Ot);
                                if (IntOt > IntDo) {
                                    Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "неверный формат цены первое число не может быть больше второго", Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                else {
                                    price += Ot + "-";
                                    price += Do;
                                    dialog.dismiss();//скрыть окно
                                }
                            }
                        });
                        break;
                    case R.id.Sbutton8: {
                        //кнопка прочее
                        dialog = new Dialog(ParamsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.select_other);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окнаButton back_to_houses1 = dialog.findViewById(R.id.BtnBackSelect);
                        EditText ageenter;
                        //однотонность
                        RadioButton checkbox1_1 = dialog.findViewById(R.id.radioButton1_1);
                        RadioButton checkbox1_2 = dialog.findViewById(R.id.radioButton1_2);
                        RadioButton checkbox1_3 = dialog.findViewById(R.id.radioButton1_3);
                        checkbox1_3.setChecked(true);
                        //регион
                        RadioButton checkbox2_1 = dialog.findViewById(R.id.radioButton2_1);
                        RadioButton checkbox2_2 = dialog.findViewById(R.id.radioButton2_2);
                        RadioButton checkbox2_3 = dialog.findViewById(R.id.radioButton2_3);
                        RadioButton checkbox2_4 = dialog.findViewById(R.id.radioButton2_4);
                        RadioButton checkbox2_5 = dialog.findViewById(R.id.radioButton2_5);
                        checkbox2_5.setChecked(true);
                        //климат
                        RadioButton checkbox3_1 = dialog.findViewById(R.id.radioButton3_1);
                        RadioButton checkbox3_2 = dialog.findViewById(R.id.radioButton3_2);
                        RadioButton checkbox3_3 = dialog.findViewById(R.id.radioButton3_3);
                        RadioButton checkbox3_4 = dialog.findViewById(R.id.radioButton3_4);
                        checkbox3_4.setChecked(true);
                        //узоры
                        RadioButton checkbox4_1 = dialog.findViewById(R.id.radioButton4_1);
                        RadioButton checkbox4_2 = dialog.findViewById(R.id.radioButton4_2);
                        RadioButton checkbox4_3 = dialog.findViewById(R.id.radioButton4_3);
                        checkbox4_3.setChecked(true);
                        //принты
                        RadioButton checkbox5_1 = dialog.findViewById(R.id.radioButton5_1);
                        RadioButton checkbox5_2 = dialog.findViewById(R.id.radioButton5_2);
                        RadioButton checkbox5_3 = dialog.findViewById(R.id.radioButton5_3);
                        checkbox5_3.setChecked(true);

                        ageenter = dialog.findViewById(R.id.editTextTextPassword2);
                        Button back_to_houses8 = dialog.findViewById(R.id.BtnBackSelect);

                        monotone = "";
                        region = "";
                        climate = "";
                        patterns = "";
                        prints = "";

                        back_to_houses8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (TextUtils.isEmpty(ageenter.getText().toString())) {
                                    Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Поле 'возраст' не заполнено", Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                promezh = ageenter.getText().toString();
                                IntOt= Integer.parseInt (Ot);
                                String regex = "\\d+";
                                boolean check = true;
                                if (!promezh.matches(regex)) {
                                    check = false;
                                }
                                if (check == false) {
                                    Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "неверный формат возраста", Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                if(check) {
                                    Intage = Integer.parseInt(promezh);
                                }
                                if((Intage <0||Intage>150))
                                {
                                    Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "неверный формат возраста", Toast.LENGTH_SHORT);
                                    toast.show();
                                    return;
                                }
                                else {
                                    age += promezh;
                                }

///////////////////////////////////////
                                if (checkbox1_1.isChecked()) {
                                    monotone += checkbox1_1.getText() + " ";
                                }
                                if (checkbox1_2.isChecked()) {
                                    monotone += checkbox1_2.getText() + " ";
                                }
                                if (checkbox1_3.isChecked()) {
                                    monotone += checkbox1_3.getText() + " ";
                                }
///////////////////////////////////////
                                if (checkbox2_1.isChecked()) {
                                    region += checkbox2_1.getText() + " ";
                                }
                                if (checkbox2_2.isChecked()) {
                                    region += checkbox2_2.getText() + " ";
                                }
                                if (checkbox2_3.isChecked()) {
                                    region += checkbox2_3.getText() + " ";
                                }
                                if (checkbox2_4.isChecked()) {
                                    region += checkbox2_4.getText() + " ";
                                }
                                if (checkbox2_5.isChecked()) {
                                    region += checkbox2_5.getText() + " ";
                                }
///////////////////////////////////////
                                if (checkbox3_1.isChecked()) {
                                    climate += checkbox3_1.getText() + " ";
                                }
                                if (checkbox3_2.isChecked()) {
                                    climate += checkbox3_2.getText() + " ";
                                }
                                if (checkbox3_3.isChecked()) {
                                    climate += checkbox3_3.getText() + " ";
                                }
                                if (checkbox3_4.isChecked()) {
                                    climate += checkbox3_4.getText() + " ";
                                }
///////////////////////////////////////
                                if (checkbox4_1.isChecked()) {
                                    patterns += checkbox4_1.getText() + " ";
                                }
                                if (checkbox4_2.isChecked()) {
                                    patterns += checkbox4_2.getText() + " ";
                                }
                                if (checkbox4_3.isChecked()) {
                                    patterns += checkbox4_3.getText() + " ";
                                }
///////////////////////////////////////
                                if (checkbox5_1.isChecked()) {
                                    prints += checkbox5_1.getText() + " ";
                                }
                                if (checkbox5_2.isChecked()) {
                                    prints += checkbox5_2.getText() + " ";
                                }
                                if (checkbox5_3.isChecked()) {
                                    prints += checkbox5_3.getText() + " ";
                                }
///////////////////////////////////////
                                dialog.dismiss();//скрыть окно
                            }
                        });
                    }
                    break;
                    case R.id.collect_the_onion:
                        //кнопка собрать лук
                        if (color.length() < 1) {
                            Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Параметр цвет не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        } else if (style.length() < 1) {
                            Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Параметр стиль не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        } else if (brand.length() < 1) {
                            Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Параметр бренд не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (size.length() < 1) {
                            Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Параметр размер не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (gender.length() < 1) {
                            Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Параметр пол не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (season.length() < 1) {
                            Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Параметр сезон не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (price.length() < 1) {
                            Toast toast = Toast.makeText(ParamsFragment.this.getActivity(), "Параметр цена не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        users.child(UID).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

//основные параметры
                                users.child(UID).child("color").setValue(color);
                                users.child(UID).child("style").setValue(style);
                                users.child(UID).child("brand").setValue(brand);
                                users.child(UID).child("size").setValue(size);
                                users.child(UID).child("gender").setValue(gender);
                                users.child(UID).child("season").setValue(season);
                                users.child(UID).child("price").setValue(price);
                                //прочее
                                users.child(UID).child("age").setValue(age);
                                users.child(UID).child("monotone").setValue(monotone);
                                users.child(UID).child("region").setValue(region);
                                users.child(UID).child("climate").setValue(climate);
                                users.child(UID).child("patterns").setValue(patterns);
                                users.child(UID).child("prints").setValue(prints);
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
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}