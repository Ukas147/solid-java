// Classe Pessoa com atributos encapsulados
class Pessoa {
  private String nome; // Atributo privado (não pode ser acessado diretamente)
  private int idade;

  // Construtor para inicializar a pessoa
  public Pessoa(String nome, int idade) {
      this.nome = nome;
      this.idade = idade;
  }

  // Método getter para obter o nome
  public String getNome() {
      return nome;
  }

  // Método setter para alterar o nome
  public void setNome(String nome) {
      this.nome = nome;
  }

  // Método getter para obter a idade
  public int getIdade() {
      return idade;
  }

  // Método setter para alterar a idade (com validação)
  public void setIdade(int idade) {
      if (idade > 0) { // Valida para não aceitar idade negativa
          this.idade = idade;
      } else {
          System.out.println("Idade inválida!");
      }
  }

  // Método para exibir informações da pessoa
  public void exibirInfo() {
      System.out.println("Nome: " + nome + ", Idade: " + idade);
  }
}

// public class Main {
//   public static void main(String[] args) {
//       // Criando um objeto Pessoa
//       Pessoa pessoa1 = new Pessoa("João", 25);

//       // Acessando informações através dos métodos encapsulados
//       pessoa1.exibirInfo();

//       // Alterando nome e idade de forma controlada
//       pessoa1.setNome("Carlos");
//       pessoa1.setIdade(30);

//       // Exibindo novamente os dados atualizados
//       pessoa1.exibirInfo();

//       // Tentando definir uma idade inválida
//       pessoa1.setIdade(-5); // Exibirá "Idade inválida!"
//   }
// }