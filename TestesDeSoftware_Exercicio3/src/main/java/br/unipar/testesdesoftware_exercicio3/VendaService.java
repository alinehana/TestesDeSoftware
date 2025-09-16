/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.testesdesoftware_exercicio3;
import java.util.List;
import java.util.Map;
/**
 *
 * @author aline
 */
public class VendaService {
    private DescontoService descontoService;
    private PagamentoService pagamentoService;
    private NotaFiscalService notaFiscalService;
    
    public VendaService(DescontoService descontoService, PagamentoService pagamentoService, NotaFiscalService notaFiscalService) {
        this.descontoService = descontoService;
        this.pagamentoService = pagamentoService;
        this.notaFiscalService = notaFiscalService;
    }
    public boolean realizarVenda(CarrinhoDeCompras carrinho) {
        double total = carrinho.calcularTotal();
        double totalComDesconto = descontoService.aplicarDesconto(total);
        Map<Produto, Integer> itens = carrinho.getItens();
        // Verifica estoque
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            if (produto.getEstoque() < quantidade) {
                return false;
            }
        }
        try {
            boolean pagamentoAprovado = pagamentoService.processarPagamento(totalComDesconto);
            if (!pagamentoAprovado) {
                return false;
            }
        } catch (RuntimeException e) {
            // Tratamento da exceção conforme solicitado
            return false;
        }
        // Reduz estoque
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            produto.reduzirEstoque(quantidade);
        }
        // Emite nota fiscal
        List<Produto> produtos = carrinho.getProdutos();
        notaFiscalService.emitirNota(totalComDesconto, produtos);
        return true;
    }
}
