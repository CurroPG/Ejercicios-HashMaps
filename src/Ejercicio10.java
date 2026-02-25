import java.util.HashMap;

public class Ejercicio10 {
    public static void main(String[] args) {
        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("casa", "House");
        diccionario.put("perro", "Dog");
        diccionario.put("gato", "Cat");
        diccionario.put("cama", "Bed");
        diccionario.put("noche", "Night");
        diccionario.put("mesa", "Table");
        diccionario.put("silla", "Chair");

        int opcion = 0;
        while(opcion != 2){
            System.out.println("1. Traducir palabra");
            System.out.println("2. Salir");
            opcion = Integer.parseInt(System.console().readLine("Escoja una opción: "));
            if(opcion != 2){
                String palabra = System.console().readLine("Introduzca la palabra a traducir: ");
                if(diccionario.containsKey(palabra.toLowerCase()))
                    System.out.println(diccionario.get(palabra.toLowerCase()));
            }
        }
    }
}
