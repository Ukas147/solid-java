/**
 * Herança em Java
 *
 * A Herança é um dos pilares da Programação Orientada a Objetos (POO) e permite que uma classe (subclasse) 
 * herde atributos e métodos de outra classe (superclasse). Isso promove a reutilização de código e facilita a manutenção.
 *
 * Benefícios da Herança:
 * - Reutilização de código: evita duplicação ao compartilhar atributos e métodos entre classes.
 * - Organização hierárquica: permite criar relações entre classes de forma estruturada.
 * - Extensibilidade: facilita a adição de novas funcionalidades sem modificar código existente.
 *
 * No exemplo abaixo:
 * - A classe `Animal` é a **superclasse** e contém um atributo `nome` e um método `comer()`.
 * - A classe `Cachorro` é uma **subclasse** que herda de `Animal` e possui um método adicional `latir()`.
 * - O objeto `dog` da classe `Cachorro` pode acessar atributos e métodos da superclasse `Animal`.
 */

 // Superclasse (classe mãe)
 class Animal {
  String nome; // Atributo comum para todos os animais

  // Método comum que pode ser utilizado por todas as subclasses
  void comer() {
      System.out.println(nome + " está comendo.");
  }
}

// Subclasse (classe filha) que herda de Animal
class Cachorro extends Animal {
  // Método específico da classe Cachorro
  void latir() {
      System.out.println(nome + " está latindo: Au Au!");
  }
}

// Classe principal contendo o método main
// public class Main {
//   public static void main(String[] args) {
//       // Criando um objeto da subclasse Cachorro
//       Cachorro dog = new Cachorro();
//       dog.nome = "Rex"; // Atributo herdado da classe Animal
//       dog.comer(); // Método herdado da classe Animal
//       dog.latir(); // Método próprio da classe Cachorro
//   }
// }