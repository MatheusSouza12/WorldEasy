package com.example.matheus.worldeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button entrar, registrar;
    private EditText email, senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        entrar = (Button) findViewById(R.id.btt_entrar);
        registrar = (Button) findViewById(R.id.btt_registrar);
        email = (EditText) findViewById(R.id.tx_email);
        senha = (EditText) findViewById(R.id.tx_senha);
        entrar.setOnClickListener(this);
        registrar.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btt_entrar:
                break;
            case R.id.btt_registrar:
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));

                break;
            default:

        }
    }

}
