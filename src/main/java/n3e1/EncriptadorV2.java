package n3e1;

import org.apache.commons.crypto.stream.CryptoInputStream;
import org.apache.commons.crypto.stream.CryptoOutputStream;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Properties;

public class EncriptadorV2 {
    private String transform;
    private SecretKeySpec key;
    private IvParameterSpec iv;
    private Properties properties;

    public EncriptadorV2(String transform, String clau) {
        this.transform = transform;
        this.key = new SecretKeySpec(getUTF8Bytes(clau), "AES");
        this.iv = new IvParameterSpec(getUTF8Bytes(clau));
        this.properties = new Properties();
    }

    public void encriptar(String fitxerPla, String fitxerEncriptat) {
        try {
            String input = Files.readString(Path.of(fitxerPla));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            CryptoOutputStream cos = new CryptoOutputStream(transform, properties, outputStream, key, iv);
            cos.write(getUTF8Bytes(input));
            cos.flush();
            String content = Arrays.toString(outputStream.toByteArray());
            escriureFitxer(content, fitxerEncriptat);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void desencriptar(String fitxerEncriptat, String fitxerDesencriptat) {
        try {
            String inputEncriptat = Files.readString(Path.of(fitxerEncriptat));
            InputStream inputStream = new ByteArrayInputStream(inputEncriptat.getBytes());
            System.out.println(inputEncriptat.getBytes().length);

            CryptoInputStream cis = new CryptoInputStream(transform, properties, inputStream, key, iv);
            byte[] decryptedData = new byte[1024];
            int decryptedLen = 0;
            int i;

            /*
            while ((i = cis.read(decryptedData, decryptedLen, decryptedData.length - decryptedLen)) > -1) {
                decryptedLen += i;
            }
             */

            String content = new String(decryptedData, 0, decryptedLen, StandardCharsets.UTF_8);
            escriureFitxer(content, fitxerDesencriptat);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private byte[] getUTF8Bytes(final String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

    private void escriureFitxer(String content, String desti) {
        try {
            FileWriter fw = new FileWriter(desti, false);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
