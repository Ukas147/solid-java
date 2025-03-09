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