import java.util.HashMap;

public class Ejercicio6 {
        public static void main(String[] args) {
            HashMap<String, String> identificador = new HashMap<>();
        identificador.put("Curro", "1234Curro");
        
        boolean correcto = false;
        int intentos = 3;
        do{
            String nombre = System.console().readLine("Introduzca su nombre: ");
            String contraseña = System.console().readLine("Introduzca su contraseña: ");
            if(identificador.containsKey(nombre) && identificador.containsValue(contraseña))
                correcto = true;
            else{
                System.out.println("fallo");
                intentos--;
            }
        }while(!correcto && intentos!=0);
        if(correcto)
            System.out.println("Ha accedido al área restringida");
        else
            System.out.println("Lo siento, no tiene acceso al área restringida");
        }
}
