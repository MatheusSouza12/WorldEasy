package com.example.matheus.worldeasy.infra;

import com.example.matheus.worldeasy.usuario.dominio.Usuario;



public class Sessao {
    private static Sessao instancia = new Sessao();
    private static Usuario usuario;

    public static Usuario getUsuario(){
        return usuario;
    }

    public static void setUsuario(Usuario usuario){
        Sessao.usuario = usuario;
    }

    public static Sessao getInstancia(){ return  instancia;}
}
