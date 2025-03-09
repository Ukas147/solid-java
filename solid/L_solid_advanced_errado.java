/**
 * 🚨 Problema: Violação do Princípio da Substituição de Liskov (LSP - Liskov Substitution Principle)
 *
 * O código abaixo **viola o LSP**, pois algumas subclasses (`Bicicleta`, `CarroEletrico`, `Trem`) **não podem ser usadas corretamente no lugar da superclasse `Veiculo`**.
 * O LSP afirma que **uma subclasse deve poder substituir sua superclasse sem alterar o comportamento esperado**.
 *
 * 🔴 **Problemas encontrados:**
 * 1️⃣ `Bicicleta` herda `Veiculo`, mas **não pode acelerar como um carro**, causando erro (`UnsupportedOperationException`).
 * 2️⃣ `CarroEletrico` precisa estar carregado antes de acelerar, mas herda um comportamento incorreto.
 * 3️⃣ `Trem` tem restrições específicas de aceleração que não fazem sentido para um `Veiculo` comum.
 *
 * 🔹 **Solução correta**:
 *    - Criar uma **interface `Movivel`**, garantindo que todos os veículos podem **se mover e parar**.
 *    - Criar classes especializadas para diferentes tipos de veículos (`VeiculoMotorizado` e `VeiculoNaoMotorizado`).
 *    - Garantir que **nenhuma classe tenha métodos que não fazem sentido para ela**.
 */

 import java.util.ArrayList;
 import java.util.List;
 
 // ❌ Código antigo que viola LSP
 class Veiculo {
     protected String nome;
     protected double velocidade;
 
     public Veiculo(String nome) {
         this.nome = nome;
         this.velocidade = 0;
     }
 
     public void acelerar(double aumento) {
         this.velocidade += aumento;
         System.out.println("🚗 " + nome + " acelerando para " + velocidade + " km/h");
     }
 
     public void frear() {
         this.velocidade = 0;
         System.out.println("🛑 " + nome + " parou.");
     }
 }
 
 // ❌ Bicicletas não podem acelerar como carros!
 class Bicicleta extends Veiculo {
     public Bicicleta(String nome) {
         super(nome);
     }
 
     @Override
     public void acelerar(double aumento) {
         throw new UnsupportedOperationException("❌ Bicicletas não podem acelerar dessa forma!");
     }
 }
 
 // ❌ Carros elétricos precisam de bateria antes de acelerar
 class CarroEletrico extends Veiculo {
     private boolean carregado;
 
     public CarroEletrico(String nome) {
         super(nome);
         this.carregado = false;
     }
 
     public void carregarBateria() {
         this.carregado = true;
         System.out.println("⚡ " + nome + " está carregado!");
     }
 
     @Override
     public void acelerar(double aumento) {
         if (!carregado) {
             throw new UnsupportedOperationException("❌ Carro elétrico precisa ser carregado antes de acelerar!");
         }
         super.acelerar(aumento);
     }
 }
 
 // ❌ Trens não podem acelerar livremente como carros
 class Trem extends Veiculo {
     public Trem(String nome) {
         super(nome);
     }
 
     @Override
     public void acelerar(double aumento) {
         if (aumento > 20) {
             throw new UnsupportedOperationException("❌ Trem não pode acelerar bruscamente!");
         }
         super.acelerar(aumento);
     }
 }
 
 // ❌ Código principal que espera que todos os veículos funcionem da mesma maneira
 // public class Main {
 //     public static void main(String[] args) {
 //         List<Veiculo> veiculos = new ArrayList<>();
 //         veiculos.add(new Veiculo("Carro Normal"));
 //         veiculos.add(new Bicicleta("Bicicleta Speed"));
 //         veiculos.add(new CarroEletrico("Tesla"));
 //         veiculos.add(new Trem("Trem Expresso"));
 
 //         for (Veiculo v : veiculos) {
 //             try {
 //                 v.acelerar(30);
 //                 v.frear();
 //             } catch (UnsupportedOperationException e) {
 //                 System.out.println("🚨 Erro ao tentar acelerar: " + e.getMessage());
 //             }
 //         }
 //     }
 // }
 
 // ✅ Código corrigido seguindo LSP
 
 // Criamos uma interface que define o comportamento correto
 interface Movivel {
     void mover(double velocidade);
     void parar();
 }
 
 // ✅ Criamos uma classe base para veículos motorizados
 abstract class VeiculoMotorizado implements Movivel {
     protected String nome;
     protected double velocidade;
 
     public VeiculoMotorizado(String nome) {
         this.nome = nome;
         this.velocidade = 0;
     }
 
     @Override
     public void parar() {
         this.velocidade = 0;
         System.out.println("🛑 " + nome + " parou.");
     }
 }
 
 // ✅ Criamos uma classe base para veículos não motorizados (como Bicicletas)
 abstract class VeiculoNaoMotorizado implements Movivel {
     protected String nome;
 
     public VeiculoNaoMotorizado(String nome) {
         this.nome = nome;
     }
 
     @Override
     public void parar() {
         System.out.println("🛑 " + nome + " parou.");
     }
 }
 
 // ✅ Carros podem acelerar normalmente
 class Carro extends VeiculoMotorizado {
     public Carro(String nome) {
         super(nome);
     }
 
     @Override
     public void mover(double velocidade) {
         this.velocidade += velocidade;
         System.out.println("🚗 " + nome + " acelerando para " + this.velocidade + " km/h");
     }
 }
 
 // ✅ Bicicletas não aceleram como carros, mas podem se mover
 class Bicicleta extends VeiculoNaoMotorizado {
     public Bicicleta(String nome) {
         super(nome);
     }
 
     @Override
     public void mover(double velocidade) {
         System.out.println("🚲 " + nome + " está pedalando a " + velocidade + " km/h");
     }
 }
 
 // ✅ Carros elétricos precisam estar carregados antes de se mover
 class CarroEletrico extends VeiculoMotorizado {
     private boolean carregado;
 
     public CarroEletrico(String nome) {
         super(nome);
         this.carregado = false;
     }
 
     public void carregarBateria() {
         this.carregado = true;
         System.out.println("⚡ " + nome + " está carregado!");
     }
 
     @Override
     public void mover(double velocidade) {
         if (!carregado) {
             System.out.println("❌ " + nome + " precisa ser carregado antes de se mover!");
             return;
         }
         this.velocidade += velocidade;
         System.out.println("⚡ " + nome + " acelerando para " + this.velocidade + " km/h");
     }
 }
 
 // ✅ Trens seguem trilhos e têm restrições de aceleração
 class Trem extends VeiculoMotorizado {
     public Trem(String nome) {
         super(nome);
     }
 
     @Override
     public void mover(double velocidade) {
         if (velocidade > 20) {
             System.out.println("❌ Trem não pode acelerar tão rápido!");
             return;
         }
         this.velocidade += velocidade;
         System.out.println("🚆 " + nome + " se movendo a " + this.velocidade + " km/h nos trilhos.");
     }
 }

//  public class Main {
//      public static void main(String[] args) {
//          List<Movivel> veiculos = new ArrayList<>();
//          veiculos.add(new Carro("Sedan"));
//          veiculos.add(new Bicicleta("Mountain Bike"));
//          veiculos.add(new CarroEletrico("Tesla"));
//          veiculos.add(new Trem("Trem Expresso"));
 
//          for (Movivel v : veiculos) {
//              v.mover(30);
//              v.parar();
//          }
//      }
//  } 