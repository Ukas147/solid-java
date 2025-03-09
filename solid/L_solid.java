// 🎯 Classe base correta: Agora TODOS os carros podem acelerar, mas abastecer é específico!
abstract class Carro {
  abstract void acelerar();
}

// 🚗 Carros que usam gasolina
abstract class CarroCombustivel extends Carro {
  abstract void abastecer();
}

// ⚡ Carros elétricos que carregam a bateria
abstract class CarroEletrico extends Carro {
  abstract void carregarBateria();
}

// 🏎️ Carro de corrida usa gasolina
class CarroFormula1 extends CarroCombustivel {
  void acelerar() {
      System.out.println("🏎️ O carro de Fórmula 1 está acelerando SUPER RÁPIDO!");
  }

  void abastecer() {
      System.out.println("⛽ Abastecendo o carro de Fórmula 1 com gasolina!");
  }
}

// 🚙 Carro normal também usa gasolina
class CarroNormal extends CarroCombustivel {
  void acelerar() {
      System.out.println("🚙 O carro normal está acelerando!");
  }

  void abastecer() {
      System.out.println("⛽ Abastecendo o carro normal com gasolina!");
  }
}

// ⚡ Carro elétrico agora tem o método correto!
class CarroTesla extends CarroEletrico {
  void acelerar() {
      System.out.println("⚡ O carro Tesla está acelerando silenciosamente!");
  }

  void carregarBateria() {
      System.out.println("🔋 Carregando a bateria do Tesla!");
  }
}

// 🎮 Simulador de corrida
class Corrida {
  static void iniciarCorrida(Carro carro) {
      carro.acelerar();
  }
}

// 🏁 Testando a corrida
// public class Main {
//   public static void main(String[] args) {
//       System.out.println("🏎️ Corrida começando!");

//       Corrida.iniciarCorrida(new CarroFormula1());  // ✅ Ok
//       Corrida.iniciarCorrida(new CarroNormal());    // ✅ Ok
//       Corrida.iniciarCorrida(new CarroTesla());     // ✅ Ok

//       System.out.println("\n🔋 Carregando o carro elétrico...");
//       CarroTesla meuTesla = new CarroTesla();
//       meuTesla.carregarBateria(); // ✅ Agora tudo funciona direitinho!
//   }
// }