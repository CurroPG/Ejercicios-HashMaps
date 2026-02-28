package Ejercicio12;

import java.util.ArrayList;
import java.util.HashMap;

import Ejercicio8.Carta;

public class Ejercicio12 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> valorCartas = new HashMap<>();
        valorCartas.put(1, 11);
        valorCartas.put(3, 10);
        valorCartas.put(10, 2);
        valorCartas.put(11, 3);
        valorCartas.put(12, 4);

        ArrayList<Carta> cartas = new ArrayList<>();
        Carta carta = new Carta();
        cartas.add(carta);
        
        for (int i = 1; i < 5; i++) {
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

        int puntos = 0;

        for (Carta carta1 : cartas) {
            System.out.println(carta1);
            if(valorCartas.containsKey(carta1.getNumero()))
                puntos += valorCartas.get(carta1.getNumero());
        }

        System.out.println("Tienes "+puntos+" puntos");
    }
}
