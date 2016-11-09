package com.example.matheus.worldeasy.produto.negocio;


import android.content.Context;

import com.example.matheus.worldeasy.produto.dao.produtoDAO;
import com.example.matheus.worldeasy.produto.dominio.Produto;

public class produtoNegocio {
    private produtoDAO produtoDao;

    public produtoNegocio(Context context){produtoDao=new produtoDAO(context);}

    public void cadastrarProduto(String nome, int valor, int valorComImposto, int quantidade, String origem, String impostos, String tamanhoPeso) throws Exception{


        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setValor(valor);
        produto.setValorComImposto(valorComImposto);
        produto.setQuantidade(quantidade);
        produto.setOrigem(origem);
        produto.setImpostos(impostos);
        produto.setTamanhoPeso(tamanhoPeso);

        long idProduto = produtoDao.inserir(produto);
        produto.set_id(idProduto);
    }
}
