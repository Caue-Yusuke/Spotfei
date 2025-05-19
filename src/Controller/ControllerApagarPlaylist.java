/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.PlaylistDAO;
import View.ApagarPlaylistFrame;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer Nitro 5
 */
public class ControllerApagarPlaylist {
    private ApagarPlaylistFrame view;

    public ControllerApagarPlaylist(ApagarPlaylistFrame view) {
        this.view = view;
    }
    
    public void apagarPlaylist(int id_playlist){
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.deletePlaylist(id_playlist);
            JOptionPane.showMessageDialog(view, "Playlist deletada!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao deletar playlist!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
