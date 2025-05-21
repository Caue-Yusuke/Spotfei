/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.Conexao;
import DAO.PlaylistDAO;
import Model.Sessao;
import View.MenuFrame;
import View.MusicaPlaylistPanel;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 * Controller de  MusicaPlaylistPanel
 * @author Acer Nitro 5
 */
public class ControllerMusicaPlaylistPanel {
    private MusicaPlaylistPanel view;
    
    public ControllerMusicaPlaylistPanel(MusicaPlaylistPanel view) {
        this.view = view;
    }
    //insere aa musica no historico
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
    //insere a musica em curtidas no banco
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
    //insere a musica em descurtidas no banco
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
    public void removerMusica(int id_musica,int id_playlist){
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.deleteMusicaPlaylist(id_musica, id_playlist);
            JOptionPane.showMessageDialog(view, "Musica deletada!","Aviso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao deletar musica!","Erro", JOptionPane.ERROR_MESSAGE);
        }
        MenuFrame menu = new MenuFrame(Sessao.getUsuario());
        menu.setVisible(true);
    }
}
