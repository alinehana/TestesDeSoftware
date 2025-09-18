/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.mavenproject2;

/**
 *
 * @author aline
 */
public class ItemPedido {
    private String nomeProduto;
    private double preco;
    private int quantidade;

    public ItemPedido(String nomeProduto, double preco, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return preco * quantidade;
    }
}
