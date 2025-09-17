/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.testesdesoftware2;
import org.mockito.Mockito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author aline
 */
public class CarrinhoControllerTest {
    private ProdutoDao daoMock;
    private CarrinhoController controller;
    
    public CarrinhoControllerTest() {
    }

    @BeforeEach
    public void setUp() {
        daoMock = Mockito.mock(ProdutoDao.class);
        controller = new CarrinhoController(daoMock);
    }

    @Test
    public void testAdicionarProdutoComEstoqueSuficiente() {
        int produtoId = 1;
        int quantidade = 2;

        when(daoMock.getEstoque(produtoId)).thenReturn(5);
        boolean resultado = controller.adicionarProduto(produtoId, quantidade);
        assertTrue(resultado, "O produto deveria ser adicionado quando há estoque suficiente");
        verify(daoMock).atualizarEstoque(produtoId, 3); 
    }
    
    @Test
    public void testAdicionarProdutoComEstoqueInsuficiente() {
        int produtoId = 1;
        int quantidade = 10;

        when(daoMock.getEstoque(produtoId)).thenReturn(5);
        boolean resultado = controller.adicionarProduto(produtoId, quantidade);
        assertFalse(resultado, "O produto não deveria ser adicionado quando o estoque é insuficiente");
        verify(daoMock, never()).atualizarEstoque(anyInt(), anyInt());
    }
    
    @Test
    public void testAtualizarEstoqueChamadoCorretamente() {
        int produtoId = 2;
        int quantidade = 4;

        when(daoMock.getEstoque(produtoId)).thenReturn(10);
        controller.adicionarProduto(produtoId, quantidade);
        verify(daoMock).atualizarEstoque(produtoId, 6);
    }
}
