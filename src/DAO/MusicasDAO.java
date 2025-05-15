/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Musica;
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
    
    
    
}
//public ArrayList<Musica> getAllMusicas() throws SQLException {
//        ArrayList<Musica> musicas = new ArrayList<>();
//        String sql = "SELECT * FROM musica";  // Ou faça JOIN se quiser nome do artista
//
//        PreparedStatement stmt = connection.prepareStatement(sql);
//        ResultSet rs = stmt.executeQuery();
//
//        while (rs.next()) {
//            Musica m = new Musica();
//            m.setTitulo(rs.getString("titulo"));
//            m.setDuracao(rs.getInt("duracao"));
//            m.setGenero(rs.getString("genero"));
//            m.setLetra(rs.getString("letra"));
//            m.setIDartista(rs.getInt("id_artista")); // ou nome do artista, se usar JOIN
//            musicas.add(m);
//        }
//
//        return musicas;
//    }