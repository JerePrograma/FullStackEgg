package entidad;
//• Número de mástiles para veleros.

public class BarcoVelero extends Barco {

    protected int cantidadMastiles;

    public BarcoVelero(int cantidadMastiles, String matricula, double eslora, int anio) {
        super(matricula, eslora, anio);
        this.cantidadMastiles = cantidadMastiles;
    }

    public int getCantidadMastiles() {
        return cantidadMastiles;
    }

    public void setCantidadMastiles(int cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }

}
