/**
 * 🎯 Aplicação do Princípio da Responsabilidade Única (SRP - Single Responsibility Principle)
 *
 * Este código implementa um sistema de **gestão de uma clínica médica**, utilizando a **modularização** e o **Princípio da Responsabilidade Única (SRP)**.
 * Cada classe é responsável por **apenas uma funcionalidade**, tornando o código mais **organizado, fácil de manter e escalável**.
 *
 * 🔹 **O que foi feito corretamente aqui?**
 *    - **GerenciadorPacientes** → Gerencia apenas os pacientes.
 *    - **GerenciadorConsultas** → Controla apenas o agendamento e cancelamento de consultas.
 *    - **GerenciadorPagamentos** → Processa e calcula pagamentos.
 *    - **GeradorRelatorios** → Gera relatórios de pacientes e finanças.
 *
 * 🔹 **Benefícios dessa abordagem**:
 * 1️⃣ **Alta coesão e baixo acoplamento**  
 *     - Cada classe tem uma **única responsabilidade**, tornando o código mais **modular e reutilizável**.
 *
 * 2️⃣ **Facilidade de manutenção**  
 *     - Se for necessário modificar a lógica de pagamentos, **basta alterar `GerenciadorPagamentos`** sem impactar outras partes do código.
 *
 * 3️⃣ **Código mais testável**  
 *     - Podemos testar individualmente cada classe, sem interferência de funcionalidades não relacionadas.
 *
 * 4️⃣ **Facilidade de expansão**  
 *     - Se precisarmos adicionar uma nova funcionalidade (como um sistema de prontuário médico), podemos criar uma nova classe **sem modificar o código existente**.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se todas essas funcionalidades estivessem em uma única classe `Clinica`, ela ficaria **inchada, difícil de modificar e propensa a erros**.
 *    - O sistema perderia flexibilidade, dificultando **adicionar novas funcionalidades** sem afetar as existentes.
 */

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
 
 // ✅ CLASSE PACIENTE (Representação dos pacientes no sistema)
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
 
 // 🏡 Testando o sistema da clínica (agora modularizado!)
//  public class Main {
//      public static void main(String[] args) {
//          GerenciadorPacientes gerenciadorPacientes = new GerenciadorPacientes();
//          GerenciadorConsultas gerenciadorConsultas = new GerenciadorConsultas();
//          GerenciadorPagamentos gerenciadorPagamentos = new GerenciadorPagamentos();
//          GeradorRelatorios geradorRelatorios = new GeradorRelatorios();
 
//          gerenciadorPacientes.cadastrarPaciente("Carlos Silva", "123.456.789-00", "11999999999");
//          gerenciadorConsultas.marcarConsulta("Carlos Silva", "10/04/2024");
//          gerenciadorPagamentos.processarPagamento("Carlos Silva", 250);
 
//          geradorRelatorios.gerarRelatorioPacientes(gerenciadorPacientes.getPacientes());
//          geradorRelatorios.gerarRelatorioFinanceiro(gerenciadorPagamentos);
         
//          gerenciadorConsultas.cancelarConsulta("Carlos Silva", "10/04/2024");
//      }
//  } 