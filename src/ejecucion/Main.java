/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        InputStreamReader is= new InputStreamReader(System.in);
        BufferedReader bf= new BufferedReader(is);
        boolean indicador = false;
        int opcion = 0;
        while(indicador == false){
            menu.menu(scanner, bf);
            System.out.println("Seguro que desea salir...1. Si 2. No");
            opcion = scanner.nextInt();
            if(opcion == 1){
                indicador = true;
            }
        }       
    }
}
