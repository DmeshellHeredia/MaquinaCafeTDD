
package maquinacafe;

import static org.junit.Assert.*;
import org.junit.Test;

public class MaquinaDeCafeTest {

    @Test
    public void deberiaDevolverUnVasoPequeno() {

        Vaso vasoPequeno = new Vaso(5, 10);

        MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

        maquinaDeCafe.setVasosPequeno(vasoPequeno);

        Vaso resultado = maquinaDeCafe.getTipoDeVaso("pequeno");

        assertSame(vasoPequeno, resultado);
    }
    
    
@Test
public void deberiaDevolverUnVasoMediano() {

    Vaso vasoMediano = new Vaso(5, 20);

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

    maquinaDeCafe.setVasosMediano(vasoMediano);

    Vaso resultado = maquinaDeCafe.getTipoDeVaso("mediano");

    assertSame(vasoMediano, resultado);
}


@Test
public void deberiaDevolverUnVasoGrande() {

    Vaso vasoGrande = new Vaso(5, 30);

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

    maquinaDeCafe.setVasosGrande(vasoGrande);

    Vaso resultado = maquinaDeCafe.getTipoDeVaso("grande");

    assertSame(vasoGrande, resultado);
}

@Test
public void deberiaDevolverNoHayVasos() {

    Vaso vasosPequenos = new Vaso(5, 10);

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();
    maquinaDeCafe.setVasosPequeno(vasosPequenos);

    Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

    String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 10, 2);

    assertEquals("No hay Vasos", resultado);
}

@Test
public void deberiaDevolverNoHayCafe() {

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

    Cafetera cafetera = new Cafetera(5);
    maquinaDeCafe.setCafetera(cafetera);

    Vaso vasosPequenos = new Vaso(5, 10);
    maquinaDeCafe.setVasosPequeno(vasosPequenos);

    Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

    String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 2);

    assertEquals("No hay Cafe", resultado);
}

@Test
public void deberiaDevolverNoHayAzucar() {

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

    Cafetera cafetera = new Cafetera(50);
    maquinaDeCafe.setCafetera(cafetera);

    Vaso vasosPequenos = new Vaso(5, 10);
    maquinaDeCafe.setVasosPequeno(vasosPequenos);

    Azucarero azucarero = new Azucarero(2);
    maquinaDeCafe.setAzucarero(azucarero);

    Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

    String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

    assertEquals("No hay Azucar", resultado);
}

@Test
public void deberiaRestarCafe() {

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

    Cafetera cafetera = new Cafetera(50);
    maquinaDeCafe.setCafetera(cafetera);

    Vaso vasosPequenos = new Vaso(5, 10);
    maquinaDeCafe.setVasosPequeno(vasosPequenos);

    Azucarero azucarero = new Azucarero(20);
    maquinaDeCafe.setAzucarero(azucarero);

    Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

    maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

    int resultado = cafetera.getCantidadCafe();

    assertEquals(40, resultado);
}

@Test
public void deberiaRestarVasos() {

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

    Cafetera cafetera = new Cafetera(50);
    maquinaDeCafe.setCafetera(cafetera);

    Vaso vasosPequenos = new Vaso(5, 10);
    maquinaDeCafe.setVasosPequeno(vasosPequenos);

    Azucarero azucarero = new Azucarero(20);
    maquinaDeCafe.setAzucarero(azucarero);

    Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

    maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

    int resultado = vasosPequenos.getCantidadVasos();

    assertEquals(4, resultado);
}

@Test
public void deberiaRestarAzucar() {

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

    Cafetera cafetera = new Cafetera(50);
    maquinaDeCafe.setCafetera(cafetera);

    Vaso vasosPequenos = new Vaso(5, 10);
    maquinaDeCafe.setVasosPequeno(vasosPequenos);

    Azucarero azucarero = new Azucarero(20);
    maquinaDeCafe.setAzucarero(azucarero);

    Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

    maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

    int resultado = azucarero.getCantidadAzucar();

    assertEquals(17, resultado);
}

@Test
public void deberiaDevolverFelicitaciones() {

    MaquinaDeCafe maquinaDeCafe = new MaquinaDeCafe();

    Cafetera cafetera = new Cafetera(50);
    maquinaDeCafe.setCafetera(cafetera);

    Vaso vasosPequenos = new Vaso(5, 10);
    maquinaDeCafe.setVasosPequeno(vasosPequenos);

    Azucarero azucarero = new Azucarero(20);
    maquinaDeCafe.setAzucarero(azucarero);

    Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");

    String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);

    assertEquals("Felicitaciones", resultado);
}

}
