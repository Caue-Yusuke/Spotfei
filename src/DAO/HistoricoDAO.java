/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Acer Nitro 5
 */
public class HistoricoDAO {
    private Connection conn;

    public HistoricoDAO(Connection conn) {
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
}
