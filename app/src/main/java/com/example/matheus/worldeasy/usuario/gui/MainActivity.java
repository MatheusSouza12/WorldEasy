package com.example.matheus.worldeasy.usuario.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.matheus.worldeasy.R;
import com.example.matheus.worldeasy.produto.gui.AnunciarProdutoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onButtonClick(View v){
        if (v.getId()==R.id.btn_anunciar_produtos){
            Intent intent = new Intent(getApplicationContext(), AnunciarProdutoActivity.class);
            startActivity(intent);

        }
        if (v.getId()==R.id.btn_procurar_produtos){

        }
    }

}
