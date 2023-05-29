package entidad;
//8 A X | 8 B X | 8 C X | 8 D   | 8 E X | 8 F X
//7 A X | 7 B X | 7 C X | 7 D X | 7 E   | 7 F X
//6 A X | 6 B X | 6 C   | 6 D X | 6 E X | 6 F
//5 A X | 5 B X | 5 C X | 5 D X | 5 E X | 5 F X
//4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
//3 A X | 3 B X | 3 C X | 3 D   | 3 E X | 3 F X
//2 A X | 2 B   | 2 C X | 2 D X | 2 E X | 2 F
//1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X

public class Asiento {

    private String nombre;
    private boolean ocupado;
    private Espectador espectador;

    public Asiento() {

    }

    public Asiento(String nombre, boolean ocupado, Espectador espectador) {
        this.nombre = nombre;
        this.ocupado = ocupado;
        this.espectador = espectador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
