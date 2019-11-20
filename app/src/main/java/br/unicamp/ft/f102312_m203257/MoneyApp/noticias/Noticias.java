package br.unicamp.ft.f102312_m203257.MoneyApp.noticias;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Noticias {
    //Indica o status da API news
    @SerializedName("status")
    @Expose
    private String status;
    //Quantos artigos foram retornados
    @SerializedName("numeroDeResultados")
    @Expose
    private int numeroDeResultados;
    //Lista contendo os artigos
    @SerializedName("artigos")
    @Expose
    private List<Artigo> artigo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumeroDeResultados() {
        return numeroDeResultados;
    }

    public void setNumeroDeResultados(int numeroDeResultados) {
        this.numeroDeResultados = numeroDeResultados;
    }

    public List<Artigo> getArtigo() {
        return artigo;
    }

    public void setArtigo(List<Artigo> artigo) {
        this.artigo = artigo;
    }
}
