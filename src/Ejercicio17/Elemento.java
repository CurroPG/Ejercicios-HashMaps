package Ejercicio17;

public class Elemento {
    private String nombre;
    private double precio;
    private int cantidad;

    public Elemento(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("%-20s PVP: %6.2f  Unidades: %d  Subtotal: %.2f",
                nombre, precio, cantidad, precio * cantidad);
    }
}
