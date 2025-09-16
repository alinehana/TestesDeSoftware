# Atividade 03 – 1º Bimestre  
## Sistema de Vendas Avançado com JUnit e Mockito

Este projeto implementa um sistema de vendas que simula o fluxo de um **e-commerce**, incluindo carrinho de compras, descontos, estoque, pagamento e emissão de nota fiscal.  

Também foram implementados **testes unitários com JUnit e Mockito**, cobrindo os principais cenários de negócio.

---

## 🎯 Objetivo
Desenvolver um sistema modular com foco em **testabilidade** e **boas práticas de programação orientada a objetos**.  

---

## 📦 Estrutura do Projeto

### Classes e Interfaces
1. **Produto**
   - Atributos: `id`, `nome`, `preco`, `estoque`.
   - Método:  
     - `boolean reduzirEstoque(int quantidade)` → diminui o estoque; retorna `false` se não houver quantidade suficiente.

2. **CarrinhoDeCompras**
   - Atributo: lista de itens (produto + quantidade).  
   - Métodos:  
     - `void adicionarProduto(Produto produto, int quantidade)`  
     - `void removerProduto(int produtoId)`  
     - `double calcularTotal()` → soma dos preços considerando quantidades.  

3. **DescontoService (Interface)**
   - Método:  
     - `double aplicarDesconto(double valorTotal)`

4. **PagamentoService (Interface)**
   - Método:  
     - `boolean processarPagamento(double valor)`

5. **NotaFiscalService (Interface)**
   - Método:  
     - `void emitirNota(double valor, List<Produto> produtos)`

6. **VendaService**
   - Depende de: `DescontoService`, `PagamentoService`, `NotaFiscalService`.  
   - Método principal:  
     - `boolean realizarVenda(CarrinhoDeCompras carrinho)`  
       - Calcula o total do carrinho.  
       - Aplica desconto via `DescontoService`.  
       - Verifica estoque dos produtos.  
       - Processa pagamento.  
       - Se aprovado: reduz estoque, emite nota fiscal e retorna `true`.  
       - Caso contrário, retorna `false`.  

---

## 🧪 Testes Implementados

### Parte 1 – Carrinho
- Adição de produtos no carrinho (incluindo quantidades).  
- Remoção de produtos.  
- Cálculo do valor total com múltiplos itens.  

### Parte 2 – Desconto
- Mock de `DescontoService` para aplicar **10%** de desconto.  
- Teste com **0% de desconto** (sem alteração no valor).  

### Parte 3 – Estoque
- Produto com estoque insuficiente.  
- Venda deve falhar e pagamento não é processado.  

### Parte 4 – Pagamento
- `PagamentoService` retorna `true`:  
  - Venda concluída com sucesso.  
  - Estoque reduzido corretamente.  
  - `NotaFiscalService.emitirNota(...)` chamado **exatamente uma vez**.  

- `PagamentoService` retorna `false`:  
  - Venda falha.  
  - Nenhuma nota fiscal emitida.  

### Parte 5 – Exceções
- `PagamentoService` lança `RuntimeException`.  
- `VendaService` captura exceção e retorna `false`.  
- Estoque não é alterado e nenhuma nota fiscal é emitida.  

---

## 🚀 Tecnologias Utilizadas
- **Java 21**  
- **JUnit 5**  
- **Mockito**  
- **Maven/Gradle** (dependendo do seu build)  

---

## ▶️ Como Executar
1. Clone o repositório:  
   ```bash
   git clone https://github.com/seu-usuario/seu-repo.git
   cd seu-repo
