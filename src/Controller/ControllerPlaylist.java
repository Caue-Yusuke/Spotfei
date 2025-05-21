/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.Conexao;
import DAO.MusicasDAO;
import DAO.PlaylistDAO;
import Model.Musica;
import Model.Sessao;
import View.MenuFrame;
import View.PlaylistFrame;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Controller de PlaylistFrame
 * @author Acer Nitro 5
 */
public class ControllerPlaylist {
    private PlaylistFrame view;

    public ControllerPlaylist(PlaylistFrame view) {
        this.view = view;
    }
    //insere a musica no banco musica_playlist
    public void adicionarMusica (int id_musica, int id_playlist){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.addMusica(id_musica, id_playlist);
            JOptionPane.showMessageDialog(view, "Musica Adicionada!","Erro", JOptionPane.INFORMATION_MESSAGE);
            MenuFrame menu = new MenuFrame(Sessao.getUsuario());
            menu.setVisible(true);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(view, "Musica nao Adicionada!","Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
}
