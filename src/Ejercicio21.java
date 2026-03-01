import java.util.HashMap;

public class Ejercicio21 {
    public static void main(String[] args) {
        HashMap<String, String> tipoHabitat = new HashMap<>();
        HashMap<String, String> tipoAlimentacion = new HashMap<>();
        tipoHabitat.put("rana", "En los trópicos y cerca de las zonas húmedas y acuáticas");
        tipoHabitat.put("salamandra", "Ecosistemas húmedos");
        tipoHabitat.put("sapo", "En cualquier sitio salvo el desierto y la Antártida");
        tipoHabitat.put("tritón", "América y África");
        tipoAlimentacion.put("rana", "Larvas e insectos");
        tipoAlimentacion.put("salamandra", "Pequeños crustáceos e insectos");
        tipoAlimentacion.put("sapo", "Insectos, lombrices y pequeños roedores");
        tipoAlimentacion.put("tritón", "Insectos");

        do {
            String anfibio = System.console().readLine("Introduzca el tipo de anfibio: ");
            if(anfibio.equals("salir"))
                break;
            if (tipoHabitat.containsKey(anfibio)) {
                System.out.println("Hábitat: " + tipoHabitat.get(anfibio));
                System.out.println("Alimentación: " + tipoAlimentacion.get(anfibio));
            } else
                System.out.println("Ese tipo de anfibio no existe.");
        } while (true);
    }
}
