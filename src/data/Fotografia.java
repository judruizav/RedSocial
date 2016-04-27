/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.ArrayList;
import servicio.Servicio;
/**
 *
 * @author Julian
 */
public class Fotografia {
    private String nombreArchivo;
    private String descripcion;
    private PerfilUsuario usuarioFoto;
    private ArrayList<PerfilUsuario> usuariosEt;
    private ArrayList<String> personasEt;
    private Servicio servicio= new Servicio();

    public Fotografia(String nombreArchivo, String descripcion, PerfilUsuario usuarioFoto, ArrayList<PerfilUsuario> usuariosEt, ArrayList<String> personasEt) {
        this.nombreArchivo = nombreArchivo;
        this.descripcion = descripcion;
        this.usuarioFoto = usuarioFoto;
        this.usuariosEt = usuariosEt;
        this.personasEt = personasEt;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public PerfilUsuario getUsuarioFoto() {
        return usuarioFoto;
    }

    public ArrayList<PerfilUsuario> getUsuariosEt() {
        return usuariosEt;
    }

    public ArrayList<String> getPersonasEt() {
        return personasEt;
    }

    public Servicio getServicio() {
        return servicio;
    }

    @Override
    public String toString(){
        return "Nombre de archivo: " + this.nombreArchivo + "\n" +
        this.descripcion + "\n" +
        "Subida por " + this.usuarioFoto.getNombreReal();    
    }
}
