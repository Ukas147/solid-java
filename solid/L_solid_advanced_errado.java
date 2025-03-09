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

// ❌ Subclasse errada: Bicicletas não podem acelerar como um carro!
class Bicicleta extends Veiculo {
    public Bicicleta(String nome) {
        super(nome);
    }

    @Override
    public void acelerar(double aumento) {
        throw new UnsupportedOperationException("❌ Bicicletas não podem acelerar dessa forma!");
    }
}

// ❌ Subclasse errada: Carros elétricos precisam de bateria, mas herdam o comportamento incorreto
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

// ❌ Subclasse errada: Trens não podem fazer curvas livres, mas herdaram aceleração errada
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