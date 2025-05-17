/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
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
