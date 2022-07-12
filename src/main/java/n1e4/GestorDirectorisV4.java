package n1e4;

import n1e3.GestorDirectorisV3;

import java.nio.file.Files;
import java.nio.file.Path;

public class GestorDirectorisV4 extends GestorDirectorisV3 {

    public static void ensenyarFitxer(String fitxer) {
        try {
            Files.readAllLines(Path.of(fitxer)).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
