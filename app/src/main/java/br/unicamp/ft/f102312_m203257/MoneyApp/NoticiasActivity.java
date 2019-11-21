package br.unicamp.ft.f102312_m203257.MoneyApp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.unicamp.ft.f102312_m203257.MoneyApp.newsapi.ClientApi;
import br.unicamp.ft.f102312_m203257.MoneyApp.newsapi.InterfaceAPI;
import br.unicamp.ft.f102312_m203257.MoneyApp.noticias.Artigo;
import br.unicamp.ft.f102312_m203257.MoneyApp.noticias.Noticias;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticiasActivity extends AppCompatActivity {
    public static final String API_KEY = "657cc041eec747bbb2a2c4bbc7a22a9d";
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Artigo> artigos = new ArrayList<>();
    private Adapter mAdapter;
    private String TAG = NoticiasActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = findViewById(R.id.recycler_view_noticias);
        mLayoutManager = new LinearLayoutManager(NoticiasActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setNestedScrollingEnabled(false);
        LoadJson();
    }

    public void LoadJson (){
        InterfaceAPI interfaceAPI = ClientApi.getClientApi().create(InterfaceAPI.class);
        String pais = "br";
        String categoria = "business";

        Call<Noticias> call;
        call = interfaceAPI.getNoticias(pais,categoria,API_KEY);

        call.enqueue(new Callback<Noticias>() {
            @Override
            public void onResponse(Call<Noticias> call, Response<Noticias> response) {
                if (response.isSuccessful()&& response.body().getArtigo()!=null){
                    if(!artigos.isEmpty()){
                        artigos.clear();
                    }
                    artigos = response.body().getArtigo();
                    mAdapter = new Adapter(artigos,NoticiasActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(NoticiasActivity.this, "Nada encontrado!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Noticias> call, Throwable t) {
                Log.d("Erro API","Erro na api");
            }
        });
    }




}
