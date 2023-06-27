//• Potencia en CV y número de camarotes para yates de lujo.
package entidades;

public class Yate extends Barco {

    private int nroCamarotes;
    private int potencia;

    public Yate() {
    }

    public Yate(int nroCamarotes, int potencia, String matricula, int eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.nroCamarotes = nroCamarotes;
        this.potencia = potencia;
    }

    public int getNroCamarotes() {
        return nroCamarotes;
    }

    public void setNroCamarotes(int nroCamarotes) {
        this.nroCamarotes = nroCamarotes;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

}
