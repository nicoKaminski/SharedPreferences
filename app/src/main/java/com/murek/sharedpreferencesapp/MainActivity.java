package com.murek.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.murek.sharedpreferencesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Leer el correo electrónico guardado al iniciar la app
        SharedPreferences preferences = getSharedPreferences("mi_mail", Context.MODE_PRIVATE);
        String mail = preferences.getString("mail", "");
        binding.etMail.setText(mail);
    }

    public void guardarMail(View view) {
        String mail = binding.etMail.getText().toString();
        SharedPreferences preferences = getSharedPreferences("mi_mail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("mail", mail);
        editor.commit();
        finish();
    }

}