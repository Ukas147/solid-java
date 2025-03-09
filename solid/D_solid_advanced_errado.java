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

//         processador.processarPedido("Laptop Gamer", 5000, "cliente@email.com");
//         processador.processarPedido("Mouse sem fio", 200, "cliente@email.com");
//     }
// }