import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio23 {
    public static void main(String[] args) {
        int numCapturas = (int) (Math.random() * 16);

        HashMap<String, Integer> puntos = new HashMap<>();
        puntos.put("peon", 1);
        puntos.put("torre", 5);
        puntos.put("caballo", 2);
        puntos.put("dama", 9);
        puntos.put("alfil", 3);
        int sumaPuntos = 0;

        ArrayList<String> piezasDisponibles = new ArrayList<>();
        for (int i = 0; i < 8; i++) piezasDisponibles.add("peon");
        for (int i = 0; i < 2; i++) piezasDisponibles.add("torre");
        for (int i = 0; i < 2; i++) piezasDisponibles.add("alfil");
        for (int i = 0; i < 2; i++) piezasDisponibles.add("caballo");
        piezasDisponibles.add("dama");

        System.out.println("Fichas capturadas por el jugador:");
        for (int i = 0; i < numCapturas; i++) {
            int indice = (int) (Math.random() * piezasDisponibles.size());
            String pieza = piezasDisponibles.remove(indice);

            System.out.println(pieza + " (" + puntos.get(pieza) + " peones)");
            sumaPuntos += puntos.get(pieza);
        }

        System.out.println("Puntos totales: " + sumaPuntos + " peones.");
    }
}
