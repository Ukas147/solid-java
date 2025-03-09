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
//   public static void main(String[] args) {
//       ControleXbox controle = new ControleXbox();
//       VideoGame videogame = new VideoGame(controle);
//       videogame.jogar(); // Funciona só com Controle Xbox
//   }
// }