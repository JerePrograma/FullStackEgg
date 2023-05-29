//• barajar(): cambia de posición todas las cartas aleatoriamente.
//• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
//se haya llegado al final, se indica al usuario que no hay más cartas.
//• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
//• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
//cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
//debemos indicárselo al usuario.
//• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
//indicárselo al usuario
//• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
//luego se llama al método, este no mostrara esa primera carta.
package servicio;

import entidad.Baraja;
import entidad.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BarajaServicio {

    public Baraja crearBaraja() {
        Baraja baraja = new Baraja();
        String[] palos = {"Basto", "Copa", "Espada", "Oro"};
        ArrayList<Carta> mazo = new ArrayList();
        for (int j = 0; j < palos.length; j++) {
            for (int i = 1; i <= 12; i++) {
                if (i == 8 || i == 9) {
                    continue;
                }
                mazo.add(new Carta(i, palos[j]));
            }
        }
        baraja.setMazo(mazo);
        return baraja;
    }

    public void barajar(Baraja baraja) {
        System.out.println("Se barajó el mazo");
        Collections.shuffle(baraja.getMazo());
    }

    public void siguienteCarta(Baraja baraja) {
        ArrayList<Carta> monton = baraja.getMonton();
        if (baraja.getMazo().size() > 1) {
            System.out.println("Se entregó " + baraja.getMazo().get(0));
            monton.add(baraja.getMazo().remove(0));
        } else if (baraja.getMazo().size() == 1) {
            System.out.println("Se entregó " + baraja.getMazo().get(0));
            monton.add(baraja.getMazo().remove(0));
            System.out.println("No quedan más cartas");
        } 
    }

    public int cartasDisponibles(Baraja baraja) {
        System.out.println("Quedan " + baraja.getMazo().size() + " cartas disponibles");
        return baraja.getMazo().size();
    }

    public void darCartas(Baraja baraja) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el número de cartas que desea tomar");
        int cantidadCartas = leer.nextInt();
        if (cantidadCartas > baraja.getMazo().size()) {
            System.out.println("Solicitó más cartas de las que hay :|");
        } else {
            for (int i = 0; i < cantidadCartas; i++) {
                siguienteCarta(baraja);
            }
        }
    }

    public void cartasMonton(Baraja baraja) {
        if (baraja.getMonton().isEmpty()) {
            System.out.println("NO salió ninguna carta");
        } else {
            System.out.println(baraja.getMonton());
        }
    }

    public void mostrarBaraja(Baraja baraja) {
        System.out.println(baraja.getMazo());
    }
}
