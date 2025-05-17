/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.Conexao;
import DAO.MusicasDAO;
import Model.Musica;
import View.PlaylistFrame;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Acer Nitro 5
 */
public class ControllerPlaylist {
    private PlaylistFrame view;

    public ControllerPlaylist(PlaylistFrame view) {
        this.view = view;
    }
    //metodo igual ao de ControllerMusicas que retorna um array  de musicas : )
    public ArrayList<Musica> buscarMusicasCurtidas() {
        ArrayList<Musica> musicas = new ArrayList<>();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);
            ResultSet res = dao.getMusicasCurtidas();
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
            e.printStackTrace(); 
        }
        return musicas;
    }
    
}
