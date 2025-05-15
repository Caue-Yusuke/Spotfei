/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
//importação de todas bibliotecas SQL
import java.sql.*;
import Model.Usuario;

/**
 *
 * @author Acer Nitro 5
 */
public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    public ResultSet consultar(Usuario usuario) throws SQLException{
        String sql = "select * from usuarios where email = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getEmail());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, idade, email, senha) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setInt(2, usuario.getIdade());
        statement.setString(3, usuario.getEmail());
        statement.setString(4, usuario.getSenha());
        statement.executeUpdate();
        conn.close();
    }
    
}
