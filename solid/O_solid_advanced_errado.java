import java.util.HashMap;
import java.util.Map;

// ❌ CLASSE GIGANTE QUE QUEBRA O OCP
class CalculadoraImposto {
    private static final Map<String, Double> impostosBrasil = new HashMap<>();
    private static final Map<String, Double> impostosEUA = new HashMap<>();
    private static final Map<String, Double> impostosEuropa = new HashMap<>();

    static {
        // Impostos para o Brasil
        impostosBrasil.put("eletronico", 0.30);
        impostosBrasil.put("livro", 0.10);
        impostosBrasil.put("alimento", 0.05);

        // Impostos para os EUA
        impostosEUA.put("eletronico", 0.25);
        impostosEUA.put("livro", 0.08);
        impostosEUA.put("alimento", 0.02);

        // Impostos para a Europa
        impostosEuropa.put("eletronico", 0.40);
        impostosEuropa.put("livro", 0.12);
        impostosEuropa.put("alimento", 0.07);
    }

    // ❌ Método gigantesco que faz cálculos de impostos de vários países
    public double calcularImposto(String pais, String categoria, double preco) {
        double taxa = 0;

        if (pais.equalsIgnoreCase("brasil")) {
            taxa = impostosBrasil.getOrDefault(categoria, 0.15);
        } else if (pais.equalsIgnoreCase("eua")) {
            taxa = impostosEUA.getOrDefault(categoria, 0.10);
        } else if (pais.equalsIgnoreCase("europa")) {
            taxa = impostosEuropa.getOrDefault(categoria, 0.20);
        } else {
            System.out.println("❌ País não suportado!");
            return 0;
        }

        return preco * taxa;
    }

    // ❌ Sempre que um novo país for adicionado, este método precisa ser modificado!
    public void adicionarNovoPais(String pais, String categoria, double taxa) {
        if (pais.equalsIgnoreCase("brasil")) {
            impostosBrasil.put(categoria, taxa);
        } else if (pais.equalsIgnoreCase("eua")) {
            impostosEUA.put(categoria, taxa);
        } else if (pais.equalsIgnoreCase("europa")) {
            impostosEuropa.put(categoria, taxa);
        } else {
            System.out.println("❌ País não suportado para adição de impostos!");
        }
    }
}

// 🏡 Testando o sistema de impostos (com código ruim)
// public class Main {
//     public static void main(String[] args) {
//         CalculadoraImposto calculadora = new CalculadoraImposto();

//         double impostoBrasil = calculadora.calcularImposto("brasil", "eletronico", 1000);
//         double impostoEUA = calculadora.calcularImposto("eua", "livro", 200);
//         double impostoEuropa = calculadora.calcularImposto("europa", "alimento", 50);

//         System.out.println("🇧🇷 Imposto Brasil: R$ " + impostoBrasil);
//         System.out.println("🇺🇸 Imposto EUA: R$ " + impostoEUA);
//         System.out.println("🇪🇺 Imposto Europa: R$ " + impostoEuropa);

//         // Agora a empresa quer adicionar impostos para o Japão! 😨
//         calculadora.adicionarNovoPais("japão", "eletronico", 0.35); // ❌ Esse método não funciona corretamente para novos países!
//     }
// }