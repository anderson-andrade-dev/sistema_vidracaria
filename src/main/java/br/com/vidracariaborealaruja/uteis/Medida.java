package br.com.vidracariaborealaruja.uteis;

import br.com.vidracariaborealaruja.exceptions.MedidaException;

public class Medida {
    private Medida() {
    }

    public static Medida create() {
        return new Medida();
    }

    public int aredondamento(int medida, int mutiplo) {
        int restoDivisao = (medida % mutiplo);
        if (restoDivisao == 0) return medida;
        return (mutiplo - restoDivisao) + medida;
    }

    public int metroQuadrado(int largura, int altura) {
        if (largura > 0 && altura > 0) {
            return (largura * altura) / 10000;
        }
        throw new MedidaException("Verifique a Media ela não pode ser menor que 0!");
    }
}
