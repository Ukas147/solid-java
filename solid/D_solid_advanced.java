/**
 * 🚀 Aplicação correta do Princípio da Inversão de Dependência (DIP - Dependency Inversion Principle)
 *
 * O código abaixo **implementa corretamente o DIP**, garantindo que **o sistema de pedidos depende de abstrações (interfaces)**
 * em vez de depender diretamente de implementações concretas (`PagamentoCartao`, `PagamentoPix`, `NotificacaoEmail`, `NotificacaoSMS`).
 *
 * O DIP afirma que:
 * 1️⃣ **Módulos de alto nível (ex: `ProcessadorPedido`) não devem depender de módulos de baixo nível (`PagamentoCartao`, `NotificacaoEmail`).**
 * 2️⃣ **Ambos devem depender de abstrações (interfaces).**
 *
 * 🔹 **O que foi corrigido aqui?**
 *    - Criamos **a interface `Pagamento` e `Notificacao`**, garantindo que `ProcessadorPedido` **não dependa de uma implementação específica**.
 *    - Agora podemos **adicionar novos métodos de pagamento ou notificações sem modificar a classe `ProcessadorPedido`**.
 *
 * 🔹 **Benefícios dessa abordagem:**
 * 1️⃣ **Respeito ao DIP**  
 *     - O `ProcessadorPedido` **não depende de implementações concretas**, apenas das interfaces `Pagamento` e `Notificacao`.
 *     - Se criarmos um `PagamentoCripto` ou `NotificacaoWhatsApp`, **não precisamos modificar `ProcessadorPedido`**.
 *
 * 2️⃣ **Código modular e reutilizável**  
 *     - Se precisarmos suportar um novo método de pagamento, basta criar uma nova classe sem alterar o código existente.
 *
 * 3️⃣ **Baixo acoplamento**  
 *     - O `ProcessadorPedido` apenas **chama os métodos da interface**, sem se preocupar com detalhes da implementação.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se `ProcessadorPedido` dependesse diretamente de `PagamentoCartao` e `NotificacaoEmail`,
 *      precisaríamos modificar o código toda vez que um novo método fosse adicionado.
 *    - Isso tornaria o sistema rígido e difícil de expandir.
 */

 import java.util.ArrayList;
 import java.util.List;
 
 // ✅ INTERFACE PARA PAGAMENTOS (ABSTRAÇÃO)
 interface Pagamento {
     boolean processarPagamento(double valor);
 }
 
 // ✅ IMPLEMENTAÇÃO DE PAGAMENTO POR CARTÃO
 class PagamentoCartao implements Pagamento {
     public boolean processarPagamento(double valor) {
         System.out.println("💳 Processando pagamento de R$ " + valor + " via cartão...");
         return valor > 0;
     }
 }
 
 // ✅ IMPLEMENTAÇÃO DE PAGAMENTO POR PIX
 class PagamentoPix implements Pagamento {
     public boolean processarPagamento(double valor) {
         System.out.println("⚡ Pagamento via Pix de R$ " + valor + " confirmado!");
         return valor > 0;
     }
 }
 
 // ✅ INTERFACE PARA NOTIFICAÇÃO (ABSTRAÇÃO)
 interface Notificacao {
     void enviar(String destinatario, String mensagem);
 }
 
 // ✅ IMPLEMENTAÇÃO DE NOTIFICAÇÃO POR E-MAIL
 class NotificacaoEmail implements Notificacao {
     public void enviar(String email, String mensagem) {
         System.out.println("📧 Enviando e-mail para " + email + ": " + mensagem);
     }
 }
 
 // ✅ IMPLEMENTAÇÃO DE NOTIFICAÇÃO POR SMS
 class NotificacaoSMS implements Notificacao {
     public void enviar(String telefone, String mensagem) {
         System.out.println("📱 Enviando SMS para " + telefone + ": " + mensagem);
     }
 }
 
 // ✅ CLASSE DE PROCESSAMENTO DE PEDIDOS QUE DEPENDE DE ABSTRAÇÕES
 class ProcessadorPedido {
     private Pagamento metodoPagamento;
     private Notificacao metodoNotificacao;
     private List<String> pedidos = new ArrayList<>();
 
     // ✅ Dependência injetada via construtor (DIP aplicado corretamente)
     public ProcessadorPedido(Pagamento metodoPagamento, Notificacao metodoNotificacao) {
         this.metodoPagamento = metodoPagamento;
         this.metodoNotificacao = metodoNotificacao;
     }
 
     public void processarPedido(String pedido, double valor, String destinatario) {
         pedidos.add(pedido);
 
         boolean sucesso = metodoPagamento.processarPagamento(valor);
         if (sucesso) {
             System.out.println("✅ Pedido confirmado: " + pedido);
             metodoNotificacao.enviar(destinatario, "Seu pedido foi confirmado!");
         } else {
             System.out.println("❌ Falha no pagamento do pedido: " + pedido);
         }
     }
 }
 
 // 🏡 Testando o sistema de pedidos (agora modularizado e extensível!)
//  public class Main {
//      public static void main(String[] args) {
//          // ✅ Criamos diferentes configurações de pagamento e notificação
//          ProcessadorPedido pedidoCartaoEmail = new ProcessadorPedido(new PagamentoCartao(), new NotificacaoEmail());
//          ProcessadorPedido pedidoPixSMS = new ProcessadorPedido(new PagamentoPix(), new NotificacaoSMS());
 
//          // ✅ Agora podemos usar diferentes combinações sem modificar a classe principal
//          pedidoCartaoEmail.processarPedido("Laptop Gamer", 5000, "cliente@email.com");
//          pedidoPixSMS.processarPedido("Mouse sem fio", 200, "11999999999");
//      }
//  } 