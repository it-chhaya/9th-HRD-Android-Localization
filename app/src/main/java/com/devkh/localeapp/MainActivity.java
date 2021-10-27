package com.devkh.localeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devkh.localeapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // bind event
        onButtonKhmerClicked();
        onButtonEnglishClicked();
        onButtonGoToClicked();

    }

    private void onButtonKhmerClicked() {
        // TODO
        binding.buttonKhmer.setOnClickListener(view -> {
            // Change language to Khmer
            LocaleUtils.setLocaleCode(this, LocaleUtils.KHMER);
            recreate();
        });
    }

    private void onButtonEnglishClicked() {
        // TODO
        binding.buttonEnglish.setOnClickListener(view -> {
            // Change language to English
            LocaleUtils.setLocaleCode(this, LocaleUtils.ENGLISH);
            recreate();
        });
    }

    private void onButtonGoToClicked() {
        binding.buttonGoTo.setOnClickListener(view -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        ContextWrapper localeContextWrapper = LocaleUtils.updateLocale(newBase);
        super.attachBaseContext(localeContextWrapper);
    }

}