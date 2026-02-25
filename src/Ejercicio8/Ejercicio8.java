package Ejercicio8;

import java.util.ArrayList;

public class Ejercicio8 {
    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>();
        Carta carta = new Carta();
        cartas.add(carta);
        
        for (int i = 1; i < 10; i++) {
            boolean añadida = false;
            do {
                Carta candidata = new Carta();
                boolean repetida = false;

                for (Carta actual : cartas) {
                    if(actual.getNumero() == candidata.getNumero() &&
                        actual.getTipo().equals(candidata.getTipo())){
                            repetida = true;
                        }
                }

                if(!repetida){
                    cartas.add(candidata);
                    añadida = true;
                }
            } while (!añadida);
        }

        for (Carta carta1 : cartas) {
            System.out.println(carta1);
        }

        for (int i = 0; i < cartas.size() - 1; i++) {
            for (int j = 0; j < cartas.size() - 1 - i; j++) {
                Carta c1 = cartas.get(j);
                Carta c2 = cartas.get(j + 1);

                boolean intercambiar = false;
                if (c1.ordenPalo() > c2.ordenPalo()) {
                    intercambiar = true;
                } else if (c1.ordenPalo() == c2.ordenPalo() &&
                        c1.getNumero() > c2.getNumero()) {
                    intercambiar = true;
                }

                if (intercambiar) {
                    cartas.set(j, c2);
                    cartas.set(j + 1, c1);
                }
            }
        }

        System.out.println("===========CARTAS ORDENADAS===========");
        for (Carta carta1 : cartas) {
            System.out.println(carta1);
        }
    }
}
