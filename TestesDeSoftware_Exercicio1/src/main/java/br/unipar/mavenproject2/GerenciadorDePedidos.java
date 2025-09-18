/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.mavenproject2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aline
 */
public class GerenciadorDePedidos {
    private List<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public double calcularValorTotal(int idPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido) {
                return pedido.getItens().stream()
                        .mapToDouble(ItemPedido::getSubtotal)
                        .sum();
            }
        }
        throw new IllegalArgumentException("Pedido não encontrado.");
    }

    public List<Pedido> listarPedidosPorCliente(String nomeCliente) {
        List<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNomeCliente().equalsIgnoreCase(nomeCliente)) {
                pedidosCliente.add(pedido);
            }
        }
        return pedidosCliente;
    }
}