import java.util.ArrayList;

public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String nombresIntroducir = System.console().readLine("Añade un nombre: ");
            nombres.add(nombresIntroducir);
        }
        System.out.println(nombres);

        int n = nombres.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nombres.get(j).compareTo(nombres.get(j + 1)) > 0) {
                    // Intercambiar elementos
                    String aux = nombres.get(j);
                    nombres.set(j, nombres.get(j + 1));
                    nombres.set(j + 1, aux);
                }
            }
        }
        System.out.println(nombres);       
        
    }
}
