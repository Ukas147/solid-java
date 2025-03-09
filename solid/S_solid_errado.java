/**
 * 🚨 Violação do Princípio da Responsabilidade Única (SRP - Single Responsibility Principle)
 *
 * Esta classe `RoboBaguncado` está violando o SRP, pois tem **múltiplas responsabilidades** 
 * dentro de uma única classe. Segundo o SRP, uma classe deve ter apenas **uma razão para mudar**, 
 * mas aqui temos várias funções independentes agrupadas em um só lugar.
 *
 * 🔴 **Problemas dessa abordagem:**
 * 1️⃣ **Dificuldade de manutenção**: Se quisermos modificar apenas um comportamento, 
 *     como a forma de tocar música, seremos obrigados a alterar uma classe que também 
 *     contém lógica de limpeza, cozinha e cuidado com animais.
 *
 * 2️⃣ **Baixa reutilização**: Não podemos usar o robô apenas para limpar ou apenas para cozinhar 
 *     sem carregar funcionalidades desnecessárias, tornando o código menos modular.
 *
 * 3️⃣ **Dificuldade de expansão**: Se quisermos adicionar novas funcionalidades, como um robô 
 *     de segurança, teríamos que modificar essa mesma classe, quebrando o Princípio Aberto/Fechado (OCP).
 *
 * 4️⃣ **Baixa coesão e alto acoplamento**: As responsabilidades dentro dessa classe são 
 *     muito distintas e sem relação direta, tornando o código difícil de entender e manter.
 *
 * 🔹 **Solução correta:**
 *    - Criar classes separadas para cada funcionalidade (`RoboFaxineiro`, `RoboCozinheiro`, `RoboPet`, `RoboDJ`).
 *    - Utilizar **composição** para reunir esses robôs dentro de uma classe `Casa`, que coordena as tarefas.
 */

 class RoboBaguncado {
    void limparCasa() {
        System.out.println("Limpando a casa...");
    }

    void cozinhar() {
        System.out.println("Cozinhando comida...");
    }

    void cuidarDoCachorro() {
        System.out.println("Dando comida para o cachorro...");
    }

    void tocarMusica() {
        System.out.println("Tocando música...");
    }
}