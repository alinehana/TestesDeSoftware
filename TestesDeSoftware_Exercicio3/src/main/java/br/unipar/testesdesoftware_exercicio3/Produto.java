/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.testesdesoftware_exercicio3;

/**
 *
 * @author aline
 */
public class Produto {
    private int id;
    private String nome;
    private Double preco;
    private int estoque;

    public Produto(int id, String nome, Double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public boolean reduzirEstoque(int quantidade) {
        if (quantidade <= 0) {
            return false;
        }
        if (estoque >= quantidade) {
            estoque -= quantidade;
            return true;
        }
        return false;
    } 
    
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
}
