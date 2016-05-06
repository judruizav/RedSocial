/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import data.PerfilUsuario;
import data.Comentario;
import data.Fotografia;
import data.RedSocial;
import servicio.Servicio;
/**
 *
 * @author IVAN
 */
public class test {
    public static void main(String ...args) {
      Dao dao= new Dao();  
      Servicio servicio = new Servicio(dao);
      try{
      servicio.getDao().deserializar(servicio.getRedSocial().getUsuarios());
      }catch(IOException | ClassNotFoundException ex){
        System.out.println("Deserializacion fallida");
        if(ex instanceof IOException){
          System.out.println("IOException");    
        }
        if(ex instanceof ClassNotFoundException){
          System.out.println("ClassNotFoundException");    
        }
      }
      for(int i=0; i<servicio.getRedSocial().getUsuarios().size(); i++){
          System.out.println(servicio.getRedSocial().getUsuarios().get(i).toString());
      }
    }
}    
        /*FileOutputStream os;
        A obj = new A(5);
        try{
          os = new FileOutputStream("RedSocial.ser");
          ObjectOutputStream escribirObj = new ObjectOutputStream(os);
          escribirObj.writeObject(obj);
          os.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        
        
        FileInputStream is;
        A obj2;
        try{
          is = new FileInputStream("RedSocial.ser");
          ObjectInputStream readObj = new ObjectInputStream(is);
          obj2 = (A) readObj.readObject();
          
          System.out.println(obj2.i);
          
          is.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
        

class A implements Serializable {
    int i;

    public A(int i) {
        this.i = i;
    }
    
    //private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        //out.write(i);
        //out.write(7);
    //}
    //private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        
    //}
    //private void readObjectNoData() throws ObjectStreamException {
        
    //}
}*/