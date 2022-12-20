package com.example.pmdm_ejercicioretrofit;

import android.os.Bundle;

import com.example.pmdm_ejercicioretrofit.adapters.DatosAdapter;
import com.example.pmdm_ejercicioretrofit.conexiones.ApiConexiones;
import com.example.pmdm_ejercicioretrofit.conexiones.RetrofitObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.pmdm_ejercicioretrofit.databinding.ActivityMainBinding;
import com.example.pmdm_ejercicioretrofit.modelos.DataItem;
import com.example.pmdm_ejercicioretrofit.modelos.Respuesta;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<DataItem> users;
    private RecyclerView contenedor;
    private DatosAdapter adapter;
    private RecyclerView.LayoutManager lm;

    // -------------
    //Crearemos las variables como atributos
    private Retrofit retrofit;
    private ApiConexiones api;

    //
    private Button btnPage1;
    private Button btnPage2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        contenedor = findViewById(R.id.contenedor);
        btnPage1 = findViewById(R.id.btnPage1);
        btnPage2 = findViewById(R.id.btnPage2);

        users = new ArrayList<>();
        adapter = new DatosAdapter(users, R.layout.datos_view_holder, this);
        lm = new LinearLayoutManager(this);

        contenedor.setAdapter(adapter);
        contenedor.setLayoutManager(lm);

        retrofit = RetrofitObject.getConexion();
        api = retrofit.create(ApiConexiones.class);

        cargarUsers("1");


    }

    private void cargarUsers(String page) {
        Call<Respuesta> doGetUsers = api.getUsers(page); //le mandas la pagina que quiere mediante el string
        doGetUsers.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if(response.code() == HttpsURLConnection.HTTP_OK && response.body() != null){
                    adapter.notifyItemRangeRemoved(0, users.size()); //
                    users.clear();
                    users.addAll(response.body().getData());
                    adapter.notifyItemRangeInserted(0, users.size());

                    if(response.body().getPage() == 1){
                        btnPage1.setEnabled(false);
                        btnPage2.setEnabled(true);
                    }
                    else{
                        btnPage1.setEnabled(true);
                        btnPage2.setEnabled(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {

            }
        });

    }

  public void users(View v){
        Button btn = (Button) v; //lo casteamos para sacar su texto
        cargarUsers(btn.getText().toString());
        //se lo ponemos a los botenes en el xml
  }

}