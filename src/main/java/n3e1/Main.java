package n3e1;

import org.apache.commons.crypto.stream.CryptoInputStream;
import org.apache.commons.crypto.stream.CryptoOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class Main {
    public static void main(final String[] args) {
        String flag = args[0];
        String origen = args[1];
        String desti = args[2];
        String pass = args[3];
        EncriptadorV2 enc = new EncriptadorV2("AES/CBC/PKCS5Padding", args[3]);

        if (flag.equals("-e")) {
            System.out.println("Encriptant");
            enc.encriptar(args[1], args[2]);

        } else if (flag.equals("-d")) {
            System.out.println("Desencriptant");
            enc.desencriptar(args[1], args[2]);

        } else {
            System.out.println("Input d'operació no reconegut");
        }

    }

}
