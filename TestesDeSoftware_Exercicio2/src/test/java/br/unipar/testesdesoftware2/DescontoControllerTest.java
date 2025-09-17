/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.testesdesoftware2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author aline
 */
public class DescontoControllerTest {
    private ClienteDao clienteDaoMock;
    private DescontoController controller;
    
    public DescontoControllerTest() {
    }

    @BeforeEach
    public void setUp() {
        clienteDaoMock = Mockito.mock(ClienteDao.class);
        controller = new DescontoController(clienteDaoMock);
    }
    
    @Test
    public void testDescontoClienteVip() {
        String email = "vip@teste.com";
        double valorCompra = 100.0;

        when(clienteDaoMock.isClienteVip(email)).thenReturn(true);
        double resultado = controller.calcularDesconto(email, valorCompra);
        assertEquals(80.0, resultado, 0.001, "Cliente VIP deve receber 20% de desconto");
        verify(clienteDaoMock).isClienteVip(email);
    }

    @Test
    public void testClienteNaoVipSemDesconto() {
        String email = "comum@teste.com";
        double valorCompra = 100.0;
        when(clienteDaoMock.isClienteVip(email)).thenReturn(false);
        double resultado = controller.calcularDesconto(email, valorCompra);
        assertEquals(100.0, resultado, 0.001, "Cliente comum não deve receber desconto");
        verify(clienteDaoMock).isClienteVip(email);
    }
}
