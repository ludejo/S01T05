package n1e5;

import java.io.Serializable;

public class Cotxe implements Serializable {
    private String marca;
    private String model;
    private int potencia;
    private int pesKg;

    public Cotxe(String marca, String model, int potencia, int pesKg) {
        this.marca = marca;
        this.model = model;
        this.potencia = potencia;
        this.pesKg = pesKg;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public int getPotencia() {
        return potencia;
    }

    public int getPesKg() {
        return pesKg;
    }

    @Override
    public String toString() {
        return "Cotxe{" +
                "marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", potencia=" + potencia +
                ", pesKg=" + pesKg +
                '}';
    }
}
