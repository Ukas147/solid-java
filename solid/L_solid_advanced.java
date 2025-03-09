import java.util.ArrayList;
import java.util.List;

// ✅ Criamos uma interface base para definir o comportamento correto
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
// public class Main {
//     public static void main(String[] args) {
//         List<Movivel> veiculos = new ArrayList<>();
//         veiculos.add(new Carro("Sedan"));
//         veiculos.add(new Bicicleta("Mountain Bike"));
//         veiculos.add(new CarroEletrico("Tesla"));
//         veiculos.add(new Trem("Trem Expresso"));

//         for (Movivel v : veiculos) {
//             v.mover(30);
//             v.parar();
//         }
//     }
// }