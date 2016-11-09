package com.example.matheus.worldeasy.produto.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.matheus.worldeasy.R;
import com.example.matheus.worldeasy.infra.GuiUtil;
import com.example.matheus.worldeasy.infra.Validacao;
import com.example.matheus.worldeasy.produto.negocio.produtoNegocio;
import com.example.matheus.worldeasy.usuario.gui.LoginActivity;
import com.example.matheus.worldeasy.usuario.gui.MainActivity;

public class AnunciarProdutoActivity extends AppCompatActivity {
    produtoNegocio produtonegocio = new produtoNegocio(this);
    Validacao validacaoUtil = Validacao.getValidacaoUtil();
    GuiUtil guiUtil = GuiUtil.getGuiUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunciar_produto);

    }

    public void onButtonClickProduto(View v) {
        if (v.getId() == R.id.btn_cadastrarProduto) {
            guiUtil.toastLong(getApplicationContext(), "Cadastro realizado com sucesso");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            EditText nome = (EditText)findViewById(R.id.tx_nomeproduto);
            EditText valor = (EditText)findViewById(R.id.tx_valor);
            EditText quantidade = (EditText)findViewById(R.id.tx_quantidade);
            EditText tamanhoPeso = (EditText)findViewById(R.id.tx_tamanho_peso);
            EditText origem = (EditText) findViewById(R.id.tx_origem);
            EditText impostos = (EditText) findViewById(R.id.tx_impostos);

            String nomeString = nome.getText().toString();
            String valorString = valor.getText().toString();
            String quantidadeString = quantidade.getText().toString();
            String tamanhoPesoString = tamanhoPeso.getText().toString();
            String origemString = origem.getText().toString();
            String impostosString = impostos.getText().toString();

            if (validacaoUtil.isFieldEmpty(nome)) {
                nome.requestFocus();
                nome.setError("Digite seu nome");
                return;
            }
            if (validacaoUtil.isFieldEmpty(valor)) {
                valor.requestFocus();
                valor.setError("Digite o Valor");
                return;
            }
            if (validacaoUtil.isFieldEmpty(quantidade)) {
                quantidade.requestFocus();
                quantidade.setError("Digite a Quantidade de Produtos");
                return;
            }
            if (validacaoUtil.isFieldEmpty(tamanhoPeso)) {
                tamanhoPeso.requestFocus();
                tamanhoPeso.setError("Digite o Tamanho ou o Peso do Produto");
                return;
            }
            if (validacaoUtil.isFieldEmpty(origem)) {
                origem.requestFocus();
                origem.setError("Digite a Origem do Produto");
                return;
            }
            if (validacaoUtil.isFieldEmpty(impostos)) {
                impostos.requestFocus();
                impostos.setError("Digite os Impostos");
                return;
            }
        } else {
            try {
                //produtonegocio.cadastrarProduto(nomeString);
                guiUtil.toastLong(getApplicationContext(), "Cadastro realizado com sucesso");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            } catch (Exception exception) {
                guiUtil.toastLong(getApplicationContext(), exception.getMessage());
            }
        }
//    }else if (v.getId() == R.id.tvVoltar){
//        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//        startActivity(intent);
    }
}
