/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Julian
 */
public class RedSocial implements Serializable{
    
    private ArrayList<PerfilUsuario> usuarios;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Fotografia> fotografias;

    public RedSocial(ArrayList<Fotografia> fotografias) {
        this.usuarios = new ArrayList<PerfilUsuario>();
        this.comentarios= new ArrayList<Comentario>();
        this.fotografias = fotografias;
    }

    public ArrayList<PerfilUsuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public ArrayList<Fotografia> getFotografias() {
        return fotografias;
    }
}
