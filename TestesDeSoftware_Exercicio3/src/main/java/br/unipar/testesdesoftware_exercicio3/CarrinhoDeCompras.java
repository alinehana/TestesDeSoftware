/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.testesdesoftware_exercicio3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aline
 */
public class CarrinhoDeCompras {
    private Map<Integer, Item> itens = new HashMap<>();
    Map<Produto, Integer> getItens;
    private static class Item {
        Produto produto;
        int quantidade;
        Item(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) return;
        Item item = itens.get(produto.getId());
        if (item == null) {
            itens.put(produto.getId(), new Item(produto, quantidade));
        } else {
            item.quantidade += quantidade;
        }
    }
    
    public void removerProduto(int produtoId) {
        itens.remove(produtoId);
    }
    public double calcularTotal() {
        return itens.values().stream()
                .mapToDouble(i -> i.produto.getPreco() * i.quantidade)
                .sum();
    }
    public List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        for (Item item : itens.values()) {
            produtos.add(item.produto);
        }
        return produtos;
    }
    
    public Map<Produto, Integer> getItens() {
        Map<Produto, Integer> map = new HashMap<>();
        for (Item item : itens.values()) {
            map.put(item.produto, item.quantidade);
        }
        return map;
    }
}
