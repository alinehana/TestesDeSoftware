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
public class Pedido {
    private int id;
    private String nomeCliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(int id, String nomeCliente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
    }

    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }
}