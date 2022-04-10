package com.example.lifestyle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityAutorization extends AppCompatActivity {
    Button buttonreggistration;
    Button buttonautirisation;
    Button buttonmisspassword;

    EditText email;
    EditText password;

    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorization);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();

        buttonmisspassword = (Button) findViewById(R.id.misspassword);
        buttonreggistration = (Button) findViewById(R.id.buttonReg);
        buttonautirisation = (Button) findViewById(R.id.btnmiss);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.Password);

        auth = FirebaseAuth.getInstance();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonReg: {
                        Intent intent = new Intent(ActivityAutorization.this, ActivityRegistration.class);
                        startActivity(intent);
                        break;
                    }

                    case R.id.misspassword: {
                        Intent intent = new Intent(ActivityAutorization.this, MissPassword.class);
                        startActivity(intent);
                        break;
                    }

                    case R.id.btnmiss:
                        if (TextUtils.isEmpty(email.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityAutorization.this, "Поле 'email' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }

                        if (TextUtils.isEmpty(password.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityAutorization.this, "Поле 'пароль' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;

                        }
                        auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        if (auth.getCurrentUser() != null) {
                                            boolean isEmailVerified = auth.getCurrentUser().isEmailVerified();
                                            if (isEmailVerified) {
                                                Intent intent = new Intent(ActivityAutorization.this, Tutorial.class);
                                                startActivity(intent);
                                            } else {
                                                Toast toast = Toast.makeText(ActivityAutorization.this, "Верефицируйте ваш аккаунт!", Toast.LENGTH_SHORT);
                                                toast.show();
                                            }
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast toast = Toast.makeText(ActivityAutorization.this, "Ошибка авторизации" + e.getMessage(), Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        });

                }
            }
        };
        buttonautirisation.setOnClickListener(onClickListener);
        buttonreggistration.setOnClickListener(onClickListener);
        buttonmisspassword.setOnClickListener(onClickListener);
    }
}

