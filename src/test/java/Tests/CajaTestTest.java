
package Tests;

import Models.Caja;
import Models.Camisa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author duckycoyote
 */
public class CajaTestTest {

    private static final double DELTA = 1E-15;

    @Test
    public void testTestCalcularDescuento() {
        System.out.println("testCalcularDescuento");
        Caja caja = new Caja();

        assertEquals(0, caja.calcularDescuento(1), DELTA);
        assertEquals(0, caja.calcularDescuento(2), DELTA);
        assertEquals(0.05, caja.calcularDescuento(3), DELTA);
        assertEquals(0.05, caja.calcularDescuento(4), DELTA);
        assertEquals(0.05, caja.calcularDescuento(5), DELTA);
        assertEquals(0.08, caja.calcularDescuento(6), DELTA);
        assertEquals(0.08, caja.calcularDescuento(7), DELTA);
    }

    @Test
    public void testTestCalcularPrecioTotal() {
        System.out.println("testCalcularPrecioTotal");
        //Varias camisas del mismo tipo
        Camisa camisa = new Camisa(1, "Playera Manga Larga", 1250, 2);
        Camisa camisa2 = new Camisa(2, "Playera azul", 200, 3);
        Camisa camisa3 = new Camisa(3, "Playera Morada", 400, 6);

        //Varias camisas del mismo tipo con varias camisas de diferente dipo
        Camisa camisa10 = new Camisa(4, "Playera Homero", 700, 1);
        Camisa camisa11 = new Camisa(5, "Playera Estampada", 800, 3);
        Camisa camisa12 = new Camisa(6, "Playera Manga Corta", 300, 2);

        //Arreglo de varias camisas del mismo tipo con varias camisas de diferente dipo
        Camisa[] camisas = {camisa10, camisa11, camisa12};

        Camisa[] camisasCaja1 = {camisa};
        Caja caja = new Caja(camisasCaja1);

        Camisa[] camisasCaja2 = {camisa2};
        Caja caja2 = new Caja(camisasCaja2);

        Camisa[] camisaCaja3 = {camisa3};
        Caja caja3 = new Caja(camisaCaja3);

        Caja caja4 = new Caja(camisas);

        //Test camisa individuales con mas de un objeto de la misma camisa
        assertEquals(2500, caja.calcularTotal(), DELTA);
        assertEquals(570, caja2.calcularTotal(), DELTA);
        assertEquals(2208, caja3.calcularTotal(), DELTA);

        //Test con un arreglo de mas de un tipo de camisa con camisas diferentes
        assertEquals(3404, caja4.calcularTotal(), DELTA);
    }

}
