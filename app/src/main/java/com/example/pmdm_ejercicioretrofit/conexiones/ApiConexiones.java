package com.example.pmdm_ejercicioretrofit.conexiones;

import com.example.pmdm_ejercicioretrofit.modelos.DataItem;
import com.example.pmdm_ejercicioretrofit.modelos.Respuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiConexiones {

    @GET("api/users?")
    Call<Respuesta> getUsers(@Query("page") String pagina);

    @GET("api/users?")
    Call<ArrayList<DataItem>> getDatos();



}
