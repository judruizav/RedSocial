/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;
import data.RedSocial;
import data.Fotografia;
import Exception.ClaveException;
import Exception.CorreoException;
import Exception.EdadException;
import Exception.NickException;
import Exception.NombreException;
import Exception.ComentarioException;
import Exception.FotografiaException;
import java.util.*;
import servicio.Servicio;
import ui.UI;

/**
 *
 * @author Julian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servicio servicio = new Servicio();
        UI menu = new UI(servicio);
        Scanner scanner = new Scanner(System.in);
        boolean indicador = false;
        int opcion = 0;
        while(indicador == false){
            menu.menu(scanner);
               System.out.println("Desea continuar...1. Si 2. No");
               opcion = scanner.nextInt();
               if(opcion != 1)
                  indicador = true;
        }       
    }
}
