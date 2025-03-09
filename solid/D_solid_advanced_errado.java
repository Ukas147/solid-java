/**
 * 🚨 Problema: Violação do Princípio da Inversão de Dependência (DIP - Dependency Inversion Principle)
 *
 * O código abaixo **viola o DIP**, pois `ProcessadorPedido` **depende diretamente de implementações concretas**
 * (`PagamentoCartao` e `NotificacaoEmail`) em vez de depender de abstrações (interfaces).
 *
 * O DIP afirma que:
 * 1️⃣ **Módulos de alto nível (ex: `ProcessadorPedido`) não devem depender de módulos de baixo nível (`PagamentoCartao`, `NotificacaoEmail`).**
 * 2️⃣ **Ambos devem depender de abstrações (interfaces).**
 *
 * 🔴 **Problemas encontrados:**
 * 1️⃣ **Acoplamento alto** → `ProcessadorPedido` depende diretamente de `PagamentoCartao` e `NotificacaoEmail`,
 *    tornando difícil a adição de novos métodos de pagamento ou notificação.
 *
 * 2️⃣ **Código pouco flexível** → Se quisermos adicionar `PagamentoPix` ou `NotificacaoSMS`, precisamos modificar
 *    `ProcessadorPedido`, o que vai contra o **OCP (Open-Closed Principle)**.
 *
 * 3️⃣ **Dificuldade de manutenção** → Se `PagamentoCartao` for alterado, `ProcessadorPedido` pode ser afetado diretamente.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se quisermos suportar um novo método de pagamento (ex: `PagamentoCripto`) ou um novo canal de notificação
 *      (ex: `NotificacaoWhatsApp`), precisaríamos modificar `ProcessadorPedido` diretamente.
 *    - Isso tornaria o código mais rígido e difícil de reutilizar.
 */

 import java.util.ArrayList;
 import java.util.List;
 
 // ❌ CLASSE QUE GERENCIA PEDIDOS, MAS DEPENDE DIRETAMENTE DE IMPLEMENTAÇÕES CONCRETAS!
 class ProcessadorPedido {
     private PagamentoCartao pagamentoCartao;
     private NotificacaoEmail notificacaoEmail;
     private List<String> pedidos = new ArrayList<>();
 
     public ProcessadorPedido() {
         this.pagamentoCartao = new PagamentoCartao();
         this.notificacaoEmail = new NotificacaoEmail();
     }
 
     public void processarPedido(String pedido, double valor, String emailCliente) {
         pedidos.add(pedido);
 
         // ❌ DEPENDÊNCIA DIRETA EM UMA CLASSE CONCRETA DE PAGAMENTO
         boolean sucesso = pagamentoCartao.processarPagamento(valor);
         if (sucesso) {
             System.out.println("✅ Pedido confirmado: " + pedido);
             
             // ❌ DEPENDÊNCIA DIRETA EM UMA CLASSE CONCRETA DE NOTIFICAÇÃO
             notificacaoEmail.enviar(emailCliente, "Seu pedido foi confirmado!");
         } else {
             System.out.println("❌ Falha no pagamento do pedido: " + pedido);
         }
     }
 }
 
 // ❌ CLASSE DE PAGAMENTO ALTAMENTE ACOPLADA
 class PagamentoCartao {
     public boolean processarPagamento(double valor) {
         System.out.println("💳 Processando pagamento de R$ " + valor + " via cartão...");
         return valor > 0;
     }
 }
 
 // ❌ CLASSE DE NOTIFICAÇÃO ALTAMENTE ACOPLADA
 class NotificacaoEmail {
     public void enviar(String email, String mensagem) {
         System.out.println("📧 Enviando e-mail para " + email + ": " + mensagem);
     }
 }
 
 // 🏡 Testando o sistema de pedidos (com código ruim)
 // public class Main {
 //     public static void main(String[] args) {
 //         ProcessadorPedido processador = new ProcessadorPedido();
 //
 //         processador.processarPedido("Laptop Gamer", 5000, "cliente@email.com");
 //         processador.processarPedido("Mouse sem fio", 200, "cliente@email.com");
 //     }
 // } 