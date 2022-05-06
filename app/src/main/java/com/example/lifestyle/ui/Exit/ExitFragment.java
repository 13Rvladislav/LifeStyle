package com.example.lifestyle.ui.Exit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestyle.LoadingActivity;
import com.example.lifestyle.R;
import com.example.lifestyle.StartScreen;
import com.example.lifestyle.databinding.FragmentExitBinding;
import com.example.lifestyle.ui.Settings.ExitViewModel;
import com.google.firebase.auth.FirebaseAuth;


public class ExitFragment extends Fragment {

    private ExitViewModel settingsViewModel;
    private FragmentExitBinding binding;
    ImageButton cansel;
    protected FirebaseAuth mAuth;

    private ProgressDialog pd;

    //UI widgets
    private EditText oldPass, newPass, newPassRepeat, name;
    private Button updatePasswordBtn;
    private Button Exit;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exit, container, false);
        binding = FragmentExitBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mAuth = FirebaseAuth.getInstance();
        Exit = view.findViewById(R.id.exit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent intent = new Intent(getActivity(), StartScreen.class);
                    mAuth.getInstance().signOut();
                    startActivity(intent);
                }
            }

        });

        return view;
        }


        @Override
        public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }
    }