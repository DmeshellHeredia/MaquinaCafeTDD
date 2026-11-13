package maquinacafe;

/** Inventario de azucar; cero cucharadas equivale a cafe sin azucar. */
public class Azucarero {
    private int cantidadAzucar;

    public Azucarero(int cantidadAzucar) {
        if (cantidadAzucar < 0) {
            throw new IllegalArgumentException("El inventario de azucar no puede ser negativo");
        }
        this.cantidadAzucar = cantidadAzucar;
    }

    public boolean hasAzucar(int cantidad) {
        return cantidad >= 0 && cantidadAzucar >= cantidad;
    }

    public void giveAzucar(int cantidad) {
        if (!hasAzucar(cantidad)) {
            throw new IllegalArgumentException("Cantidad de azucar invalida o insuficiente");
        }
        cantidadAzucar -= cantidad;
    }

    public int getCantidadAzucar() {
        return cantidadAzucar;
    }
}
