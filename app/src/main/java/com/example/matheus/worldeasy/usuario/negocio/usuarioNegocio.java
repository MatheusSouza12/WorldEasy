package com.example.matheus.worldeasy.usuario.negocio;

import android.content.Context;

import com.example.matheus.worldeasy.infra.Criptografia;
import com.example.matheus.worldeasy.infra.Sessao;
import com.example.matheus.worldeasy.usuario.dao.usuarioDAO;
import com.example.matheus.worldeasy.usuario.dominio.Usuario;


public class usuarioNegocio {
    private usuarioDAO usuarioDao;
    //private Criptografia criptografia = new Criptografia();

    public usuarioNegocio(Context context){
        usuarioDao=new usuarioDAO(context);
    }
    public void cadastrarUsuario(String nome, String email, String senha, String cpf) throws Exception{
        Usuario usuario = usuarioDao.getUsuario(email, senha);

        if (usuario!=null){
            throw new Exception("Usuario Já Cadastrado");
        }
        //String senhaMascarada = criptografia.criptografarSenha(senha);
        usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setCpf(cpf);

        long idUsuario = usuarioDao.inserir(usuario);
        usuario.set_id(idUsuario);
    }
//    public void CompletarCadastroUsuario(String nomedaempresa, String cpfoucnpj, String pais, String estado, String cidade){
//        Usuario usuario = usuarioDao.getUsuario();
//        usuario= new Usuario();
//        usuario.setNomedaempresa(nomedaempresa);
//        usuario.setCpfoucnpj(cpfoucnpj);
//        usuario.setPais(pais);
//        usuario.setEstado(estado);
//        usuario.setCidade(cidade);
//    }

    public  void login(String email, String senha) throws Exception {

        //String senhaMascarada = criptografia.criptografarSenha(senha);
        Usuario usuarioVerificado = usuarioDao.getUsuario(email, senha);

        if (usuarioVerificado == null) {
            throw new Exception("Usuário ou Senha Inválidos!");
        } else {
            Sessao.setUsuario(usuarioVerificado);
        }
    }
}
