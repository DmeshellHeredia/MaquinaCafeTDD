package maquinacafe;

/** Inventario de cafe, en las unidades de contenido de los vasos. */
public class Cafetera {
    private int cantidadCafe;

    public Cafetera(int cantidadCafe) {
        if (cantidadCafe < 0) {
            throw new IllegalArgumentException("El inventario de cafe no puede ser negativo");
        }
        this.cantidadCafe = cantidadCafe;
    }

    public boolean hasCafe(int cantidad) {
        return cantidad > 0 && cantidadCafe >= cantidad;
    }

    public void giveCafe(int cantidad) {
        if (!hasCafe(cantidad)) {
            throw new IllegalArgumentException("Cantidad de cafe invalida o insuficiente");
        }
        cantidadCafe -= cantidad;
    }

    public int getCantidadCafe() {
        return cantidadCafe;
    }
}
