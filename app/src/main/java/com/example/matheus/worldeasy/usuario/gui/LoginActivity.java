package com.example.matheus.worldeasy.usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.matheus.worldeasy.R;
import com.example.matheus.worldeasy.infra.GuiUtil;
import com.example.matheus.worldeasy.infra.Sessao;
import com.example.matheus.worldeasy.infra.Validacao;
import com.example.matheus.worldeasy.usuario.negocio.usuarioNegocio;

public class LoginActivity extends AppCompatActivity {
    usuarioNegocio UsuarioNegocio = new usuarioNegocio(this);
    GuiUtil guiUtil = GuiUtil.getGuiUtil();
    Validacao validacaoUtil = Validacao.getValidacaoUtil();
    private Sessao sessao = Sessao.getInstancia();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Window window = this.getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


    }
    public void onButtonClick(View v){

        if (v.getId()==R.id.btn_CadastrarFornecedor) {
            EditText usuarioEmail = (EditText)findViewById(R.id.tx_email);
            EditText usuarioSenha = (EditText)findViewById(R.id.tx_senha);
            String email = usuarioEmail.getText().toString();
            String senha = usuarioSenha.getText().toString();

            if (validacaoUtil.isFieldEmpty(usuarioEmail)) {
                usuarioEmail.requestFocus();
                usuarioEmail.setError("Digite seu email");
                return;
            }
            if (validacaoUtil.isFieldEmpty(usuarioSenha)) {
                usuarioSenha.requestFocus();
                usuarioSenha.setError("digite sua senha");
                return;
            }
            if (!validacaoUtil.isEmailValid(email)) {
                usuarioEmail.requestFocus();
                usuarioEmail.setError("Email invalido");
                return;
            } else {
                try {
                    UsuarioNegocio.login(email, senha);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else if (v.getId()==R.id.btn_registrar){
            Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
            startActivity(intent);
        }
    }
}








//        entrar = (Button) findViewById(R.id.btn_entrar);
//        registrar = (Button) findViewById(R.id.btn_registrar);
//        email = (EditText) findViewById(R.id.tx_email);
//        senha = (EditText) findViewById(R.id.tx_senha);
//        entrar.setOnClickListener(this);
//        registrar.setOnClickListener(this);
//
//    }
//
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_entrar:
//                EditText usuarioEmail = (EditText)findViewById(R.id.tx_email);
//                EditText usuarioSenha = (EditText)findViewById(R.id.tx_senha);
//                String email = usuarioEmail.getText().toString();
//                String senha = usuarioSenha.getText().toString();
//
//                if (validacaoUtil.isFieldEmpty(usuarioEmail)) {
//                    usuarioEmail.requestFocus();
//                    usuarioEmail.setError("Digite seu email");
//                    return;
//                }
//                if (validacaoUtil.isFieldEmpty(usuarioSenha)) {
//                    usuarioSenha.requestFocus();
//                    usuarioSenha.setError("Digite sua senha");
//                    return;
//                }
//                if (!validacaoUtil.isEmailValid(email)) {
//                    usuarioEmail.requestFocus();
//                    usuarioEmail.setError("Email invalido");
//                    return;
//                } else {
//                    try {
//                        UsuarioNegocio.login(email, senha);
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        //startActivity(intent);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            case R.id.btn_registrar:
//                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
//                }
//
//
//
//
//    }

