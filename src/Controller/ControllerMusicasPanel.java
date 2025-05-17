/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.PlaylistDAO;
import Model.Sessao;
import View.MusicaPanel;
import View.MusicasFrame;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer Nitro 5
 */
public class ControllerMusicasPanel {
    private MusicaPanel view;

    public ControllerMusicasPanel(MusicaPanel view) {
        this.view = view;
    }
    
    public void salvarHistorico(int id_musica){
        int id_usuario = Sessao.getUsuario().getId();
        int idMusica = id_musica;
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.inserirHistorico(idMusica, id_usuario);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(view, "Historico nao Salvo!","Erro", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    public void curtirMusica(int id_musica){
        int id_usuario = Sessao.getUsuario().getId();
        int idMusica = id_musica;
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.inserirCurtidas(idMusica, id_usuario);
            JOptionPane.showMessageDialog(view, "Musica Curtida!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(view, "Musica nao Salva!","Erro", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    public void descurtirMusica(int id_musica){
        int id_usuario = Sessao.getUsuario().getId();
        int idMusica = id_musica;
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.inserirDescurtidas(idMusica, id_usuario);
            JOptionPane.showMessageDialog(view, "Musica Descurtida!","Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(view, "Musica nao Salva!","Erro", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
