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
import Exception.MenuException;
import dao.Dao;
import data.Fotografia;
import data.PerfilUsuario;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author La Formula de Pina Records
 */
public class UI {
    
    private Dao dao;
    private Servicio servicio;
    
    public UI(Servicio servicio, Dao dao)  {
        this.servicio = servicio;
        this.dao = dao;
    }
    
    public void menu(Scanner lectura, BufferedReader bf) throws IOException{
        int opcMenu=3;
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
        System.out.println("Bienvenido");
        System.out.println("");
        do{
            if(opcMenu==3){
                String banderaMenu=null;
                do{
                    System.out.println("Menu:");
                    System.out.println("1: Crea tu perfil. 2: Inicia sesion. 0: Salir ");
                        try{
                            opcMenu= lectura.nextInt();
                            if(opcMenu>3||opcMenu<0){
                                throw new MenuException("Opción no valida");
                            }
                            banderaMenu=" ";
                        }catch(MenuException ex){
                            System.out.println(ex.getMessage());
                        }
                }while(banderaMenu==null);
           }
            if(opcMenu==1){
                String bandera = null;
                do{
                    try{
                        System.out.println("Crea tu perfil");
                        System.out.println("");
                        System.out.print("Ingresa tu Nombre: ");
                        nombre = bf.readLine();
                        System.out.print("Ingresa tu nick: ");
                        nick = lectura.next();
                        System.out.print("Ingresa tu clave de acceso: ");
                        claveAcceso = lectura.next();
                        System.out.print("Ingresa tu edad: ");
                        edad = lectura.nextInt();
                        System.out.print("Ingresa tu correo electronico(example@correo.com): ");
                        correo = lectura.next();
                        this.servicio.crearPerfil(nombre, nick, edad, claveAcceso, correo);                        
                        bandera= "Excelente, acabas de crear un perfil";
                        opcMenu=3;
                        System.out.println("");
                        System.out.println(bandera);
                    }catch(IOException | NickException | NombreException | EdadException | CorreoException | ClaveException ex){
                        System.out.println(ex.getMessage());
                        System.out.println("1. Volver a ingresar los datos. 3.Volver al menu principal. 0.Salir");
                        opcMenu=lectura.nextInt();
                    }
                }while (bandera== null&&opcMenu==1);
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
                        banderaIni="Bienvenido/a " + perfil.getNombreReal();
                        System.out.println("");
                        System.out.println(banderaIni);
                    }catch(NickException | ClaveException ex){
                        System.out.println(ex.getMessage());
                        System.out.println("2. Volver a ingresar datos. 3.Volver al menu principal. 0.Salir");
                        opcMenu=lectura.nextInt();
                    }
                }while(banderaIni==null&&opcMenu==2); 
                if(perfil!=null){
                do{  
                  opcMenuIni=0;
                  if(opcMenuIni==0){
                    System.out.println("1: Haz un comentario.");
                    System.out.println("2: Subir fotografia.");
                    System.out.println("3: Etiquetar fotografia.");
                    System.out.println("4: Ver informacion de perfil.");
                    System.out.println("5: Cerrar sesion.");
                    opcMenuIni=lectura.nextInt();
                  }  
                    if(opcMenuIni==1){
                            String textoComentario;
                            String banderaComentario=null;
                            do{
                                try{
                                    System.out.print("Escribe un comentario: ");
                                    textoComentario=bf.readLine();
                                    this.servicio.hacerComentario(textoComentario, perfil);
                                    banderaComentario="Comentario realizado";
                                    System.out.println(banderaComentario);
                                }catch(ComentarioException ex){
                                    System.out.println(ex.getMessage());
                                    System.out.println("1: Volver a realizar el comentario. 0: Ir al menu anterior.");
                                    opcMenuIni = lectura.nextInt();
                                }
                            }while(banderaComentario==null&&opcMenuIni==1);
                            System.out.println("1: Realizar otro comentario. 0: Ir al menu anterior.");
                            opcMenuIni = lectura.nextInt();
                    }
                    if(opcMenuIni==2){
                        do{
                            System.out.println("Subir una foto");
                            String nombreArchivo;
                            String descripcion;
                            String banderaFoto=null;
                            do{
                                try{
                                    System.out.println("Nombre del Archivo: ");
                                    nombreArchivo=lectura.next();
                                    System.out.println("Ingrese descripcion: ");
                                    descripcion= bf.readLine();
                                    this.servicio.subirFotografia(nombreArchivo, descripcion, perfil);
                                    banderaFoto= "Foto subida exitosamente";
                                    System.out.println(banderaFoto);
                                }catch(FotografiaException ex){
                                    System.out.println(ex.getMessage());
                                     System.out.println("2: Volver a subir la foto. 0: Volver al menu anterior.");
                                     opcMenuIni = lectura.nextInt();                                    
                                }
                            }while(banderaFoto==null&&opcMenuIni==2);
                            System.out.println("2: Subir otra foto. 0: Volver al menu anterior.");
                            opcMenuIni = lectura.nextInt();
                        }while(opcMenuIni==2);
                    }
                    if(opcMenuIni==3){
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
                                    System.out.println("3: Volver a cargar foto. 0: Volver al menu anterior.");
                                    opcMenuIni = lectura.nextInt();                                                                        
                                }
                            }while(fotoEt==null&&opcMenuIni==3);
                            if(fotoEt!=null){
                              int opcEt=1;
                              String banderaEt=null;
                              ArrayList<String> nombresEt= new ArrayList<String>();
                              do{
                                try{
                                    System.out.println("Ingrese los nicks de los usuarios a etiquetar");
                                    while(opcEt==1){
                                        String nombreTemp= bf.readLine();
                                        if(this.servicio.buscarUsuario(nombreTemp)==null){
                                          throw new EtiquetaException("El usuario " + nombreTemp + "no tiene un perfil");    
                                        }
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
                                    System.out.println("3: Volver a etiquetar foto. 0: Volver al menu anterior.");
                                    opcMenuIni = lectura.nextInt(); 
                                }
                            }while(banderaEt==null&&opcMenuIni==3);
                            String banderaEt1=null;  
                            int opcEt1=1;
                            if(banderaEt!=null){
                            do{
                                try{
                                    System.out.println("Ingrese los nombres de las personas sin perfil que desea etiquetar"
                                    + "(Debe haber al menos uno)");
                                    ArrayList<String> personasEt= new ArrayList<String>();
                                    while(opcEt1==1){
                                        String nombreTemp= lectura.next();
                                        personasEt.add(nombreTemp);
                                        System.out.println("Desea seguir etiquetando? 1:Si. 0:No.");
                                        opcEt1=lectura.nextInt();         
                                    }  
                                    this.servicio.etiquetarFotografiaPersona(personasEt, fotoEt);
                                    banderaEt1="";
                                    for(int i=0; i<personasEt.size(); i++){
                                        banderaEt1+="Se ha etiquetado a " + personasEt.get(i) + " correctamente \n";    
                                    }
                                    System.out.println(banderaEt1);
                                }catch (EtiquetaException ex){
                                    System.out.println(ex.getMessage());
                                    System.out.println("3: Volver a cargar foto. 0: Volver al menu anterior.");
                                    opcMenuIni = lectura.nextInt(); 
                                }
                            }while(banderaEt1==null&&opcMenuIni==3);
                            }
                            if(banderaEt!=null&&banderaEt1!=null){
                              System.out.println("3: Etiquetar otra foto. 0: Volver al menu anterior.");
                              opcMenuIni = lectura.nextInt();
                            }
                          }  
                    }
                    if(opcMenuIni==4){
                        int menuInfo;
                      do{
                        System.out.println("1:Ver info del perfil.\n2:Ver comentarios publicados.\n3:Ver fotos subidas.\n4:Ver fotos en las que se le ha etiquetado.");
                        menuInfo=lectura.nextInt();
                        if(menuInfo==1){
                          System.out.println(perfil.toString());    
                        }
                        if(menuInfo==2){
                          try{        
                            if(perfil.getComentariosRealizados().isEmpty()){
                              throw new ComentarioException("No tiene comentarios actualmente");    
                            }
                            System.out.println("Comentarios realizados");  
                            System.out.println(this.servicio.imprimirComentarios(perfil.getComentariosRealizados()));                            
                          }catch(ComentarioException ex){
                            System.out.println(ex.getMessage());
                          }
                        }
                        if(menuInfo==3){
                          try{    
                            if(perfil.getFotosSubidas().isEmpty()){
                              throw new FotografiaException("No tiene fotos actualmente");    
                            }                      
                            System.out.println("Fotos subidas"); 
                            System.out.println(this.servicio.imprimirInfoFotografia(perfil.getFotosSubidas()));
                          }catch(FotografiaException ex){
                            System.out.println(ex.getMessage());
                          }
                        }
                        if(menuInfo==4){
                          try{    
                            if(perfil.getFotosEt().isEmpty()){
                              throw new EtiquetaException("No aparece en ninguna foto actualmente");    
                            }      
                            System.out.println("Fotos en las que ha sido etiquetado"); 
                            System.out.println(this.servicio.imprimirInfoFotografia(perfil.getFotosSubidas()));
                          }catch(EtiquetaException ex){
                            System.out.println(ex.getMessage());
                          }                            
                        }
                        System.out.println("4: Seguir consultando info. 0: Volver al menu anterior.");                                   
                        opcMenuIni=lectura.nextInt();                          
                      }while(opcMenuIni==4);
                    }  
                    if(opcMenuIni==5){
                      perfil=null;
                      System.out.println("Ha cerrado sesion correctamente");
                      opcMenu=3;
                    }
                }while(perfil!=null);
                }   
              }      
        }while(opcMenu!=0);    
    }
}
