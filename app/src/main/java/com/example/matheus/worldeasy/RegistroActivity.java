package com.example.matheus.worldeasy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.matheus.worldeasy.R.id.btt_registrar;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registrar;
    private EditText email, senha;
    private TextView voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        registrar=(Button)findViewById(btt_registrar);
        email=(EditText)findViewById(R.id.tx_email);
        senha=(EditText)findViewById(R.id.tx_senha);
        voltar=(TextView)findViewById(R.id.tvVoltar);
        registrar.setOnClickListener(this);
        voltar.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btt_registrar:
                break;
            case R.id.tvVoltar:
                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
                break;
            default:
        }
    }


}
