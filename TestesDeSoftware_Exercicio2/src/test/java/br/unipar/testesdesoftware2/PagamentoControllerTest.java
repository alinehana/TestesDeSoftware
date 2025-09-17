/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.testesdesoftware2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author aline
 */
public class PagamentoControllerTest {
    private GatewayPagamento gatewayMock;
    private PagamentoController controller;
    
    public PagamentoControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
        gatewayMock = Mockito.mock(GatewayPagamento.class);
        controller = new PagamentoController(gatewayMock);
    }
 
    @Test
    public void testPagamentoSucesso() {
        double valor = 100.0;
        when(gatewayMock.processarPagamento(valor)).thenReturn(true);
        String resultado = controller.realizarPagamento(valor);
        assertEquals("SUCESSO", resultado);
        verify(gatewayMock).processarPagamento(valor);
    }

    @Test
    public void testPagamentoFalho() {
        double valor = 50.0;
        when(gatewayMock.processarPagamento(valor)).thenReturn(false);
        String resultado = controller.realizarPagamento(valor);
        assertEquals("FALHA", resultado);
        verify(gatewayMock).processarPagamento(valor);
    }

    @Test
    public void testPagamentoValorInvalido() {
        double valor = 0.0;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.realizarPagamento(valor);
        });
        assertEquals("Valor inválido", exception.getMessage());
        verify(gatewayMock, never()).processarPagamento(anyDouble());
    }
}
