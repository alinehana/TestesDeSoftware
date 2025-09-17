/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.testesdesoftware2;

/**
 *
 * @author aline
 */
public class DescontoController {
    private final ClienteDao dao;
    
    public DescontoController (ClienteDao dao) {
        this.dao = dao;
}

    public double calcularDesconto (String email, double valorCompra) {
        if (dao.isClienteVip (email)) {
            return valorCompra =0.8; // 20% de desconto
    }
        return valorCompra;
}
}