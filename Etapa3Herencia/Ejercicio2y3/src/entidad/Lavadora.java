//A continuación, se debe crear una subclase llamada Lavadora, con el atributo carga,
//además de los atributos heredados.
//Los constructores que se implementarán serán:
//• Un constructor vacío.
//• Un constructor con la carga y el resto de los atributos heredados. Recuerda que debes
//llamar al constructor de la clase padre.
package entidad;

public class Lavadora extends Electrodomestico {

    private int carga;

    public Lavadora() {
    }

    public Lavadora(double precio, String color, char consumoEnergetico, int peso, int carga) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public Lavadora(Electrodomestico electro, int carga) {
        this.peso = electro.peso;
        this.precio = electro.precio;
        this.color = electro.color;
        this.consumoEnergetico = electro.consumoEnergetico;
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        return super.toString() + "Lavadora{" + "carga=" + carga + '}';
    }

}
