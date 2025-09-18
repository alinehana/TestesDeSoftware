# Atividades

# 📝 Atividade 01 – 1º Bimestre

## Exercícios de Lógica e Estatística

### 1 – Calculadora Avançada

**Testes Unitários:**
- Validar potência com base e expoente positivos.  
- Validar raiz quadrada de número positivo.  
- Validar logaritmo natural de número positivo.  
- Verificar comportamento com números negativos ou zero (tratar exceções).  

### 2 – Gerenciador de Contas

**Testes Unitários:**
- Testar adição de uma nova conta.  
- Testar busca de conta existente pelo número.  
- Testar transferência entre contas com saldo suficiente e insuficiente.  
- Testar transferência entre contas inexistentes (tratamento de exceções).  

### 3 – Processador de Texto

**Testes Unitários:**
- Teste para inverter palavras em uma frase.  
- Teste para substituir palavras em uma frase.  
- Teste para contar ocorrências de uma palavra em uma frase.  
- Verificar comportamento com strings vazias ou nulas.  

### 4 – Gerenciador de Pedidos

**Testes Unitários:**
- Testar adição de novos pedidos.  
- Testar cálculo do valor total de um pedido com diferentes itens.  
- Testar listagem de pedidos por cliente.  
- Verificar comportamento ao acessar pedidos inexistentes.  

### 5 – Estatísticas de Lista

**Testes Unitários:**
- Testar cálculo da média de uma lista de números.  
- Testar cálculo da mediana para listas com tamanho par e ímpar.  
- Testar cálculo do desvio padrão para uma lista de números.  
- Verificar comportamento com listas vazias ou contendo valores nulos.  

---

# 📝 Atividade 02 – 1º Bimestre

## Sistema de Testes Unitários com Mocks

Esta atividade foca na **criação de testes unitários utilizando mocks**, simulando o comportamento de serviços e dependências para garantir que a lógica de negócio funcione corretamente sem depender de implementações reais.

## Objetivo

Desenvolver **testes unitários** para diversas classes do sistema, garantindo **isolamento de dependências**, **validação de regras de negócio** e **uso correto de mocks**.

## Exercícios

### 1 – Autenticação de Usuário

**Testes Unitários:**
- Validar login com sucesso (usuário existe e senha correta).  
- Validar login falho (usuário não existe).  
- Validar senha incorreta.

### 2 – Carrinho de Compras

**Testes Unitários:**
- Testar que um produto pode ser adicionado se tiver estoque suficiente.  
- Testar que não é adicionado quando o estoque é insuficiente.  
- Verificar que `atualizarEstoque()` é chamado corretamente.

### 3 – Envio de E-mail

**Testes Unitários:**
- Validar que ao chamar `notificarUsuario()`, o método `enviarEmail()` seja chamado com os parâmetros corretos.

### 4 – Processamento de Pagamento

**Testes Unitários:**
- Validar pagamento com sucesso.  
- Validar pagamento falho.  
- Validar exceção quando o valor é menor ou igual a 0.

### 5 – Calculadora de Desconto

**Testes Unitários:**
- Validar desconto de 20% para cliente VIP.  
- Validar que clientes comuns não têm desconto.

---

# 📝 Atividade 03 – 1º Bimestre

## Sistema de Vendas Avançado com JUnit e Mockito

Este projeto implementa um sistema de vendas que simula o fluxo de um **e-commerce**, incluindo carrinho de compras, descontos, estoque, pagamento e emissão de nota fiscal.  
Também foram implementados **testes unitários com JUnit e Mockito**, cobrindo os principais cenários de negócio.

## Objetivo

Desenvolver um sistema modular com foco em **testabilidade** e **boas práticas de programação orientada a objetos**.  

## Estrutura do Projeto

### Classes e Interfaces

1. **Produto**
   - Atributos: `id`, `nome`, `preco`, `estoque`.
   - Método:  
     - `boolean reduzirEstoque(int quantidade)` → diminui o estoque; retorna `false` se não houver quantidade suficiente.

2. **CarrinhoDeCompras**
   - Atributo: lista de itens (produt
