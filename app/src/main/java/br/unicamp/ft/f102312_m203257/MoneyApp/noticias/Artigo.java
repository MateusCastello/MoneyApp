package br.unicamp.ft.f102312_m203257.MoneyApp.noticias;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artigo {
    //Estrutura básica d eum artigo retornado pela News API
    @SerializedName("source")
    @Expose
    private Fonte fonte;

    @SerializedName("author")
    @Expose
    private String autor;

    @SerializedName("title")
    @Expose
    private String titulo;

    @SerializedName("description")
    @Expose
    private String descricao;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("urlToImage")
    @Expose
    private String urlDaImagem;

    @SerializedName("publishedAt")
    @Expose
    private String publicadoEm;

    public Fonte getFonte() {
        return fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlDaImagem() {
        return urlDaImagem;
    }

    public void setUrlDaImagem(String urlDaImagem) {
        this.urlDaImagem = urlDaImagem;
    }

    public String getPublicadoEm() {
        return publicadoEm;
    }

    public void setPublicadoEm(String publicadoEm) {
        this.publicadoEm = publicadoEm;
    }
}
