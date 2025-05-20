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
import View.ResultadoFrame;
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
    public void buscarMusicasPesquisa(int tipo_pesquisa, String consulta){
        ArrayList<Musica> musicas = new ArrayList<>();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);
            ResultSet res;
            if(tipo_pesquisa == 1){res = dao.searchMusicaArtista(consulta);}
            else if(tipo_pesquisa == 2){res = dao.searchMusicaGenero(consulta);}
            else if(tipo_pesquisa == 3){res = dao.searchMusicaNome(consulta);}
            else if(tipo_pesquisa == 4){res = dao.searchMusicaGeral(consulta);}
            else{res = dao.getMusicas();}
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
            ResultadoFrame rf = new ResultadoFrame(musicas);
            rf.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace(); // pode trocar por JOptionPane se for necessário
        }
        
        
    }
    
    
    
    
}
