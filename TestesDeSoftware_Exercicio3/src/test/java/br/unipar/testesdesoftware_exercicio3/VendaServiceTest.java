/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.testesdesoftware_exercicio3;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyList;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;


/**
 *
 * @author aline
 */
public class VendaServiceTest {
    private Produto produto1;
    private Produto produto2;
    private CarrinhoDeCompras carrinho;
    
    @Mock
    private DescontoService descontoService;
    @Mock
    private PagamentoService pagamentoService;
    @Mock
    private NotaFiscalService notaFiscalService;
    
    private VendaService vendaService;
    
    public VendaServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        produto1 = new Produto(1, "Produto 1", 100.0, 10);
        produto2 = new Produto(2, "Produto 2", 50.0, 5);
        carrinho = new CarrinhoDeCompras();
        vendaService = new VendaService(descontoService, pagamentoService, notaFiscalService);
    }
    
    // Testando Carrinho
    @Test
    public void testAdicionarProduto() {
        carrinho.adicionarProduto(produto1, 2);
        carrinho.adicionarProduto(produto1, 3);
        carrinho.adicionarProduto(produto2, 1);
        assertEquals(2, carrinho.getItens().size());
        assertEquals(5, carrinho.getItens().get(produto1));
        assertEquals(1, carrinho.getItens().get(produto2));
    }
    
    @Test
    public void testRemoverProduto() {
        carrinho.adicionarProduto(produto1, 2);
        carrinho.adicionarProduto(produto2, 1);
        carrinho.removerProduto(produto1.getId());
        assertEquals(1, carrinho.getItens().size());
        assertFalse(carrinho.getItens().containsKey(produto1));
    }
    
    @Test
    public void testCalcularTotal() {
        carrinho.adicionarProduto(produto1, 2); // 2 * 100 = 200
        carrinho.adicionarProduto(produto2, 3); // 3 * 50 = 150
        double total = carrinho.calcularTotal();
        assertEquals(350.0, total, 0.001);
    }
    
    //Testando Desconto
    @Test
    public void testDescontoDezPorcento() {
        carrinho.adicionarProduto(produto1, 1);
        when(descontoService.aplicarDesconto(100.0)).thenReturn(90.0);
        when(pagamentoService.processarPagamento(90.0)).thenReturn(true);
        boolean resultado = vendaService.realizarVenda(carrinho);
        assertTrue(resultado);
        verify(descontoService).aplicarDesconto(100.0);
    }
    
    @Test
    public void testDescontoZeroPorcento() {
        carrinho.adicionarProduto(produto1, 1);
        when(descontoService.aplicarDesconto(100.0)).thenReturn(100.0);
        when(pagamentoService.processarPagamento(100.0)).thenReturn(true);
        boolean resultado = vendaService.realizarVenda(carrinho);
        assertTrue(resultado);
        verify(descontoService).aplicarDesconto(100.0);
    }
    
    // Testando Estoque insuficiente
    @Test
    public void testEstoqueInsuficiente() {
        Produto produtoComPoucoEstoque = new Produto(3, "Produto 3", 30.0, 1);
        carrinho.adicionarProduto(produtoComPoucoEstoque, 2); // quantidade maior que estoque
        when(descontoService.aplicarDesconto(anyDouble())).thenReturn(60.0);
        boolean resultado = vendaService.realizarVenda(carrinho);
        assertFalse(resultado);
        verify(pagamentoService, never()).processarPagamento(anyDouble());
        verify(notaFiscalService, never()).emitirNota(anyDouble(), anyList());
    }
    
    // Testando Pagamento
    @Test
    public void testPagamentoAprovado() {
        carrinho.adicionarProduto(produto1, 2);
        when(descontoService.aplicarDesconto(200.0)).thenReturn(180.0);
        when(pagamentoService.processarPagamento(180.0)).thenReturn(true);
        boolean resultado = vendaService.realizarVenda(carrinho);
        assertTrue(resultado);
        assertEquals(8, produto1.getEstoque()); // 10 - 2 = 8
        verify(notaFiscalService, times(1)).emitirNota(180.0, List.of(produto1));
    }
    
    @Test
    public void testPagamentoRejeitado() {
        carrinho.adicionarProduto(produto1, 1);
        when(descontoService.aplicarDesconto(100.0)).thenReturn(100.0);
        when(pagamentoService.processarPagamento(100.0)).thenReturn(false);
        boolean resultado = vendaService.realizarVenda(carrinho);
        assertFalse(resultado);
        assertEquals(10, produto1.getEstoque()); // estoque não alterado
        verify(notaFiscalService, never()).emitirNota(anyDouble(), anyList());
    }
    
    //Testando Exceções
    @Test
    public void testPagamentoLancaExcecao() {
        carrinho.adicionarProduto(produto1, 1);
        when(descontoService.aplicarDesconto(100.0)).thenReturn(100.0);
        when(pagamentoService.processarPagamento(100.0)).thenThrow(new RuntimeException("Erro no pagamento"));
        boolean resultado = vendaService.realizarVenda(carrinho);
        assertFalse(resultado);
        assertEquals(10, produto1.getEstoque()); // estoque não alterado
        verify(notaFiscalService, never()).emitirNota(anyDouble(), anyList());
    }
}
