package br.unicamp.ft.f102312_m203257.MoneyApp.ui.noticias;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.unicamp.ft.f102312_m203257.MoneyApp.Adapter;
import br.unicamp.ft.f102312_m203257.MoneyApp.MainActivity;
import br.unicamp.ft.f102312_m203257.MoneyApp.NoticiasActivity;
import br.unicamp.ft.f102312_m203257.MoneyApp.R;
import br.unicamp.ft.f102312_m203257.MoneyApp.newsapi.ClientApi;
import br.unicamp.ft.f102312_m203257.MoneyApp.newsapi.InterfaceAPI;
import br.unicamp.ft.f102312_m203257.MoneyApp.noticias.Artigo;
import br.unicamp.ft.f102312_m203257.MoneyApp.noticias.Noticias;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticiasFragment extends Fragment {
    public static final String API_KEY = "657cc041eec747bbb2a2c4bbc7a22a9d";
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Artigo> artigos = new ArrayList<>();
    private Adapter mAdapter;
    private String tag = NoticiasFragment.class.getSimpleName();
    private NoticiasViewModel noticiasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        noticiasViewModel =
                ViewModelProviders.of(this).get(NoticiasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_noticias, container, false);
//        mRecyclerView = root.findViewById(R.id.recyclerViewNoticias);
//        mLayoutManager = new LinearLayoutManager(root.getContext());
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.setNestedScrollingEnabled(false);
//        LoadJson();
        return root;
    }



//    public void LoadJson (){
//        InterfaceAPI interfaceAPI = ClientApi.getClientApi().create(InterfaceAPI.class);
//        String pais = "br";
//        String categoria = "business";
//
//        Call<Noticias> call;
//        call = interfaceAPI.getNoticias(pais,categoria,API_KEY);
//
//        call.enqueue(new Callback<Noticias>() {
//            @Override
//            public void onResponse(Call<Noticias> call, Response<Noticias> response) {
//                if (response.isSuccessful()&& response.body().getArtigo()!=null){
//                    if(!artigos.isEmpty()){
//                        artigos.clear();
//                    }
//                    artigos = response.body().getArtigo();
//                    mAdapter = new Adapter(artigos, NoticiasActivity.this);
//                    mRecyclerView.setAdapter(mAdapter);
//                    mAdapter.notifyDataSetChanged();
//
//                } else {
//                    Toast.makeText(NoticiasActivity.this, "Nada encontrado!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Noticias> call, Throwable t) {
//
//            }
//        });
//    }
//
//    public static String getPais(){
//        Locale locale = Locale.getDefault();
//        String pais = String.valueOf(locale.getCountry());
//        return pais.toLowerCase();
//    }

}