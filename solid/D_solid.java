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
