/**
 * 🎯 Aplicação dos Princípios SOLID: Abstração, Herança, Polimorfismo e OCP (Open/Closed Principle)
 *
 * Este código implementa um sistema de pedidos de um restaurante usando **Abstração, Herança e Polimorfismo**.
 * Ele também respeita o **Princípio Aberto/Fechado (OCP - Open/Closed Principle)**, permitindo a expansão sem modificações na classe `Restaurante`.
 *
 * 🔹 **Como funciona?**
 *    - `Lanche` é uma classe **abstrata**, definindo o método `preparar()`, que será implementado por subclasses.
 *    - Cada lanche (`Hamburguer`, `CachorroQuente`, `Pizza`, `BatataFrita`) **herda de `Lanche`** e tem seu próprio comportamento.
 *    - O **Polimorfismo** permite que `Restaurante` aceite qualquer `Lanche`, sem precisar saber sua implementação exata.
 *
 * 🔹 **Benefícios dessa abordagem:**
 * 1️⃣ **Aberto para expansão, fechado para modificação (OCP)**  
 *     - Podemos adicionar novos lanches (`BatataFrita`, `Taco`, etc.) **sem modificar o código do Restaurante**.
 *
 * 2️⃣ **Código mais flexível e reutilizável**  
 *     - `Restaurante` **não depende de tipos específicos de lanche**, tornando o sistema mais modular.
 *
 * 3️⃣ **Facilidade de manutenção**  
 *     - Se um novo tipo de lanche for criado, **não precisamos modificar `Restaurante`** – basta criar uma nova classe que herde `Lanche`.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se o restaurante dependesse diretamente de `Hamburguer`, `Pizza`, etc., teríamos que modificar a classe `Restaurante` toda vez que um novo lanche fosse adicionado.
 *    - Isso quebraria o **OCP**, tornando o código rígido e difícil de manter.
 */

 // 🎯 Classe base para qualquer lanche
 abstract class Lanche {
  abstract void preparar();
}

// ✅ Cada lanche extende a classe Lanche e tem seu próprio método de preparo
class Hamburguer extends Lanche {
  void preparar() {
      System.out.println("🍔 Preparando um hambúrguer!");
  }
}

class CachorroQuente extends Lanche {
  void preparar() {
      System.out.println("🌭 Preparando um cachorro-quente!");
  }
}

class Pizza extends Lanche {
  void preparar() {
      System.out.println("🍕 Preparando uma pizza!");
  }
}

// ✅ Um novo lanche pode ser adicionado SEM modificar a classe Restaurante!
class BatataFrita extends Lanche {
  void preparar() {
      System.out.println("🍟 Preparando batata-frita!");
  }
}

// ✅ O restaurante agora trabalha com qualquer lanche, sem precisar modificar código
class Restaurante {
  void fazerLanche(Lanche lanche) {
      lanche.preparar();
  }
}

// 🏡 Testando o restaurante
// public class Main {
//   public static void main(String[] args) {
//       Restaurante restaurante = new Restaurante();

//       // Criamos os lanches e passamos para o restaurante
//       restaurante.fazerLanche(new Hamburguer());
//       restaurante.fazerLanche(new CachorroQuente());
//       restaurante.fazerLanche(new Pizza());

//       // ✅ Agora podemos adicionar novos lanches sem modificar a classe Restaurante!
//       restaurante.fazerLanche(new BatataFrita());
//   }
// }