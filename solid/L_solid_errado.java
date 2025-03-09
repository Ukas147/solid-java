// Classe base de um carro
class Carro {
  void acelerar() {
      System.out.println("O carro está acelerando!");
  }

  void abastecer() {
      System.out.println("Abastecendo com gasolina...");
  }
}

// Carro de corrida (ok, usa gasolina)
class CarroFormula1 extends Carro {
  void acelerar() {
      System.out.println("🏎️ O carro de Fórmula 1 está acelerando SUPER RÁPIDO!");
  }
}

// ❌ Problema: Carro elétrico não usa gasolina, mas herda o método abastecer()!
class CarroEletrico extends Carro {
  void acelerar() {
      System.out.println("⚡ O carro elétrico está acelerando silenciosamente!");
  }

  // ❌ Método herdado que NÃO DEVERIA EXISTIR!
  void abastecer() {
      throw new UnsupportedOperationException("Carro elétrico não usa gasolina!");
  }
}

// Testando a corrida
// public class Main {
//   public static void main(String[] args) {
//       Carro meuCarro = new CarroEletrico();
//       meuCarro.acelerar();
//       meuCarro.abastecer(); // ❌ Vai dar erro!
//   }
// }