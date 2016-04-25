/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Exception.PerfilUsuarioException;
import data.Comentario;
import data.Fotografia;
import data.PerfilUsuario;
import data.RedSocial;
import java.util.ArrayList;

/**
 *
 * @author La Formula de Pina Records
 */
public class UI {
    
    public RedSocial crearRedSocial(){
        ArrayList<Fotografia> fotografias = null;
        RedSocial laFormula = new RedSocial(fotografias);
        return laFormula;
    }
    
    public void menu(RedSocial laFormula){
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        int opcMenu = 0;
        System.out.println("Bienvenido a nuestra red social La Formula");
        System.out.println("");
        do{
            System.out.println("Menu:");
            System.out.println("1: Crea tu perfil");
            System.out.println("2: Has un comentario");
            System.out.println("3: Subir Fotografia");
            System.out.println("4: Cerrar Red Social");
            opcMenu = lectura.nextInt();
            System.out.println("");
            if(opcMenu==1){
                try{
                System.out.println("Crea tu perfil de La Formula");
                System.out.print("Ingresa tu Nombre:             ");
                String nombre = lectura.next();
                System.out.print("Ingresa tu nick:               ");
                String nick = lectura.next();
                System.out.print("Ingresa tu clave de acceso:    ");
                String claveAcceso = lectura.next();
                System.out.print("Ingresa tu edad:               ");
                int edad = lectura.nextInt();
                System.out.print("Ingresa tu correo electronico: ");
                String correo = lectura.next();
                laFormula.crearPerfil(nombre, nick, edad, claveAcceso, correo);
                System.out.println("");
                System.out.println("Excelente, acabas de crear un perfil en La Formula");
                System.out.println("");
                
                }catch(PerfilUsuarioException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }while(opcMenu!=4);
        
    }
}
