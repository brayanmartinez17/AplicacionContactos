package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.listview.databinding.ActivityMainBinding;
import com.example.listview.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intento = this.getIntent();
        if (intento != null){
            String name = intento.getStringExtra("name");
            String phone = intento.getStringExtra("phone");
            String country = intento.getStringExtra("country");
            int imageid = intento.getIntExtra("imageid",R.drawable.depredador);
            binding.nameProfile.setText(name);
            binding.phoneProfile.setText(phone);
            binding.countryProfile.setText(country);
            binding.profileImage.setImageResource(imageid);
        }
    }
}