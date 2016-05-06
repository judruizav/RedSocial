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
public class Dao implements Serializable{

    public Dao() {
    }
    
    
    public void serializar(PerfilUsuario perfil) throws IOException{
    ByteArrayOutputStream os=null;    
    try{   
      RandomAccessFile raf= new RandomAccessFile("RedSocial.ser", "rw");
      os= new ByteArrayOutputStream();
      ObjectOutputStream escribirObj = new ObjectOutputStream(os);
      raf.seek(raf.length());
      escribirObj.writeObject(perfil);
      raf.write(os.toByteArray());
      }finally{
        if(os!=null){
          os.close();
        }
      }
    }
    
    public void deserializar(ArrayList<PerfilUsuario> usuarios) throws IOException, ClassNotFoundException{
      FileInputStream is=null;
      PerfilUsuario perfil;
      try{
        RandomAccessFile raf= new RandomAccessFile("RedSocial.ser", "rw");  
        is= new FileInputStream("RedSocial.ser");  
        ObjectInputStream objIs= new ObjectInputStream(is);
        perfil= (PerfilUsuario) objIs.readObject();
        usuarios.add(perfil);
      }finally{
        if(is!=null){
          is.close();
        }
      }
    }
}
