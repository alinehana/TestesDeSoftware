/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.testesdesoftware2;

/**
 *
 * @author aline
 */
public class PagamentoController {
    private final GatewayPagamento gateway;
    public PagamentoController (GatewayPagamento gateway) {
        this. gateway = gateway;
    }
    
    public String realizarPagamento (double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
    }
        return gateway.processarPagamento (valor) ? "SUCESSO" : "FALHA";
    }
}
