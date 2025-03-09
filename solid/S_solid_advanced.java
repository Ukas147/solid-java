import java.util.ArrayList;
import java.util.List;

// ✅ CLASSE QUE GERENCIA APENAS PACIENTES
class GerenciadorPacientes {
    private List<Paciente> pacientes = new ArrayList<>();

    public void cadastrarPaciente(String nome, String cpf, String telefone) {
        pacientes.add(new Paciente(nome, cpf, telefone));
        System.out.println("🩺 Paciente cadastrado: " + nome);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}

// ✅ CLASSE QUE GERENCIA APENAS CONSULTAS
class GerenciadorConsultas {
    private List<String> consultas = new ArrayList<>();

    public void marcarConsulta(String pacienteNome, String data) {
        consultas.add(pacienteNome + " - " + data);
        System.out.println("📅 Consulta marcada para " + pacienteNome + " na data " + data);
    }

    public void cancelarConsulta(String pacienteNome, String data) {
        String consulta = pacienteNome + " - " + data;
        if (consultas.remove(consulta)) {
            System.out.println("❌ Consulta cancelada para " + pacienteNome + " na data " + data);
        } else {
            System.out.println("⚠️ Consulta não encontrada para " + pacienteNome);
        }
    }
}

// ✅ CLASSE QUE GERENCIA APENAS PAGAMENTOS
class GerenciadorPagamentos {
    private List<Double> pagamentos = new ArrayList<>();

    public void processarPagamento(String pacienteNome, double valor) {
        pagamentos.add(valor);
        System.out.println("💰 Pagamento de R$" + valor + " processado para " + pacienteNome);
    }

    public double calcularTotal() {
        return pagamentos.stream().mapToDouble(Double::doubleValue).sum();
    }
}

// ✅ CLASSE QUE GERA RELATÓRIOS
class GeradorRelatorios {
    public void gerarRelatorioPacientes(List<Paciente> pacientes) {
        System.out.println("📋 Lista de Pacientes:");
        for (Paciente p : pacientes) {
            System.out.println("👤 " + p.getNome() + " - CPF: " + p.getCpf());
        }
    }

    public void gerarRelatorioFinanceiro(GerenciadorPagamentos gerenciadorPagamentos) {
        System.out.println("📊 Relatório Financeiro: Total arrecadado: R$" + gerenciadorPagamentos.calcularTotal());
    }
}

// 🏡 Testando o sistema da clínica (agora modularizado!)
// public class Main {
//     public static void main(String[] args) {
//         GerenciadorPacientes gerenciadorPacientes = new GerenciadorPacientes();
//         GerenciadorConsultas gerenciadorConsultas = new GerenciadorConsultas();
//         GerenciadorPagamentos gerenciadorPagamentos = new GerenciadorPagamentos();
//         GeradorRelatorios geradorRelatorios = new GeradorRelatorios();

//         gerenciadorPacientes.cadastrarPaciente("Carlos Silva", "123.456.789-00", "11999999999");
//         gerenciadorConsultas.marcarConsulta("Carlos Silva", "10/04/2024");
//         gerenciadorPagamentos.processarPagamento("Carlos Silva", 250);

//         geradorRelatorios.gerarRelatorioPacientes(gerenciadorPacientes.getPacientes());
//         geradorRelatorios.gerarRelatorioFinanceiro(gerenciadorPagamentos);
        
//         gerenciadorConsultas.cancelarConsulta("Carlos Silva", "10/04/2024");
//     }
// }