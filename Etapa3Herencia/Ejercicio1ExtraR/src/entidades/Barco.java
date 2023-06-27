//Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
//Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:
//• Número de mástiles para veleros.
//• Potencia en CV para barcos a motor.
//• Potencia en CV y número de camarotes para yates de lujo.
package entidades;

public class Barco {

    protected String matricula;
    protected int eslora;
    protected int anioFabricacion;

    public Barco() {
    }

    public Barco(String matricula, int eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

}
