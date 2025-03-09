/**
 * 🚀 Aplicação correta do Princípio da Inversão de Dependência (DIP - Dependency Inversion Principle)
 *
 * O código abaixo implementa corretamente **o DIP**, garantindo que **o videogame depende de uma abstração (interface Controle)**
 * e **não de implementações concretas**.
 *
 * O DIP afirma que:
 * 1️⃣ **Módulos de alto nível (ex: VideoGame)** **não devem depender** de módulos de baixo nível (ex: ControleXbox, ControlePlayStation).
 * 2️⃣ **Ambos devem depender de abstrações** (ex: `Controle`).
 *
 * 🔹 **O que foi corrigido aqui?**
 *    - Criamos **a interface `Controle`**, garantindo que o `VideoGame` **não dependa de um controle específico**.
 *    - Agora podemos **adicionar novos controles** sem modificar o código do `VideoGame`.
 *
 * 🔹 **Benefícios dessa abordagem:**
 * 1️⃣ **Respeito ao DIP**  
 *     - O `VideoGame` pode aceitar qualquer controle **sem precisar conhecer sua implementação**.
 *     - Se criarmos um `ControleBluetooth`, **não precisamos modificar o `VideoGame`**.
 *
 * 2️⃣ **Código modular e reutilizável**  
 *     - Se precisarmos suportar um novo controle (ex: `ControleSteam`), basta criar uma nova classe sem alterar código existente.
 *
 * 3️⃣ **Baixo acoplamento**  
 *     - O `VideoGame` só sabe que existe um `Controle`, sem precisar saber detalhes de implementação.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se `VideoGame` dependesse diretamente de `ControleXbox`, `ControlePlayStation` e `ControleNintendo`,
 *      precisaríamos modificar o código toda vez que um novo controle fosse adicionado.
 *    - Isso tornaria o sistema rígido e difícil de expandir.
 */

 // 🎯 Criamos uma INTERFACE para que o videogame dependa de uma abstração, e não de um controle específico
 interface Controle {
  void pressionarBotao();
}

// ✅ Diferentes tipos de controle implementam a interface
class ControleXbox implements Controle {
  public void pressionarBotao() {
      System.out.println("🎮 Botão pressionado no Controle Xbox!");
  }
}

class ControlePlayStation implements Controle {
  public void pressionarBotao() {
      System.out.println("🎮 Botão pressionado no Controle PlayStation!");
  }
}

class ControleNintendo implements Controle {
  public void pressionarBotao() {
      System.out.println("🎮 Botão pressionado no Controle Nintendo!");
  }
}

// ✅ O videogame agora depende da **interface Controle**, e não de um controle específico!
class VideoGame {
  private Controle controle;

  // Agora o videogame pode receber QUALQUER CONTROLE que implemente a interface Controle!
  VideoGame(Controle controle) {
      this.controle = controle;
  }

  void jogar() {
      controle.pressionarBotao();
  }
}

// 🏡 Testando o videogame
// public class Main {
//   public static void main(String[] args) {
//       // Podemos escolher qualquer controle sem mudar o código do videogame!
//       Controle controleXbox = new ControleXbox();
//       Controle controlePlayStation = new ControlePlayStation();
//       Controle controleNintendo = new ControleNintendo();

//       System.out.println("\n🎮 Jogando com Controle Xbox:");
//       VideoGame videogame1 = new VideoGame(controleXbox);
//       videogame1.jogar();

//       System.out.println("\n🎮 Jogando com Controle PlayStation:");
//       VideoGame videogame2 = new VideoGame(controlePlayStation);
//       videogame2.jogar();

//       System.out.println("\n🎮 Jogando com Controle Nintendo:");
//       VideoGame videogame3 = new VideoGame(controleNintendo);
//       videogame3.jogar();
//   }
// }