import java.util.HashMap;

public class Ejercicio16 {
    public static void main(String[] args) {
        HashMap<String, String> capitales = new HashMap<>();
        capitales.put("España","Madrid");
        capitales.put("Francia","París");
        capitales.put("Portugal","Lisboa");

        do{
            String pais = System.console().readLine("Escribe el nombre de un país y te diré su capital: ");
            if(pais.equals("salir"))
                break;
            else if(capitales.containsKey(pais))
                System.out.println("La capital de " + pais + " es " + capitales.get(pais));
                else{
                    String capitalNueva = System.console().readLine("No conozco la respuesta ¿cuál es la capital de "+pais+"?: ");
                    capitales.put(pais, capitalNueva);
                }
        }while(true);
    }
}