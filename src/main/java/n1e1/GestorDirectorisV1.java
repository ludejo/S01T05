package n1e1;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.stream.Stream;

public class GestorDirectorisV1 {

    public GestorDirectorisV1() {
    }

    public static void mostrarDirectori(String ruta) {
        //try-with-resource amb Stream + Files
        try (Stream<Path> fitxer = Files.list(Path.of(ruta))){
            fitxer.sorted().forEach(f -> System.out.println(f.getFileName()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
