/*Realiza un programa en donde exista una clase Jugador que contenga nombre, apellido, posición
y número. Luego otra clase Equipo que contenga una colección de jugadores. Una vez hecho
esto, desde el main recorreremos el equipo mostrando la información de cada jugador.
 */
package eje2.entidad;

import java.util.ArrayList;

public class Equipo {

    ArrayList<Jugador> equipo;

    public ArrayList<Jugador> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<Jugador> equipo) {
        this.equipo = equipo;
    }

    public Equipo() {
        this.equipo = new ArrayList();
    }
}
