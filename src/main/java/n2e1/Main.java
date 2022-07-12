package n2e1;

import n1e3.GestorDirectorisV3;

import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(args[0]));
            String directori = appProps.getProperty(args[1]);
            String destinacio = appProps.getProperty(args[2]);
            GestorDirectorisV3.guardarDirectoriComplet(directori, 1, destinacio);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
