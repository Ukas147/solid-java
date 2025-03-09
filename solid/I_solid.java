/**
 * 🚀 Aplicação correta do Princípio da Segregação de Interfaces (ISP - Interface Segregation Principle)
 *
 * O código abaixo implementa corretamente **o ISP**, garantindo que cada classe implementa **apenas as interfaces necessárias**.
 * O ISP afirma que **nenhuma classe deve ser forçada a implementar métodos que não utiliza**.
 *
 * 🔹 **O que foi corrigido aqui?**
 *    - Criamos **interfaces separadas** (`AnimalCorredor`, `AnimalVoador`, `AnimalNadador`) para cada comportamento específico.
 *    - Agora cada animal **implementa apenas as interfaces relevantes**, sem métodos desnecessários.
 *
 * 🔹 **Benefícios dessa abordagem:**
 * 1️⃣ **Respeito ao ISP**  
 *     - Se um novo tipo de animal for adicionado (ex: `Golfinho`), ele pode implementar **apenas `AnimalNadador`**, sem métodos irrelevantes.
 *
 * 2️⃣ **Código modular e reutilizável**  
 *     - As interfaces são **pequenas e específicas**, permitindo maior flexibilidade.
 *
 * 3️⃣ **Evita métodos desnecessários**  
 *     - Nenhum animal precisa de um método que não faz sentido para ele (ex: `Peixe` não implementa `voar()`).
 *
 * 🔹 **O que aconteceria sem essa estrutura?**
 *    - Se `Animal` fosse uma única interface grande com todos os métodos (`comer()`, `correr()`, `voar()`, `nadar()`), todas as classes precisariam implementar métodos **que não fazem sentido para elas**.
 *    - Isso tornaria o código confuso e menos flexível para futuras expansões.
 */

 // 🎯 Interface correta: Apenas habilidades específicas!
 interface Animal {
    void comer();
}

interface AnimalCorredor {
    void correr();
}

interface AnimalVoador {
    void voar();
}

interface AnimalNadador {
    void nadar();
}

// 🐶 O cachorro só precisa comer e correr, então implementa apenas as interfaces necessárias
class Cachorro implements Animal, AnimalCorredor {
    public void comer() {
        System.out.println("🐶 O cachorro está comendo.");
    }

    public void correr() {
        System.out.println("🐶 O cachorro está correndo.");
    }
}

// 🐦 O pássaro pode comer e voar, então implementa apenas essas interfaces
class Passaro implements Animal, AnimalVoador {
    public void comer() {
        System.out.println("🐦 O pássaro está comendo.");
    }

    public void voar() {
        System.out.println("🐦 O pássaro está voando!");
    }
}

// 🐠 O peixe só precisa nadar e comer
class Peixe implements Animal, AnimalNadador {
    public void comer() {
        System.out.println("🐠 O peixe está comendo.");
    }

    public void nadar() {
        System.out.println("🐠 O peixe está nadando.");
    }
}

// 🏡 Testando o zoológico
// public class Main {
//     public static void main(String[] args) {
//         Cachorro cachorro = new Cachorro();
//         Passaro passaro = new Passaro();
//         Peixe peixe = new Peixe();

//         System.out.println("\n🐶 Cachorro:");
//         cachorro.comer();
//         cachorro.correr();

//         System.out.println("\n🐦 Pássaro:");
//         passaro.comer();
//         passaro.voar();

//         System.out.println("\n🐠 Peixe:");
//         peixe.comer();
//         peixe.nadar();
//     }
// }