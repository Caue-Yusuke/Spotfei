/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Sessao;
import Model.Usuario;
import View.LoginFrame;
import View.MenuFrame;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Controller de LoginFrame
 * @author Acer Nitro 5
 */
public class ControllerLogin {
    private LoginFrame view;

    public ControllerLogin(LoginFrame view) {
        this.view = view;
    }
    //verifica se o usuario existe e realiza o login
    public void loginUsuario(){
        Usuario usuario = new Usuario(view.getEmail_login().getText(),view.getSenha_login().getText(), null, 0, 0);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(view, 
                                              "Login efetuado!", 
                                              "Aviso",
                                              JOptionPane.INFORMATION_MESSAGE);
                int id = res.getInt("id");
                String nome = res.getString("nome");
                int idade = res.getInt("idade");
                String email = res.getString("email");
                String senha = res.getString("senha");
                Usuario usuario2 = new Usuario(email, senha, nome, idade, id);
                Sessao.setUsuario(usuario2); 

                MenuFrame menu = new MenuFrame(Sessao.getUsuario());
                menu.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(view, 
                                              "Login NÃO efetuado!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e){    
            JOptionPane.showMessageDialog(view, 
                                              "Erro de conexão!", 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
