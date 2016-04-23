/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;
import data.PerfilUsuario;
import data.Fotografia;
import data.Comentario;
import java.util.ArrayList;
/**
 *
 * @author Julian
 */
public class Servicio {

    public Servicio() {
    }
    
    public PerfilUsuario buscarUsuario(ArrayList<PerfilUsuario> usuarios, String buscar){
      PerfilUsuario usuarioEncontrado= null;
      for(int i=0; i<usuarios.size(); i++){
        if(usuarios.get(i).getNombreReal().equals(buscar)||usuarios.get(i).getNick().equals(buscar)||usuarios.get(i).getCuentaCorreo().equals(buscar)){
          usuarioEncontrado=usuarios.get(i);
        }    
      }
      return usuarioEncontrado;
    } 
    
    public String imprimirUsuarios(ArrayList<PerfilUsuario> usuarios){
      String imprimir="";
      for(int i=0; i<usuarios.size(); i++){
        imprimir+=usuarios.get(i).toString();
        imprimir+="\n";
      }
      return imprimir;     
    }
    
    public String imprimirComentarios(ArrayList<Comentario> comentarios){
      String imprimir="";
      for(int i=0; i<comentarios.size(); i++){
        imprimir+=comentarios.get(i).toString();
        imprimir+="\n";
      }
      return imprimir;
    }
    
    public String imprimirInfoFotografia(ArrayList<Fotografia> fotografias){
      String imprimir="";
      for(int i=0; i<fotografias.size(); i++){
        imprimir+=fotografias.get(i).toString();
        imprimir+="\n";
      }
      return imprimir;
    }
}
