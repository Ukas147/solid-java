/**
 * Interfaces, Herança, Composição, Agregação, Associação, Exceções, Singleton e Outros Padrões em Java
 *
 * Este código demonstra uma implementação completa de um sistema de Zoológico utilizando conceitos avançados da POO.
 *
 * 🔹 **Interface (`Animal`)**:
 *    - Define um contrato para todos os animais do zoológico.
 *
 * 🔹 **Herança e Abstração (`Mamifero`)**:
 *    - `Mamifero` é uma classe abstrata que implementa `Animal` e define métodos adicionais como `respirar()` e `amamentar()`.
 *    - `Cachorro` é uma subclasse concreta que sobrescreve `fazerSom()` e `mover()`.
 *
 * 🔹 **Composição (`Setor`)**:
 *    - `Setor` contém uma lista de `Animal`, ou seja, **não pode existir sem o zoológico**.
 *
 * 🔹 **Agregação (`Funcionario`)**:
 *    - `Funcionario` pertence ao zoológico, mas **pode existir sem ele**.
 *
 * 🔹 **Associação (`Veterinario`)**:
 *    - `Veterinario` pode examinar qualquer `Animal`, mas não os possui.
 *
 * 🔹 **Exceções Personalizadas (`SetorNaoEncontradoException`)**:
 *    - Exceção customizada para indicar quando um setor não é encontrado.
 *
 * 🔹 **Singleton (`Zoologico`)**:
 *    - Garante que **apenas um zoológico exista** na aplicação.
 *
 * 🔹 **Try-Catch-Finally (`Zoologico.buscarSetor()`)**:
 *    - Tratamento de erro ao buscar setores inexistentes.
 *
 * 🔹 **Inner Class (`Zoologico.Estatisticas`)**:
 *    - Classe interna para calcular estatísticas do zoológico.
 *
 * 🔹 **Overloading (`Cachorro.fazerSom(int vezes)`)**:
 *    - Método sobrecarregado para permitir latidos múltiplos.
 *
 * O código cria um zoológico, adiciona setores, animais, funcionários e veterinários, e realiza várias operações, demonstrando flexibilidade e boas práticas de design.
 */

 import java.util.ArrayList;
 import java.util.List;
 
 // ✅ Interface: Define o contrato para todos os animais
 interface Animal {
     void fazerSom();
     void mover();
 }
 
 // ✅ Classe abstrata: Define comportamento base para mamíferos
 abstract class Mamifero implements Animal {
     protected String nome;
 
     public Mamifero(String nome) {
         this.nome = nome;
     }
 
     public void respirar() {
         System.out.println(nome + " está respirando.");
     }
 
     public abstract void amamentar();
 }
 
 // ✅ Subclasse concreta Cachorro
 class Cachorro extends Mamifero {
     public Cachorro(String nome) {
         super(nome);
     }
 
     @Override
     public void fazerSom() {
         System.out.println(nome + " late: Au Au!");
     }
 
     @Override
     public void mover() {
         System.out.println(nome + " está correndo!");
     }
 
     @Override
     public void amamentar() {
         System.out.println(nome + " amamenta seus filhotes.");
     }
 
     // ✅ Overloading: Variação do método de latir
     public void fazerSom(int vezes) {
         for (int i = 0; i < vezes; i++) {
             System.out.println(nome + " late: Au Au!");
         }
     }
 }
 
 // ✅ Exceção personalizada para setor inexistente
 class SetorNaoEncontradoException extends Exception {
     public SetorNaoEncontradoException(String mensagem) {
         super(mensagem);
     }
 }
 
 // ✅ Composição: Setor contém uma lista de animais e não pode existir sem o zoológico
 class Setor {
     private String nome;
     private List<Animal> animais = new ArrayList<>();
 
     public Setor(String nome) {
         this.nome = nome;
     }
 
     public void adicionarAnimal(Animal animal) {
         animais.add(animal);
     }
 
     public void listarAnimais() {
         System.out.println("📌 Animais no setor " + nome + ":");
         for (Animal animal : animais) {
             animal.fazerSom();
         }
     }
 }
 
 // ✅ Agregação: Funcionário pode existir sem o zoológico
 class Funcionario {
     private String nome;
 
     public Funcionario(String nome) {
         this.nome = nome;
     }
 
     public void trabalhar() {
         System.out.println(nome + " está trabalhando no zoológico.");
     }
 }
 
 // ✅ Associação: O veterinário apenas examina um animal sem possuí-lo
 class Veterinario {
     private String nome;
 
     public Veterinario(String nome) {
         this.nome = nome;
     }
 
     public void examinarAnimal(Animal animal) {
         System.out.println("🔍 " + nome + " está examinando " + ((Mamifero) animal).nome);
     }
 }
 
 // ✅ Singleton: Apenas um zoológico pode existir
 class Zoologico {
     private static Zoologico instancia;
     private List<Setor> setores = new ArrayList<>();
     private List<Funcionario> funcionarios = new ArrayList<>();
 
     private Zoologico() {}  // Construtor privado
 
     public static Zoologico getInstancia() {
         if (instancia == null) {
             instancia = new Zoologico();
         }
         return instancia;
     }
 
     public void adicionarSetor(Setor setor) {
         setores.add(setor);
     }
 
     public void adicionarFuncionario(Funcionario funcionario) {
         funcionarios.add(funcionario);
     }
 
     // ✅ Try-Catch-Finally: Tratando erro ao buscar setor
     public void buscarSetor(String nome) {
         try {
             for (Setor setor : setores) {
                 if (setor.equals(nome)) {
                     System.out.println("Setor encontrado: " + nome);
                     return;
                 }
             }
             throw new SetorNaoEncontradoException("Erro: Setor não encontrado!");
         } catch (SetorNaoEncontradoException e) {
             System.out.println(e.getMessage());
         } finally {
             System.out.println("Busca finalizada.");
         }
     }
 
     public void listarFuncionarios() {
         System.out.println("\n📌 Funcionários do Zoológico:");
         for (Funcionario f : funcionarios) {
             f.trabalhar();
         }
     }
 
     // ✅ Inner Class: Gerenciador de Estatísticas do Zoológico
     class Estatisticas {
         public void totalAnimais() {
             int total = setores.stream().mapToInt(setor -> setor.animais.size()).sum();
             System.out.println("📊 Total de animais no zoológico: " + total);
         }
     }
 }
 
 // ✅ Classe principal
//  public class Main {
//      public static void main(String[] args) {
//          // Criando instância do zoológico (Singleton)
//          Zoologico zoo = Zoologico.getInstancia();
 
//          // Criando setores (Composição)
//          Setor setorMamiferos = new Setor("Mamíferos");
//          zoo.adicionarSetor(setorMamiferos);
 
//          // Criando animais
//          Cachorro cachorro = new Cachorro("Rex");
 
//          // Adicionando animais ao setor
//          setorMamiferos.adicionarAnimal(cachorro);
 
//          // Criando funcionários (Agregação)
//          Funcionario f1 = new Funcionario("Carlos");
//          zoo.adicionarFuncionario(f1);
 
//          // Criando veterinário (Associação) e examinando um animal
//          Veterinario vet = new Veterinario("Dr. Ana");
//          vet.examinarAnimal(cachorro);
 
//          // Testando métodos de listagem
//          setorMamiferos.listarAnimais();
//          zoo.listarFuncionarios();
 
//          // ✅ Testando Try-Catch-Finally
//          zoo.buscarSetor("Aves");
 
//          // ✅ Testando Overloading
//          cachorro.fazerSom(3);  // Rex late 3 vezes
 
//          // ✅ Usando Inner Class para estatísticas do zoológico
//          Zoologico.Estatisticas stats = zoo.new Estatisticas();
//          stats.totalAnimais();
//      }
//  } 