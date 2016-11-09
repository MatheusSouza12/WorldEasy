package com.example.matheus.worldeasy.produto.dominio;


public class Produto {
    private long _id;
    private String Nome;
    private int Valor;
    private int ValorComImposto;
    private int Quantidade;
    private String Origem;
    private String Impostos;
    private String TamanhoPeso;
    private String idUsuario;

    public Produto(){}

    public Produto(long _id, String nome, int valor, int valorComImposto, int quantidade, String origem, String impostos, String tamanhoPeso, String idUsuario){
        this.Nome=nome;
        this.Valor=valor;
        this.ValorComImposto=valorComImposto;
        this.Quantidade=quantidade;
        this.Origem=origem;
        this.Impostos=impostos;
        this.TamanhoPeso=tamanhoPeso;
        this.idUsuario=idUsuario;

    }

    public long get_id(){return _id;}

    public void set_id(long _id){this._id=_id;}

    public String getNome(){return Nome;}

    public void setNome(String nome){this.Nome=nome;}

    public int getValor(){return this.Valor;}

    public void setValor(int valor){this.Valor=valor;}

    public String getOrigem(){return this.Origem;}

    public void setOrigem(String origem){this.Origem=origem;}

    public String getImpostos(){return this.Impostos;}

    public void setImpostos(String impostos){this.Impostos=impostos;}

    public String getTamanhoPeso(){return this.TamanhoPeso;}

    public void setTamanhoPeso(String tamanhoPeso){this.TamanhoPeso=tamanhoPeso;}

    public int getQuantidade(){return this.Quantidade;}

    public void setQuantidade(int quantidade){this.Quantidade=quantidade;}

    public int getValorComImposto(){return this.ValorComImposto;}

    public void setValorComImposto(int valorComImposto){this.ValorComImposto=valorComImposto;}

    public String getIdUsuario(){return this.idUsuario;}

    public void setIdUsuario(String idUsuario){this.idUsuario=idUsuario;}
}
