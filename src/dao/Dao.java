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
import java.util.ArrayList;
/**
 *
 * @author Julian
 */
public class Dao {

    public Dao() {
    }
    
    public void serializar(PerfilUsuario perfil) throws IOException{
    FileOutputStream os=null;    
    try{
      os= new FileOutputStream(new File("RedSocial.ser"));
      ObjectOutputStream escribirObj = new ObjectOutputStream(os);
      escribirObj.writeObject(perfil);
    }finally{
      if(os!=null){
        os.close();
      }
    }
    }
    
    public void deserializar(ArrayList<PerfilUsuario> usuarios) throws IOException, ClassNotFoundException{
        FileInputStream inStream=null;
        PerfilUsuario perfil;
        try{
          inStream= new FileInputStream("RedSocial.ser");
          ObjectInputStream leerObj = new ObjectInputStream(inStream);
          Object temp;
        while((temp=leerObj.readObject())!=null){
          temp= leerObj.readObject();
          perfil= (PerfilUsuario) temp;
          usuarios.add(perfil);
        }    
      }finally{
        if(inStream!=null){
          inStream.close();
        }
      }
    }
}
