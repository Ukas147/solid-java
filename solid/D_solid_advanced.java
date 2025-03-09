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
// public class Main {
//     public static void main(String[] args) {
//         // ✅ Criamos diferentes configurações de pagamento e notificação
//         ProcessadorPedido pedidoCartaoEmail = new ProcessadorPedido(new PagamentoCartao(), new NotificacaoEmail());
//         ProcessadorPedido pedidoPixSMS = new ProcessadorPedido(new PagamentoPix(), new NotificacaoSMS());

//         // ✅ Agora podemos usar diferentes combinações sem modificar a classe principal
//         pedidoCartaoEmail.processarPedido("Laptop Gamer", 5000, "cliente@email.com");
//         pedidoPixSMS.processarPedido("Mouse sem fio", 200, "11999999999");
//     }
// }