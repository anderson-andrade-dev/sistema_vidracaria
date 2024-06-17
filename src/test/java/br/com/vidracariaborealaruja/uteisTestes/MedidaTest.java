package br.com.vidracariaborealaruja.uteisTestes;

import br.com.vidracariaborealaruja.exceptions.MedidaException;
import br.com.vidracariaborealaruja.uteis.Medida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedidaTest {
    @Test
    public void aredondaMedidaMultiploDez() {
        var novaMedida = Medida.create().aredondamento(970, 100);
        assertEquals(1000, novaMedida);
    }

    @Test
    public void devolveMetroQuadradoPassandoMedida() {
        assertEquals(100, Medida.create().metroQuadrado(1000, 1000));
    }

    @Test
    public void medidaExceptionPassandoValorNegativoOuZero() {
        assertThrows(MedidaException.class, () -> Medida.create().metroQuadrado(-1, 0));
        assertThrows(MedidaException.class, () -> Medida.create().metroQuadrado(0, -1));
        assertThrows(MedidaException.class, () -> Medida.create().metroQuadrado(0, 0));
        assertThrows(MedidaException.class, () -> Medida.create().metroQuadrado(1, 0));
        assertThrows(MedidaException.class, () -> Medida.create().metroQuadrado(0, 1));
    }
}
