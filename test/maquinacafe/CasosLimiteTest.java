package maquinacafe;

import org.junit.Test;
import static org.junit.Assert.*;

/** Casos limite adicionales: no sustituye a las 19 pruebas originales. */
public class CasosLimiteTest {

    private MaquinaDeCafe crearMaquina(Vaso vasos, Cafetera cafe, Azucarero azucar) {
        MaquinaDeCafe maquina = new MaquinaDeCafe();
        maquina.setVasosPequeno(vasos);
        maquina.setCafetera(cafe);
        maquina.setAzucarero(azucar);
        return maquina;
    }

    @Test public void noPermitirCeroVasos() {
        Vaso vaso = new Vaso(5, 3);
        Cafetera cafe = new Cafetera(30);
        Azucarero azucar = new Azucarero(10);
        assertEquals("Cantidad de vasos invalida", crearMaquina(vaso, cafe, azucar).getVasoDeCafe(vaso, 0, 2));
        assertEquals(5, vaso.getCantidadVasos());
        assertEquals(30, cafe.getCantidadCafe());
    }

    @Test public void noPermitirVasosNegativos() {
        Vaso vaso = new Vaso(5, 3);
        assertEquals("Cantidad de vasos invalida", crearMaquina(vaso, new Cafetera(30), new Azucarero(10))
                .getVasoDeCafe(vaso, -1, 2));
    }

    @Test public void noPermitirAzucarNegativaNiAumentarInventario() {
        Vaso vaso = new Vaso(5, 3);
        Cafetera cafe = new Cafetera(30);
        Azucarero azucar = new Azucarero(10);
        assertEquals("Cantidad de azucar invalida", crearMaquina(vaso, cafe, azucar)
                .getVasoDeCafe(vaso, 1, -3));
        assertEquals(10, azucar.getCantidadAzucar());
        assertEquals(30, cafe.getCantidadCafe());
        assertEquals(5, vaso.getCantidadVasos());
    }

    @Test public void manejarVasoNulo() {
        assertEquals("Vaso invalido", new MaquinaDeCafe().getVasoDeCafe(null, 1, 1));
    }

    @Test public void servirCafeSinAzucar() {
        Vaso vaso = new Vaso(5, 3);
        Cafetera cafe = new Cafetera(30);
        Azucarero azucar = new Azucarero(0);
        assertEquals("Felicitaciones", crearMaquina(vaso, cafe, azucar).getVasoDeCafe(vaso, 1, 0));
        assertEquals(27, cafe.getCantidadCafe());
        assertEquals(4, vaso.getCantidadVasos());
        assertEquals(0, azucar.getCantidadAzucar());
    }

    @Test public void conservarInventarioAnteFaltaDeAzucar() {
        Vaso vaso = new Vaso(5, 3);
        Cafetera cafe = new Cafetera(30);
        Azucarero azucar = new Azucarero(1);
        assertEquals("No hay Azucar", crearMaquina(vaso, cafe, azucar).getVasoDeCafe(vaso, 1, 2));
        assertEquals(5, vaso.getCantidadVasos());
        assertEquals(30, cafe.getCantidadCafe());
        assertEquals(1, azucar.getCantidadAzucar());
    }

    @Test public void noDesbordarMultiplicacionDeCafe() {
        Vaso vaso = new Vaso(2, Integer.MAX_VALUE);
        Cafetera cafe = new Cafetera(50);
        Azucarero azucar = new Azucarero(10);
        assertEquals("No hay Cafe", crearMaquina(vaso, cafe, azucar).getVasoDeCafe(vaso, 2, 2));
        assertEquals(50, cafe.getCantidadCafe());
    }

    @Test public void prepararCafeDeTresCincoYSieteOnzas() {
        MaquinaDeCafe maquina = new MaquinaDeCafe();
        Vaso pequeno = new Vaso(1, 3);
        Vaso mediano = new Vaso(1, 5);
        Vaso grande = new Vaso(1, 7);
        Cafetera cafe = new Cafetera(15);
        maquina.setVasosPequeno(pequeno);
        maquina.setVasosMediano(mediano);
        maquina.setVasosGrande(grande);
        maquina.setCafetera(cafe);
        maquina.setAzucarero(new Azucarero(3));
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(maquina.getTipoDeVaso("pequeno"), 1, 1));
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(maquina.getTipoDeVaso("mediano"), 1, 1));
        assertEquals("Felicitaciones", maquina.getVasoDeCafe(maquina.getTipoDeVaso("grande"), 1, 1));
        assertEquals(0, cafe.getCantidadCafe());
    }

    @Test public void impedirConstructorConValoresNegativos() {
        assertThrows(IllegalArgumentException.class, () -> new Vaso(-1, 3));
        assertThrows(IllegalArgumentException.class, () -> new Vaso(1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Cafetera(-1));
        assertThrows(IllegalArgumentException.class, () -> new Azucarero(-1));
    }

    @Test public void noPermitirDescuentosDirectosInvalidos() {
        Vaso vaso = new Vaso(2, 3);
        Cafetera cafe = new Cafetera(3);
        Azucarero azucar = new Azucarero(3);
        assertThrows(IllegalArgumentException.class, () -> vaso.giveVasos(-1));
        assertThrows(IllegalArgumentException.class, () -> vaso.giveVasos(3));
        assertThrows(IllegalArgumentException.class, () -> cafe.giveCafe(-1));
        assertThrows(IllegalArgumentException.class, () -> cafe.giveCafe(4));
        assertThrows(IllegalArgumentException.class, () -> azucar.giveAzucar(-1));
        assertThrows(IllegalArgumentException.class, () -> azucar.giveAzucar(4));
        assertEquals(2, vaso.getCantidadVasos());
        assertEquals(3, cafe.getCantidadCafe());
        assertEquals(3, azucar.getCantidadAzucar());
    }

    @Test public void ceroAzucarSiPeroCeroCafeNo() {
        assertTrue(new Azucarero(0).hasAzucar(0));
        assertFalse(new Cafetera(10).hasCafe(0));
        assertFalse(new Vaso(10, 3).hasVasos(0));
    }
}
