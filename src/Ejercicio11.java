import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ejercicio11 {
    public static void main(String[] args) {
        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("casa", "House");
        diccionario.put("perro", "Dog");
        diccionario.put("gato", "Cat");
        diccionario.put("cama", "Bed");
        diccionario.put("noche", "Night");
        diccionario.put("mesa", "Table");
        diccionario.put("silla", "Chair");
        diccionario.put("cargador", "Charger");
        diccionario.put("ventana", "Window");
        diccionario.put("cristal", "glass");
        diccionario.put("botella", "bottle");
        diccionario.put("correr", "run");
        diccionario.put("leer", "read");

        ArrayList<String> keys = new ArrayList<>(diccionario.keySet());
        Collections.shuffle(keys);
        List<String> seleccionadas = keys.subList(0, 5);

        int aciertos = 0;
        int fallos = 0;

        for (String string : seleccionadas) {
            String respuesta = System.console().readLine("La palabra " + string + " en inglés es: ");
            if(respuesta.toLowerCase().equals(diccionario.get(string).toLowerCase())){
                aciertos++;
                System.out.println("¡Acierto!");
            } else{
                fallos++;
                System.out.println("¡Fallo!");
            }    
        }
        System.out.printf("Has obtenido %d aciertos y %d fallos", aciertos, fallos);
    }
}
