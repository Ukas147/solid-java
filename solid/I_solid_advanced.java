import java.util.List;

// ✅ Criamos interfaces menores para segregar responsabilidades
interface Trabalhavel {
    double calcularSalario();
}

interface Beneficiavel {
    void receberBeneficios();
}

interface Registravel {
    void registrarPonto();
}

interface Supervisionavel {
    void definirSupervisor(String supervisor);
}

// ✅ Funcionário CLT -> Implementa todas as interfaces necessárias
class FuncionarioCLT implements Trabalhavel, Beneficiavel, Registravel, Supervisionavel {
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

// ✅ Funcionário PJ -> Implementa apenas o que faz sentido para ele
class FuncionarioPJ implements Trabalhavel {
    private double valorContrato;

    public FuncionarioPJ(double valorContrato) {
        this.valorContrato = valorContrato;
    }

    @Override
    public double calcularSalario() {
        return valorContrato;
    }
}

// ✅ Estagiário -> Tem supervisor, ponto e benefícios, mas salário reduzido
class Estagiario implements Trabalhavel, Beneficiavel, Registravel, Supervisionavel {
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