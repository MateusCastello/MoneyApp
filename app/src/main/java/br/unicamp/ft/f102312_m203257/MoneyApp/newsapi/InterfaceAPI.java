package br.unicamp.ft.f102312_m203257.MoneyApp.newsapi;

import br.unicamp.ft.f102312_m203257.MoneyApp.noticias.Noticias;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceAPI {
    @GET("top-headlines")
    Call<Noticias> getNoticias(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
