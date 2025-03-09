class Restaurante {
  void fazerLanche(String tipo) {
      if (tipo.equals("hamburguer")) {
          System.out.println("🍔 Fazendo um hambúrguer!");
      } else if (tipo.equals("cachorro-quente")) {
          System.out.println("🌭 Fazendo um cachorro-quente!");
      } else if (tipo.equals("pizza")) {
          System.out.println("🍕 Fazendo uma pizza!");
      } else {
          System.out.println("❌ Esse lanche não está no cardápio!");
      }
  }
}

// 🏡 Testando o restaurante
// public class Main {
//   public static void main(String[] args) {
//       Restaurante restaurante = new Restaurante();
//       restaurante.fazerLanche("hamburguer");
//       restaurante.fazerLanche("cachorro-quente");
//       restaurante.fazerLanche("pizza");

//       // ⚠ Se quisermos adicionar um novo lanche, PRECISAMOS MODIFICAR a classe Restaurante!
//       restaurante.fazerLanche("batata-frita");
//   }
// }