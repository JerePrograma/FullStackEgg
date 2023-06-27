package entidad;
//Se debe crear también una subclase llamada Televisor con los siguientes atributos:
//resolución (en pulgadas) y sintonizador TDT (booleano), además de los atributos
//heredados.
//Los constructores que se implementarán serán:
//• Un constructor vacío.
//• Un constructor con la resolución, sintonizador TDT y el resto de los atributos
//heredados. Recuerda que debes llamar al constructor de la clase padre.
//Los métodos que se implementara serán:
//• Método get y set de los atributos resolución y sintonizador TDT.


public class Televisor extends Electrodomestico {

    private int pulgadas;
    private boolean sintonizador;

    public Televisor() {
    }

    public Televisor(int pulgadas, boolean sintonizador, int precio, String color, char consumoEnergetico, int peso) {
        super(precio, color, consumoEnergetico, peso);
        this.pulgadas = pulgadas;
        this.sintonizador = sintonizador;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean isSintonizador() {
        return sintonizador;
    }

    public void setSintonizador(boolean sintonizador) {
        this.sintonizador = sintonizador;
    }

}
