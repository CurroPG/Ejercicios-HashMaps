import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio14 {
    public static void main(String[] args) {
        ArrayList<String> producto = new ArrayList<>();
        ArrayList<Double> precio = new ArrayList<>();
        ArrayList<Integer> cantidades = new ArrayList<>();
        ArrayList<Double> subtotal = new ArrayList<>();
        HashMap<String, Double> productos = new HashMap<>();
        productos.put("avena", 2.21);
        productos.put("garbanzos", 2.39);
        productos.put("tomate", 1.59);
        productos.put("jengibre", 3.13);
        productos.put("quinoa", 4.5);
        productos.put("guisantes", 1.6);

        String eleccion = "";
        double total = 0;
        do{
            eleccion = System.console().readLine("Producto: ");
            if(eleccion.equals("fin"))
                break;
            int cantidad = Integer.parseInt(System.console().readLine("Cantidad: "));
            producto.add(eleccion);
            precio.add(productos.get(eleccion));
            cantidades.add(cantidad);
            subtotal.add(productos.get(eleccion) * cantidad);
            total += productos.get(eleccion) * cantidad;
        }while(true);

        String descuento = System.console().readLine("Introduzca código de descuento (INTRO si no tiene ninguno): ");
        double valorDescuento = total * 0.1;

        for (int i = 0; i < producto.size(); i++) {
            System.out.printf("%s %10.2f %s %.2f\n", producto.get(i), precio.get(i), cantidades.get(i), subtotal.get(i));
            if(descuento.equals("ECODTO") && i == (producto.size()-1))
                System.out.printf("Descuento: %.2f\n", valorDescuento);
        }

        System.out.printf("TOTAL: %.2f", (total-valorDescuento));
    }
}
