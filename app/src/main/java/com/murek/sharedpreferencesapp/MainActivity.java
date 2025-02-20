package com.murek.sharedpreferencesapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.murek.sharedpreferencesapp.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String archivos[] = fileList();
        if (archivosExiste(archivos, "informacion")) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("informacion"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String lineaTodas = "";

                while (linea != null) {
                    lineaTodas += linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                binding.etBitacora.setText(lineaTodas);
            } catch (Exception e) {
            }
        }
    }

    public boolean archivosExiste(String archivos [] , String NombreArchivo) {
        for (int i = 0; i < archivos.length; i++) {
            if (NombreArchivo.equals(archivos[i])) return true;
        }
        return false;
    }

    public void guardarBitacora(View view) {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("informacion", Context.MODE_PRIVATE));
            archivo.write(binding.etBitacora.getText().toString());
            archivo.flush(); //limpia
            archivo.close();
        } catch (Exception e) {}
        Toast.makeText(this, "Bitacora guardada", Toast.LENGTH_SHORT).show();
        finish();
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