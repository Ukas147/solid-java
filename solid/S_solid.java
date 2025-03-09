/**
 * Composição e Princípio da Responsabilidade Única (SRP) em Java
 *
 * Este código demonstra o uso de **Composição** e o **Princípio da Responsabilidade Única (SRP - Single Responsibility Principle)**
 * para estruturar um sistema de automação residencial com diferentes robôs especializados.
 *
 * 🔹 **Composição (`Casa` possui robôs especializados)**:
 *    - A classe `Casa` contém instâncias de `RoboFaxineiro`, `RoboCozinheiro`, `RoboPet` e `RoboDJ`,
 *      permitindo modularizar as responsabilidades.
 *
 * 🔹 **Princípio da Responsabilidade Única (SRP)**:
 *    - Cada robô possui **apenas uma responsabilidade**, seguindo o conceito de SRP:
 *      - `RoboFaxineiro`: Limpa a casa.
 *      - `RoboCozinheiro`: Cozinha.
 *      - `RoboPet`: Cuida dos animais de estimação.
 *      - `RoboDJ`: Toca música.
 *    - Isso facilita manutenção e expansão do sistema, evitando **classes com múltiplas responsabilidades**.
 *
 * 🔹 **Facilidade de Extensão**:
 *    - Novos robôs podem ser adicionados sem modificar a estrutura existente da `Casa`.
 *
 * O código simula um **dia normal em uma casa automatizada**, chamando as ações de cada robô em `diaNormal()`.
 */

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

// 🏡 Casa com vários robôs especializados (Composição)
class Casa {
    RoboFaxineiro faxineiro = new RoboFaxineiro();
    RoboCozinheiro cozinheiro = new RoboCozinheiro();
    RoboPet pet = new RoboPet();
    RoboDJ dj = new RoboDJ();

    // Simula um dia normal chamando as funções de cada robô
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