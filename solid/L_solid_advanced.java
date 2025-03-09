/**
 * 🚀 Aplicação correta do Princípio da Segregação de Interfaces (ISP - Interface Segregation Principle)
 *
 * Este código implementa corretamente a **segregação de interfaces**, garantindo que **cada classe implementa apenas os métodos relevantes** para seu comportamento.
 * Assim, evitamos que classes herdem métodos que **não fazem sentido para elas**, respeitando o **ISP (Interface Segregation Principle)**.
 *
 * 🔹 **O que foi corrigido aqui?**
 *    - Criamos a **interface `Movivel`**, garantindo que todos os veículos podem **se mover e parar**, sem impor métodos desnecessários.
 *    - **Herdamos corretamente a classe `Veiculo`** para garantir que apenas veículos motorizados compartilhem atributos como `velocidade`.
 *    - **Bicicletas e outros veículos especiais** não herdam métodos que não fazem sentido, pois apenas implementam `Movivel`.
 *
 * 🔹 **Benefícios dessa abordagem:**
 * 1️⃣ **Respeito ao ISP**  
 *     - Bicicletas **não herdam métodos desnecessários**, como atributos de velocidade.
 *     - Carros elétricos têm **seu próprio método `carregarBateria()`**, sem depender de lógica de combustíveis.
 *
 * 2️⃣ **Código mais modular e reutilizável**  
 *     - Cada classe implementa **apenas os métodos relevantes**, tornando o código mais limpo.
 *
 * 3️⃣ **Baixo acoplamento e alta coesão**  
 *     - Classes têm responsabilidades bem definidas e podem ser reutilizadas independentemente.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se `Bicicleta` herdasse de `Veiculo`, teria um atributo de velocidade **que não faz sentido para ela**.
 *    - Se `CarroEletrico` herdasse de `Carro` sem modificação, poderia ter **métodos que lidam com combustíveis**.
 *    - O código ficaria confuso e difícil de manter.
 */
 interface Movivel {
     void mover(double velocidade);
     void parar();
 }
 
 // ✅ Classe abstrata para veículos que podem acelerar normalmente
 abstract class Veiculo implements Movivel {
     protected String nome;
     protected double velocidade;
 
     public Veiculo(String nome) {
         this.nome = nome;
         this.velocidade = 0;
     }
 
     @Override
     public void parar() {
         this.velocidade = 0;
         System.out.println("🛑 " + nome + " parou.");
     }
 
     public String getNome() {
         return nome;
     }
 }
 
 // ✅ Carros podem acelerar normalmente
 class Carro extends Veiculo {
     public Carro(String nome) {
         super(nome);
     }
 
     @Override
     public void mover(double velocidade) {
         this.velocidade += velocidade;
         System.out.println("🚗 " + nome + " acelerando para " + this.velocidade + " km/h");
     }
 }
 
 // ✅ Bicicletas não aceleram, mas podem se mover
 class Bicicleta implements Movivel {
     private String nome;
 
     public Bicicleta(String nome) {
         this.nome = nome;
     }
 
     @Override
     public void mover(double velocidade) {
         System.out.println("🚲 " + nome + " está pedalando a " + velocidade + " km/h");
     }
 
     @Override
     public void parar() {
         System.out.println("🛑 " + nome + " parou de pedalar.");
     }
 }
 
 // ✅ Carros elétricos precisam estar carregados antes de acelerar
 class CarroEletrico extends Carro {
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
         super.mover(velocidade);
     }
 }
 
 // ✅ Trem segue trilhos e não pode acelerar bruscamente
 class Trem extends Veiculo {
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
 
 // 🏡 Código agora está correto!
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