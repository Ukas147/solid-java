/**
 * 🚨 Problema: Violação do Princípio da Substituição de Liskov (LSP - Liskov Substitution Principle)
 *
 * Este código **viola o LSP**, pois `CarroEletrico` herda de `Carro`, mas **não pode ser tratado corretamente como um `Carro`**.
 * O LSP diz que **qualquer subclasse deve poder substituir sua superclasse sem alterar o comportamento esperado**.
 *
 * 🔴 **Por que isso é um problema?**
 * 1️⃣ `CarroEletrico` herda o método `abastecer()`, mas **não deveria ter esse método**.
 * 2️⃣ A tentativa de chamar `abastecer()` em `CarroEletrico` **gera uma exceção (`UnsupportedOperationException`)**.
 * 3️⃣ Isso viola o conceito de **Herança Correta**, pois a classe filha (`CarroEletrico`) não pode ser usada corretamente no lugar da classe base (`Carro`).
 *
 * 🔹 **Solução correta**:
 *    - Criar uma **classe base `Carro` mais genérica**, contendo apenas `acelerar()`.
 *    - Criar **duas subclasses específicas**:
 *      - `CarroCombustivel` (com `abastecer()`).
 *      - `CarroEletrico` (com `carregarBateria()`).
 *    - Assim, evitamos que carros elétricos tenham um método que não faz sentido.
 */

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