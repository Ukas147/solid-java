import java.util.ArrayList;
import java.util.List;

// ✅ Interface: Define um contrato para todos os animais
interface Animal {
    void fazerSom();
    void mover();
}

// ✅ Classe abstrata: Define comportamento base para animais
abstract class AnimalSelvagem implements Animal {
    protected String nome;
    protected int idade;

    public AnimalSelvagem(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void respirar() {
        System.out.println(nome + " está respirando.");
    }

    public abstract void habitat();
}

// ✅ Subclasse concreta Leão
class Leao extends AnimalSelvagem {
    public Leao(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void fazerSom() {
        System.out.println(nome + " ruge: ROOOARR!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está correndo na savana!");
    }

    @Override
    public void habitat() {
        System.out.println(nome + " vive em regiões de savana.");
    }

    // ✅ Overloading: Rugir em intensidade diferente
    public void fazerSom(int intensidade) {
        for (int i = 0; i < intensidade; i++) {
            System.out.println(nome + " ruge: ROOOARR!");
        }
    }
}

// ✅ Exceção personalizada para setor não encontrado
class SetorNaoEncontradoException extends Exception {
    public SetorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

// ✅ Composição: Setor contém animais e não pode existir sem o Parque
class Setor {
    private String nome;
    private List<Animal> animais = new ArrayList<>();

    public Setor(String nome) {
        this.nome = nome;
    }

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    public void listarAnimais() {
        System.out.println("\n📌 Animais no setor " + nome + ":");
        for (Animal animal : animais) {
            animal.fazerSom();
        }
    }
}

// ✅ Agregação: Funcionário pode existir sem o Parque
class Funcionario {
    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public void trabalhar() {
        System.out.println(nome + " está trabalhando no Parque.");
    }
}

// ✅ Associação: O veterinário apenas examina um animal sem possuí-lo
class Veterinario {
    private String nome;

    public Veterinario(String nome) {
        this.nome = nome;
    }

    public void examinarAnimal(Animal animal) {
        System.out.println("🔍 " + nome + " está examinando " + ((AnimalSelvagem) animal).nome);
    }
}

// ✅ Singleton: Apenas um Parque pode existir
class ParqueSelvagem {
    private static ParqueSelvagem instancia;
    private List<Setor> setores = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();

    private ParqueSelvagem() {}  // Construtor privado

    public static ParqueSelvagem getInstancia() {
        if (instancia == null) {
            instancia = new ParqueSelvagem();
        }
        return instancia;
    }

    public void adicionarSetor(Setor setor) {
        setores.add(setor);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    // ✅ Try-Catch-Finally: Tratando erro ao buscar setor
    public void buscarSetor(String nome) {
        try {
            for (Setor setor : setores) {
                if (setor.equals(nome)) {
                    System.out.println("Setor encontrado: " + nome);
                    return;
                }
            }
            throw new SetorNaoEncontradoException("Erro: Setor não encontrado!");
        } catch (SetorNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Busca finalizada.");
        }
    }

    public void listarFuncionarios() {
        System.out.println("\n📌 Funcionários do Parque:");
        for (Funcionario f : funcionarios) {
            f.trabalhar();
        }
    }

    // ✅ Inner Class: Gerenciador de Estatísticas do Parque
    class Estatisticas {
        public void totalAnimais() {
            int total = setores.stream().mapToInt(setor -> setor.animais.size()).sum();
            System.out.println("📊 Total de animais no parque: " + total);
        }
    }
}

// ✅ Classe principal
// public class Main {
//     public static void main(String[] args) {
//         // Criando instância do parque (Singleton)
//         ParqueSelvagem parque = ParqueSelvagem.getInstancia();

//         // Criando setores (Composição)
//         Setor setorSelvagem = new Setor("Selvagem");
//         parque.adicionarSetor(setorSelvagem);

//         // Criando animais
//         Leao leao = new Leao("Simba", 5);

//         // Adicionando animais ao setor
//         setorSelvagem.adicionarAnimal(leao);

//         // Criando funcionários (Agregação)
//         Funcionario f1 = new Funcionario("Carlos");
//         parque.adicionarFuncionario(f1);

//         // Criando veterinário (Associação) e examinando um animal
//         Veterinario vet = new Veterinario("Dr. Ana");
//         vet.examinarAnimal(leao);

//         // Testando métodos de listagem
//         setorSelvagem.listarAnimais();
//         parque.listarFuncionarios();

//         // ✅ Testando Try-Catch-Finally
//         parque.buscarSetor("Aves");

//         // ✅ Testando Overloading
//         leao.fazerSom(3);  // Simba ruge 3 vezes

//         // ✅ Usando Inner Class para estatísticas do parque
//         ParqueSelvagem.Estatisticas stats = parque.new Estatisticas();
//         stats.totalAnimais();
//     }
// }