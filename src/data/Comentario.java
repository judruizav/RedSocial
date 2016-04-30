/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.Date;
import Exception.ComentarioException;
/**
 *
 * @author Julian
 */
public class Comentario {
    
    private String texto;
    private Date fechaCreacion;
    private PerfilUsuario usuarioComent;
    
    public Comentario(String texto, Date fechaCreacion, PerfilUsuario usuarioComent) throws ComentarioException{
        if(texto.length()>200){
            throw new ComentarioException("El numero de caracteres del comentario no puede ser mayor a 200");    
        }
        this.texto= texto;
        this.fechaCreacion= fechaCreacion;
        this.usuarioComent= usuarioComent;
    }

    public String getTexto() {
        return texto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public PerfilUsuario getUsuarioComent() {
        return usuarioComent;
    }
    
    @Override
    public String toString(){
        return this.texto + "\n" + this.fechaCreacion;    
    }
}
