//• Potencia en CV para barcos a motor.
package entidades;

public class BarcoMotor extends Barco {

    private int potencia;

    public BarcoMotor(int potencia) {
        this.potencia = potencia;
    }

    public BarcoMotor(int potencia, String matricula, int eslora, int anioFabricacion) {
        super(matricula, eslora, anioFabricacion);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

}
