package Ejercicio7;

public class Moneda {
    private String lado;
    private String precio;

    public Moneda() {
        int lado = (int) (Math.random()*2 + 1);
        switch (lado) {
            case 1:
                this.lado = "cara";
                break;
            case 2:
                this.lado = "cruz";
                break;
        }

        int precio = (int) (Math.random()*8 + 1);
        switch (precio) {
            case 1:
                this.precio = "1 céntimo";
                break;
            case 2:
                this.precio = "2 céntimos";
                break;
            case 3:
                this.precio = "5 céntimos";
                break;
            case 4:
                this.precio = "10 céntimos";
                break;
            case 5:
                this.precio = "20 céntimos";
                break;
            case 6:
                this.precio = "50 céntimos";
                break;
            case 7:
                this.precio = "1 euro";
                break;
            case 8:
                this.precio = "2 euros";
                break;
        }
    }

    public String getLado() {
        return lado;
    }

    public String getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.precio, this.lado);
    }
}
