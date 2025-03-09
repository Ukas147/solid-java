/**
 * 🚀 Aplicação correta do Princípio da Substituição de Liskov (LSP - Liskov Substitution Principle)
 *
 * Este código implementa corretamente **herança e polimorfismo**, respeitando o **Princípio da Substituição de Liskov (LSP)**.
 * O LSP garante que qualquer subclasse possa ser substituída por sua classe base **sem quebrar o comportamento esperado**.
 *
 * 🔹 **O que foi corrigido aqui?**
 *    - Criamos a classe abstrata `Carro`, garantindo que TODOS os carros podem **acelerar**.
 *    - Criamos subtipos especializados:
 *      - `CarroCombustivel`: Para carros que precisam de abastecimento.
 *      - `CarroEletrico`: Para carros que precisam carregar bateria.
 *    - Agora um carro **elétrico não pode ser abastecido com gasolina**, evitando erros.
 *
 * 🔹 **Benefícios dessa abordagem:**
 * 1️⃣ **Respeito ao LSP**  
 *     - Qualquer `Carro` pode participar da `Corrida`, pois **todos implementam o método `acelerar()` corretamente**.
 *
 * 2️⃣ **Evita comportamentos inesperados**  
 *     - Se usássemos um carro elétrico em um código que chamasse `abastecer()`, **o código quebraria**.
 *     - Agora, o tipo correto (`CarroEletrico`) define **um método específico `carregarBateria()`**.
 *
 * 3️⃣ **Código mais flexível e reutilizável**  
 *     - Se quisermos adicionar novos tipos de carro (ex: híbridos), podemos fazê-lo sem modificar código existente.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se `Carro` tivesse um método `abastecer()`, **os carros elétricos seriam forçados a implementar um método que não faz sentido**.
 *    - Isso causaria erros e violaria o **LSP**, tornando o código inconsistente.
 */

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