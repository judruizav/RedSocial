/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Exception.ClaveException;
import Exception.ComentarioException;
import Exception.CorreoException;
import Exception.EdadException;
import Exception.NickException;   
import Exception.FotografiaException;
import servicio.Servicio;
import Exception.NombreException;
import Exception.EtiquetaException;
import data.Fotografia;
import data.PerfilUsuario;
import java.util.*;

/**
 *
 * @author La Formula de Pina Records
 */
public class UI {
    
    private Servicio servicio;

    public UI(Servicio servicio)  {
        this.servicio = servicio;
    }
    
    public void menu(Scanner lectura){
        
        int opcMenu;
        //Crear perfil
        String nombre;
        String nick;
        String claveAcceso;
        int edad;
        String correo;
        //Iniciar sesion
        String accesoIni;
        String claveAccesoIni;
        PerfilUsuario perfil= null;
        int opcMenuIni;
        System.out.println("Bienvenido a nuestra red social La Formula");
        System.out.println("");
        do{
            System.out.println("Menu:");
            System.out.println("1: Crea tu perfil. 2: Inicia sesion. 0: Salir ");
            opcMenu= lectura.nextInt();
            System.out.println("");
            if(opcMenu==1){
                String bandera = null;
                do{
                    try{
                        System.out.println("Crea tu perfil de La Formula");
                        System.out.println("");
                        System.out.print("Ingresa tu Nombre: ");
                        nombre = lectura.next();
                        System.out.print("Ingresa tu nick: ");
                        nick = lectura.next();
                        System.out.print("Ingresa tu clave de acceso: ");
                        claveAcceso = lectura.next();
                        System.out.print("Ingresa tu edad: ");
                        edad = lectura.nextInt();
                        System.out.print("Ingresa tu correo electronico(example@correo.com): ");
                        correo = lectura.next();
                        this.servicio.crearPerfil(nombre, nick, edad, claveAcceso, correo);
                        bandera= "Excelente, acabas de crear un perfil en La Formula";
                        System.out.println("");
                        System.out.println(bandera);
                    }catch(NickException | NombreException | EdadException | CorreoException | ClaveException ex){
                        System.out.println(ex.getMessage());
                    }
                }while (bandera== null);
            }
            if(opcMenu==2){  
                String banderaIni=null;  
                System.out.println("Iniciar sesion");
                System.out.println("");
                do{
                    try{
                        System.out.print("Ingresa tu Nick o Correo: ");
                        accesoIni=lectura.next();
                        perfil= this.servicio.buscarUsuario(accesoIni);
                        if(perfil==null){
                            throw new NickException("El usuario no existe");    
                        }
                        System.out.print("Ingresa tu clave: ");
                        claveAccesoIni=lectura.next();
                        if(!perfil.getClaveAcceso().equals(claveAccesoIni)){
                            throw new ClaveException("Clave incorrecta");    
                        }
                        System.out.println("");
                        banderaIni="Bienvenido " + perfil.getNombreReal();
                        System.out.println("");
                        System.out.println(banderaIni);
                    }catch(NickException | ClaveException ex){
                        System.out.println(ex.getMessage());      
                    }
                }while(banderaIni==null); 
                System.out.println("1: Haz un comentario.");
                System.out.println("2: Subir fotografia.");
                System.out.println("3: Etiquetar fotografia.");
                System.out.println("4: Ver informacion de perfil.");
                System.out.println("5: Cerrar sesion.");
                opcMenuIni=lectura.nextInt();
                do{
                    if(opcMenuIni==1){
                        int opcionSubMenu1 = 0;
                        do{
                            String textoComentario;
                            String banderaComentario=null;
                            do{
                                try{
                                    System.out.print("Escribe un comentario: ");
                                    textoComentario=lectura.nextLine();
                                    this.servicio.hacerComentario(textoComentario, perfil);
                                    banderaComentario="Comentario realizado";
                                    System.out.println(banderaComentario);
                                }catch(ComentarioException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }while(banderaComentario!=null);
                            System.out.println("1: Realizar otro comentario. 2: Ir al menu anterior.");
                                opcionSubMenu1 = lectura.nextInt();
                        }while(opcionSubMenu1==1);
                    }
                    if(opcMenuIni==2){
                        int opcionSubMenu2=0;
                        do{
                            System.out.println("Subir una foto");
                            int opcFoto=0;
                            String nombreArchivo;
                            String descripcion;
                            String banderaFoto=null;
                            do{
                                try{
                                    System.out.println("Nombre del Archivo: ");
                                    nombreArchivo=lectura.next();
                                    System.out.println("Ingrese descripcion: ");
                                    descripcion=lectura.nextLine();
                                    this.servicio.subirFotografia(nombreArchivo, descripcion, perfil);
                                    banderaFoto= "Foto subida exitosamente";
                                    System.out.println(banderaFoto);
                                }catch(FotografiaException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }while(banderaFoto==null);
                            System.out.println("1: Subir otra foto. 2: Volver al menu anterior.");
                            opcionSubMenu2 = lectura.nextInt();
                        }while(opcionSubMenu2==1);
                    }
                    if(opcMenuIni==3){
                        int opcionSubMenu3=0;
                        do{
                            String nombreArchivEt;
                            Fotografia fotoEt=null;
                            System.out.println("Etiquetar una foto");
                            do{
                                try{
                                    System.out.println("Ingrese el nombre de archivo de la foto que quiere etiquetar: ");
                                    nombreArchivEt=lectura.next();
                                    fotoEt = this.servicio.buscarFoto(nombreArchivEt, perfil, perfil.getFotosSubidas());
                                    if(fotoEt==null){
                                        throw new FotografiaException("Foto no encontrada");    
                                    }
                                }catch(FotografiaException ex){
                                    System.out.println(ex.getMessage());        
                                }
                            }while(fotoEt==null);
                            int opcEt=1;
                            String banderaEt=null;
                            ArrayList<String> nombresEt= new ArrayList<String>();
                            do{
                                System.out.println("Ingrese los nombres de los usuarios a etiquetar");
                                try{
                                    while(opcEt==1){
                                        String nombreTemp= lectura.nextLine();
                                        nombresEt.add(nombreTemp);
                                        System.out.println("Desea seguir etiquetando? 1:Si. 0:No.");
                                        opcEt=lectura.nextInt();
                                    }
                                    this.servicio.etiquetarFotografiaUsuario(nombresEt, fotoEt);
                                    banderaEt="";
                                    for(int i=0; i<nombresEt.size(); i++){
                                        banderaEt+="Se ha etiquetado a " + nombresEt.get(i) + " correctamente \n";    
                                    }
                                    System.out.println(banderaEt);
                                }catch (EtiquetaException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }while(banderaEt==null);
                            String banderaEt1=null;  
                            int opcEt1=1;
                            do{
                                try{
                                    System.out.println("Ingrese los nombres de las personas sin perfil que desea etiquetar"
                                    + "(Debe haber al menos uno)");
                                    ArrayList<String> personasEt= new ArrayList<String>();
                                    while(opcEt1==1){
                                        String nombreTemp= lectura.nextLine();
                                        personasEt.add(nombreTemp);
                                        System.out.println("Desea seguir etiquetando? 1:Si. 0:No.");
                                        opcEt1=lectura.nextInt();         
                                    }  
                                    this.servicio.etiquetarFotografiaPersona(nombresEt, fotoEt);
                                    banderaEt1="";
                                    for(int i=0; i<nombresEt.size(); i++){
                                        banderaEt1+="Se ha etiquetado a " + nombresEt.get(i) + " correctamente \n";    
                                    }
                                    System.out.println(banderaEt1);
                                }catch (EtiquetaException ex){
                                    System.out.println(ex.getMessage());        
                                }
                            }while(banderaEt1==null);
                            System.out.println("1: Etiquetar otra foto. 2: Volver al menu anterior.");
                            opcionSubMenu3 = lectura.nextInt();
                        }while(opcionSubMenu3==1);
                    }
                    if(opcMenuIni==4){
                        int menuInfo;  
                        System.out.println(perfil.toString());
                        System.out.println("1:Ver comentarios publicados. 2:Ver fotos subidas. 3:Ver fotos en las que se le ha etiquetado.");
                        menuInfo=lectura.nextInt();
                        if(menuInfo==1){
                            System.out.println("Comentarios realizados");  
                            System.out.println(this.servicio.imprimirComentarios(perfil.getComentariosRealizados()));    
                        }
                        if(menuInfo==2){
                            System.out.println("Fotos subidas"); 
                            System.out.println(this.servicio.imprimirInfoFotografia(perfil.getFotosSubidas())); 
                        }
                        if(menuInfo==3){
                            System.out.println("Fotos en las que ha sido etiquetado"); 
                            System.out.println(this.servicio.imprimirInfoFotografia(perfil.getFotosSubidas()));     
                        }
                    }
                }while(opcMenuIni!=5);
            }
        }while(opcMenu!=0);    
    }
}
