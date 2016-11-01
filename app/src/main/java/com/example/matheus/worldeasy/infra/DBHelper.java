package com.example.matheus.worldeasy.infra;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    public static final String TAG = DBHelper.class.getSimpleName();
    public static final String DB_NOME="worldeasy.db";
    public static final int DB_VERSAO=1;

    //atributos da tabela usuario
    public static final String TABELA_USUARIO="usuario";
    public static final String COLUNA_ID="_id";
    public static final String COLUNA_NOME="nome";
    public static final String COLUNA_EMAIL="email";
    public static final String COLUNA_SENHA="senha";
    public static final String COLUNA_CPF="cpf";


    public DBHelper(Context context){
        super(context, DB_NOME,null, DB_VERSAO);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABELA_USUARIO + "("
                + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUNA_NOME + " TEXT,"
                + COLUNA_EMAIL + " TEXT,"
                + COLUNA_SENHA+ " TEXT,"
                + COLUNA_CPF + " INT);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXIST " + TABELA_USUARIO);
        onCreate(db);
    }

}
