package com.example.matheus.worldeasy.usuario.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.matheus.worldeasy.infra.DBHelper;
import com.example.matheus.worldeasy.usuario.dominio.Usuario;



public class usuarioDAO {
    private DBHelper helper;

    public usuarioDAO(Context context){helper=new DBHelper(context);}

    public long inserir(Usuario usuario){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        String nome = DBHelper.COLUNA_NOME;
        String email = DBHelper.COLUNA_EMAIL;
        String senha = DBHelper.COLUNA_SENHA;
        String cpf = DBHelper.COLUNA_CPF;

        values.put(nome, usuario.getNome());
        values.put(email, usuario.getEmail());
        values.put(senha, usuario.getSenha());
        values.put(cpf, usuario.getCpf());

        String tabela = DBHelper.TABELA_USUARIO;

        long id = db.insert(tabela, null, values);
        db.close();

        return id;
    }
    public Usuario getUsuario(String email, String senha) {
        SQLiteDatabase db = helper.getReadableDatabase();

        String comando = "SELECT * FROM " + DBHelper.TABELA_USUARIO +
                " WHERE " + DBHelper.COLUNA_EMAIL + " LIKE ? AND " +
                DBHelper.COLUNA_SENHA + " LIKE ?";
        String[] argumentos = {email, senha};
        Cursor cursor = db.rawQuery(comando, argumentos);
        Usuario usuario = null;
        if (cursor.moveToNext()){
            usuario = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuario;
    }
    public Usuario getUsuario(Usuario usuario) {
        SQLiteDatabase db = helper.getReadableDatabase();

        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        Cursor cursor = db.query(helper.TABELA_USUARIO,new String[]{" * "}, " email=? and senha=?", new String[]{email, senha}, null, null, null);

        Usuario usuarioVerificado = null;
        if  (cursor.moveToFirst()){
            usuarioVerificado = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuarioVerificado;
    }

    public Usuario getUsuario(String email) {
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(helper.TABELA_USUARIO,new String[]{" * "}, " email=?", new String[]{email}, null, null, null);

        Usuario usuario = null;
        if  (cursor.moveToFirst()){
            usuario = criarUsuario(cursor);
        }
        cursor.close();
        db.close();
        return usuario;

    }

    private Usuario criarUsuario(Cursor cursor) {
        Usuario usuario = new Usuario();
        usuario.set_id(cursor.getInt(0));
        usuario.setNome(cursor.getString(1));
        usuario.setEmail(cursor.getString(2));
        usuario.setSenha(cursor.getString(3));
        usuario.setCpf(cursor.getString(4));
        return usuario;
    }
}
