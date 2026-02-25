import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Curro");
        nombres.add("Marco");
        nombres.add("Juan");
        nombres.add("Juanma");
        nombres.add("Sergio");
        nombres.add("Santi");
        System.out.println(nombres);
        for (String string : nombres) {
            System.out.println(string);
        }
    }
}
