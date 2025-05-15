/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Acer Nitro 5
 */
public class Usuario extends Pessoa{
    //atributos exclusivos de Usuario
    private String email;
    private String senha;
    
    //Construtor de Pessoa

    public Usuario(String email, String senha, String nome, int idade) {
        super(nome, idade);
        this.email = email;
        this.senha = senha;
    }
    

    //Getters de Usuario
    public String getEmail() {return email;}
    public String getSenha() {return senha;}
    //Setters de Usuario
    public void setEmail(String email) {this.email = email;}
    public void setSenha(String senha) {this.senha = senha;}

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", senha=" + senha + '}';
    }

    
    
    
    
    
}
