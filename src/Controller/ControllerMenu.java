/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.Conexao;
import DAO.MusicasDAO;
import DAO.PlaylistDAO;
import Model.Musica;
import Model.Playlist;
import Model.Sessao;
import View.MenuFrame;
import View.PlaylistFrame;
import java.sql.*;
import java.util.ArrayList;

/**
 * Controller de MenuFrame
 * @author Acer Nitro 5
 */
public class ControllerMenu {
    private MenuFrame view;

    public ControllerMenu(MenuFrame view) {
        this.view = view;
    }
    //metodo igual ao de ControllerMusicas que retorna um array  de musicas : )
    public void buscarMusicasCurtidas() {
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
            Playlist pl = new Playlist();
            pl.setNome("Curtidas");
            pl.setIDusuario(Sessao.getUsuario().getId());
            pl.setMusicas(musicas);
            PlaylistFrame plFrame = new PlaylistFrame(pl);
            plFrame.setVisible(true);
            
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    //retorna o arraylist das musicas descurtidas
    public void buscarMusicasDescurtidas() {
        ArrayList<Musica> musicas = new ArrayList<>();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);
            ResultSet res = dao.getMusicasDescurtidas();
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
            Playlist pl = new Playlist();
            pl.setNome("Descurtidas");
            pl.setIDusuario(Sessao.getUsuario().getId());
            pl.setMusicas(musicas);
            PlaylistFrame plFrame = new PlaylistFrame(pl);
            plFrame.setVisible(true);
            
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    //retorna o arraylist das musicas 10 ultimas musicas do historico
    public void buscarMusicasHistorico() {
        ArrayList<Musica> musicas = new ArrayList<>();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);
            ResultSet res = dao.getHistorico();
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
            Playlist pl = new Playlist();
            pl.setNome("Histórico");
            pl.setIDusuario(Sessao.getUsuario().getId());
            pl.setMusicas(musicas);
            PlaylistFrame plFrame = new PlaylistFrame(pl);
            plFrame.setVisible(true);
            
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    //procura playlist
    public ArrayList<Playlist> buscarPlaylists(){
        ArrayList<Playlist> playlists = new ArrayList<>();
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            ResultSet res = dao.getPlaylists();
            while (res.next()) {
                Playlist p = new Playlist();
                p.setIDusuario(Sessao.getUsuario().getId());
                p.setNome(res.getString("nome"));
                p.setId_playlist(res.getInt("id_playlist"));
                playlists.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // pode trocar por JOptionPane se for necessário
        }
        return playlists;
    }
    //busca as musicas da playlist
    public ArrayList<Musica> buscarMusicasPlaylist(int id_playlist){
        ArrayList<Musica> musicas = new ArrayList<>();
        Conexao conexao = new Conexao ();
        try{
            Connection conn = conexao.getConnection();
            MusicasDAO dao = new MusicasDAO(conn);
            ResultSet res = dao.getMusicasPlaylist(id_playlist);
            while (res.next()) {
                Musica m = new Musica();
                m.setArtista(res.getString("artista"));
                m.setDuracao(res.getInt("duracao"));
                m.setGenero(res.getString("genero"));
                m.setTitulo(res.getString("titulo"));
                m.setId(res.getInt("id_musica"));
                m.setLetra(res.getString("letra"));
                musicas.add(m);
            }
        }
        catch (SQLException e) {
            e.printStackTrace(); // pode trocar por JOptionPane se for necessário
        }
            
        return musicas;
    }
}
