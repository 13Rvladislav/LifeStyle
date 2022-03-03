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

import com.example.lifestyle.models.ProfileU;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityRegistration extends AppCompatActivity {
    Button btnRegistration;//кнопка зарегестрироваться
    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;
    //объявление полей ввода
    EditText email;
    EditText name;
    EditText password1;
    EditText password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//выключение поворота экрана
        getSupportActionBar().hide();
        //поля ввода
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.Username);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();


        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        btnRegistration = (Button) findViewById(R.id.buttonReg);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonReg:
                        if (TextUtils.isEmpty(email.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "Поле 'email' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(name.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "Поле 'имя пользователя' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(password1.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "Поле 'пароль' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (TextUtils.isEmpty(password2.getText().toString())) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "Поле 'повторить пароль' не заполнено", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        if (password1.getText().toString().length() < 5) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "слишком короткий пароль", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }
                        String pass1 = password1.getText().toString();
                        String pass2 = password2.getText().toString();
                        boolean passcorrect = pass1.equalsIgnoreCase(pass2);
                        if (!passcorrect) {
                            Toast toast = Toast.makeText(ActivityRegistration.this, "пароли не совпадают", Toast.LENGTH_SHORT);
                            toast.show();
                            return;
                        }

                        //регистрация пользователя
                        auth.createUserWithEmailAndPassword(email.getText().toString(), password1.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                ProfileU user = new ProfileU();
                                user.setName(name.getText().toString());


                                user1.sendEmailVerification()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(ActivityRegistration.this,
                                                            "письмо верификации отправлено на ваш email", Toast.LENGTH_LONG).show();
                                                } else {
                                                    Toast.makeText(ActivityRegistration.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                                }
                                            }
                                        });

                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {

                                                Toast toast = Toast.makeText(ActivityRegistration.this, "Пользователь успешно зарегистрирован!", Toast.LENGTH_SHORT);
                                                toast.show();
                                                Intent intent = new Intent(ActivityRegistration.this, ActivityAutorization.class);
                                                startActivity(intent);
                                            }
                                        });
                            }
                        });


                }
            }
        };

        btnRegistration.setOnClickListener(onClickListener);


    }

}