/**
 * 🚀 Aplicação correta do Princípio da Segregação de Interfaces (ISP - Interface Segregation Principle)
 *
 * O código abaixo **implementa corretamente o ISP**, garantindo que cada classe implementa **apenas as interfaces necessárias**.
 * O ISP afirma que **nenhuma classe deve ser forçada a implementar métodos que não utiliza**.
 *
 * 🔹 **O que foi corrigido aqui?**
 *    - Criamos **interfaces menores e mais específicas** (`Trabalhavel`, `Beneficiavel`, `Registravel`, `Supervisionavel`).
 *    - Cada funcionário **implementa apenas as interfaces relevantes**, sem métodos desnecessários.
 *
 * 🔹 **Benefícios dessa abordagem:**
 * 1️⃣ **Respeito ao ISP**  
 *     - `FuncionarioPJ` não implementa `Beneficiavel`, `Registravel` ou `Supervisionavel`, pois **não precisa desses métodos**.
 *     - `FuncionarioCLT` implementa **todas as interfaces relevantes** porque tem contrato formal.
 *     - `Estagiario` também implementa `Registravel` e `Supervisionavel`, pois precisa registrar ponto e tem supervisor.
 *
 * 2️⃣ **Código modular e reutilizável**  
 *     - As interfaces são **pequenas e específicas**, permitindo maior flexibilidade.
 *
 * 3️⃣ **Evita métodos desnecessários**  
 *     - Nenhuma classe precisa sobrescrever métodos que **não fazem sentido para ela**.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se tivéssemos uma única interface grande (`Funcionario` com `calcularSalario()`, `receberBeneficios()`, `registrarPonto()` e `definirSupervisor()`),
 *      todas as classes precisariam implementar **métodos que não fazem sentido para elas**.
 *    - Isso tornaria o código confuso e menos flexível para futuras expansões.
 */
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
 
 // 🏡 Testando o sistema de funcionários
//  public class Main {
//      public static void main(String[] args) {
//          FuncionarioCLT clt = new FuncionarioCLT(5000);
//          FuncionarioPJ pj = new FuncionarioPJ(8000);
//          Estagiario estagiario = new Estagiario(1500);
 
//          System.out.println("\n📌 Funcionário CLT:");
//          clt.calcularSalario();
//          clt.receberBeneficios();
//          clt.registrarPonto();
//          clt.definirSupervisor("Carlos");
 
//          System.out.println("\n📌 Funcionário PJ:");
//          pj.calcularSalario(); // ✅ Só calcula salário, pois não tem benefícios ou ponto
 
//          System.out.println("\n📌 Estagiário:");
//          estagiario.calcularSalario();
//          estagiario.receberBeneficios();
//          estagiario.registrarPonto();
//          estagiario.definirSupervisor("Ana");
//      }
//  } 