package maquinacafe;

/** Inventario de vasos de una capacidad de cafe determinada. */
public class Vaso {
    private int cantidadVasos;
    private final int contenido;

    public Vaso(int cantidadVasos, int contenido) {
        if (cantidadVasos < 0) {
            throw new IllegalArgumentException("El inventario de vasos no puede ser negativo");
        }
        if (contenido <= 0) {
            throw new IllegalArgumentException("El contenido del vaso debe ser positivo");
        }
        this.cantidadVasos = cantidadVasos;
        this.contenido = contenido;
    }

    public boolean hasVasos(int cantidad) {
        return cantidad > 0 && cantidadVasos >= cantidad;
    }

    public void giveVasos(int cantidad) {
        if (!hasVasos(cantidad)) {
            throw new IllegalArgumentException("Cantidad de vasos invalida o insuficiente");
        }
        cantidadVasos -= cantidad;
    }

    public int getCantidadVasos() {
        return cantidadVasos;
    }

    public int getContenido() {
        return contenido;
    }
}
