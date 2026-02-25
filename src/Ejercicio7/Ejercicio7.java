package Ejercicio7;

import java.util.ArrayList;

public class Ejercicio7 {
    public static void main(String[] args) {
        ArrayList<Moneda> monedas = new ArrayList<>();
        Moneda moneda = new Moneda();
        monedas.add(moneda);

        for (int i = 1; i < 6; i++) {
            Moneda actual = monedas.get(i - 1);
            boolean añadida = false;
            do {
                Moneda candidata = new Moneda();
                if (actual.getPrecio().equals(candidata.getPrecio()) ||
                        actual.getLado().equals(candidata.getLado())) {
                    monedas.add(candidata);
                    añadida = true;
                }
            } while (!añadida);
        }

        for (Moneda moneda1 : monedas) {
            System.out.println(moneda1);
        }
    }
}
