/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ControllerMenu;
import Model.Musica;
import Model.Playlist;
import Model.Sessao;
import Model.Usuario;
import java.util.ArrayList;
import javax.swing.BoxLayout;

/**
 * Frame do menu
 * @author Acer Nitro 5
 */
public class MenuFrame extends javax.swing.JFrame {

    /**
     * Creates new form MenuFrame
     */
    public MenuFrame(Usuario usuario) {
        initComponents();
        c = new ControllerMenu(this);
        lbl_nome_usuario.setText(usuario.getNome());
        usuario.autenticar();
        ArrayList<Playlist> playlists = c.buscarPlaylists();
        mostrarPlaylists(playlists);
    }
    
        private void mostrarPlaylists(ArrayList<Playlist> playlist) {
        painelPlaylist.removeAll();
        painelPlaylist.setLayout(new BoxLayout(painelPlaylist, BoxLayout.Y_AXIS));

        for (Playlist p : playlist) {
            ArrayList<Musica> musicas = new ArrayList<>();
            musicas = c.buscarMusicasPlaylist(p.getId_playlist());
            p.setMusicas(musicas);
            PlaylistPanel pp = new PlaylistPanel(p);       
            painelPlaylist.add(pp);
        }

        painelPlaylist.revalidate();
        painelPlaylist.repaint();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nome_usuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoMusicas = new javax.swing.JButton();
        botaoCriar = new javax.swing.JButton();
        botaoApagar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        painelPlaylist = new javax.swing.JPanel();
        botaoCurtidas = new javax.swing.JButton();
        botaoDescurtidas = new javax.swing.JButton();
        botaoHistorico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_nome_usuario.setText("NOME_USUARIO");

        jLabel1.setText("OLÁ:");

        jLabel2.setText("Suas PlayLists");

        botaoMusicas.setText("MUSICAS");
        botaoMusicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMusicasActionPerformed(evt);
            }
        });

        botaoCriar.setText("Criar Playlist");
        botaoCriar.setActionCommand("Criar Playlist");
        botaoCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarActionPerformed(evt);
            }
        });

        botaoApagar.setText("Apagar Playlist");
        botaoApagar.setActionCommand("Apagar Playlsit");
        botaoApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPlaylistLayout = new javax.swing.GroupLayout(painelPlaylist);
        painelPlaylist.setLayout(painelPlaylistLayout);
        painelPlaylistLayout.setHorizontalGroup(
            painelPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );
        painelPlaylistLayout.setVerticalGroup(
            painelPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(painelPlaylist);

        botaoCurtidas.setText("Curtidas");
        botaoCurtidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCurtidasActionPerformed(evt);
            }
        });

        botaoDescurtidas.setText("Descurtidas");
        botaoDescurtidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDescurtidasActionPerformed(evt);
            }
        });

        botaoHistorico.setText("Historico");
        botaoHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_nome_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoMusicas)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botaoCurtidas)
                        .addGap(30, 30, 30)
                        .addComponent(botaoDescurtidas)
                        .addGap(38, 38, 38)
                        .addComponent(botaoHistorico))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(botaoCriar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoApagar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome_usuario)
                    .addComponent(jLabel1)
                    .addComponent(botaoMusicas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(botaoCriar)
                    .addComponent(botaoApagar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCurtidas)
                    .addComponent(botaoDescurtidas)
                    .addComponent(botaoHistorico))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoMusicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMusicasActionPerformed
        // TODO add your handling code here:
        MusicasFrame mf = new MusicasFrame();
        mf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botaoMusicasActionPerformed

    private void botaoCurtidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCurtidasActionPerformed
        // TODO add your handling code here:
        c.buscarMusicasCurtidas();
        this.setVisible(false);
    }//GEN-LAST:event_botaoCurtidasActionPerformed

    private void botaoDescurtidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDescurtidasActionPerformed
        // TODO add your handling code here:
        c.buscarMusicasDescurtidas();
        this.setVisible(false);
    }//GEN-LAST:event_botaoDescurtidasActionPerformed

    private void botaoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoHistoricoActionPerformed
        // TODO add your handling code here:
        c.buscarMusicasHistorico();
        this.setVisible(false);
    }//GEN-LAST:event_botaoHistoricoActionPerformed

    private void botaoCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarActionPerformed
        // TODO add your handling code here:
        CriarPlaylistFrame cp = new CriarPlaylistFrame();
        cp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botaoCriarActionPerformed

    private void botaoApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoApagarActionPerformed
        // TODO add your handling code here:
        ApagarPlaylistFrame ap = new ApagarPlaylistFrame();
        ap.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_botaoApagarActionPerformed


    private ControllerMenu c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoApagar;
    private javax.swing.JButton botaoCriar;
    private javax.swing.JButton botaoCurtidas;
    private javax.swing.JButton botaoDescurtidas;
    private javax.swing.JButton botaoHistorico;
    private javax.swing.JButton botaoMusicas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_nome_usuario;
    private javax.swing.JPanel painelPlaylist;
    // End of variables declaration//GEN-END:variables
}
