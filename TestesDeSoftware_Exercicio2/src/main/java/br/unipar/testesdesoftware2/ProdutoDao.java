/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.testesdesoftware2;

/**
 *
 * @author aline
 */
public interface ProdutoDao {
    int getEstoque (int produtoId);
    void atualizarEstoque (int produtoId, int quantidade);
}
