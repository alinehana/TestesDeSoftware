/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.mavenproject2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aline
 */
public class GerenciadorDeContasTest {
    private GerenciadorDeContas gerenciador;
    
    @BeforeEach
    public void setUp() {
         gerenciador = new GerenciadorDeContas();
    }

    @Test
    public void testAbrirConta() {
        Conta conta = new Conta("1231231", 100);
        gerenciador.adicionarConta(conta);
        
        assertEquals(1, gerenciador.getContasAbertas().size());
        
        Conta contaCriada = gerenciador.getContasAbertas().get(0);
        
        assertEquals("1231231", contaCriada.getCpf());
        assertEquals(null, contaCriada.getValorInicial());
        assertTrue(contaCriada.getNumeroConta() >= 0 && contaCriada.getNumeroConta() <= 1000);
    }

    @Test
    public void testNaoAbrirConta(){
        Conta conta = new Conta(null, 50.0);
        gerenciador.adicionarConta(conta);
        assertEquals(0, gerenciador.getContasAbertas().size());
    }
    
    @Test
    public void testBuscarContaPorNumeroExistente() {
        Conta conta = new Conta("987.654.321-00", 2000.0);
        gerenciador.adicionarConta(conta);
        
        int numeroConta = conta.getNumeroConta();
        Conta contaBuscada = gerenciador.buscarContaPorNumero(numeroConta);
        
        assertNotNull(contaBuscada);
        assertEquals(numeroConta, contaBuscada.getNumeroConta());
    }
    
    @Test
    public void testBuscarContaPorNumeroInexistente() {
        Conta contaBuscada = gerenciador.buscarContaPorNumero(999);
        assertNull(contaBuscada);
    }

    @Test
    public void testTransferenciaComSaldoSuficiente() {
        Conta origem = new Conta("111.111.111-11", 500.0);
        Conta destino = new Conta("222.222.222-22", 100.0);

        gerenciador.adicionarConta(origem);
        gerenciador.adicionarConta(destino);

        int numOrigem = origem.getNumeroConta();
        int numDestino = destino.getNumeroConta();

        Exception ex = assertThrows(NullPointerException.class, () -> {
            gerenciador.transferir(numOrigem, numDestino, 200.0);
        });
        assertEquals("Transferência realizada com sucesso.", ex.getMessage());
        //Está com erro
        assertEquals(300.0, origem.getValorInicial());
        assertEquals(300.0, destino.getValorInicial());
    }

    @Test
    public void testTransferenciaComSaldoInsuficiente() {
        Conta origem = new Conta("111.111.111-11", 100.0);
        Conta destino = new Conta("222.222.222-22", 200.0);

        gerenciador.adicionarConta(origem);
        gerenciador.adicionarConta(destino);

        int numOrigem = origem.getNumeroConta();
        int numDestino = destino.getNumeroConta();

        Exception ex = assertThrows(NullPointerException.class, () -> {
            gerenciador.transferir(numOrigem, numDestino, 150.0);
        });

        assertEquals("Saldo insuficiente para a transferência.", ex.getMessage());
        //Está com erro
        assertEquals(100.0, origem.getValorInicial());
        assertEquals(200.0, destino.getValorInicial());
    }

    @Test
    public void testTransferenciaEntreContasInexistentes() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            gerenciador.transferir(999, 888, 100.0);
        });

        assertEquals("Conta de origem ou destino não encontrada.", ex.getMessage());
    }
    }