/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.testesdesoftware2;

/**
 *
 * @author aline
 */
public class CarrinhoController {
    private final ProdutoDao dao;
    
    public CarrinhoController(ProdutoDao dao) {
        this.dao = dao;
}
    
    public boolean adicionarProduto (int produtoId, int quantidade) {
        if (dao.getEstoque (produtoId) < quantidade) {
            return false;
}
        dao.atualizarEstoque(produtoId, dao.getEstoque(produtoId) - quantidade);
            return true;
    }
}