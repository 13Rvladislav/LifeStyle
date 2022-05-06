package com.example.lifestyle.ui.Settings;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestyle.R;
import com.example.lifestyle.StartScreen;
import com.example.lifestyle.databinding.FragmentSettingsBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SettingsFragment extends Fragment {

    private com.example.lifestyle.ui.Settings.ExitViewModel exitViewModel;
    private FragmentSettingsBinding binding;
    Dialog dialog;
    Button changePass;
    Button changename;
    ImageButton cansel;
    int chet = 0;
    private FirebaseAuth firebaseAuth;
    protected FirebaseAuth mAuth;
    private ProgressDialog pd;

    //UI widgets
    private EditText oldPass, newPass, newPassRepeat, name;
    private Button updatePasswordBtn;
    private Button updateNameProfile;
    private Button Exit;
    private Button out;
    FirebaseAuth auth;
    FirebaseDatabase DB;
    DatabaseReference users;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Exit= (Button) view.findViewById(R.id.Exit);
        changePass = (Button) view.findViewById(R.id.updatePass);
        changename = (Button) view.findViewById(R.id.updateNameProfile);

        pd = new ProgressDialog(this.getActivity());
        pd.setMessage("Please Wait...");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.updatePass:
                        //кнопка смена пароля
                    {
                        dialog = new Dialog(SettingsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.settings_password_change);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна

                        cansel = dialog.findViewById(R.id.close);

                        oldPass = (EditText) dialog.findViewById(R.id.oldpass);
                        newPass = dialog.findViewById(R.id.newpass);
                        newPassRepeat = dialog.findViewById(R.id.newpassrepeat);
                        updatePasswordBtn = dialog.findViewById(R.id.updatePassProfile);
//смена пароля
                        cansel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.cancel();
                            }
                        });
                        updatePasswordBtn.setOnClickListener(new View.OnClickListener() {
                                                                 @Override
                                                                 public void onClick(View v) {

                                                                     String oldPassword = oldPass.getText().toString().trim();
                                                                     String newPassword = newPass.getText().toString().trim();
                                                                     //validate data
                                                                     if (TextUtils.isEmpty(oldPassword)) {
                                                                         Toast.makeText(SettingsFragment.this.getActivity(), "Введите ваш текущий пароль...", Toast.LENGTH_SHORT).show();
                                                                         return; //don't proceed further
                                                                     }
                                                                     String pass1 = newPass.getText().toString();
                                                                     String pass2 = newPassRepeat.getText().toString();
                                                                     boolean passcorrect = pass1.equalsIgnoreCase(pass2);
                                                                     if (!passcorrect) {
                                                                         Toast toast = Toast.makeText(SettingsFragment.this.getActivity(), "пароли не совпадают", Toast.LENGTH_SHORT);
                                                                         toast.show();
                                                                         return;
                                                                     }
                                                                     if (newPassword.length() < 5) {
                                                                         Toast.makeText(SettingsFragment.this.getActivity(), "Длина пароля должна быть не менее 6 символов...", Toast.LENGTH_SHORT).show();
                                                                         return;  //don't proceed further
                                                                     }
                                                                     updatePassword(oldPassword, newPassword);
                                                                 }
                                                             }
                        );

                        break;
                    }
                    case R.id.Exit:
                    {
                        dialog = new Dialog(SettingsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.settings_exit);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна

                        mAuth = FirebaseAuth.getInstance();
                        out = dialog.findViewById(R.id.exit);
                        cansel = dialog.findViewById(R.id.close);
                        cansel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.cancel();
                            }
                        });
                        out.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                {
                                    Intent intent = new Intent(getActivity(), StartScreen.class);
                                    mAuth.getInstance().signOut();
                                    startActivity(intent);
                                }
                            }

                        });
                        break;
                    }
                    case R.id.updateNameProfile:
                        //смена имени профиля
                    {
                        dialog = new Dialog(SettingsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.settings_profile_change);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна
                        cansel = dialog.findViewById(R.id.close);
                        name = (EditText) dialog.findViewById(R.id.name);
                        updateNameProfile = dialog.findViewById(R.id.updateNameProfile);
                        cansel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.cancel();
                            }
                        });
                        updateNameProfile.setOnClickListener(new View.OnClickListener() {
                                                                 @Override
                                                                 public void onClick(View v) {
                                                                     if (TextUtils.isEmpty(name.getText().toString())) {
                                                                         Toast toast = Toast.makeText(SettingsFragment.this.getActivity(), "Поле 'имя' не заполнено", Toast.LENGTH_SHORT);
                                                                         toast.show();
                                                                         return;
                                                                     }

                                                                     String newName = name.getText().toString();
                                                                     for (int i = 0; i < newName.length(); i++)
                                                                         if (newName.charAt(i) == ' ')
                                                                             chet++;
                                                                     if (chet != 0) {
                                                                         Toast toast = Toast.makeText(SettingsFragment.this.getActivity(), "имя не может содержать пробелы", Toast.LENGTH_SHORT);
                                                                         toast.show();
                                                                         return;
                                                                     }
                                                                     //validate data
                                                                     updateName(newName);

                                                                 }
                                                             }
                        );
                        break;
                    }


                }
            }


        };
        changePass.setOnClickListener(onClickListener);
        changename.setOnClickListener(onClickListener);
        Exit.setOnClickListener(onClickListener);

        return view;
    }

    private void updateName(String name) {
        auth = FirebaseAuth.getInstance();
        FirebaseUser user1 = auth.getCurrentUser();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        String UID = user1.getUid();
        users.child(UID).child("name").setValue(name);
        Toast.makeText(SettingsFragment.this.getActivity(), "имя успешно обновлено...", Toast.LENGTH_SHORT).show();
        dialog.cancel();
    }

    private void updatePassword(String oldPassword, final String newPassword) {
        //show dialog
        pd.show();

        //get current user
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();

        //before changing password re-authenticate the user
        AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(), oldPassword);
        user.reauthenticate(authCredential)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //successfully authenticated, begin update

                        user.updatePassword(newPassword)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        //password updated
                                        pd.dismiss();
                                        Toast.makeText(SettingsFragment.this.getActivity(), "пароль успешно обновлен...", Toast.LENGTH_SHORT).show();
                                        dialog.cancel();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //failed updating password, show reason
                                        pd.dismiss();
                                        Toast.makeText(SettingsFragment.this.getActivity(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //authentication failed, show reason
                        pd.dismiss();
                        Toast.makeText(SettingsFragment.this.getActivity(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}