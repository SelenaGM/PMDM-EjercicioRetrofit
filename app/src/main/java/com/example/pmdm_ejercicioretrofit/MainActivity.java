package com.example.pmdm_ejercicioretrofit;

import android.os.Bundle;

import com.example.pmdm_ejercicioretrofit.conexiones.ApiConexiones;
import com.example.pmdm_ejercicioretrofit.conexiones.RetrofitObject;
import com.example.pmdm_ejercicioretrofit.modelos.Datos;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import com.example.pmdm_ejercicioretrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        doGetDatos();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void doGetDatos() {
        Retrofit retrofit = RetrofitObject.getConexion();
        ApiConexiones api = retrofit.create(ApiConexiones.class);
        Call<ArrayList<Datos>> getDatos= api.getDatos();

        getDatos.enqueue(new Callback<ArrayList<Datos>>() {
            @Override
            public void onResponse(Call<ArrayList<Datos>> call, Response<ArrayList<Datos>> response) {
                if(response.code()== HttpsURLConnection.HTTP_OK){

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Datos>> call, Throwable t) {

            }
        });
    }

}