package com.example.pmdm_ejercicioretrofit.conexiones;

import com.example.pmdm_ejercicioretrofit.modelos.Datos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConexiones {

    @GET("/api/users")
    Call<ArrayList<Datos>> getDatos();

}
