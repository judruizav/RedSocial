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

/**
 *
 * @author IVAN
 */
public class test {
    public static void main(String ...args) {
        
        
        FileOutputStream os;
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
}