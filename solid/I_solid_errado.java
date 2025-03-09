/**
 * 🚨 Problema: Violação do Princípio da Segregação de Interfaces (ISP - Interface Segregation Principle)
 *
 * O código abaixo **viola o ISP**, pois a interface `Animal` obriga **todos os animais** a implementarem métodos
 * que **não fazem sentido para eles**.
 *
 * O ISP afirma que **nenhuma classe deve ser forçada a implementar métodos que não utiliza**.
 *
 * 🔴 **Problemas encontrados:**
 * 1️⃣ `Cachorro` precisa implementar `voar()` e `nadar()`, mesmo que cachorros **não voem nem todos nadem**.
 * 2️⃣ `Passaro` precisa implementar `correr()` e `nadar()`, mesmo que pássaros **não corram nem nadem**.
 * 3️⃣ **Uso de `UnsupportedOperationException`** para métodos que não fazem sentido para a classe,
 *    indicando um problema na modelagem das interfaces.
 *
 * 🔹 **Solução correta**:
 *    - Criar interfaces **separadas** para cada comportamento (`AnimalCorredor`, `AnimalVoador`, `AnimalNadador`).
 *    - Garantir que cada animal **implementa apenas as interfaces relevantes**.
 *    - Isso torna o código **mais flexível e modular**.
 */

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
class Passaro implements Animal {
    public void comer() {
        System.out.println("🐦 O pássaro está comendo.");
    }

    public void correr() { // ❌ Alguns pássaros não correm
        throw new UnsupportedOperationException("Pássaros não correm!");
    }

    public void voar() {
        System.out.println("🐦 O pássaro está voando!");
    }

    public void nadar() { // ❌ Pássaros não nadam!
        throw new UnsupportedOperationException("Pássaros não nadam!");
    }
}