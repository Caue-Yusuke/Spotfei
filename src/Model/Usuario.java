/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.JOptionPane;

/**
 * Classe Usuario
 * @author Acer Nitro 5
 */
public class Usuario extends Pessoa implements Autenticacao{
    //atributos exclusivos de Usuario
    public static int verificacao = 0; // usada para a verificacao ocorrer apenas uma vez
    private String email;
    private String senha;
    private int id;
    
    //Construtor de Pessoa

    public Usuario(String email, String senha, String nome, int idade, int id) {
        super(nome, idade);
        this.email = email;
        this.senha = senha;
        this.id = id;
    }
    

    //Getters de Usuario
    public String getEmail() {return email;}
    public String getSenha() {return senha;}
    public int getId() {return id;}
    //Setters de Usuario
    public void setEmail(String email) {this.email = email;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setId(int id) {this.id = id;}

    @Override
    
    //metodo de verificacao de robo
    public void autenticar() {
        if(verificacao == 0){
            int resposta = JOptionPane.showConfirmDialog(
                null,
                "Você é um robô?",
                "Verificação",
                JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else if (resposta == JOptionPane.NO_OPTION) {
            }
            verificacao ++;
        }
        
    }
    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", senha=" + senha + '}';
    }

    
    
    
    
    
}
