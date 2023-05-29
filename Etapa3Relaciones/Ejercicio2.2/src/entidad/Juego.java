// Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
//Revolver
//Métodos:
//• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
//y el revolver para guardarlos en los atributos del juego
//• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
//aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
//moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
//mojar. Al final del juego, se debe mostrar que jugador se mojó.
//Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.*/
package entidad;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {

    private ArrayList<Jugador> jugadores;
    private Revolver revolver;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void llenarJuego() {
        ArrayList<Jugador> jugadores = new ArrayList();
        int cantidad;
        do {
            System.out.println("Cuántos jugadores desean participar? (Máximo 6)");
            cantidad = leer.nextInt();
        } while (cantidad > 6 || cantidad < 2);
        int id = 1;

        for (int i = 0; i < cantidad; i++) {
            Jugador jugador = new Jugador(id);
            jugadores.add(jugador);
            id++;
        }
        this.jugadores = jugadores;
        this.revolver = new Revolver();
        revolver.llenarRevolver();
    }

    public void ronda() {
        boolean juego = true;
        do {
            for (Jugador jugador : jugadores) {
                jugador.disparo(revolver, jugador);
                System.out.println(jugador.getNombre() + " te toca");
                if (jugador.isMojado()) {
                    System.out.println("BOOOOOOOOOM");
                    System.out.println("Finalizó el juego, el jugador " + jugador.getNombre() + " se mojó");
                    juego = false;
                    break;
                } else {
                    System.out.println("Zafaste... por ahora");
                }
            }
        } while (juego);

    }
}
