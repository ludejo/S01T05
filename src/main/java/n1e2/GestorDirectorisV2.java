package n1e2;

import n1e1.GestorDirectorisV1;

import java.io.File;
import java.util.Date;
import java.util.Arrays;

public class GestorDirectorisV2 extends GestorDirectorisV1 {
    public static void mostrarDirectoriComplet(String ruta, int marge) {
        // java classic amb File
        try {
            File dir = new File(ruta);
            if (!dir.exists()) throw new Exception("El directori no existeix");
            boolean isDir = dir.isDirectory();
            System.out.printf("-".repeat(marge) + "%s %s [%s]\n", isDir ? "[D]" : "[F]", dir.getName(), new Date(dir.lastModified()));
            if (isDir) {
                File[] subdir = dir.listFiles();
                if (subdir.length != 0) {
                    Arrays.sort(subdir);
                    for (File f : subdir) {
                        mostrarDirectoriComplet(f.toString(), marge + 1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
