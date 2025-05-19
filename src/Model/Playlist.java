/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Acer Nitro 5
 */
public class Playlist {
    //atributos da playlist
    private int id_playlist;
    private String nome;
    private ArrayList<Musica> musicas;
    private int IDusuario;

    public Playlist() {
    }
    
    public Playlist(String nome, int IDusuario, int id_playlist) {
        this.IDusuario = IDusuario;
        this.id_playlist =  id_playlist;
        this.nome = nome;
    }
    
    
    //getters e setters de playList

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    public int getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(int IDusuario) {
        this.IDusuario = IDusuario;
    }

    public int getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(int id_playlist) {
        this.id_playlist = id_playlist;
    }
    
    
}
