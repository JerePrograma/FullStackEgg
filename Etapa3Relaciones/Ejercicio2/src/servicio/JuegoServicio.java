/*Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
//    • ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
//aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
//moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
//mojar. Al final del juego, se debe mostrar que jugador se mojó.
//Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
package servicio;

import entidad.Juego;
import entidad.Jugador;
import entidad.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Scanner;

public class JuegoServicio {

    JugadorServicio js = new JugadorServicio();
    RevolverDeAguaServicio rs = new RevolverDeAguaServicio();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Juego llenarJuego() {
        ArrayList<Jugador> jugadores = new ArrayList();
        RevolverDeAgua revolver = rs.llenarRevolver();
        System.out.println("Cuántos jugadores van a participar?");
        int respuesta = leer.nextInt();
        if (respuesta > 6 || respuesta < 1) {
            respuesta = 6;
        }
        for (int i = 0; i < respuesta; i++) {
            Jugador jugador = new Jugador(i + 1);
            jugadores.add(jugador);
        }
        return new Juego(jugadores, revolver);
    }

    public void ronda(Juego juego) {
        while (true) {
            for (Jugador jugador : juego.getJugadores()) {
                js.disparo(jugador, juego.getRevolver());
                System.out.println(jugador.getNombre() + " " + jugador.getId() + " se dispara...");
                if (jugador.isMojado()) {
                    System.out.println(jugador.getNombre() + " " + jugador.getId() + " se mojó");
                    return;
                }
                System.out.println(jugador.getNombre() + " " + jugador.getId() + " sobrevive una ronda más");
            }
        }
    }
}
