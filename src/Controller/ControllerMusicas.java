/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.HistoricoDAO;
import DAO.MusicasDAO;
import Model.Musica;
import Model.Sessao;
import View.MusicasFrame;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer Nitro 5
 */
public class ControllerMusicas {
    private MusicasFrame view;

    public ControllerMusicas(MusicasFrame view) {
        this.view = view;
    }

    public ArrayList<Musica> buscarMusicas() {
        ArrayList<Musica> musicas = new ArrayList<>();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);
            ResultSet res = dao.getMusicas();
            while (res.next()) {
                Musica m = new Musica();
                m.setId(res.getInt("id_musica"));
                m.setTitulo(res.getString("titulo"));
                m.setDuracao(res.getInt("duracao"));
                m.setArtista(res.getString("artista"));
                m.setGenero(res.getString("genero"));
                m.setLetra(res.getString("letra"));
                musicas.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // pode trocar por JOptionPane se for necessário
        }
        return musicas;
    }
    
    
    
}
//public void salvarUsuario(){
//        
//        String email = view.getEmail_cadastro().getText();
//        String senha = view.getSenha_cadastro().getText();
//        String nome = view.getNome_cadastro().getText();
//        String idadeString = view.getIdade_cadastro().getText();
//        int idade = Integer.parseInt(idadeString);
//        
//        Usuario usuario = new Usuario(email, senha, nome, idade, 0);
//        
//        Conexao conexao = new Conexao();
//        try {
//            Connection conn = conexao.getConnection();
//            UsuarioDAO dao = new UsuarioDAO(conn);
//            dao.inserir(usuario);
//            JOptionPane.showMessageDialog(view, "Usuario Cadastrado!","Aviso", JOptionPane.INFORMATION_MESSAGE);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(view, "Usuário não cadastrado!","Erro", JOptionPane.ERROR_MESSAGE);
//        }
//    }
