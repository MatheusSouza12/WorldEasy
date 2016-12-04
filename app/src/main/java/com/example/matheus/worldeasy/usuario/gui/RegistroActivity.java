package com.example.matheus.worldeasy.usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.matheus.worldeasy.R;
import com.example.matheus.worldeasy.infra.GuiUtil;
import com.example.matheus.worldeasy.infra.Validacao;
import com.example.matheus.worldeasy.usuario.negocio.usuarioNegocio;

import static com.example.matheus.worldeasy.R.id.btn_registrar;
import static com.example.matheus.worldeasy.R.id.email;

public class RegistroActivity extends AppCompatActivity {
    usuarioNegocio UsuarioNegocio = new usuarioNegocio(this);
    Validacao validacaoUtil = Validacao.getValidacaoUtil();
    GuiUtil guiUtil = GuiUtil.getGuiUtil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


    }
    public void onButtonClickUsuario(View v) {
        if (v.getId() == R.id.btn_registrar){
                EditText nome=(EditText)findViewById(R.id.tx_nome);
                EditText email=(EditText)findViewById(R.id.tx_email);
                EditText senha=(EditText)findViewById(R.id.tx_senha);
                EditText cpf = (EditText)findViewById(R.id.tx_cpf);

                String nomeString = nome.getText().toString();
                String emailString = email.getText().toString();
                String senhaString = senha.getText().toString();
                String cpfString=cpf.getText().toString();

            if (validacaoUtil.isFieldEmpty(nome)){
                nome.requestFocus();
                nome.setError("Digite seu nome");
                return;
            }
            if (validacaoUtil.isFieldEmpty(email)){
                email.requestFocus();
                email.setError("Digite seu Email");
                return;
            }
            if (validacaoUtil.isFieldEmpty(senha)){
                senha.requestFocus();
                senha.setError("Digite sua senha");
                return;
            }
            if (!validacaoUtil.hasSpacePassword(senha)){
                senha.requestFocus();
                senha.setError("Não é permitido espaços na senha");
                return;
            }
            if (!validacaoUtil.isEmailValid(emailString)){
                email.requestFocus();
                email.setError("Email Invalido");
                return;
            }
            else{
                try {
                    UsuarioNegocio.cadastrarUsuario(nomeString,emailString,senhaString, cpfString);
                    guiUtil.toastLong(getApplicationContext(), "Cadastro realizado com sucesso");
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);

                }catch (Exception exception){
                    guiUtil.toastLong(getApplicationContext(),exception.getMessage());
                }
            }
        }else if (v.getId() == R.id.tvVoltar){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }


}
