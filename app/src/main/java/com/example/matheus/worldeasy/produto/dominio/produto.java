package com.example.matheus.worldeasy.produto.dominio;


public class Produto {
    private long _idProduto;
    private String Nome;
    private String Valor;
    private String ValorComImposto;
    private String Quantidade;
    private String Origem;
    private String Impostos;
    private String TamanhoPeso;
    private Long idUsuario;

    public Produto(){}

    public Produto(long _id, String nome, String valor, String valorComImposto, String quantidade, String origem, String impostos, String tamanhoPeso, Long idUsuario){
        this._idProduto =_id;
        this.Nome=nome;
        this.Valor=valor;
        this.ValorComImposto=valorComImposto;
        this.Quantidade=quantidade;
        this.Origem=origem;
        this.Impostos=impostos;
        this.TamanhoPeso=tamanhoPeso;
        this.idUsuario=idUsuario;

    }

    public long get_idProduto(){return _idProduto;}

    public void set_idProduto(long _id){this._idProduto=_id;}

    public String getNome(){return Nome;}

    public void setNome(String nome){this.Nome=nome;}

    public String getValor(){return this.Valor;}

    public void setValor(String valor){this.Valor=valor;}

    public String getOrigem(){return this.Origem;}

    public void setOrigem(String origem){this.Origem=origem;}

    public String getImpostos(){return this.Impostos;}

    public void setImpostos(String impostos){this.Impostos=impostos;}

    public String getTamanhoPeso(){return this.TamanhoPeso;}

    public void setTamanhoPeso(String tamanhoPeso){this.TamanhoPeso=tamanhoPeso;}

    public String getQuantidade(){return this.Quantidade;}

    public void setQuantidade(String quantidade){this.Quantidade=quantidade;}

    public String getValorComImposto(){return this.ValorComImposto;}

    public void setValorComImposto(String valorComImposto){this.ValorComImposto=valorComImposto;}

    public long getIdUsuario(){return idUsuario;}

    public void setIdUsuario(long idUsuario){this.idUsuario=idUsuario;}
}
