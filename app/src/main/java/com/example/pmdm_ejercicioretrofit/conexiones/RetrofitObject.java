package com.example.pmdm_ejercicioretrofit.conexiones;

import com.example.pmdm_ejercicioretrofit.constantes.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    public static Retrofit getConexion(){

        return new Retrofit.Builder()
                //saber la url y la herramienta
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
