/**
 * Polimorfismo e Sobrescrita de Métodos em Java
 *
 * O **polimorfismo** é um dos pilares da Programação Orientada a Objetos (POO) e permite que 
 * um mesmo método tenha diferentes comportamentos dependendo da classe que o implementa.
 *
 * 🔹 **Sobrescrita de métodos (@Override)**:
 *    - O método `fazerSom()` é declarado na superclasse `Animal` e sobrescrito nas subclasses `Cachorro` e `Gato`.
 *    - Cada subclasse implementa sua própria versão do método, tornando o comportamento específico para cada tipo de animal.
 *
 * 🔹 **Polimorfismo em ação**:
 *    - Objetos `Cachorro` e `Gato` são tratados como `Animal`, mas executam métodos próprios.
 *    - Isso permite maior flexibilidade e reutilização de código.
 *
 * No exemplo abaixo, criamos objetos das subclasses usando referências da superclasse `Animal`.
 * Quando chamamos `fazerSom()`, cada objeto executa sua própria versão do método, demonstrando **polimorfismo dinâmico**.
 */

// Superclasse
class Animal {
  void fazerSom() {
      System.out.println("O animal faz um som.");
  }
}

// Subclasse Cachorro que sobrescreve o método fazerSom
class Cachorro extends Animal {
  @Override
  void fazerSom() {
      System.out.println("O cachorro late: Au Au!");
  }
}

// Subclasse Gato que sobrescreve o método fazerSom
class Gato extends Animal {
  @Override
  void fazerSom() {
      System.out.println("O gato mia: Miau!");
  }
}

// Classe principal (Main)
// public class Main {
//   public static void main(String[] args) {
//       // Criando objetos das subclasses usando polimorfismo
//       Animal meuAnimal1 = new Cachorro();
//       Animal meuAnimal2 = new Gato();

//       // Chamando o mesmo método, mas cada objeto executa de forma diferente
//       meuAnimal1.fazerSom(); // "O cachorro late: Au Au!"
//       meuAnimal2.fazerSom(); // "O gato mia: Miau!"
//   }
// }