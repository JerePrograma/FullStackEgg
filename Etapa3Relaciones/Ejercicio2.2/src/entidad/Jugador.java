package entidad;

import java.util.Scanner;

//Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
//jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
//si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
//debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
public class Jugador {

    private int id;
    private String nombre;
    boolean mojado;

    public Jugador(int id) {
        System.out.println("Ingrese el nombre");
        String nombre2 = leer.next();
        this.nombre = id + " " + nombre2;
        this.mojado = false;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void disparo(Revolver revolver, Jugador jugador) {
        jugador.setMojado(revolver.mojar());
        revolver.siguienteChorro();
    }
}
