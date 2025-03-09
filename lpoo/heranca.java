// Superclasse (classe mãe)
class Animal {
  String nome;

  void comer() {
      System.out.println(nome + " está comendo.");
  }
}

// Subclasse (classe filha) que herda de Animal
class Cachorro extends Animal {
  void latir() {
      System.out.println(nome + " está latindo: Au Au!");
  }
}

// public class Main {
//   public static void main(String[] args) {
//       // Criando um objeto da subclasse Cachorro
//       Cachorro dog = new Cachorro();
//       dog.nome = "Rex"; // Atributo herdado da classe Animal
//       dog.comer(); // Método herdado da classe Animal
//       dog.latir(); // Método próprio da classe Cachorro
//   }
// }