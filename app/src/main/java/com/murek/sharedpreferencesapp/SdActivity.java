package com.murek.sharedpreferencesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.murek.sharedpreferencesapp.databinding.ActivitySdBinding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SdActivity extends AppCompatActivity {

    private ActivitySdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

    }

    //mostrar y ocultar menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //funciones a menu
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item2) {
            Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3) {
            Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void guardarNota(View view) {
        String nombre = binding.etNombreNota.getText().toString();
        String datos = binding.etNotas.getText().toString();

        try {
            File tarjetaSd = Environment.getExternalStorageDirectory();
            Toast.makeText(this, tarjetaSd.getPath(), Toast.LENGTH_SHORT).show();
            File ruta = new File(tarjetaSd.getPath(), nombre);
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombre, SdActivity.MODE_PRIVATE));
            archivo.write(datos);
            archivo.flush();
            archivo.close();
            Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show();
            binding.etNombreNota.setText("");
            binding.etNotas.setText("");
        } catch (Exception e) {
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
        }
    }

    public void consultarNota(View view) {
        String nombre = binding.etNombreNota.getText().toString();
        try {
            File tarjetaSd = Environment.getExternalStorageDirectory();
            File archivo = new File(tarjetaSd.getPath(), nombre);
            InputStreamReader archivoReader = new InputStreamReader(openFileInput(nombre));
                BufferedReader br = new BufferedReader(archivoReader);
                String linea = br.readLine();
                String lineaTodas = "";
                while (linea != null) {
                    lineaTodas += linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivoReader.close();
                binding.etNotas.setText(lineaTodas);
        } catch (Exception e) {
            Toast.makeText(this, "Error al consultar", Toast.LENGTH_SHORT).show();
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