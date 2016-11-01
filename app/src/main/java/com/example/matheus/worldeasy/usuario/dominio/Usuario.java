package com.example.matheus.worldeasy.usuario.dominio;



public class Usuario {
    private long _id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    public Usuario(){

    }

    public Usuario(long id, String nome, String email, String senha, String cpf){
        this._id=id;
        this.nome=nome;
        this.senha=senha;
        this.cpf=cpf;
    }

    public long get_id(){return _id;}

    public void set_id(long _id){this._id=_id;}

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome=nome;}

    public String getEmail(){return this.email;}

    public void setEmail(String email){this.email=email;}

    public String getCpf(){return this.cpf;}

    public void setCpf(String cpf){this.cpf=cpf;}

    public String getSenha(){return this.senha;}

    public void setSenha(String senha){this.senha=senha;}




}

