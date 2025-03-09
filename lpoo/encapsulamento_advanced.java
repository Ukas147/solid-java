import java.util.ArrayList;
import java.util.List;

// Classe ContaBancaria encapsulada
class ContaBancaria {
    private String titular;
    private double saldo;
    private final List<String> transacoes; // Lista de transações (histórico)

    // Construtor: inicializa conta com titular e saldo inicial
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial > 0 ? saldoInicial : 0; // Garante saldo não negativo
        this.transacoes = new ArrayList<>();
        registrarTransacao("Conta criada com saldo inicial: R$ " + this.saldo);
    }

    // Método privado para registrar transações no histórico
    private void registrarTransacao(String transacao) {
        transacoes.add(transacao);
    }

    // Método getter para obter o saldo (somente leitura)
    public double getSaldo() {
        return saldo;
    }

    // Método getter para obter o titular da conta
    public String getTitular() {
        return titular;
    }

    // Método setter para alterar o titular (com validação)
    public void setTitular(String novoTitular) {
        if (novoTitular == null || novoTitular.isEmpty()) {
            System.out.println("Erro: Nome do titular inválido!");
            return;
        }
        this.titular = novoTitular;
        registrarTransacao("Titular alterado para: " + novoTitular);
    }

    // Método para depositar dinheiro na conta
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: Depósito inválido!");
            return;
        }
        saldo += valor;
        registrarTransacao("Depósito de R$ " + valor);
    }

    // Método para sacar dinheiro da conta (com validação de saldo)
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: Valor de saque inválido!");
            return false;
        }
        if (valor > saldo) {
            System.out.println("Erro: Saldo insuficiente!");
            return false;
        }
        saldo -= valor;
        registrarTransacao("Saque de R$ " + valor);
        return true;
    }

    // Método para transferir dinheiro para outra conta (seguindo o encapsulamento)
    public boolean transferir(ContaBancaria destino, double valor) {
        if (this.sacar(valor)) { // Se o saque for bem-sucedido
            destino.depositar(valor);
            registrarTransacao("Transferência de R$ " + valor + " para " + destino.getTitular());
            return true;
        }
        return false;
    }

    // Método público para exibir o histórico de transações
    public void exibirHistorico() {
        System.out.println("\n📜 Histórico de transações da conta de " + titular + ":");
        for (String transacao : transacoes) {
            System.out.println(" - " + transacao);
        }
    }
}

// Classe principal para testes
// public class Main {
//     public static void main(String[] args) {
//         // Criando duas contas bancárias
//         ContaBancaria conta1 = new ContaBancaria("João", 500);
//         ContaBancaria conta2 = new ContaBancaria("Maria", 300);

//         // Realizando operações bancárias
//         conta1.depositar(200);
//         conta1.sacar(100);
//         conta1.transferir(conta2, 250);

//         // Alterando titular da conta
//         conta1.setTitular("João Silva");

//         // Exibindo histórico de transações
//         conta1.exibirHistorico();
//         conta2.exibirHistorico();
//     }
// }