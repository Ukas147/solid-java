package java_lpoo_solid.exercício;
// ❌ Esta classe tem duas responsabilidades: armazenar dados do estudante e calcular aprovação
class Estudante {
  private String nome;
  private double nota;

  public Estudante(String nome, double nota) {
      this.nome = nome;
      this.nota = nota;
  }

  public String getNome() {
      return nome;
  }

  public double getNota() {
      return nota;
  }

  public boolean estaAprovado() {
      return nota >= 7.0;
  }
}

// 🏡 Testando a classe Estudante
public class Main {
  public static void main(String[] args) {
      Estudante estudante = new Estudante("Carlos", 8.5);
      System.out.println("📚 Estudante: " + estudante.getNome());
      System.out.println("📊 Nota: " + estudante.getNota());

      if (estudante.estaAprovado()) {
          System.out.println("✅ Aprovado!");
      } else {
          System.out.println("❌ Reprovado.");
      }
  }
}