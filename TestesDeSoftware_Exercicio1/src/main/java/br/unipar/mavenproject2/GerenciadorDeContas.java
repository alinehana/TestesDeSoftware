/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.mavenproject2;

import java.util.ArrayList;

/**
 *
 * @author aline
 */
public class GerenciadorDeContas {
    private ArrayList<Conta> listaContasAbertas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        if (conta.getCpf() != null) {
            conta.setNumeroConta((int) (Math.random() * 1000));
            listaContasAbertas.add(conta);
        }
    }

    public ArrayList<Conta> getContasAbertas() {
        return listaContasAbertas;
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : listaContasAbertas) {
            if (conta.getNumeroConta() == numero) {
                return conta;
            }
        }
        return null;
    }

    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta origem = buscarContaPorNumero(numeroContaOrigem);
        Conta destino = buscarContaPorNumero(numeroContaDestino);

        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Conta de origem ou destino não encontrada.");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de transferência deve ser positivo.");
        }

        if (origem.getValorInicial() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente para a transferência.");
        }

        origem.setValorInicial(origem.getValorInicial() - valor);
        destino.setValorInicial(destino.getValorInicial() + valor);
    }
}