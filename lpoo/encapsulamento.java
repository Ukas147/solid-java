/**
 * Encapsulamento em Java
 *
 * O encapsulamento é um dos pilares da Programação Orientada a Objetos (POO) e consiste em 
 * restringir o acesso direto aos atributos de uma classe, permitindo que sejam acessados 
 * e modificados apenas por meio de métodos específicos (getters e setters). 
 *
 * Benefícios do Encapsulamento:
 * - Proteção dos dados internos da classe contra modificações inadequadas.
 * - Facilita a manutenção do código ao controlar como os atributos são acessados e alterados.
 * - Permite a validação de dados antes de serem atribuídos a um atributo.
 * - Segue o princípio do "ocultamento de informação" (Information Hiding).
 * 
 * No código abaixo, a classe `Pessoa` possui atributos privados e métodos públicos para acessá-los e modificá-los.
 * O método `setIdade()` inclui uma validação para impedir que valores inválidos sejam atribuídos ao atributo `idade`.
 */

 class Pessoa {
    private String nome; // Atributo privado (não pode ser acessado diretamente)
    private int idade;

    // Construtor para inicializar os atributos da classe
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método getter para obter o nome
    public String getNome() {
        return nome;
    }

    // Método setter para modificar o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para obter a idade
    public int getIdade() {
        return idade;
    }

    // Método setter para modificar a idade com validação
    public void setIdade(int idade) {
        if (idade > 0) { // Valida para impedir valores negativos
            this.idade = idade;
        } else {
            System.out.println("Idade inválida!"); // Mensagem de erro
        }
    }

    // Método para exibir as informações da pessoa
    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}

// Classe principal contendo o método main
// public class Main {
//     public static void main(String[] args) {
//         // Criando um objeto da classe Pessoa
//         Pessoa pessoa1 = new Pessoa("João", 25);

//         // Exibindo as informações da pessoa
//         pessoa1.exibirInfo();

//         // Modificando atributos usando os métodos setters
//         pessoa1.setNome("Carlos");
//         pessoa1.setIdade(30);

//         // Exibindo novamente as informações atualizadas
//         pessoa1.exibirInfo();

//         // Tentando definir uma idade inválida
//         pessoa1.setIdade(-5); // Exibirá "Idade inválida!"
//     }
// }