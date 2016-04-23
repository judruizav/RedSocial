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
    
    public void etiquetarFotografiaUsuario(ArrayList<PerfilUsuario> usuarios, String nombre, Fotografia fotografia){
      PerfilUsuario usuarioEt = servicio.buscarUsuario(usuarios, nombre);
      fotografia.usuariosEt.add(usuarioEt);
      usuarioEt.getFotosEt().add(fotografia);
    }
    
    public void etiquetarFotografiaPersona(String nombre){
      this.personasEt.add(nombre);
    }
    
    @Override
    public String toString(){
      return "Nombre de archivo: " + this.nombreArchivo + "\n" +
             this.descripcion + "\n" +
             "Subida por " + this.usuarioFoto.getNombreReal();    
    }
    
}
