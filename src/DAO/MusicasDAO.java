/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Musica;
import Model.Sessao;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Acer Nitro 5
 */
public class MusicasDAO {
    private Connection conn;

    public MusicasDAO(Connection conn) {
        this.conn = conn;
    }
    public ResultSet getMusicas() throws SQLException {
        String sql = "SELECT * FROM musicas";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute();
        ResultSet resultado = stmt.getResultSet();
        return resultado;
    }
    public ResultSet getMusicasCurtidas() throws SQLException {
        String sql = "SELECT DISTINCT m.artista, m.duracao, m.genero, m.id_musica, m.letra, m.titulo\n" +
                     "FROM musicas m\n" +
                     "JOIN curtidas c\n" +
                     "ON c.id_musica = m.id_musica\n" +
                     "WHERE id_usuario = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Sessao.getUsuario().getId());
        stmt.execute();
        ResultSet resultado = stmt.getResultSet();
        return resultado;
    }
    public ResultSet getMusicasDescurtidas() throws SQLException {
        String sql = "SELECT DISTINCT m.artista, m.duracao, m.genero, m.id_musica, m.letra, m.titulo\n" +
                     "FROM musicas m\n" +
                     "JOIN descurtidas c\n" +
                     "ON c.id_musica = m.id_musica\n" +
                     "WHERE id_usuario = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Sessao.getUsuario().getId());
        stmt.execute();
        ResultSet resultado = stmt.getResultSet();
        return resultado;
    }
    public ResultSet getHistorico() throws SQLException {
        String sql = "SELECT DISTINCT h.id_historico, m.artista, m.duracao, m.genero, m.id_musica, m.letra, m.titulo " +
                     "FROM musicas m " +
                     "JOIN historico h ON h.id_musica = m.id_musica " +
                     "WHERE h.id_usuario = ? " + // <- WHERE vem antes
                     "ORDER BY h.id_historico DESC " + // <- depois o ORDER
                     "LIMIT 10"; 
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Sessao.getUsuario().getId());
        stmt.execute();
        ResultSet resultado = stmt.getResultSet();
        return resultado;
    }
    public ResultSet getMusicasPlaylist(int id_playlist) throws SQLException {
        System.out.println(id_playlist);
        String sql = "SELECT p.id_playlist, m.*\n" +
                     "FROM musicas m\n" +
                     "JOIN musica_playlist mp\n" +
                     "ON m.id_musica = mp.id_musica\n" +
                     "JOIN playlist p\n" +
                     "ON mp.id_playlist = p.id_playlist\n" +
                     "WHERE p.id_usuario = ?\n" +
                     "AND p.id_playlist = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Sessao.getUsuario().getId());
        stmt.setInt(2, id_playlist);
        stmt.execute(); 
        ResultSet resultado = stmt.getResultSet();
        return resultado;
    }
    
}
