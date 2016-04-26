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
        int opcMenu = 0;
        //Crear perfil
        String nombre;
        String nick;
        String claveAcceso;
        int edad;
        String correo;
        //Iniciar sesion
        String nickIni;
        String claveAccesoIni;
        System.out.println("Bienvenido a nuestra red social La Formula");
        System.out.println("");
        do{
            System.out.println("Menu:");
            System.out.print("1: Crea tu perfil ");
            System.out.print("2: Inicia sesion ");
            opcMenu = lectura.nextInt();
            System.out.println("");
            if(opcMenu==1){
                try{
                System.out.println("Crea tu perfil de La Formula");
                System.out.print("Ingresa tu Nombre:             ");
                nombre = lectura.next();
                System.out.print("Ingresa tu nick:               ");
                nick = lectura.next();
                System.out.print("Ingresa tu clave de acceso:    ");
                claveAcceso = lectura.next();
                System.out.print("Ingresa tu edad:               ");
                edad = lectura.nextInt();
                System.out.print("Ingresa tu correo electronico: ");
                correo = lectura.next();
                this.servicio.crearPerfil(nombre, nick, edad, claveAcceso, correo);
                System.out.println("");
                System.out.println("Excelente, acabas de crear un perfil en La Formula");
                System.out.println("");
                }catch(NickException | EdadException | ClaveException | CorreoException | NombreException ex){
                    System.out.println(ex.getMessage());
                }                
            }
            if(opcMenu==2){
                
              System.out.println("1: Haz un comentario");
              System.out.println("2: Subir Fotografia");
              System.out.println("3: Cerrar Red Social");    
            }
        }while(opcMenu!=4);
        
    }
}
