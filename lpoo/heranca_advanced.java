/**
 * Herança, Abstração e Polimorfismo em Java
 *
 * Este código demonstra três conceitos fundamentais da Programação Orientada a Objetos (POO):
 * 
 * 🔹 **Herança**: Permite que uma classe (subclasse) herde atributos e métodos de outra classe (superclasse),
 *     promovendo reutilização de código.
 * 🔹 **Abstração**: A superclasse `Pessoa` é **abstrata**, ou seja, não pode ser instanciada diretamente,
 *     forçando suas subclasses a implementarem o método `exibirInformacoes()`.
 * 🔹 **Polimorfismo**: Objetos da classe `Funcionario` e `Gerente` podem ser armazenados e manipulados 
 *     usando uma referência do tipo `Pessoa`, permitindo flexibilidade no código.
 *
 * Estrutura:
 * - `Pessoa` (superclasse abstrata) → `Funcionario` (subclasse concreta) → `Gerente` (especialização de Funcionario)
 * - `Gerente` possui uma **associação** com `Funcionario` (composição), pois pode ter uma equipe de funcionários.
 * - A classe `Main` instancia os objetos e demonstra o uso de herança, polimorfismo e sobrescrita de métodos.
 */

 import java.util.ArrayList;
 import java.util.List;
 
 // 🔹 Superclasse abstrata (não pode ser instanciada diretamente)
 abstract class Pessoa {
     protected String nome;
     protected int idade;
 
     // Construtor
     public Pessoa(String nome, int idade) {
         this.nome = nome;
         this.idade = idade;
     }
 
     // Método abstrato (cada subclasse deve implementar)
     abstract void exibirInformacoes();
 }
 
 // 🔹 Subclasse Funcionario que herda de Pessoa
 class Funcionario extends Pessoa {
     protected double salario;
 
     // Construtor usando super para herdar nome e idade
     public Funcionario(String nome, int idade, double salario) {
         super(nome, idade);
         this.salario = salario;
     }
 
     // Método que pode ser sobrescrito nas subclasses
     public void trabalhar() {
         System.out.println(nome + " está trabalhando...");
     }
 
     // Sobrescrevendo o método abstrato de Pessoa
     @Override
     void exibirInformacoes() {
         System.out.println("Funcionário: " + nome + ", Idade: " + idade + ", Salário: R$" + salario);
     }
 }
 
 // 🔹 Subclasse Gerente que herda de Funcionario
 class Gerente extends Funcionario {
     private List<Funcionario> equipe; // Gerente tem uma equipe de funcionários
 
     // Construtor
     public Gerente(String nome, int idade, double salario) {
         super(nome, idade, salario);
         this.equipe = new ArrayList<>();
     }
 
     // Método para adicionar funcionário à equipe
     public void adicionarFuncionario(Funcionario f) {
         equipe.add(f);
         System.out.println(f.nome + " foi adicionado à equipe de " + nome);
     }
 
     // Sobrescrevendo método para diferenciar gerente
     @Override
     public void trabalhar() {
         System.out.println(nome + " está gerenciando a equipe!");
     }
 
     // Sobrescrevendo exibirInformacoes para mostrar equipe
     @Override
     void exibirInformacoes() {
         System.out.println("🔹 Gerente: " + nome + ", Idade: " + idade + ", Salário: R$" + salario);
         System.out.println("Equipe: ");
         for (Funcionario f : equipe) {
             System.out.println("   - " + f.nome);
         }
     }
 }
 
 // 🔹 Classe principal (Main)
//  public class Main {
//      public static void main(String[] args) {
//          // Criando funcionários e gerente
//          Funcionario f1 = new Funcionario("Carlos", 30, 3000);
//          Funcionario f2 = new Funcionario("Ana", 28, 3200);
//          Gerente g1 = new Gerente("Roberto", 40, 7000);
 
//          // Adicionando funcionários à equipe do gerente
//          g1.adicionarFuncionario(f1);
//          g1.adicionarFuncionario(f2);
 
//          // Criando lista de funcionários genérica (exemplo de polimorfismo)
//          List<Pessoa> pessoas = new ArrayList<>();
//          pessoas.add(f1);
//          pessoas.add(f2);
//          pessoas.add(g1);
 
//          // Exibindo informações de todos
//          System.out.println("\n📌 Lista de Funcionários:");
//          for (Pessoa p : pessoas) {
//              p.exibirInformacoes();
//              System.out.println("-------------------");
//          }
 
//          // Testando métodos de trabalho
//          f1.trabalhar();
//          f2.trabalhar();
//          g1.trabalhar();
//      }
//  } 