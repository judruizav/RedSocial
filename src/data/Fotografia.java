/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import Exception.FotografiaException;
import java.io.Serializable;
import java.util.ArrayList;
import servicio.Servicio;
/**
 *
 * @author Julian
 */
public class Fotografia implements Serializable{
    
    private String nombreArchivo;
    private String descripcion;
    private PerfilUsuario usuarioFoto;
    private ArrayList<PerfilUsuario> usuariosEt;
    private ArrayList<String> personasEt;

    public Fotografia(String nombreArchivo, String descripcion, PerfilUsuario usuarioFoto, ArrayList<PerfilUsuario> usuariosEt, ArrayList<String> personasEt) throws FotografiaException {
        if(descripcion.length()>200){
            throw new FotografiaException ("El numero maximo de caracteres permitido en la descripcion es 200 D:");
        }
        
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

    @Override
    public String toString(){
        String acum1="";
        String acum2="";
        if(this.usuariosEt.isEmpty()){
          acum1+="No hay usuarios etiquetados";     
        }else{
          for(int i=0; i<(this.usuariosEt.size()-1); i++){
            acum1+=this.usuariosEt.get(i).getNombreReal() + ",";
          }
        acum1+= this.usuariosEt.get(this.usuariosEt.size()-1).getNombreReal();
        }
        if(this.personasEt.isEmpty()){
          acum2+="No hay personas etiquetadas";     
        }else{
          for(int i=0; i<(this.personasEt.size()-1); i++){
            acum2+=this.personasEt.get(i) + ",";
          }
        acum2+= this.personasEt.get(this.personasEt.size()-1);
        }
        return "Nombre de archivo: " + this.nombreArchivo + "\n" +
        this.descripcion + "\n" +
        "Subida por " + this.usuarioFoto.getNombreReal() + "\n" +
        "Usuarios etiquetados: " +  acum1 + "\n" +
        "Personas etiquetadas: " +  acum2;     
    }
}
