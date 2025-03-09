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
// public class Main {
//     public static void main(String[] args) {
//         CalculadoraImposto calculadora = new CalculadoraImposto();

//         System.out.println("🇧🇷 Imposto Brasil: R$ " + calculadora.calcularImposto("brasil", "eletronico", 1000));
//         System.out.println("🇺🇸 Imposto EUA: R$ " + calculadora.calcularImposto("eua", "livro", 200));

//         // ✅ Adicionando um novo país SEM modificar a classe CalculadoraImposto!
//         calculadora.adicionarRegra("japão", (categoria, preco) -> preco * 0.35);
//         System.out.println("🇯🇵 Imposto Japão: R$ " + calculadora.calcularImposto("japão", "eletronico", 1000));
//     }
// }