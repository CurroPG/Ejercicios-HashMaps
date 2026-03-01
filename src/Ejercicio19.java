import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio19 {
    public static void main(String[] args) {
        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("caliente", "hot");
        diccionario.put("ardiente", "hot");
        diccionario.put("abrasador", "hot");
        diccionario.put("rojo", "red");
        diccionario.put("verde", "green");
        diccionario.put("agujetas", "stiff");
        diccionario.put("hierro", "iron");
        diccionario.put("grande", "big");
        ArrayList<String> keys = new ArrayList<>(diccionario.keySet());

        do {
            String palabra = System.console().readLine("Introduzca una palabra y le daré los sinónimos: ");
            String significado = diccionario.get(palabra);
            String sinonimos = "";
            String opcion = "";
            String nuevoSinonimo = "";
            if (palabra.equals("salir"))
                break;
            if (!diccionario.containsKey(palabra)) {
                opcion = System.console().readLine("No conozco esa palabra ¿quiere añadirla al diccionario? (s/n): ");
                if (opcion.equals("s")) {
                    significado = System.console().readLine("Introduzca la traducción de " + palabra + " en inglés: ");
                    keys.add(palabra);
                    diccionario.put(palabra, significado);
                }
            } else {
                for (String k : keys) {
                    if (diccionario.get(k).equals(significado) && !k.equals(palabra))
                        sinonimos += k + ", ";
                }
                if (sinonimos.isEmpty()) {
                    opcion = System.console()
                            .readLine("No conozco sinónimos de esa palabra ¿quiere añadir alguno? (s/n): ");
                    if (opcion.equals("s")) {
                        nuevoSinonimo += System.console().readLine("Introduzca un sinónimo de " + palabra + ": ");
                        keys.add(nuevoSinonimo);
                        diccionario.put(nuevoSinonimo, diccionario.get(palabra));
                    }
                } else
                    System.out.println("Sinónimos de " + palabra + ": " + sinonimos);
            }
        } while (true);
    }
}
