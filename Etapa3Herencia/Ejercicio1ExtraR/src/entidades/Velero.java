package entidades;
//• Número de mástiles para veleros.

public class Velero extends Barco {

    private int mastiles;

    public Velero(int mastiles) {
        this.mastiles = mastiles;
    }

    public Velero(int mastiles, String matricula, int eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.mastiles = mastiles;
    }

    public int getMastiles() {
        return mastiles;
    }

    public void setMastiles(int mastiles) {
        this.mastiles = mastiles;
    }

}
