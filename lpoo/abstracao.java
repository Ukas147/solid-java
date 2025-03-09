/**
 * Abstração, Herança e Polimorfismo em Java
 *
 * Este código demonstra os princípios fundamentais da Programação Orientada a Objetos (POO):
 *
 * 🔹 **Abstração (`Veiculo`)**:
 *    - A classe `Veiculo` é **abstrata**, o que significa que **não pode ser instanciada diretamente**.
 *    - Contém um método abstrato `mover()`, que **deve ser implementado** por todas as subclasses.
 *
 * 🔹 **Herança**:
 *    - `Carro` e `Bicicleta` são subclasses que herdam da superclasse `Veiculo`.
 *    - Ambas aproveitam o atributo `modelo` e o método `exibirModelo()`, definidos na superclasse.
 *
 * 🔹 **Polimorfismo**:
 *    - Criamos objetos das subclasses (`Carro` e `Bicicleta`) usando referências do tipo `Veiculo`.
 *    - Quando chamamos `mover()`, cada objeto executa sua **própria versão** do método, demonstrando **polimorfismo dinâmico**.
 *
 * O código cria e manipula veículos de forma genérica, permitindo flexibilidade e reutilização.
 */

// Classe abstrata (não pode ser instanciada diretamente)
abstract class Veiculo {
  protected String modelo;

  // Construtor
  public Veiculo(String modelo) {
      this.modelo = modelo;
  }

  // Método abstrato (deve ser implementado pelas subclasses)
  abstract void mover();

  // Método comum (todas as subclasses podem usar)
  public void exibirModelo() {
      System.out.println("Modelo: " + modelo);
  }
}

// Subclasse Carro que herda de Veiculo
class Carro extends Veiculo {
  public Carro(String modelo) {
      super(modelo);
  }

  @Override
  void mover() {
      System.out.println("O carro " + modelo + " está acelerando!");
  }
}

// Subclasse Bicicleta que herda de Veiculo
class Bicicleta extends Veiculo {
  public Bicicleta(String modelo) {
      super(modelo);
  }

  @Override
  void mover() {
      System.out.println("A bicicleta " + modelo + " está pedalando!");
  }
}

// Classe principal (Main)
// public class Main {
//   public static void main(String[] args) {
//       // Criando objetos das subclasses usando polimorfismo
//       Veiculo carro = new Carro("Ferrari");
//       Veiculo bicicleta = new Bicicleta("Caloi");

//       // Chamando os métodos polimórficos
//       carro.mover();       // "O carro Ferrari está acelerando!"
//       bicicleta.mover();   // "A bicicleta Caloi está pedalando!"

//       // Exibindo os modelos
//       carro.exibirModelo();      // "Modelo: Ferrari"
//       bicicleta.exibirModelo();  // "Modelo: Caloi"
//   }
// }