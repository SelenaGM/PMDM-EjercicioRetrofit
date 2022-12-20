package com.example.pmdm_ejercicioretrofit.conexiones;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    private static final String BASE_URL = "https://reqres.in";


    public static Retrofit getConexion(){

        return new Retrofit.Builder()
                //saber la url y la herramienta
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
