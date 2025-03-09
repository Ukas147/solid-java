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