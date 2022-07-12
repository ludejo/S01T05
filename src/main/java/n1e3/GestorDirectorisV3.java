package n1e3;

import n1e2.GestorDirectorisV2;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Date;

public class GestorDirectorisV3 extends GestorDirectorisV2 {

    public static void guardarDirectoriComplet(String ruta, int marge, String destinacio) {
        try {
            File dir = new File(ruta);
            //if (!dir.exists()) throw new Exception("El directori no existeix");
            boolean isDir = dir.isDirectory();
            FileWriter fw = new FileWriter(new File(destinacio), true);
            fw.append(String.format("-".repeat(marge) + "%s %s [%s]\n", isDir ? "[D]" : "[F]", dir.getName(), new Date(dir.lastModified())));
            fw.flush();
            fw.close();
            if (isDir) {
                File[] subdir = dir.listFiles();
                if (subdir.length != 0) {
                    Arrays.sort(subdir);
                    for (File f : subdir) {
                        guardarDirectoriComplet(f.toString(), marge + 1, destinacio);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
