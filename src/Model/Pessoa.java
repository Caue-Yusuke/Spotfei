/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Acer Nitro 5
 */

//Classe Pessoa
public class Pessoa {
    //criando os atributos de pessoas
    private String nome;
    private int idade;

    // Construtor de Pessoa
    public Pessoa(String nome, int idade) {
        this.nome = nome;    
        this.idade = idade;
} 

    //getters
    public String getNome() {return nome;}
    public int getIdade() {return idade;}
    //setters
    public void setNome(String nome) {this.nome = nome;}
    public void setIdade(int idade) {this.idade = idade;}

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + '}';
    }
    
    
    
}
