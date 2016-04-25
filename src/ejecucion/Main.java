/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;

import Exception.PerfilUsuarioException;
import java.util.Scanner;
import ui.UI;

/**
 *
 * @author Julian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PerfilUsuarioException{
        UI menu = new UI();
        Scanner scanner = new Scanner(System.in);
        boolean indicador = false;
        int opcion = 0;
        while(indicador == false){
            menu.menu(menu.crearRedSocial());
               System.out.println("Desea continuar...1. Si 2. No");
               opcion = scanner.nextInt();
               if(opcion != 1)
                  indicador = true;
        }       
    }
}
