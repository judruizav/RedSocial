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
import servicio.Servicio;
import Exception.NombreException;
import data.Comentario;
import data.Fotografia;
import data.PerfilUsuario;
import data.RedSocial;
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
              do{try{
                System.out.println("Crea tu perfil de La Formula");
                System.out.print("Ingresa tu Nombre:             ");
                nombre = lectura.next();
                System.out.print("Ingresa tu nick:               ");
                nick = lectura.next();
                System.out.print("Ingresa tu clave de acceso:    ");
                claveAcceso = lectura.next();
                System.out.print("Ingresa tu edad:               ");
                edad = lectura.nextInt();
                System.out.print("Ingresa tu correo electronico(example@correo.com): ");
                correo = lectura.next();
                this.servicio.crearPerfil(nombre, nick, edad, claveAcceso, correo);
                System.out.println("");
                bandera= "Excelente, acabas de crear un perfil";
                System.out.println(bandera);
                }catch(NickException | NombreException | EdadException | CorreoException | ClaveException ex){
                    System.out.println(ex.getMessage());
                }
              }while (bandera== null);
            }
            if(opcMenu==2){  
              String banderaIni=null;  
              System.out.println("Iniciar sesion");
              do{try{
                System.out.print("Ingresa tu Nick o Correo: ");
                accesoIni=lectura.next();
                perfil= this.servicio.buscarUsuario(accesoIni);
                if(perfil==null){
                  throw new NickException("El usuario no existe");    
                }
                System.out.print("Ingresa tu clave");
                claveAccesoIni=lectura.next();
                if(!perfil.getClaveAcceso().equals(claveAccesoIni)){
                  throw new ClaveException("Clave incorrecta");    
                }
                banderaIni="Bienvenido " + perfil.getNombreReal();
                System.out.println(banderaIni);
                }catch(NickException | ClaveException ex){
                  System.out.println(ex.getMessage());      
                }
              }while(banderaIni==null); 
              System.out.println("1: Haz un comentario. 2: Subir Fotografia.  3: Ver informacion de perfil.");
              opcMenuIni=lectura.nextInt();
              if(opcMenuIni==1){
                String textoComentario;
                String banderaComentario= null;
              do{try{
                System.out.print("Escribe un comentario: ");
                textoComentario=lectura.nextLine();
                this.servicio.hacerComentario(textoComentario, perfil);
                banderaComentario="Comentario realizado";
                System.out.println(banderaComentario);
                }catch(ComentarioException ex){
                  System.out.println(ex.getMessage());
                }
              }while(banderaComentario!=null);  
              }
              if(opcMenuIni==2){
                  
              }
              if(opcMenuIni==3){
                  
              }
            }
        }while(opcMenu!=0);
        
    }
}
