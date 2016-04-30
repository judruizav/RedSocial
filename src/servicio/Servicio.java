/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;
import Exception.ClaveException;
import Exception.CorreoException;
import Exception.EdadException;
import Exception.NickException;
import Exception.NombreException;
import Exception.ComentarioException;
import Exception.EtiquetaException;
import Exception.FotografiaException;
import data.PerfilUsuario;
import data.Fotografia;
import data.Comentario;
import data.RedSocial;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Julian
 */
public class Servicio {

    private RedSocial redSocial;
    
    public Servicio() {
        ArrayList<Fotografia> fotos= new ArrayList<Fotografia>();  
        this.redSocial= new RedSocial(fotos);
    }
    
    
    public PerfilUsuario buscarUsuario(String buscar){
        PerfilUsuario usuarioEncontrado= null;
        for(int i=0; i<this.redSocial.getUsuarios().size(); i++){
            if(this.redSocial.getUsuarios().get(i).getNombreReal().equals(buscar)||this.redSocial.getUsuarios().get(i).getNick().equals(buscar)||this.redSocial.getUsuarios().get(i).getCuentaCorreo().equals(buscar)){
                usuarioEncontrado=this.redSocial.getUsuarios().get(i);
            }    
        }
        return usuarioEncontrado;
    }
    
    public Fotografia buscarFoto(String buscar, PerfilUsuario usuario, ArrayList<Fotografia> fotos){
        Fotografia fotoEncontrada= null;
        for(int i=0; i<fotos.size(); i++){
            if(fotos.get(i).getNombreArchivo().equals(buscar)){
                fotoEncontrada = fotos.get(i);    
            }      
        }
        return fotoEncontrada;      
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
    
    public void crearPerfil(String nombreReal, String nick, int edad, String claveAcceso, String cuentaCorreo) throws NombreException, EdadException, CorreoException, ClaveException, NickException {
        ArrayList<Comentario> comentariosRealizados = new ArrayList<Comentario>();      
        ArrayList<Fotografia> fotosSubidas= new ArrayList<Fotografia>();
        ArrayList<Fotografia> fotosEt= new ArrayList<Fotografia>();
        if(buscarUsuario(nick)!=null){
            throw new NickException("El nick ya existe");    
        }
        PerfilUsuario nuevoUsuario= new PerfilUsuario(nombreReal, nick, claveAcceso, edad, cuentaCorreo, comentariosRealizados, fotosSubidas, fotosEt);    
        this.redSocial.getUsuarios().add(nuevoUsuario);
    }
    
    public void subirFotografia(String nombreArchivo, String descripcion, PerfilUsuario usuario)throws FotografiaException{
        ArrayList<PerfilUsuario> usuariosEt= new ArrayList<PerfilUsuario>();
        ArrayList<String> personasEt= new ArrayList<String>();
        Fotografia nuevaFoto= new Fotografia(nombreArchivo,descripcion,usuario,usuariosEt,personasEt);
        this.redSocial.getFotografias().add(nuevaFoto);
        usuario.getFotosSubidas().add(nuevaFoto);
    } 
    
    public void etiquetarFotografiaUsuario(ArrayList<String> nombres, Fotografia fotografia)throws EtiquetaException{
        ArrayList<PerfilUsuario> usuariosBuscados= new ArrayList<PerfilUsuario>();
        if(nombres.size()<2 || nombres.size()>5){
            throw new EtiquetaException ("Debe etiquetar al menos 2 usuarios y máximo 5");
        }
        PerfilUsuario temp=null;
        for(int i=0; i<nombres.size(); i++){
            temp = buscarUsuario(nombres.get(i));
            usuariosBuscados.add(temp);
        }            
    }
    
    public void etiquetarFotografiaPersona(ArrayList<String> nombres, Fotografia fotografia) throws EtiquetaException{
        if(nombres.isEmpty()){
            throw new EtiquetaException ("Debe etiquetar al menos una persona sin perfil ");
        }
        for(int i=0; i<nombres.size(); i++){
            fotografia.getPersonasEt().add(nombres.get(i));    
        }
    }
    
    public void hacerComentario(String texto, PerfilUsuario usuario) throws ComentarioException{
        Comentario nuevoComentario = new Comentario(texto,new Date(), usuario);
        this.redSocial.getComentarios().add(nuevoComentario);
        usuario.getComentariosRealizados().add(nuevoComentario);
    }
}
