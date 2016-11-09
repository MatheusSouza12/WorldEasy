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


    //atributos da tabela Produto

    public static final String TABELA_PRODUTOS="produtos";
    public static final String COLUNA_ID_PRODUTO="_id";
    public static final String COLUNA_NOME_PRODUTO="nome";
    public static final String COLUNA_PRECO ="valor";
    public static final String COLUNA_PRECO_COM_IMPOSTO ="valor com imposto";
    public static final String COLUNA_QUANTIDADE="quantidade";
    public static final String COLUNA_IMPOSTOS="impostos";
    public static final String COLUNA_ORIGEM="origem";
    public static final String COLUNA_TAMANHO_PESO="tamanho ou peso";
    public static final String COLUNA_ID_USUARIO="id_usuario";



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

        db.execSQL("CREATE TABLE " + TABELA_PRODUTOS + "("
                + COLUNA_ID_PRODUTO + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUNA_NOME_PRODUTO + " TEXT,"
                //+ COLUNA_PRECO + " DOUBLE,"
                + COLUNA_PRECO_COM_IMPOSTO + " DOUBLE,"
                + COLUNA_QUANTIDADE + " DOUBLE,"
                + COLUNA_IMPOSTOS + " TEXT,"
                + COLUNA_ORIGEM + " TEXT,"
                + COLUNA_TAMANHO_PESO + " DOUBLE,"
                + COLUNA_ID_USUARIO + " INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXIST " + TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXIST " + TABELA_PRODUTOS);
        onCreate(db);
    }

}
