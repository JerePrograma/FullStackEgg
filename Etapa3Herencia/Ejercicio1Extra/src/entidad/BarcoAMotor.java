package entidad;

public class BarcoAMotor extends Barco {

    protected int potenciaMotor;

    public BarcoAMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public BarcoAMotor(int potenciaMotor, String matricula, double eslora, int anio) {
        super(matricula, eslora, anio);
        this.potenciaMotor = potenciaMotor;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

}
