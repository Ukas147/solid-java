/**
 * 🚨 Problemas na Implementação: Violação do Princípio Aberto/Fechado (OCP - Open/Closed Principle)
 *
 * A classe `Restaurante` está violando o **Princípio Aberto/Fechado (OCP)** da Programação Orientada a Objetos.
 * O OCP diz que uma classe deve estar **aberta para extensão, mas fechada para modificação**.
 *
 * 🔴 **Problema principal**:
 * - O método `fazerLanche()` usa **comparações diretas de strings (if/else)** para decidir qual lanche preparar.
 * - Se precisarmos adicionar um novo lanche (`batata-frita`, `taco`), seremos **obrigados a modificar** a classe `Restaurante`.
 * - Isso torna o código **difícil de manter**, pois cada nova funcionalidade exige mudanças diretas na classe principal.
 *
 * 🔴 **Desvantagens dessa abordagem**:
 * 1️⃣ **Baixa escalabilidade**:
 *    - A cada novo lanche, precisamos **modificar e recompilar** `Restaurante`.
 *    - Isso pode gerar bugs e tornar o código cada vez mais difícil de gerenciar.
 *
 * 2️⃣ **Alto acoplamento**:
 *    - `Restaurante` conhece diretamente todas as opções de lanche, o que dificulta mudanças futuras.
 *
 * 3️⃣ **Dificuldade na reutilização**:
 *    - Se quisermos reutilizar esse código em outro contexto, teremos que copiá-lo e modificá-lo novamente.
 *
 * 🔹 **Solução correta**:
 *    - Criar uma classe **abstrata `Lanche`** e **subclasses para cada lanche** (`Hamburguer`, `Pizza`, etc.).
 *    - O método `fazerLanche()` deve **aceitar um objeto `Lanche`** em vez de depender de strings.
 *    - Isso permite adicionar novos lanches **sem modificar a classe `Restaurante`**, respeitando o **OCP**.
 */

 class Restaurante {
    void fazerLanche(String tipo) {
        if (tipo.equals("hamburguer")) {
            System.out.println("🍔 Fazendo um hambúrguer!");
        } else if (tipo.equals("cachorro-quente")) {
            System.out.println("🌭 Fazendo um cachorro-quente!");
        } else if (tipo.equals("pizza")) {
            System.out.println("🍕 Fazendo uma pizza!");
        } else {
            System.out.println("❌ Esse lanche não está no cardápio!");
        }
    }
}

// 🏡 Testando o restaurante
// public class Main {
//     public static void main(String[] args) {
//         Restaurante restaurante = new Restaurante();
//         restaurante.fazerLanche("hamburguer");
//         restaurante.fazerLanche("cachorro-quente");
//         restaurante.fazerLanche("pizza");

//         // ⚠ Se quisermos adicionar um novo lanche, PRECISAMOS MODIFICAR a classe Restaurante!
//         restaurante.fazerLanche("batata-frita");
//     }
// }