package com.example.matheus.worldeasy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco  extends SQLiteOpenHelper {
    private  static final  String NOME_BANCO="banco.db";
    private static final String DB_TABELA = "Usuarios";
    private static final String COLUNA_ID = "_id";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_SENHA = "senha";
    private static  final String COLUNA_CPF="cpf";
    private static final int VERSAO = 1;

    public CriaBanco(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }






    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table" + DB_TABELA + "(" +
                COLUNA_ID + "integer primary key autoincrement, " +
                COLUNA_NOME + "text, " +
                COLUNA_EMAIL + "text, " +
                COLUNA_SENHA + "text, " +
                COLUNA_CPF+ "text);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+DB_TABELA);
        onCreate(db);
    }
}
