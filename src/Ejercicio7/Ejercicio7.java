package Ejercicio7;

import java.util.ArrayList;

public class Ejercicio7 {
    public static void main(String[] args) {
        ArrayList<String> lados = new ArrayList<>();
        ArrayList<String> precios = new ArrayList<>();
        ArrayList<Moneda> monedas = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Moneda moneda = new Moneda();
            monedas.add(moneda);
            lados.add(moneda.getLado());
            precios.add(moneda.getPrecio());
        }

        
    }
}
