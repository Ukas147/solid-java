/**
 * 🚨 Problema: Violação do Princípio da Inversão de Dependência (DIP - Dependency Inversion Principle)
 *
 * O código abaixo **viola o DIP**, pois o `VideoGame` **depende diretamente da implementação concreta** `ControleXbox`
 * em vez de depender de uma abstração (interface).
 *
 * O DIP afirma que:
 * 1️⃣ **Módulos de alto nível (ex: `VideoGame`) não devem depender de módulos de baixo nível (`ControleXbox`).**
 * 2️⃣ **Ambos devem depender de abstrações (interfaces).**
 *
 * 🔴 **Problemas encontrados:**
 * 1️⃣ **Acoplamento alto** → Se quisermos suportar outros controles (ex: `ControlePlayStation`, `ControleNintendo`),
 *    precisaríamos modificar o código do `VideoGame`, tornando a classe rígida e difícil de expandir.
 *
 * 2️⃣ **Código pouco flexível** → O `VideoGame` **só funciona com `ControleXbox`**. Se quisermos adicionar outro controle,
 *    precisaríamos reescrever o código do videogame.
 *
 * 3️⃣ **Dificuldade de manutenção** → Se `ControleXbox` for modificado, o `VideoGame` pode ser impactado diretamente.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se quisermos suportar um novo controle (ex: `ControlePlayStation`), precisaríamos modificar `VideoGame`.
 *    - Isso tornaria o código mais rígido e difícil de reutilizar.
 */
 
// ❌ O videogame depende diretamente do ControleXbox
class ControleXbox {
  void pressionarBotao() {
      System.out.println("🎮 Botão pressionado no Controle Xbox!");
  }
}

class VideoGame {
  private ControleXbox controle; // ⚠️ O videogame depende diretamente de um controle específico!

  VideoGame(ControleXbox controle) {
      this.controle = controle;
  }

  void jogar() {
      controle.pressionarBotao();
  }
}

// 🏡 Testando o videogame
// public class Main {
//     public static void main(String[] args) {
//         ControleXbox controle = new ControleXbox();
//         VideoGame videogame = new VideoGame(controle);
//         videogame.jogar(); // Funciona só com Controle Xbox
//     }
// }