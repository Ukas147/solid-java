/**
 * Abstração, Interfaces, Herança e Polimorfismo em Java
 *
 * Este código demonstra os principais conceitos da Programação Orientada a Objetos (POO):
 *
 * 🔹 **Abstração (`Veiculo`)**:
 *    - A classe `Veiculo` é **abstrata**, servindo como modelo genérico para diferentes tipos de veículos.
 *    - Define um método abstrato `mover()` que deve ser implementado por todas as subclasses.
 *
 * 🔹 **Interfaces (`Motorizado` e `NaoMotorizado`)**:
 *    - A interface `Motorizado` define o comportamento de veículos que precisam de abastecimento.
 *    - A interface `NaoMotorizado` define o comportamento de veículos que necessitam de manutenção manual.
 *    - `Carro` e `Avião` implementam `Motorizado`, enquanto `Bicicleta` implementa `NaoMotorizado`.
 *
 * 🔹 **Herança**:
 *    - `Carro`, `Bicicleta` e `Avião` herdam atributos e métodos da superclasse `Veiculo`.
 *
 * 🔹 **Polimorfismo**:
 *    - Os objetos `Carro`, `Bicicleta` e `Avião` são armazenados e manipulados como `Veiculo`.
 *    - O método `mover()` é chamado polimorficamente, cada subclasse executando sua própria versão.
 *    - O uso de `instanceof` permite chamar métodos específicos das interfaces implementadas.
 *
 * O código cria uma frota de veículos, processa seus movimentos e testa funcionalidades específicas de cada tipo.
 */

 import java.util.ArrayList;
 import java.util.List;
 
 // 🔹 Interface para veículos motorizados
 interface Motorizado {
     void abastecer();
 }
 
 // 🔹 Interface para veículos não motorizados
 interface NaoMotorizado {
     void manutencao();
 }
 
 // 🔹 Classe abstrata que define um modelo de veículo
 abstract class Veiculo {
     protected String modelo;
     protected int capacidadePassageiros;
 
     // Construtor
     public Veiculo(String modelo, int capacidadePassageiros) {
         this.modelo = modelo;
         this.capacidadePassageiros = capacidadePassageiros;
     }
 
     // Método abstrato (todas as subclasses devem implementar)
     abstract void mover();
 
     // Método comum (todas as subclasses podem usar)
     public void exibirInfo() {
         System.out.println("Modelo: " + modelo + ", Capacidade: " + capacidadePassageiros + " passageiros.");
     }
 }
 
 // 🔹 Subclasse Carro, que é um veículo motorizado
 class Carro extends Veiculo implements Motorizado {
     private int nivelCombustivel;
 
     public Carro(String modelo, int capacidade) {
         super(modelo, capacidade);
         this.nivelCombustivel = 100; // Começa com tanque cheio
     }
 
     @Override
     void mover() {
         if (nivelCombustivel > 0) {
             System.out.println("O carro " + modelo + " está acelerando!");
             nivelCombustivel -= 10;
         } else {
             System.out.println("O carro " + modelo + " está sem combustível!");
         }
     }
 
     @Override
     public void abastecer() {
         nivelCombustivel = 100;
         System.out.println("O carro " + modelo + " foi abastecido!");
     }
 }
 
 // 🔹 Subclasse Bicicleta, que é um veículo não motorizado
 class Bicicleta extends Veiculo implements NaoMotorizado {
     public Bicicleta(String modelo, int capacidade) {
         super(modelo, capacidade);
     }
 
     @Override
     void mover() {
         System.out.println("A bicicleta " + modelo + " está sendo pedalada!");
     }
 
     @Override
     public void manutencao() {
         System.out.println("Lubrificando corrente da bicicleta " + modelo + ".");
     }
 }
 
 // 🔹 Subclasse Avião, que é um veículo motorizado
 class Aviao extends Veiculo implements Motorizado {
     private boolean motorLigado;
 
     public Aviao(String modelo, int capacidade) {
         super(modelo, capacidade);
         this.motorLigado = false;
     }
 
     @Override
     void mover() {
         if (motorLigado) {
             System.out.println("O avião " + modelo + " está decolando!");
         } else {
             System.out.println("O avião " + modelo + " não pode decolar sem ligar os motores.");
         }
     }
 
     @Override
     public void abastecer() {
         System.out.println("O avião " + modelo + " foi reabastecido.");
     }
 
     // Método exclusivo do avião
     public void ligarMotores() {
         motorLigado = true;
         System.out.println("Motores do avião " + modelo + " foram ligados.");
     }
 }
 
 // 🔹 Classe principal
//  public class Main {
//      public static void main(String[] args) {
//          // Criando lista de veículos abstratos
//          List<Veiculo> frota = new ArrayList<>();
 
//          // Criando diferentes tipos de veículos
//          Carro carro = new Carro("Ferrari", 2);
//          Bicicleta bicicleta = new Bicicleta("Caloi", 1);
//          Aviao aviao = new Aviao("Boeing 747", 300);
 
//          // Adicionando veículos na frota
//          frota.add(carro);
//          frota.add(bicicleta);
//          frota.add(aviao);
 
//          // Exibindo informações dos veículos
//          System.out.println("\n📌 Informações da Frota:");
//          for (Veiculo v : frota) {
//              v.exibirInfo();
//          }
 
//          // Movendo os veículos
//          System.out.println("\n📌 Movimentação dos Veículos:");
//          for (Veiculo v : frota) {
//              v.mover();
//          }
 
//          // Testando métodos específicos com instanceof
//          System.out.println("\n📌 Abastecendo e realizando manutenção:");
//          for (Veiculo v : frota) {
//              if (v instanceof Motorizado) {
//                  ((Motorizado) v).abastecer();
//              } else if (v instanceof NaoMotorizado) {
//                  ((NaoMotorizado) v).manutencao();
//              }
//          }
 
//          // Testando ligar os motores do avião
//          System.out.println("\n📌 Tentando decolar o avião...");
//          aviao.ligarMotores();
//          aviao.mover();
//      }
//  } 