/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.io.*;
import data.PerfilUsuario;
import data.PerfilUsuario;
import data.Fotografia;
import data.Comentario;
import data.RedSocial;
/**
 *
 * @author Julian
 */
public class Dao {

    public Dao() {
    }
    
    public void serializar(PerfilUsuario perfil, String archivo) throws IOException{
    FileOutputStream outStream=null;     
    try{
      outStream= new FileOutputStream(archivo);
      ObjectOutputStream escribirObj = new ObjectOutputStream(outStream);
      escribirObj.writeObject(perfil);
    }finally{
      if(outStream!=null){
        outStream.close();
      }      
    }              
    }
    
    public PerfilUsuario deserializar(String archivo) throws IOException{
        FileInputStream inStream=null;
        PerfilUsuario perfil=null;
        try{
          String leer;
          inStream= new FileInputStream(archivo);
          ObjectInputStream leerObj = new ObjectInputStream(inStream);
          leer = leerObj.readLine();
      }finally{
        if(inStream!=null){
          inStream.close();
        }      
      }
      return perfil;
    }
}
