import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int numeroIntroducir = Integer.parseInt(System.console().readLine("Introduzca un número: "));
            numeros.add(numeroIntroducir);
        }
        System.out.println(numeros);
        Collections.sort(numeros);
        System.out.println(numeros);

        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numeros.get(j) > numeros.get(j + 1)) {
                    // Intercambiar elementos
                    int aux = numeros.get(j);
                    numeros.set(j, numeros.get(j + 1));
                    numeros.set(j + 1, aux);
                }
            }
        }
        System.out.println(numeros);
    }
}
