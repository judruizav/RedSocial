/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.util.ArrayList;
/**
 *
 * @author Julian
 */
public class PerfilUsuario {
    private String nombreReal;
    private String nick;
    private String claveAcceso;
    private String cuentaCorreo;
    private ArrayList<Comentario> comentariosRealizados;
    private ArrayList<Fotografia> fotosSubidas;
    private ArrayList<Fotografia> fotosEt;

    public PerfilUsuario(String nombreReal, String nick, String claveAcceso, String cuentaCorreo, ArrayList<Comentario> comentariosRealizados, ArrayList<Fotografia> fotosSubidas, ArrayList<Fotografia> fotosEt) {
        this.nombreReal = nombreReal;
        this.nick= nick;
        this.claveAcceso = claveAcceso;
        this.cuentaCorreo = cuentaCorreo;
        this.comentariosRealizados = comentariosRealizados;
        this.fotosSubidas = fotosSubidas;
        this.fotosEt = fotosEt;
    }
    
    
    
}
