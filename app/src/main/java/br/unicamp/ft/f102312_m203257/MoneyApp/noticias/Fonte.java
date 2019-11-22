package br.unicamp.ft.f102312_m203257.MoneyApp.noticias;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fonte {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String nome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
