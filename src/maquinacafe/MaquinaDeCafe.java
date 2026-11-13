package maquinacafe;

/** Coordina vasos, cafe y azucar antes de modificar cualquier inventario. */
public class MaquinaDeCafe {
    private Vaso vasosPequeno;
    private Vaso vasosMediano;
    private Vaso vasosGrande;
    private Cafetera cafetera;
    private Azucarero azucarero;

    public MaquinaDeCafe() {
    }

    public void setVasosPequeno(Vaso vasosPequeno) {
        this.vasosPequeno = vasosPequeno;
    }

    public void setVasosMediano(Vaso vasosMediano) {
        this.vasosMediano = vasosMediano;
    }

    public void setVasosGrande(Vaso vasosGrande) {
        this.vasosGrande = vasosGrande;
    }

    public void setCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    public void setAzucarero(Azucarero azucarero) {
        this.azucarero = azucarero;
    }

    public Vaso getTipoDeVaso(String tipoDeVaso) {
        if (tipoDeVaso == null) {
            return null;
        }
        return switch (tipoDeVaso) {
            case "pequeno" -> vasosPequeno;
            case "mediano" -> vasosMediano;
            case "grande" -> vasosGrande;
            default -> null;
        };
    }

    /**
     * La cantidadAzucar corresponde al total de cucharadas solicitado, no por vaso.
     * Ante una solicitud invalida o inventario insuficiente, no descuenta recursos.
     */
    public String getVasoDeCafe(Vaso vaso, int cantidadVasos, int cantidadAzucar) {
        if (vaso == null) {
            return "Vaso invalido";
        }
        if (cantidadVasos <= 0) {
            return "Cantidad de vasos invalida";
        }
        if (cantidadAzucar < 0) {
            return "Cantidad de azucar invalida";
        }
        if (!vaso.hasVasos(cantidadVasos)) {
            return "No hay Vasos";
        }

        // Usar long evita el desbordamiento de contenido * cantidadVasos.
        long cafeNecesario = (long) vaso.getContenido() * cantidadVasos;
        if (cafetera == null || cafeNecesario > Integer.MAX_VALUE
                || !cafetera.hasCafe((int) cafeNecesario)) {
            return "No hay Cafe";
        }
        if (azucarero == null || !azucarero.hasAzucar(cantidadAzucar)) {
            return "No hay Azucar";
        }

        // Los tres consumos ocurren solo despues de validar los inventarios.
        cafetera.giveCafe((int) cafeNecesario);
        vaso.giveVasos(cantidadVasos);
        azucarero.giveAzucar(cantidadAzucar);
        return "Felicitaciones";
    }
}
