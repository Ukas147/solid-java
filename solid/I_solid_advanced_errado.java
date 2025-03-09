import java.util.List;

// ❌ INTERFACE ÚNICA OBRIGANDO TODOS OS FUNCIONÁRIOS A IMPLEMENTAR MÉTODOS INÚTEIS
interface Funcionario {
    double calcularSalario();
    void receberBeneficios();
    void registrarPonto();
    void definirSupervisor(String supervisor);
}

// ❌ Funcionário CLT -> Ele realmente usa todos os métodos, então faz sentido
class FuncionarioCLT implements Funcionario {
    private double salario;
    private String supervisor;

    public FuncionarioCLT(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public void receberBeneficios() {
        System.out.println("📦 Funcionário CLT recebendo benefícios!");
    }

    @Override
    public void registrarPonto() {
        System.out.println("⏰ Funcionário CLT registrando ponto!");
    }

    @Override
    public void definirSupervisor(String supervisor) {
        this.supervisor = supervisor;
        System.out.println("🧑‍💼 Supervisor definido: " + supervisor);
    }
}

// ❌ Funcionário PJ -> NÃO RECEBE BENEFÍCIOS, mas é obrigado a implementar esse método!
class FuncionarioPJ implements Funcionario {
    private double valorContrato;

    public FuncionarioPJ(double valorContrato) {
        this.valorContrato = valorContrato;
    }

    @Override
    public double calcularSalario() {
        return valorContrato;
    }

    @Override
    public void receberBeneficios() {
        throw new UnsupportedOperationException("❌ Funcionário PJ não recebe benefícios!");
    }

    @Override
    public void registrarPonto() {
        throw new UnsupportedOperationException("❌ Funcionário PJ não registra ponto!");
    }

    @Override
    public void definirSupervisor(String supervisor) {
        System.out.println("🧑‍💻 Funcionário PJ não tem supervisor, mas recebeu um nome: " + supervisor);
    }
}

// ❌ Estagiário -> NÃO TEM SALÁRIO COMPLETO, mas é obrigado a implementar cálculo de salário!
class Estagiario implements Funcionario {
    private double bolsaAuxilio;
    private String supervisor;

    public Estagiario(double bolsaAuxilio) {
        this.bolsaAuxilio = bolsaAuxilio;
    }

    @Override
    public double calcularSalario() {
        return bolsaAuxilio;
    }

    @Override
    public void receberBeneficios() {
        System.out.println("🎓 Estagiário recebe vale-transporte e bolsa auxílio.");
    }

    @Override
    public void registrarPonto() {
        System.out.println("⏳ Estagiário registrando ponto, mas tem horário reduzido!");
    }

    @Override
    public void definirSupervisor(String supervisor) {
        this.supervisor = supervisor;
        System.out.println("🎓 Supervisor do estagiário definido: " + supervisor);
    }
}

// ❌ Código principal esperando que todos os funcionários funcionem do mesmo jeito
// public class Main {
//     public static void main(String[] args) {
//         List<Funcionario> funcionarios = List.of(
//                 new FuncionarioCLT(5000),
//                 new FuncionarioPJ(7000),
//                 new Estagiario(1500)
//         );

//         for (Funcionario f : funcionarios) {
//             System.out.println("💼 Processando funcionário...");

//             try {
//                 f.registrarPonto();
//                 f.receberBeneficios();
//                 f.definirSupervisor("Carlos");
//                 System.out.println("💰 Salário: R$ " + f.calcularSalario());
//             } catch (UnsupportedOperationException e) {
//                 System.out.println("🚨 ERRO: " + e.getMessage());
//             }

//             System.out.println("----------------------------");
//         }
//     }
// }