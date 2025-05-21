/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Sessao;
import java.sql.*;

/**
 * DAO das playlists
 * @author Acer Nitro 5
 */
public class PlaylistDAO {
    private Connection conn;

    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }
    // insere os valores no banco
    public void inserirHistorico(int id_musica, int id_usuario)throws SQLException{
        String sql = "INSERT INTO historico (id_usuario, id_musica) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, id_usuario);
        statement.setInt(2, id_musica);
        statement.executeUpdate();
        conn.close();
    }
     // insere musicas curtidas no banco
    public void inserirCurtidas(int id_musica, int id_usuario)throws SQLException{
        String sql = "INSERT INTO curtidas (id_usuario, id_musica) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, id_usuario);
        statement.setInt(2, id_musica);
        statement.executeUpdate();
        conn.close();
    }
    // insere musicas descurtidas no banco
    public void inserirDescurtidas(int id_musica, int id_usuario)throws SQLException{
        String sql = "INSERT INTO descurtidas (id_usuario, id_musica) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setInt(1, id_usuario);
        statement.setInt(2, id_musica);
        statement.executeUpdate();
        conn.close();
    }
    // insere playlist no banco
    public void criarPlaylist(String nome_playlist)throws SQLException{
        String sql = "INSERT INTO playlist (nome, id_usuario) VALUES(?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome_playlist);
        stmt.setInt(2, Sessao.getUsuario().getId());
        stmt.executeUpdate();
        conn.close();
        
    }
    public ResultSet getPlaylists() throws SQLException {
        String sql = "SELECT * FROM playlist WHERE playlist.id_usuario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Sessao.getUsuario().getId());
        stmt.execute();
        ResultSet resultado = stmt.getResultSet();
        return resultado;
    }
    public void deletePlaylist(int id_playlist)throws SQLException{
        String sql = "DELETE FROM playlist\n" +
                     "WHERE id_playlist = ?;\n" +
                     "DELETE FROM musica_playlist\n" +
                     "WHERE id_playlist = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_playlist);
        stmt.setInt(2, id_playlist);
        stmt.executeUpdate();
        conn.close();
    }
    public void addMusica(int id_musica, int id_playlist)throws SQLException{
        String sql = "INSERT INTO musica_playlist (id_musica, id_playlist ) VALUES(?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_musica);
        stmt.setInt(2, id_playlist);
        stmt.executeUpdate();
        conn.close();
    }
    public void deleteMusicaPlaylist(int id_musica, int id_playlist)throws SQLException{
        String sql = "DELETE FROM musica_playlist\n" +
                     "WHERE id_playlist = ?;\n" +
                     "AND id_musica = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_playlist);
        stmt.setInt(2, id_musica);
        stmt.executeUpdate();
        conn.close();
    }
}
