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