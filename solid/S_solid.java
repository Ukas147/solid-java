// 🤖 Robô que só limpa a casa
class RoboFaxineiro {
    void limparCasa() {
        System.out.println("🧹 Limpando a casa...");
    }
}

// 👨‍🍳 Robô que só cozinha
class RoboCozinheiro {
    void cozinhar() {
        System.out.println("🍳 Cozinhando comida...");
    }
}

// 🐶 Robô que só cuida dos animais
class RoboPet {
    void cuidarDoCachorro() {
        System.out.println("🐕 Dando comida para o cachorro...");
    }
}

// 🎵 Robô que só toca música
class RoboDJ {
    void tocarMusica() {
        System.out.println("🎵 Tocando música...");
    }
}

// 🏡 Casa com vários robôs especializados
class Casa {
    RoboFaxineiro faxineiro = new RoboFaxineiro();
    RoboCozinheiro cozinheiro = new RoboCozinheiro();
    RoboPet pet = new RoboPet();
    RoboDJ dj = new RoboDJ();

    void diaNormal() {
        faxineiro.limparCasa();
        cozinheiro.cozinhar();
        pet.cuidarDoCachorro();
        dj.tocarMusica();
    }
}

// 🏠 Testando os robôs
// public class Main {
//     public static void main(String[] args) {
//         Casa minhaCasa = new Casa();
//         System.out.println("🏡 Um dia normal na casa:");
//         minhaCasa.diaNormal();
//     }
// }