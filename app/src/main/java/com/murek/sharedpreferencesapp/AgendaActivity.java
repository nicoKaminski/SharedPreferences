package com.murek.sharedpreferencesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.murek.sharedpreferencesapp.databinding.ActivityAgendaBinding;
import com.murek.sharedpreferencesapp.databinding.ActivityMainBinding;

public class AgendaActivity extends AppCompatActivity {

    private ActivityAgendaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAgendaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void guardarInfo (View view) {
        String nombre = binding.etNombre.getText().toString();
        String datos = binding.etInfo.getText().toString();
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(nombre, datos);
        editor.commit();

        Toast.makeText(this, "Contacto guardado", Toast.LENGTH_SHORT).show();
    }

    public void buscarInfo (View view) {
        String nombre = binding.etNombre.getText().toString();
        SharedPreferences preferences = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = preferences.getString(nombre, "");

        if (datos.length() == 0) {
            Toast.makeText(this, "Contacto no encontrado", Toast.LENGTH_SHORT).show();
        } else {
            binding.etInfo.setText(datos);
            Toast.makeText(this, "Contacto encontrado: " + datos, Toast.LENGTH_SHORT).show();
        }
    }

    public void irPag1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void irPag2(View view) {
        Intent intent = new Intent(this, AgendaActivity.class);
        startActivity(intent);
    }

    public void irPag3(View view) {
        Intent intent = new Intent(this, SdActivity.class);
        startActivity(intent);
    }

}