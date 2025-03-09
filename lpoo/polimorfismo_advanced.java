interface Imprimivel {
    void imprimirRecibo();
}

// 🔹 Classe abstrata base (superclasse)
abstract class Pagamento implements Imprimivel {
    protected double valor;

    // Construtor
    public Pagamento(double valor) {
        this.valor = valor;
    }

    // Método abstrato (sobrescrito nas subclasses)
    public abstract void processarPagamento();

    // Método sobrescrito da interface
    @Override
    public void imprimirRecibo() {
        System.out.println("Recibo: Pagamento de R$ " + valor);
    }
}

// 🔹 Subclasse de pagamento com cartão
class PagamentoCartao extends Pagamento {
    private String numeroCartao;

    public PagamentoCartao(double valor, String numeroCartao) {
        super(valor);
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento de R$ " + valor + " via cartão: " + numeroCartao);
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Recibo: Pagamento de R$ " + valor + " realizado com cartão: " + numeroCartao);
    }

    // Sobrecarga: Processamento com taxa extra
    public void processarPagamento(double taxa) {
        double total = valor + taxa;
        System.out.println("Pagamento via cartão com taxa de R$ " + taxa + ". Total: R$ " + total);
    }
}

// 🔹 Subclasse de pagamento via Pix
class PagamentoPix extends Pagamento {
    private String chavePix;

    public PagamentoPix(double valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento de R$ " + valor + " via Pix para chave: " + chavePix);
    }

    @Override
    public void imprimirRecibo() {
        System.out.println("Recibo: Pagamento de R$ " + valor + " via Pix para chave: " + chavePix);
    }
}

// 🔹 Classe principal (Main)
// public class Main {
//     public static void main(String[] args) {
//         // Criando lista de pagamentos polimórficos
//         List<Pagamento> pagamentos = new ArrayList<>();

//         pagamentos.add(new PagamentoCartao(150.0, "1234-5678-9012-3456"));
//         pagamentos.add(new PagamentoPix(75.0, "email@exemplo.com"));
//         pagamentos.add(new PagamentoCartao(200.0, "9876-5432-1098-7654"));

//         // Processando pagamentos de forma genérica
//         System.out.println("\n📌 Processando pagamentos...");
//         for (Pagamento p : pagamentos) {
//             p.processarPagamento();
//         }

//         // Exibindo recibos polimorficamente
//         System.out.println("\n📌 Imprimindo recibos...");
//         for (Imprimivel i : pagamentos) {
//             i.imprimirRecibo();
//         }

//         // Exemplo de uso do instanceof para polimorfismo dinâmico
//         System.out.println("\n📌 Verificando tipos de pagamento...");
//         for (Pagamento p : pagamentos) {
//             if (p instanceof PagamentoCartao) {
//                 System.out.println("🔹 Esse pagamento foi feito com Cartão.");
//             } else if (p instanceof PagamentoPix) {
//                 System.out.println("🔹 Esse pagamento foi feito com Pix.");
//             }
//         }

//         // Chamando método sobrecarregado para pagamento com taxa
//         System.out.println("\n📌 Pagamento com taxa...");
//         PagamentoCartao pagamentoEspecial = new PagamentoCartao(500.0, "4321-8765-2109-6543");
//         pagamentoEspecial.processarPagamento(10.0); // Chama o método sobrecarregado
//     }
// }