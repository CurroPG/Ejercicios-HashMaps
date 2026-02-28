package Ejercicio17;

import java.util.ArrayList;

public class Carrito {
    ArrayList<Elemento> miCarrito = new ArrayList<>();
    private int numeroDeElementos;
    private double importeTotal;

    public void agrega(Elemento elemento){
        boolean esta = false;
        for (Elemento e : miCarrito) {
            if(e.getNombre().equals(elemento.getNombre())){
                e.setCantidad(e.getCantidad() + elemento.getCantidad());
                this.importeTotal += elemento.getPrecio() * elemento.getCantidad();
                esta = true;
                break;
            }
        }
        if(!esta){
            this.miCarrito.add(elemento);
            this.importeTotal += elemento.getPrecio() * elemento.getCantidad();
        }
        this.numeroDeElementos = miCarrito.size();
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public int getNumeroDeElementos() {
        return numeroDeElementos;
    }

    @Override
    public String toString() {
        String resultado = "Contenido del carrito\n=====================\n";
    for (Elemento e : miCarrito) {
        resultado += e.toString() + "\n";
    }
    return resultado;
    }
}
