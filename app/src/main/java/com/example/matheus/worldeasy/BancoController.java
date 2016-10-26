//package com.example.matheus.worldeasy;
//
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//
//import static com.example.matheus.worldeasy.CriaBanco.COLUNA_NOME;
//
//public class BancoController {
//    private SQLiteDatabase db;
//    private CriaBanco banco;
//    private final Context context;
//
//    public BancoController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)){
//        banco= new CriaBanco(context,, null, VERSAO);
//        this.context = context;
//    }
//    public void insereDado(String nome, String senha, String cpf){
//        ContentValues valores;
//        long resultado;
//
//        db=banco.getWritableDatabase();
//        valores = new ContentValues();
//        valores.put(COLUNA_NOME, nome);
//        valores.put(COLUNA_EMAIL, email);
//
//
//        resultado = db.insert(CriaBanco.DB_TABELA, null, valores);
//        db.close();
//
//
//    }
//}
