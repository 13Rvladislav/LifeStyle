package com.example.lifestyle.ui.Settings;

import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestyle.R;
import com.example.lifestyle.databinding.FragmentSettingsBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModel;
    private FragmentSettingsBinding binding;
    Dialog dialog;//диалоговое окно
    Button change;

    private FirebaseAuth firebaseAuth;

    private ProgressDialog pd;

    //UI widgets
    private EditText oldPass, newPass, newPassRepeat;
    private Button updatePasswordBtn;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        change = (Button) view.findViewById(R.id.change);


        pd = new ProgressDialog(this.getActivity());
        pd.setMessage("Please Wait...");

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.change:
                        //кнопка  цвет
                    {
                        dialog = new Dialog(SettingsFragment.this.getActivity());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрыть заголовок
                        dialog.setContentView(R.layout.settings_password_change);//путь к макету диалогового окна
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
                        dialog.setCancelable(false);//не закрывается кнопкой назад
                        dialog.show();//показ окна

                        oldPass = (EditText) dialog.findViewById(R.id.oldpass);
                        newPass = dialog.findViewById(R.id.newpass);
                        newPassRepeat = dialog.findViewById(R.id.newpassrepeat);
                        updatePasswordBtn = dialog.findViewById(R.id.updatePasswordBtn);
//input data
                        updatePasswordBtn.setOnClickListener(new View.OnClickListener() {
                                                                 @Override
                                                                 public void onClick(View v) {

                                                                     String oldPassword = oldPass.getText().toString().trim();
                                                                     String newPassword = newPass.getText().toString().trim();
                                                                     //validate data
                                                                     if (TextUtils.isEmpty(oldPassword)) {
                                                                         Toast.makeText(SettingsFragment.this.getActivity(), "Enter your current password...", Toast.LENGTH_SHORT).show();
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
                                                                         Toast.makeText(SettingsFragment.this.getActivity(), "Password length must atleast 6 characters...", Toast.LENGTH_SHORT).show();
                                                                         return;  //don't proceed further
                                                                     }
                                                                     updatePassword(oldPassword, newPassword);

                                                                 }
                                                             }
                        );
                    }

                }
            }
        };
        change.setOnClickListener(onClickListener);
        return view;
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
                                        Toast.makeText(SettingsFragment.this.getActivity(), "Password Updated...", Toast.LENGTH_SHORT).show();
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