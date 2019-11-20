package br.unicamp.ft.f102312_m203257.MoneyApp.noticias;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.transform.Source;

public class Artigo {
    //Estrutura básica d eum artigo retornado pela News API
    @SerializedName("fonte")
    @Expose
    private Source fonte;

    @SerializedName("autor")
    @Expose
    private String autor;

    @SerializedName("descricao")
    @Expose
    private String descricao;

    @SerializedName("titulo")
    @Expose
    private String titulo;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("urlDaImagem")
    @Expose
    private String urlDaImagem;

    @SerializedName("publicadoEm")
    @Expose
    private String publicadoEm;

    public Source getFonte() {
        return fonte;
    }

    public void setFonte(Source fonte) {
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
