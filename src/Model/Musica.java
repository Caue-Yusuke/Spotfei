/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Acer Nitro 5
 */
public class Musica {
    //atributos musica
    private int id;
    private String titulo; 
    private int duracao;
    private String artista;
    private String genero;
    private String letra;

    public Musica() {
    }

    public Musica(int id, String titulo, int duracao, String artista, String genero, String letra) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.artista = artista;
        this.genero = genero;
        this.letra = letra;
    }
    
    
    
    //getter e setters de musica

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
