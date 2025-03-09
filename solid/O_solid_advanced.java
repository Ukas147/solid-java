/**
 * 🎯 Aplicação dos Princípios SOLID: Aberto/Fechado (OCP) e Estratégia
 *
 * Este código implementa um **sistema flexível de cálculo de impostos**, utilizando **Interfaces, OCP (Open/Closed Principle) e Strategy Pattern**.
 *
 * 🔹 **O que foi feito corretamente aqui?**
 *    - Criamos a interface **RegraDeImposto**, que define um contrato para qualquer regra de imposto.
 *    - Cada país (`ImpostoBrasil`, `ImpostoEUA`, `ImpostoEuropa`) implementa sua própria lógica de imposto **sem modificar o código principal**.
 *    - A classe **CalculadoraImposto** pode receber **novas regras de impostos** dinamicamente sem precisar ser alterada.
 *
 * 🔹 **Benefícios dessa abordagem:**
 * 1️⃣ **Princípio Aberto/Fechado (OCP)**  
 *     - Podemos adicionar **novos países** sem modificar o código existente, apenas criando uma nova implementação da interface `RegraDeImposto`.
 *
 * 2️⃣ **Uso do Padrão Strategy**  
 *     - Cada país tem **sua própria estratégia** de cálculo de impostos, encapsulada em classes separadas.
 *
 * 3️⃣ **Código modular e reutilizável**  
 *     - A calculadora pode ser facilmente expandida para incluir novos países sem impactar as implementações existentes.
 *
 * 4️⃣ **Facilidade de manutenção**  
 *     - Cada regra de imposto é isolada, tornando o código mais organizado e fácil de testar.
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se tivéssemos uma única classe com **um grande switch-case ou múltiplos if/else**, o código ficaria **difícil de manter e expandir**.
 *    - A cada novo país adicionado, precisaríamos **modificar a classe principal**, violando o **OCP**.
 */

 import java.util.HashMap;
 import java.util.Map;
 
 // ✅ Criamos uma interface que representa qualquer cálculo de imposto
 interface RegraDeImposto {
     double calcular(String categoria, double preco);
 }
 
 // ✅ Implementação do imposto para o Brasil
 class ImpostoBrasil implements RegraDeImposto {
     private static final Map<String, Double> taxas = new HashMap<>();
 
     static {
         taxas.put("eletronico", 0.30);
         taxas.put("livro", 0.10);
         taxas.put("alimento", 0.05);
     }
 
     public double calcular(String categoria, double preco) {
         return preco * taxas.getOrDefault(categoria, 0.15);
     }
 }
 
 // ✅ Implementação do imposto para os EUA
 class ImpostoEUA implements RegraDeImposto {
     private static final Map<String, Double> taxas = new HashMap<>();
 
     static {
         taxas.put("eletronico", 0.25);
         taxas.put("livro", 0.08);
         taxas.put("alimento", 0.02);
     }
 
     public double calcular(String categoria, double preco) {
         return preco * taxas.getOrDefault(categoria, 0.10);
     }
 }
 
 // ✅ Implementação do imposto para a Europa
 class ImpostoEuropa implements RegraDeImposto {
     private static final Map<String, Double> taxas = new HashMap<>();
 
     static {
         taxas.put("eletronico", 0.40);
         taxas.put("livro", 0.12);
         taxas.put("alimento", 0.07);
     }
 
     public double calcular(String categoria, double preco) {
         return preco * taxas.getOrDefault(categoria, 0.20);
     }
 }
 
 // ✅ Classe que faz o gerenciamento de impostos de forma aberta para extensão
 class CalculadoraImposto {
     private Map<String, RegraDeImposto> regras = new HashMap<>();
 
     public CalculadoraImposto() {
         regras.put("brasil", new ImpostoBrasil());
         regras.put("eua", new ImpostoEUA());
         regras.put("europa", new ImpostoEuropa());
     }
 
     public void adicionarRegra(String pais, RegraDeImposto regra) {
         regras.put(pais.toLowerCase(), regra);
     }
 
     public double calcularImposto(String pais, String categoria, double preco) {
         RegraDeImposto regra = regras.get(pais.toLowerCase());
         if (regra == null) {
             throw new IllegalArgumentException("❌ País não suportado!");
         }
         return regra.calcular(categoria, preco);
     }
 }
 
 // 🏡 Testando o sistema de impostos (agora modularizado!)
//  public class Main {
//      public static void main(String[] args) {
//          CalculadoraImposto calculadora = new CalculadoraImposto();
 
//          System.out.println("🇧🇷 Imposto Brasil: R$ " + calculadora.calcularImposto("brasil", "eletronico", 1000));
//          System.out.println("🇺🇸 Imposto EUA: R$ " + calculadora.calcularImposto("eua", "livro", 200));
 
//          // ✅ Adicionando um novo país SEM modificar a classe CalculadoraImposto!
//          calculadora.adicionarRegra("japão", (categoria, preco) -> preco * 0.35);
//          System.out.println("🇯🇵 Imposto Japão: R$ " + calculadora.calcularImposto("japão", "eletronico", 1000));
//      }
//  } 