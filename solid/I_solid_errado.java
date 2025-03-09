// ❌ Interface errada! Obriga todos os animais a implementarem coisas que não fazem!
interface Animal {
    void comer();
    void correr();
    void voar();
    void nadar();
}

// 🐶 Cachorros não voam nem nadam, mas são obrigados a implementar os métodos
class Cachorro implements Animal {
    public void comer() {
        System.out.println("🐶 O cachorro está comendo.");
    }

    public void correr() {
        System.out.println("🐶 O cachorro está correndo.");
    }

    public void voar() { // ❌ Cachorros não voam!
        throw new UnsupportedOperationException("Cachorros não voam!");
    }

    public void nadar() { // ❌ Nem todos os cachorros nadam!
        throw new UnsupportedOperationException("Cachorros não nadam!");
    }
}

// 🐦 Pássaros são obrigados a implementar "correr" e "nadar", mesmo sem precisar
// class Passaro implements Animal {
//     public void comer() {
//         System.out.println("🐦 O pássaro está comendo.");
//     }

//     public void correr() { // ❌ Alguns pássaros não correm
//         throw new UnsupportedOperationException("Pássaros não correm!");
//     }

//     public void voar() {
//         System.out.println("🐦 O pássaro está voando!");
//     }

//     public void nadar() { // ❌ Pássaros não nadam!
//         throw new UnsupportedOperationException("Pássaros não nadam!");
//     }
// }