package com.example.matheus.worldeasy.produto.negocio;


import android.content.Context;

import com.example.matheus.worldeasy.produto.dao.produtoDAO;
import com.example.matheus.worldeasy.produto.dominio.Produto;
import com.example.matheus.worldeasy.usuario.dominio.Usuario;

public class produtoNegocio {
    private produtoDAO produtoDao;
    Usuario usuario = new Usuario();

    public produtoNegocio(Context context) {
        produtoDao = new produtoDAO(context);
    }

    //public void cadastrarProduto(String nome, String valor, String quantidade, String origem, String impostos, String tamanhoPeso) throws Exception {
    public void cadastrarProduto(String nome){
        Produto produto = new Produto();
        produto.setNome(nome);
        //produto.setValor(valor);
        //produto.setValorComImposto(valorComImposto);
        //produto.setQuantidade(quantidade);
        //produto.setOrigem(origem);
        //produto.setImpostos(impostos);
        //produto.setTamanhoPeso(tamanhoPeso);
        //produto.setIdUsuario(usuario.get_id());

        long idProduto = produtoDao.inserir(produto);
        produto.set_idProduto(idProduto);
    }
}
