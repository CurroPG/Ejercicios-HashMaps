import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        int tamaño = (int)(Math.random()*(20-10+1)+10);
        int suma = 0;
        int minimo = Integer.MAX_VALUE;
        int maximo = 0;
        for (int i = 0; i < tamaño; i++) {
            int aleatorio = (int)(Math.random()*101);
            numeros.add(aleatorio);
            suma+=aleatorio;
            if(aleatorio < minimo)
                minimo = aleatorio;
            if(aleatorio > maximo)
                maximo = aleatorio;
        }
        int media = suma / tamaño;
        System.out.println("Los números son: ");
        for (Integer integer : numeros) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("El máximo es " + maximo);
        System.out.println("El mínimo es " + minimo);
        System.out.println("La media es " + media);
    }
}
