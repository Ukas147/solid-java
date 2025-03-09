import java.util.ArrayList;
import java.util.List;

// ❌ CLASSE MONSTRUOSA QUE FAZ TUDO AO MESMO TEMPO!
class Clinica {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<String> consultas = new ArrayList<>();
    private List<Double> pagamentos = new ArrayList<>();

    // Cadastrar novo paciente
    public void cadastrarPaciente(String nome, String cpf, String telefone) {
        pacientes.add(new Paciente(nome, cpf, telefone));
        System.out.println("🩺 Paciente cadastrado: " + nome);
    }

    // Marcar consulta para um paciente
    public void marcarConsulta(String pacienteNome, String data) {
        consultas.add(pacienteNome + " - " + data);
        System.out.println("📅 Consulta marcada para " + pacienteNome + " na data " + data);
    }

    // Cancelar consulta
    public void cancelarConsulta(String pacienteNome, String data) {
        String consulta = pacienteNome + " - " + data;
        if (consultas.remove(consulta)) {
            System.out.println("❌ Consulta cancelada para " + pacienteNome + " na data " + data);
        } else {
            System.out.println("⚠️ Consulta não encontrada para " + pacienteNome);
        }
    }

    // Processar pagamento de consulta
    public void processarPagamento(String pacienteNome, double valor) {
        pagamentos.add(valor);
        System.out.println("💰 Pagamento de R$" + valor + " processado para " + pacienteNome);
    }

    // Gerar relatório financeiro da clínica
    public void gerarRelatorioFinanceiro() {
        double total = pagamentos.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("📊 Relatório Financeiro: Total arrecadado: R$" + total);
    }

    // Gerar relatório de pacientes
    public void gerarRelatorioPacientes() {
        System.out.println("📋 Lista de Pacientes:");
        for (Paciente p : pacientes) {
            System.out.println("👤 " + p.getNome() + " - CPF: " + p.getCpf());
        }
    }
}

// Classe Paciente para armazenar dados
class Paciente {
    private String nome;
    private String cpf;
    private String telefone;

    public Paciente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

// 🏡 Testando o sistema da clínica (com código ruim)
// public class Main {
//     public static void main(String[] args) {
//         Clinica clinica = new Clinica();

//         clinica.cadastrarPaciente("Carlos Silva", "123.456.789-00", "11999999999");
//         clinica.marcarConsulta("Carlos Silva", "10/04/2024");
//         clinica.processarPagamento("Carlos Silva", 250);
//         clinica.gerarRelatorioPacientes();
//         clinica.gerarRelatorioFinanceiro();
//         clinica.cancelarConsulta("Carlos Silva", "10/04/2024");
//     }
// }