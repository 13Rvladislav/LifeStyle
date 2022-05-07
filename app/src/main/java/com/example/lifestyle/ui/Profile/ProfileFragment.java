package com.example.lifestyle.ui.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestyle.R;
import com.example.lifestyle.databinding.FragmentProfileBinding;
import com.example.lifestyle.models.ProfileU;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {

    private com.example.lifestyle.ui.Settings.ExitViewModel exitViewModel;
    private FragmentProfileBinding binding;


    //UI widgets

    private TextView NameU;
    private TextView Email;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    FirebaseDatabase DB;
    DatabaseReference users;
    String UID;
    String name;
    ProfileU me = new ProfileU();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        NameU = (TextView) view.findViewById(R.id.PersonName);
        Email = (TextView) view.findViewById(R.id.PersonEmail);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        UID = currentUser.getUid();
        DB = FirebaseDatabase.getInstance();
        users = DB.getReference("Users");
        updateHeader();


        return view;

    }

    public void updateHeader() {

        String GE = Email.getText().toString();
        String GN = NameU.getText().toString();
        Email.setText(GE + " " + currentUser.getEmail());
        users.child(UID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                me = snapshot.getValue(ProfileU.class);
                name = me.getName();
                NameU.setText(GN+" "+name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}