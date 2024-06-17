package br.com.vidracariaborealaruja.beans;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JanelaTest {

    @Test
    void calculaPrecoVendaJanela() {
        List<Vidro> vidros = criarVidros();
        List<Perfil> perfils = criarPerfis();
        List<Ferragem> ferragens = criarFerragens();
        Janela janela = new Janela(4, 1000, 2000, perfils, ferragens, vidros);
        assertEquals(BigDecimal.valueOf(780.0).setScale(2), janela.getPreco());
    }

    @Test
    void getPrecoCusto() {
    }

    private List<Vidro> criarVidros() {

        // Valor dos vidros nesta configuração é 340,00

        List<Vidro> vidros = new ArrayList<>();
        vidros.add(Vidro.create(1000, 500, BigDecimal.valueOf(170.0), "Incolor", 8));
        vidros.add(Vidro.create(1000, 500, BigDecimal.valueOf(170.0), "Incolor", 8));
        vidros.add(Vidro.create(1000, 500, BigDecimal.valueOf(170.0), "Incolor", 8));
        vidros.add(Vidro.create(1000, 500, BigDecimal.valueOf(170.0), "Incolor", 8));
        return vidros;
    }

    private List<Perfil> criarPerfis() {
        // Valor dos perfis nesta configuração é de 240,00
        List<Perfil> perfis = new ArrayList<>();
        perfis.add(Perfil.create(1000, "Trilho", "Código", 1.5, BigDecimal.valueOf(40.0)));
        perfis.add(Perfil.create(1000, "Capa", "Código", 1.5, BigDecimal.valueOf(40.0)));
        perfis.add(Perfil.create(1000, "Guia", "Código", 1.5, BigDecimal.valueOf(40.0)));
        perfis.add(Perfil.create(1000, "Click", "Código", 1.5, BigDecimal.valueOf(40.0)));
        return perfis;
    }

    private List<Ferragem> criarFerragens() {
        // Valor das ferragens nesta configuração é de 200,00
        List<Ferragem> ferragens = new ArrayList<>();
        ferragens.add(Ferragem.create("Fechadura", "3530", BigDecimal.valueOf(150.0)));
        ferragens.add(Ferragem.create("Fechadura", "1125", BigDecimal.valueOf(5.0)));
        ferragens.add(Ferragem.create("Fechadura", "1125", BigDecimal.valueOf(5.0)));
        ferragens.add(Ferragem.create("Fechadura", "1570", BigDecimal.valueOf(40.0)));
        return ferragens;
    }
}