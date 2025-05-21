/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Classe Artista
 * @author Acer Nitro 5
 */
public class Artista extends Pessoa{
    //atributos de artista
    private int id;
    
    //Construtor de artista
    public Artista(int id, String nome, int idade) {
        super(nome, idade);
        this.id = id;
    }
    //getters e setters de artista
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
