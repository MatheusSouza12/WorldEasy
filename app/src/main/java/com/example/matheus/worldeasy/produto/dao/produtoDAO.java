package com.example.matheus.worldeasy.produto.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.matheus.worldeasy.infra.DBHelper;
import com.example.matheus.worldeasy.produto.dominio.Produto;

public class produtoDAO {
    private DBHelper dbHelper;

    public  produtoDAO(Context context){dbHelper = new DBHelper(context);}

    public long inserir(Produto produto){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(dbHelper.COLUNA_NOME_PRODUTO, produto.getNome());
        values.put(dbHelper.COLUNA_IMPOSTOS, produto.getImpostos());
        values.put(dbHelper.COLUNA_ORIGEM, produto.getOrigem());
        values.put(dbHelper.COLUNA_PRECO, produto.getValor());
        values.put(dbHelper.COLUNA_PRECO_COM_IMPOSTO, produto.getValorComImposto());
        values.put(dbHelper.COLUNA_TAMANHO_PESO, produto.getTamanhoPeso());
        values.put(dbHelper.COLUNA_QUANTIDADE, produto.getQuantidade());
        values.put(dbHelper.COLUNA_ID_USUARIO, produto.getIdUsuario());

        String tabela= DBHelper.TABELA_PRODUTOS;

        long id = db.insert(tabela, null, values);
        db.close();
        return id;
    }

    private Produto criarProduto(Cursor cursor){
        Produto produto = new Produto();
        produto.set_id(cursor.getInt(0));
        produto.setNome(cursor.getString(1));
        produto.setValor(cursor.getInt(2));
        produto.setValorComImposto(cursor.getInt(3));
        produto.setQuantidade(cursor.getInt(4));
        produto.setImpostos(cursor.getString(5));
        produto.setOrigem(cursor.getString(6));
        produto.setTamanhoPeso(cursor.getString(7));
        produto.setIdUsuario(cursor.getString(8));

        return produto;
    }
    public Produto getProduto(String nome){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(dbHelper.TABELA_PRODUTOS, new String[]{ " * " }, " nome=? ", new String[]{nome}, null, null, null);
        Produto produto = null;
        if (cursor.moveToFirst()) {
            produto = criarProduto(cursor);
        }
        cursor.close();
        db.close();
        return produto;
    }
}
