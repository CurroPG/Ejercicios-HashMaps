package Ejercicio8;

import java.util.ArrayList;

public class Ejercicio8 {
    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>();
        Carta carta = new Carta();
        cartas.add(carta);
        
        for (int i = 1; i < 10; i++) {
            Carta candidata = new Carta();
            boolean contenida = true;
            do{
                if(!cartas.contains(candidata))
                    contenida = false;
            }while(contenida);
            cartas.add(candidata);
        }

        for (Carta carta1 : cartas) {
            System.out.println(carta1);
        }
    }
}
