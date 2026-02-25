package Ejercicio8;

public class Carta {
    private int numero;
    private String tipo;

    public Carta(){
        int numero = (int)(Math.random()*12 + 1);
        this.numero = numero;
        int tipo = (int)(Math.random()* 4 + 1);
        switch (tipo) {
            case 1:
                this.tipo = "oros";
                break;
            case 2:
                this.tipo = "copas";
                break;
            case 3:
                this.tipo = "espadas";
                break;
            case 4:
                this.tipo = "bastos";
                break;
        }
    }

    public int getNumero(){
        return this.numero;
    }

    public String getTipo(){
        return this.tipo;
    }

    @Override
    public String toString() {
        return String.format("%s de %s", this.numero, this.tipo);
    }

    public int ordenPalo() {
        switch (this.tipo) {
            case "bastos":  return 1;
            case "copas":   return 2;
            case "espadas": return 3;
            case "oros":    return 4;
            default:        return -1;
        }
    }
}
