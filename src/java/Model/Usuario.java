/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hataishi
 */
public class Usuario {
    private String usuario;
    private String senha;
    private loginPerfilDeAcesso perfil;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public loginPerfilDeAcesso getPerfil() {
        return perfil;
    }

    public void setPerfil(loginPerfilDeAcesso perfil) {
        this.perfil = perfil;
    }
    
}
