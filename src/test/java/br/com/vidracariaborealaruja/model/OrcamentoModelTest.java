package br.com.vidracariaborealaruja.model;

import br.com.vidracariaborealaruja.beans.Estoque;
import br.com.vidracariaborealaruja.beans.Produto;
import br.com.vidracariaborealaruja.entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class OrcamentoModelTest {
    private List<Produto> produtos;
    private Cliente cliente;
    private OrcamentoModel orcamento;

    @Test
    void criaOrcamentoPassandoListaProdutosECliente() {
        Produto prod1 = new Produto("Fones de Ouvidos", BigDecimal.valueOf(1.0)
                , BigDecimal.valueOf(2.001)
                , new Estoque("Geral", 1, 1, 1));
        Produto prod2 = new Produto("Canetas", BigDecimal.valueOf(1.0)
                , BigDecimal.valueOf(3.0)
                , new Estoque("Geral", 1, 1, 2));
        Produto prod3 = new Produto("Balança", BigDecimal.valueOf(1.0)
                , BigDecimal.valueOf(5.0)
                , new Estoque("Geral", 1, 1, 3));

        List<Produto> produtosTest = List.of(prod1, prod2, prod3);
        Cliente clienteTest = new Cliente();
        clienteTest.setNome("Anderson");
        clienteTest.setCelular(11935854108L);
        OrcamentoModel orcamentoTest = new OrcamentoModel(clienteTest,produtosTest);
        assertEquals(orcamentoTest,orcamento);
    }

    @Test
     void valorTotaldoOrcamento(){
        assertEquals(BigDecimal.valueOf(10.001),orcamento.total());
     }
     
     @Test
     void valorTotaldeCusto(){
        assertEquals(BigDecimal.valueOf(3.0),orcamento.totalCusto());
     }

     @Test
     void ilegalArgumentoExceptionAoProdutosNuloNoConstrutor(){
        assertThrows(IllegalArgumentException.class , ()-> new OrcamentoModel(cliente,null));
     }

     @Test
     void ilegalArgumentoExceptionAoClienteNuloNoConstrutor(){
        assertThrows(IllegalArgumentException.class,() -> new OrcamentoModel(null,produtos));
     }

    @BeforeEach
    public void inicialize() {
        Produto prod1 = new Produto("Fones de Ouvidos", BigDecimal.valueOf(1.0)
                , BigDecimal.valueOf(2.001)
                , new Estoque("Geral", 1, 1, 1));
        Produto prod2 = new Produto("Canetas", BigDecimal.valueOf(1.0)
                , BigDecimal.valueOf(3.0)
                , new Estoque("Geral", 1, 1, 2));
        Produto prod3 = new Produto("Balança", BigDecimal.valueOf(1.0)
                , BigDecimal.valueOf(5.0)
                , new Estoque("Geral", 1, 1, 3));


        produtos = new ArrayList<>();
        produtos.add(prod1);
        produtos.add(prod2);
        produtos.add(prod3);
        cliente = new Cliente();
        cliente.setNome("Anderson");
        cliente.setCelular(11935854108L);
        orcamento = new OrcamentoModel(cliente,produtos);
    }
}
