/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.mavenproject2;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aline
 */
public class GerenciadorDePedidosTest {
    private GerenciadorDePedidos gerenciador;

    public GerenciadorDePedidosTest() {
    }
    
    @BeforeEach
    public void setUp() {
        gerenciador = new GerenciadorDePedidos();
    }
    
    @Test
    public void testAdicionarPedido() {
        Pedido pedido = new Pedido(1, "Aline");
        gerenciador.adicionarPedido(pedido);
        assertEquals(1, gerenciador.listarPedidosPorCliente("Aline").size());
    }

    @Test
    public void testCalcularValorTotal() {
        Pedido pedido = new Pedido(1, "Carlos");
        pedido.adicionarItem(new ItemPedido("Notebook", 2500.0, 1));
        pedido.adicionarItem(new ItemPedido("Mouse", 100.0, 2));
        gerenciador.adicionarPedido(pedido);

        double total = gerenciador.calcularValorTotal(1);
        assertEquals(2700.0, total);
    }

    @Test
    public void testListarPedidosPorCliente() {
        Pedido p1 = new Pedido(1, "Maria");
        Pedido p2 = new Pedido(2, "Maria");
        Pedido p3 = new Pedido(3, "João");

        gerenciador.adicionarPedido(p1);
        gerenciador.adicionarPedido(p2);
        gerenciador.adicionarPedido(p3);

        List<Pedido> pedidosMaria = gerenciador.listarPedidosPorCliente("Maria");
        assertEquals(2, pedidosMaria.size());
    }

    @Test
    public void testAcessarPedidoInexistente() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            gerenciador.calcularValorTotal(999);
        });
        assertEquals("Pedido não encontrado.", ex.getMessage());
    }
}