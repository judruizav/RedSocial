/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Date;
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
    
    public void crearPerfil(String nombreReal, String nick, String claveAcceso, String cuentaCorreo){
      ArrayList<Comentario> comentariosRealizados = new ArrayList<Comentario>();      
      ArrayList<Fotografia> fotosSubidas= new ArrayList<Fotografia>();
      ArrayList<Fotografia> fotosEt= new ArrayList<Fotografia>();
      PerfilUsuario nuevoUsuario= new PerfilUsuario(nombreReal, nick, claveAcceso, cuentaCorreo, comentariosRealizados, fotosSubidas, fotosEt);    
      this.usuarios.add(nuevoUsuario);
    }
    
    public void subirFotografia(String nombreArchivo, String descripcion, PerfilUsuario usuario){
      ArrayList<PerfilUsuario> usuariosEt= new ArrayList<PerfilUsuario>();
      ArrayList<String> personasEt= new ArrayList<String>();
      Fotografia nuevaFoto= new Fotografia(nombreArchivo,descripcion,usuario,usuariosEt,personasEt);
      this.fotografias.add(nuevaFoto);
      usuario.getFotosSubidas().add(nuevaFoto);
    }
    
    public void hacerComentario(String texto, Date fechaCreacion, PerfilUsuario usuario){
      Comentario nuevoComentario = new Comentario(texto,fechaCreacion, usuario);
      this.comentarios.add(nuevoComentario);
      usuario.getComentariosRealizados().add(nuevoComentario);
    }
    
}
