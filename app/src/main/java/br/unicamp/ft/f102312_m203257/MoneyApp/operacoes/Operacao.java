package br.unicamp.ft.f102312_m203257.MoneyApp.operacoes;

public class Operacao {

    private  int id;
    private String descricao;
    private int foto;
    private String tipoOp;
    private Double valor;

    public Operacao(int id,String descricao, int foto, Double valor) {
        this.id = id;
        this.descricao = descricao;
        this.foto = foto;
        this.valor = valor;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(String tipoOp) {
        this.tipoOp = tipoOp;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
