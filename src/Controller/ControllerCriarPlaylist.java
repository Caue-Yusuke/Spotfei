/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.PlaylistDAO;
import View.CriarPlaylistFrame;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Controller de CriarPlaylistFrame
 * @author Acer Nitro 5
 */
public class ControllerCriarPlaylist {
    private CriarPlaylistFrame view;

    public ControllerCriarPlaylist(CriarPlaylistFrame view) {
        this.view = view;
    }
    //insere a playlist no banco
    public void criarPlaylist(String nome_playlist){
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.criarPlaylist(nome_playlist);
            JOptionPane.showMessageDialog(view, "Playlist Criada!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao criar Playlist!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
        
}
