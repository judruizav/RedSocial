/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Date;
import Exception.ClaveException;
import Exception.CorreoException;
import Exception.EdadException;
import Exception.NickException;
import Exception.NombreException;
import Exception.ComentarioException;
import Exception.FotografiaException;
/**
 *
 * @author Julian
 */
public class RedSocial {
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
