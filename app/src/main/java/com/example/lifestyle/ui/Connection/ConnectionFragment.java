package com.example.lifestyle.ui.Connection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.lifestyle.databinding.FragmentConnectionBinding;
import com.example.lifestyle.databinding.FragmentProfileBinding;


public class ConnectionFragment extends Fragment {

    private ConnectionViewModel connectionViewModel;
    private FragmentConnectionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        connectionViewModel = new ViewModelProvider(this).get(ConnectionViewModel.class);

        binding = FragmentConnectionBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}