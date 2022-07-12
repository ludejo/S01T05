package n1e5;

import n1e4.GestorDirectorisV4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestorDirectorisV5 extends GestorDirectorisV4 {
    public static void serialitzar(Object o, String destinacio) {
        try {
            FileOutputStream fileOut = new FileOutputStream(destinacio);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object desserialitzar(String fitxer) {
        Object o = null;
        try {
            FileInputStream fileIn = new FileInputStream(fitxer);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            o = (Object) in.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return o;
    }
}
