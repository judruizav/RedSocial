/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.ArrayList;
import Exception.ClaveException;
import Exception.ComentarioException;
import Exception.CorreoException;
import Exception.EdadException;
import Exception.NickException;        
import servicio.Servicio;
import Exception.NombreException;
/**
 *
 * @author Julian
 */
public class PerfilUsuario {
    private String nombreReal;
    private String nick;
    private String claveAcceso;
    private int edad;
    private String cuentaCorreo;
    private ArrayList<Comentario> comentariosRealizados;
    private ArrayList<Fotografia> fotosSubidas;
    private ArrayList<Fotografia> fotosEt;

    public PerfilUsuario(String nombreReal, String nick, String claveAcceso, int edad, String cuentaCorreo, ArrayList<Comentario> comentariosRealizados, 
            ArrayList<Fotografia> fotosSubidas, ArrayList<Fotografia> fotosEt) throws NombreException, EdadException, CorreoException, ClaveException{
        if(nombreReal.length()>100){
          throw new NombreException ("El nombre no puede superar los 100 caracteres");    
        }
        if(edad<18){
          throw new EdadException ("Tiene que ser mayor de 18 para crear un perfil");   
        }
        if(claveAcceso.equals("123456")){
          throw new ClaveException ("La clave no puede ser '123456'");    
        }
        if(cuentaCorreo.contains("@")){
            cuentaCorreo.split("@");
            if(cuentaCorreo.split("@")[1].contains(".com"));
        }else{
            throw new CorreoException ("El formato del correo es incorrecto");
        }
        this.nombreReal = nombreReal;
        this.nick= nick;
        this.edad = edad;
        this.claveAcceso = claveAcceso;
        this.cuentaCorreo = cuentaCorreo;
        this.comentariosRealizados = comentariosRealizados;
        this.fotosSubidas = fotosSubidas;
        this.fotosEt = fotosEt;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public String getNick() {
        return nick;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public String getCuentaCorreo() {
        return cuentaCorreo;
    }

    public ArrayList<Comentario> getComentariosRealizados() {
        return comentariosRealizados;
    }

    public ArrayList<Fotografia> getFotosSubidas() {
        return fotosSubidas;
    }

    public ArrayList<Fotografia> getFotosEt() {
        return fotosEt;
    }
    
    @Override
    public String toString(){
      return "Nombre: " + this.nombreReal +"\n"+
             "Nick: " + this.nick + "\n" +
             "Edad: " + this.edad + "\n" +
             "Correo: " + this.cuentaCorreo + "\n";    
    }
    
}
