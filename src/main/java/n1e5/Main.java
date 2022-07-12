package n1e5;

public class Main {
    public static void main(String[] args) {
        String flag = args[0];
        String fitxer = args[1];
        Cotxe cotxe;
        if (flag.equals("-s")) {
            cotxe = new Cotxe("Ford", "GT40", 6000, 900);
            GestorDirectorisV5.serialitzar(cotxe, fitxer);
        } else if (flag.equals("-d")) {
            cotxe = (Cotxe) GestorDirectorisV5.desserialitzar(fitxer);
        } else {
            System.out.println("Argument no reconegut");
        }
    }
}
