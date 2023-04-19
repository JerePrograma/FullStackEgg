package entidad;

/*Juego Ahorcado: Crear una clase Ahorcado (como el juego), la cual deberá contener como atributos, 
un vector con la palabra a buscar, la cantidad de letras encontradas y la cantidad jugadas máximas que puede realizar el usuario.
 */
public class Ahorcado {

    private char[] palabraABuscar;
    private int letrasEncontradas = 0;
    private int cantidadDeJugadas;

    public Ahorcado(char[] palabraABuscar, int letrasEncontradas, int cantidadDeJugadas) {
        this.palabraABuscar = palabraABuscar;
        this.letrasEncontradas = letrasEncontradas;
        this.cantidadDeJugadas = cantidadDeJugadas;
    }

    public Ahorcado() {
    }

    public char[] getPalabraABuscar() {
        return palabraABuscar;
    }

    public void setPalabraABuscar(char[] palabraABuscar) {
        this.palabraABuscar = palabraABuscar;
    }

    public int getLetrasEncontradas() {
        return letrasEncontradas;
    }

    public void setLetrasEncontradas(int letrasEncontradas) {
        this.letrasEncontradas = letrasEncontradas;
    }

    public int getCantidadDeJugadas() {
        return cantidadDeJugadas;
    }

    public void setCantidadDeJugadas(int cantidadDeJugadas) {
        this.cantidadDeJugadas = cantidadDeJugadas;
    }

}
