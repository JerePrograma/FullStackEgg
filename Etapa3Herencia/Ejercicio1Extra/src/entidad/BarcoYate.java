package entidad;
//• Potencia en CV y número de camarotes para yates de lujo.

public class BarcoYate extends BarcoAMotor {

    private int numeroCamarotes;

    public BarcoYate(int numeroCamarotes, int potenciaMotor, String matricula, double eslora, int anio) {
        super(potenciaMotor, matricula, eslora, anio);
        this.numeroCamarotes = numeroCamarotes;
    }

    public int getNumeroCamarotes() {
        return numeroCamarotes;
    }

    public void setNumeroCamarotes(int numeroCamarotes) {
        this.numeroCamarotes = numeroCamarotes;
    }

}
